// Generated from src/noa/syntax/demo/ by ANTLR 4.2.2

package noa.syntax.demo;
import static noa.syntax.demo.Tokens.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DemoParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, NUM=8, WS=9;
	public static final String[] tokenNames = {
		"<INVALID>", "'avg'", "'avg2'", "'('", "')'", "'*'", "'+'", "','", "NUM", 
		"WS"
	};
	public static final int
		RULE_exp = 0, RULE_prog = 1;
	public static final String[] ruleNames = {
		"exp", "prog"
	};

	@Override
	public String getGrammarFileName() { return "demo"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private noa.syntax.demo.AllAlg builder;
	public void setBuilder(noa.syntax.demo.AllAlg builder) { this.builder = builder; }
	private static <X> java.util.List<X> lift(String name, java.util.List<?> ctxs, X ...heads) {
	  java.util.List<X> l = new java.util.ArrayList<X>();
	  for (X h: heads) { l.add(h); }
	  for (Object ctx: ctxs) {
	    try {
	      l.add((X)ctx.getClass().getField(name).get(ctx));
	    } catch (Throwable e) {
	      throw new RuntimeException(e);
	    }
	  }
	  return l;
	}

	public DemoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpContext extends ParserRuleContext {
		public Object _exp;
		public ExpContext exp_0;
		public Token NUM_0;
		public ExpContext exp;
		public List<ExpContext> exp_0tail = new ArrayList<ExpContext>();
		public List<ExpContext> exp_0_list = new ArrayList<ExpContext>();
		public ExpContext exp_1;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode NUM() { return getToken(DemoParser.NUM, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			switch (_input.LA(1)) {
			case NUM:
				{
				setState(5); ((ExpContext)_localctx).NUM_0 = match(NUM);
				((ExpContext)_localctx)._exp =  builder.lit(num((((ExpContext)_localctx).NUM_0!=null?((ExpContext)_localctx).NUM_0.getText():null)));
				}
				break;
			case 1:
				{
				setState(7); match(1);
				setState(8); match(3);
				{
				setState(9); ((ExpContext)_localctx).exp_0 = exp(0);
				setState(14);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==7) {
					{
					{
					setState(10); match(7);
					setState(11); ((ExpContext)_localctx).exp = exp(0);
					((ExpContext)_localctx).exp_0tail.add(((ExpContext)_localctx).exp);
					}
					}
					setState(16);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(17); match(4);
				((ExpContext)_localctx)._exp =  builder.avg(lift("_exp", ((ExpContext)_localctx).exp_0tail, ((ExpContext)_localctx).exp_0._exp));
				}
				break;
			case 2:
				{
				setState(20); match(2);
				setState(21); match(3);
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(22); ((ExpContext)_localctx).exp = exp(0);
					((ExpContext)_localctx).exp_0_list.add(((ExpContext)_localctx).exp);
					}
					}
					setState(25); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << NUM))) != 0) );
				setState(27); match(4);
				((ExpContext)_localctx)._exp =  builder.avg2(lift("_exp", ((ExpContext)_localctx).exp_0_list));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(42);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.exp_0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(32);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(33); match(5);
						setState(34); ((ExpContext)_localctx).exp_1 = exp(3);
						((ExpContext)_localctx)._exp =  builder.mul((((ExpContext)_localctx).exp_0._exp),(((ExpContext)_localctx).exp_1._exp));
						}
						break;

					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.exp_0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(37);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(38); match(6);
						setState(39); ((ExpContext)_localctx).exp_1 = exp(2);
						((ExpContext)_localctx)._exp =  builder.add((((ExpContext)_localctx).exp_0._exp),(((ExpContext)_localctx).exp_1._exp));
						}
						break;
					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ProgContext extends ParserRuleContext {
		public Object _prog;
		public ExpContext exp_0;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); ((ProgContext)_localctx).exp_0 = exp(0);
			((ProgContext)_localctx)._prog =  builder.start((((ProgContext)_localctx).exp_0._exp));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0: return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);

		case 1: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13\65\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\17\n\2\f\2\16\2\22\13\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\6\2\32\n\2\r\2\16\2\33\3\2\3\2\3\2\5\2!\n\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2-\n\2\f\2\16\2\60\13\2\3\3\3\3\3\3"+
		"\3\3\2\3\2\4\2\4\2\28\2 \3\2\2\2\4\61\3\2\2\2\6\7\b\2\1\2\7\b\7\n\2\2"+
		"\b!\b\2\1\2\t\n\7\3\2\2\n\13\7\5\2\2\13\20\5\2\2\2\f\r\7\t\2\2\r\17\5"+
		"\2\2\2\16\f\3\2\2\2\17\22\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21\23\3"+
		"\2\2\2\22\20\3\2\2\2\23\24\7\6\2\2\24\25\b\2\1\2\25!\3\2\2\2\26\27\7\4"+
		"\2\2\27\31\7\5\2\2\30\32\5\2\2\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2"+
		"\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\7\6\2\2\36\37\b\2\1\2\37!\3\2\2"+
		"\2 \6\3\2\2\2 \t\3\2\2\2 \26\3\2\2\2!.\3\2\2\2\"#\f\4\2\2#$\7\7\2\2$%"+
		"\5\2\2\5%&\b\2\1\2&-\3\2\2\2\'(\f\3\2\2()\7\b\2\2)*\5\2\2\4*+\b\2\1\2"+
		"+-\3\2\2\2,\"\3\2\2\2,\'\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\3\3"+
		"\2\2\2\60.\3\2\2\2\61\62\5\2\2\2\62\63\b\3\1\2\63\5\3\2\2\2\7\20\33 ,"+
		".";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}