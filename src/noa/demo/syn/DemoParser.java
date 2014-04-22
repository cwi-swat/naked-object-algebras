// Generated from src/noa/demo/syn/ by ANTLR 4.2.2

package noa.demo.syn;
import static noa.demo.syn.Tokens.*;

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
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, WS=7, NUM=8;
	public static final String[] tokenNames = {
		"<INVALID>", "'avg'", "'('", "')'", "'*'", "'+'", "','", "WS", "NUM"
	};
	public static final int
		RULE_p = 0, RULE_e = 1;
	public static final String[] ruleNames = {
		"p", "e"
	};

	@Override
	public String getGrammarFileName() { return "syn"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private noa.demo.alg.ExpAlg builder;
	public void setBuilder(noa.demo.alg.ExpAlg builder) { this.builder = builder; }
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
	public static class PContext extends ParserRuleContext {
		public Object _p;
		public EContext e_0;
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public PContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p; }
	}

	public final PContext p() throws RecognitionException {
		PContext _localctx = new PContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_p);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4); ((PContext)_localctx).e_0 = e(0);
			((PContext)_localctx)._p =  builder.start((((PContext)_localctx).e_0._e));
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

	public static class EContext extends ParserRuleContext {
		public Object _e;
		public EContext e_0;
		public Token NUM_0;
		public EContext e;
		public List<EContext> e_0tail = new ArrayList<EContext>();
		public EContext e_1;
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public TerminalNode NUM() { return getToken(DemoParser.NUM, 0); }
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
	}

	public final EContext e() throws RecognitionException {
		return e(0);
	}

	private EContext e(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EContext _localctx = new EContext(_ctx, _parentState);
		EContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_e, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			switch (_input.LA(1)) {
			case NUM:
				{
				setState(8); ((EContext)_localctx).NUM_0 = match(NUM);
				((EContext)_localctx)._e =  builder.lit(num((((EContext)_localctx).NUM_0!=null?((EContext)_localctx).NUM_0.getText():null)));
				}
				break;
			case 1:
				{
				setState(10); match(1);
				setState(11); match(2);
				{
				setState(12); ((EContext)_localctx).e_0 = e(0);
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==6) {
					{
					{
					setState(13); match(6);
					setState(14); ((EContext)_localctx).e = e(0);
					((EContext)_localctx).e_0tail.add(((EContext)_localctx).e);
					}
					}
					setState(19);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(20); match(3);
				((EContext)_localctx)._e =  builder.avg(lift("_e", ((EContext)_localctx).e_0tail, ((EContext)_localctx).e_0._e));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(35);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.e_0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(25);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(26); match(4);
						setState(27); ((EContext)_localctx).e_1 = e(3);
						((EContext)_localctx)._e =  builder.mul((((EContext)_localctx).e_0._e),(((EContext)_localctx).e_1._e));
						}
						break;

					case 2:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.e_0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(30);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(31); match(5);
						setState(32); ((EContext)_localctx).e_1 = e(2);
						((EContext)_localctx)._e =  builder.add((((EContext)_localctx).e_0._e),(((EContext)_localctx).e_1._e));
						}
						break;
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return e_sempred((EContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean e_sempred(EContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);

		case 1: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\n+\4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\22\n\3\f\3\16\3\25"+
		"\13\3\3\3\3\3\3\3\5\3\32\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7"+
		"\3&\n\3\f\3\16\3)\13\3\3\3\2\3\4\4\2\4\2\2,\2\6\3\2\2\2\4\31\3\2\2\2\6"+
		"\7\5\4\3\2\7\b\b\2\1\2\b\3\3\2\2\2\t\n\b\3\1\2\n\13\7\n\2\2\13\32\b\3"+
		"\1\2\f\r\7\3\2\2\r\16\7\4\2\2\16\23\5\4\3\2\17\20\7\b\2\2\20\22\5\4\3"+
		"\2\21\17\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\26\3\2\2"+
		"\2\25\23\3\2\2\2\26\27\7\5\2\2\27\30\b\3\1\2\30\32\3\2\2\2\31\t\3\2\2"+
		"\2\31\f\3\2\2\2\32\'\3\2\2\2\33\34\f\4\2\2\34\35\7\6\2\2\35\36\5\4\3\5"+
		"\36\37\b\3\1\2\37&\3\2\2\2 !\f\3\2\2!\"\7\7\2\2\"#\5\4\3\4#$\b\3\1\2$"+
		"&\3\2\2\2%\33\3\2\2\2% \3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\5\3\2"+
		"\2\2)\'\3\2\2\2\6\23\31%\'";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}