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
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, WS=6, NUM=7;
	public static final String[] tokenNames = {
		"<INVALID>", "'*'", "'+'", "'['", "','", "']'", "WS", "NUM"
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
		public java.lang.Object _p;
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
			((PContext)_localctx)._p =  (java.lang.Object)builder.start((java.lang.Object)(((PContext)_localctx).e_0._e));
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
		public java.lang.Object _e;
		public EContext e_0;
		public EContext e;
		public List<EContext> e_0tail = new ArrayList<EContext>();
		public Token NUM_0;
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
			setState(22);
			switch (_input.LA(1)) {
			case 3:
				{
				setState(8); match(3);
				{
				setState(9); ((EContext)_localctx).e_0 = e(0);
				setState(14);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(10); match(4);
					setState(11); ((EContext)_localctx).e = e(0);
					((EContext)_localctx).e_0tail.add(((EContext)_localctx).e);
					}
					}
					setState(16);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(17); match(5);
				((EContext)_localctx)._e =  (java.lang.Object)builder.list(lift("_e", ((EContext)_localctx).e_0tail, ((EContext)_localctx).e_0._e));
				}
				break;
			case NUM:
				{
				setState(20); ((EContext)_localctx).NUM_0 = match(NUM);
				((EContext)_localctx)._e =  (java.lang.Object)builder.lit(num((((EContext)_localctx).NUM_0!=null?((EContext)_localctx).NUM_0.getText():null)));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(34);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.e_0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(24);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(25); match(1);
						setState(26); ((EContext)_localctx).e_1 = e(3);
						((EContext)_localctx)._e =  (java.lang.Object)builder.mul((java.lang.Object)(((EContext)_localctx).e_0._e),(java.lang.Object)(((EContext)_localctx).e_1._e));
						}
						break;

					case 2:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.e_0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(29);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(30); match(2);
						setState(31); ((EContext)_localctx).e_1 = e(2);
						((EContext)_localctx)._e =  (java.lang.Object)builder.add((java.lang.Object)(((EContext)_localctx).e_0._e),(java.lang.Object)(((EContext)_localctx).e_1._e));
						}
						break;
					}
					} 
				}
				setState(38);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t*\4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3\17\n\3\f\3\16\3\22\13\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3\31\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3%\n"+
		"\3\f\3\16\3(\13\3\3\3\2\3\4\4\2\4\2\2+\2\6\3\2\2\2\4\30\3\2\2\2\6\7\5"+
		"\4\3\2\7\b\b\2\1\2\b\3\3\2\2\2\t\n\b\3\1\2\n\13\7\5\2\2\13\20\5\4\3\2"+
		"\f\r\7\6\2\2\r\17\5\4\3\2\16\f\3\2\2\2\17\22\3\2\2\2\20\16\3\2\2\2\20"+
		"\21\3\2\2\2\21\23\3\2\2\2\22\20\3\2\2\2\23\24\7\7\2\2\24\25\b\3\1\2\25"+
		"\31\3\2\2\2\26\27\7\t\2\2\27\31\b\3\1\2\30\t\3\2\2\2\30\26\3\2\2\2\31"+
		"&\3\2\2\2\32\33\f\4\2\2\33\34\7\3\2\2\34\35\5\4\3\5\35\36\b\3\1\2\36%"+
		"\3\2\2\2\37 \f\3\2\2 !\7\4\2\2!\"\5\4\3\4\"#\b\3\1\2#%\3\2\2\2$\32\3\2"+
		"\2\2$\37\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\5\3\2\2\2(&\3\2\2\2"+
		"\6\20\30$&";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}