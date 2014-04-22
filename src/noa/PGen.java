package noa;

import static noa.util.Conventions.hasPlaceholder;
import static noa.util.Conventions.isToken;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import noa.annos.Level;
import noa.annos.Skip;
import noa.annos.Syntax;
import noa.annos.Token;
import noa.util.Conventions;
import noa.util.NormalAlt;
import noa.util.Rules;

import org.antlr.v4.Tool;
import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.ast.GrammarRootAST;


/*
 * TODO: <assoc=left> and <assoc=right> (non-assoc is not supported by antlr4)
 * TODO: make annotation processor version to automatically generate upon build.
 */


public class PGen {
	private Class<?> signature;
	private Class<?> tokensClass;

	public PGen(Class<?> tokens, Class<?> signature) {
		this.tokensClass = tokens;
		this.signature = signature;
	}
	
	public void generate(String name, String pkg, String path) {
		Map<String,String> tokens = new HashMap<>();
		Rules rules = new Rules(name, pkg, tokensClass, signature);
		addProductions(rules);
		
		StringBuilder sb = new StringBuilder();
		rules.groupByLevel();
		rules.generate(sb);
		generateTokens(tokens, sb);
		
		System.out.println(sb.toString());
		
		Tool t = new org.antlr.v4.Tool();
		GrammarRootAST g = t.parseGrammarFromString(sb.toString());
		Grammar theG = t.createGrammar(g);
		t.gen_listener = false;
		t.gen_visitor = false;
		t.gen_dependencies = false;
		theG.fileName = path;
		t.process(theG, true);
	}

	private void generateTokens(Map<String, String> tokens, StringBuilder sb) {
		Method[] ms = tokensClass.getMethods();
		for (Method m: ms) {
			Token tk = m.getAnnotation(Token.class);
			if (tk == null) {
				continue;
			}

			sb.append(m.getName().toUpperCase() + ": " + tk.value());
			Skip sk = m.getAnnotation(Skip.class);
			if (sk != null) {
				sb.append(" -> skip");
			}
			sb.append(";\n");
		}
	}
	

	private void addProductions(Rules rules) {
		Method[] ms = signature.getMethods();
		for (Method m: ms) {
			Type ret = m.getGenericReturnType();
			Type[] ts = m.getGenericParameterTypes();
			Syntax anno = m.getAnnotation(Syntax.class);
			if (anno == null) {
				System.err.println("Warning: method without syntax/token anno: " + m);
				continue;
			}
			String alt = anno.value();
			String[] syms = alt.split(" ");
			List<String> realSyms = new ArrayList<>();
			int i = 0;
			for (String s: syms) {
				if (hasPlaceholder(s)) {
					s = s.replaceFirst("_", typeToNonTerminal(ts[i]));
					i++;
				}
				if (isToken(s)) {
					i++;
				}
				realSyms.add(s);
			}
			Level precAnno = m.getAnnotation(Level.class);
			int prec = Conventions.MAX_PRECEDENCE;
			if (precAnno != null) {
				prec = precAnno.value();
			}
			rules.addAlt(new NormalAlt(typeToNonTerminal(ret), prec, m.getName(), realSyms));
		}
	}


	private String typeToNonTerminal(Type t) {
		String typeName = t.getTypeName();
		if (typeName.matches("^java\\.util\\.List<.*>$")) {
			typeName = typeName.substring(typeName.lastIndexOf("<") + 1, typeName.length() - 1);
		}
		return typeName.toLowerCase();
	}
	
}
