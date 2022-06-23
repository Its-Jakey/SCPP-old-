package antlr;// Generated from C.g4 by ANTLR 4.7.1

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, STRING=26, LIBRARY=27, ID=28, INT=29, HEX=30, BIN=31, VARIABLE_MODIFIER=32, 
		VARIABLE_SINGLE_MODIFIER=33, OPERATOR=34, NOT=35, WS=36, SINGLE_COMMENT=37, 
		BLOCK_COMMENT=38, L_PAREN=39, R_PAREN=40;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_compilerFunction = 2, RULE_compilerFunctionValue = 3, 
		RULE_bracketBlock = 4, RULE_bracketStatement = 5, RULE_ifStatement = 6, 
		RULE_whileStatement = 7, RULE_forStatement = 8, RULE_switchStatement = 9, 
		RULE_switchBody = 10, RULE_caseBlock = 11, RULE_defaultBlock = 12, RULE_methodDefinition = 13, 
		RULE_nonBracketStatement = 14, RULE_namespaceDefinition = 15, RULE_returnStatement = 16, 
		RULE_variableArrayDefinition = 17, RULE_variableDefinition = 18, RULE_memoryAddressChange = 19, 
		RULE_variableValueChange = 20, RULE_methodCall = 21, RULE_value = 22, 
		RULE_expression = 23, RULE_condition = 24, RULE_argumentArray = 25, RULE_methodArgumentArray = 26, 
		RULE_variable = 27, RULE_offset = 28;
	public static final String[] ruleNames = {
		"program", "statement", "compilerFunction", "compilerFunctionValue", "bracketBlock", 
		"bracketStatement", "ifStatement", "whileStatement", "forStatement", "switchStatement", 
		"switchBody", "caseBlock", "defaultBlock", "methodDefinition", "nonBracketStatement", 
		"namespaceDefinition", "returnStatement", "variableArrayDefinition", "variableDefinition", 
		"memoryAddressChange", "variableValueChange", "methodCall", "value", "expression", 
		"condition", "argumentArray", "methodArgumentArray", "variable", "offset"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'#'", "'{'", "'}'", "'if'", "'while'", "'for'", "'from'", 
		"'to'", "'by'", "'switch'", "'case'", "'->'", "'defualt'", "'public'", 
		"'func'", "'namespace'", "'return'", "'var'", "'='", "'*'", "','", "'::'", 
		"'['", "']'", null, null, null, null, null, null, null, null, null, "'!'", 
		null, null, null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "STRING", "LIBRARY", "ID", "INT", "HEX", "BIN", "VARIABLE_MODIFIER", 
		"VARIABLE_SINGLE_MODIFIER", "OPERATOR", "NOT", "WS", "SINGLE_COMMENT", 
		"BLOCK_COMMENT", "L_PAREN", "R_PAREN"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "C.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(58);
					statement();
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
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

	public static class StatementContext extends ParserRuleContext {
		public BracketStatementContext bracketStatement() {
			return getRuleContext(BracketStatementContext.class,0);
		}
		public NonBracketStatementContext nonBracketStatement() {
			return getRuleContext(NonBracketStatementContext.class,0);
		}
		public CompilerFunctionContext compilerFunction() {
			return getRuleContext(CompilerFunctionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				bracketStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				nonBracketStatement();
				setState(66);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				compilerFunction();
				}
				break;
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

	public static class CompilerFunctionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public List<CompilerFunctionValueContext> compilerFunctionValue() {
			return getRuleContexts(CompilerFunctionValueContext.class);
		}
		public CompilerFunctionValueContext compilerFunctionValue(int i) {
			return getRuleContext(CompilerFunctionValueContext.class,i);
		}
		public CompilerFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilerFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterCompilerFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitCompilerFunction(this);
		}
	}

	public final CompilerFunctionContext compilerFunction() throws RecognitionException {
		CompilerFunctionContext _localctx = new CompilerFunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_compilerFunction);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__1);
			setState(72);
			match(ID);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(73);
					compilerFunctionValue();
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
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

	public static class CompilerFunctionValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CParser.INT, 0); }
		public TerminalNode HEX() { return getToken(CParser.HEX, 0); }
		public TerminalNode BIN() { return getToken(CParser.BIN, 0); }
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public TerminalNode STRING() { return getToken(CParser.STRING, 0); }
		public TerminalNode LIBRARY() { return getToken(CParser.LIBRARY, 0); }
		public CompilerFunctionValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilerFunctionValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterCompilerFunctionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitCompilerFunctionValue(this);
		}
	}

	public final CompilerFunctionValueContext compilerFunctionValue() throws RecognitionException {
		CompilerFunctionValueContext _localctx = new CompilerFunctionValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_compilerFunctionValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << LIBRARY) | (1L << ID) | (1L << INT) | (1L << HEX) | (1L << BIN))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class BracketBlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public NonBracketStatementContext nonBracketStatement() {
			return getRuleContext(NonBracketStatementContext.class,0);
		}
		public BracketBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterBracketBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitBracketBlock(this);
		}
	}

	public final BracketBlockContext bracketBlock() throws RecognitionException {
		BracketBlockContext _localctx = new BracketBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bracketBlock);
		try {
			int _alt;
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(T__2);
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(82);
						statement();
						}
						} 
					}
					setState(87);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(88);
				match(T__3);
				}
				break;
			case T__14:
			case T__17:
			case T__18:
			case T__20:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				nonBracketStatement();
				setState(90);
				match(T__0);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class BracketStatementContext extends ParserRuleContext {
		public NamespaceDefinitionContext namespaceDefinition() {
			return getRuleContext(NamespaceDefinitionContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public MethodDefinitionContext methodDefinition() {
			return getRuleContext(MethodDefinitionContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public BracketStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterBracketStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitBracketStatement(this);
		}
	}

	public final BracketStatementContext bracketStatement() throws RecognitionException {
		BracketStatementContext _localctx = new BracketStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bracketStatement);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				namespaceDefinition();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				ifStatement();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				whileStatement();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				forStatement();
				}
				break;
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 5);
				{
				setState(98);
				methodDefinition();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(99);
				switchStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class IfStatementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BracketBlockContext bracketBlock() {
			return getRuleContext(BracketBlockContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__4);
			setState(103);
			condition();
			setState(104);
			bracketBlock();
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

	public static class WhileStatementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BracketBlockContext bracketBlock() {
			return getRuleContext(BracketBlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__5);
			setState(107);
			condition();
			setState(108);
			bracketBlock();
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

	public static class ForStatementContext extends ParserRuleContext {
		public Token by;
		public TerminalNode L_PAREN() { return getToken(CParser.L_PAREN, 0); }
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode R_PAREN() { return getToken(CParser.R_PAREN, 0); }
		public BracketBlockContext bracketBlock() {
			return getRuleContext(BracketBlockContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__6);
			setState(111);
			match(L_PAREN);
			setState(112);
			match(ID);
			setState(113);
			match(T__7);
			setState(114);
			expression(0);
			setState(115);
			match(T__8);
			setState(116);
			expression(0);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(117);
				((ForStatementContext)_localctx).by = match(T__9);
				setState(118);
				expression(0);
				}
			}

			setState(121);
			match(R_PAREN);
			setState(122);
			bracketBlock();
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

	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(CParser.L_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(CParser.R_PAREN, 0); }
		public SwitchBodyContext switchBody() {
			return getRuleContext(SwitchBodyContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitSwitchStatement(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_switchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__10);
			setState(125);
			match(L_PAREN);
			setState(126);
			expression(0);
			setState(127);
			match(R_PAREN);
			setState(128);
			switchBody();
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

	public static class SwitchBodyContext extends ParserRuleContext {
		public List<CaseBlockContext> caseBlock() {
			return getRuleContexts(CaseBlockContext.class);
		}
		public CaseBlockContext caseBlock(int i) {
			return getRuleContext(CaseBlockContext.class,i);
		}
		public DefaultBlockContext defaultBlock() {
			return getRuleContext(DefaultBlockContext.class,0);
		}
		public SwitchBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterSwitchBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitSwitchBody(this);
		}
	}

	public final SwitchBodyContext switchBody() throws RecognitionException {
		SwitchBodyContext _localctx = new SwitchBodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_switchBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__2);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(131);
					caseBlock();
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(137);
				defaultBlock();
				}
			}

			setState(140);
			match(T__3);
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

	public static class CaseBlockContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BracketBlockContext bracketBlock() {
			return getRuleContext(BracketBlockContext.class,0);
		}
		public CaseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterCaseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitCaseBlock(this);
		}
	}

	public final CaseBlockContext caseBlock() throws RecognitionException {
		CaseBlockContext _localctx = new CaseBlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_caseBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__11);
			setState(143);
			expression(0);
			setState(144);
			match(T__12);
			setState(145);
			bracketBlock();
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

	public static class DefaultBlockContext extends ParserRuleContext {
		public BracketBlockContext bracketBlock() {
			return getRuleContext(BracketBlockContext.class,0);
		}
		public DefaultBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterDefaultBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitDefaultBlock(this);
		}
	}

	public final DefaultBlockContext defaultBlock() throws RecognitionException {
		DefaultBlockContext _localctx = new DefaultBlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_defaultBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__13);
			setState(148);
			match(T__12);
			setState(149);
			bracketBlock();
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

	public static class MethodDefinitionContext extends ParserRuleContext {
		public Token pub;
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public TerminalNode L_PAREN() { return getToken(CParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(CParser.R_PAREN, 0); }
		public BracketBlockContext bracketBlock() {
			return getRuleContext(BracketBlockContext.class,0);
		}
		public MethodArgumentArrayContext methodArgumentArray() {
			return getRuleContext(MethodArgumentArrayContext.class,0);
		}
		public MethodDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterMethodDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitMethodDefinition(this);
		}
	}

	public final MethodDefinitionContext methodDefinition() throws RecognitionException {
		MethodDefinitionContext _localctx = new MethodDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_methodDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(151);
				((MethodDefinitionContext)_localctx).pub = match(T__14);
				}
			}

			setState(154);
			match(T__15);
			setState(155);
			match(ID);
			setState(156);
			match(L_PAREN);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(157);
				methodArgumentArray();
				}
			}

			setState(160);
			match(R_PAREN);
			setState(161);
			bracketBlock();
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

	public static class NonBracketStatementContext extends ParserRuleContext {
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public VariableArrayDefinitionContext variableArrayDefinition() {
			return getRuleContext(VariableArrayDefinitionContext.class,0);
		}
		public VariableValueChangeContext variableValueChange() {
			return getRuleContext(VariableValueChangeContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public MemoryAddressChangeContext memoryAddressChange() {
			return getRuleContext(MemoryAddressChangeContext.class,0);
		}
		public NonBracketStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonBracketStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterNonBracketStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitNonBracketStatement(this);
		}
	}

	public final NonBracketStatementContext nonBracketStatement() throws RecognitionException {
		NonBracketStatementContext _localctx = new NonBracketStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_nonBracketStatement);
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				variableDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				variableArrayDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				variableValueChange();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(166);
				methodCall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(167);
				returnStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(168);
				memoryAddressChange();
				}
				break;
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

	public static class NamespaceDefinitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public BracketBlockContext bracketBlock() {
			return getRuleContext(BracketBlockContext.class,0);
		}
		public NamespaceDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterNamespaceDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitNamespaceDefinition(this);
		}
	}

	public final NamespaceDefinitionContext namespaceDefinition() throws RecognitionException {
		NamespaceDefinitionContext _localctx = new NamespaceDefinitionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_namespaceDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__16);
			setState(172);
			match(ID);
			setState(173);
			bracketBlock();
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(T__17);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << STRING) | (1L << ID) | (1L << INT) | (1L << HEX) | (1L << BIN) | (1L << L_PAREN))) != 0)) {
				{
				setState(176);
				expression(0);
				}
			}

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

	public static class VariableArrayDefinitionContext extends ParserRuleContext {
		public Token pub;
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public ArgumentArrayContext argumentArray() {
			return getRuleContext(ArgumentArrayContext.class,0);
		}
		public VariableArrayDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableArrayDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterVariableArrayDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitVariableArrayDefinition(this);
		}
	}

	public final VariableArrayDefinitionContext variableArrayDefinition() throws RecognitionException {
		VariableArrayDefinitionContext _localctx = new VariableArrayDefinitionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_variableArrayDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(179);
				((VariableArrayDefinitionContext)_localctx).pub = match(T__14);
				}
			}

			setState(182);
			match(T__18);
			setState(183);
			match(ID);
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				{
				setState(184);
				offset();
				}
				break;
			case T__19:
				{
				setState(185);
				match(T__19);
				setState(186);
				match(T__2);
				setState(187);
				argumentArray();
				setState(188);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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

	public static class VariableDefinitionContext extends ParserRuleContext {
		public Token pub;
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitVariableDefinition(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(192);
				((VariableDefinitionContext)_localctx).pub = match(T__14);
				}
			}

			setState(195);
			match(T__18);
			setState(196);
			match(ID);
			setState(197);
			match(T__19);
			setState(198);
			expression(0);
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

	public static class MemoryAddressChangeContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MemoryAddressChangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memoryAddressChange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterMemoryAddressChange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitMemoryAddressChange(this);
		}
	}

	public final MemoryAddressChangeContext memoryAddressChange() throws RecognitionException {
		MemoryAddressChangeContext _localctx = new MemoryAddressChangeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_memoryAddressChange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(T__20);
			setState(201);
			expression(0);
			setState(202);
			match(T__19);
			setState(203);
			expression(0);
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

	public static class VariableValueChangeContext extends ParserRuleContext {
		public Token pointer;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode VARIABLE_SINGLE_MODIFIER() { return getToken(CParser.VARIABLE_SINGLE_MODIFIER, 0); }
		public TerminalNode VARIABLE_MODIFIER() { return getToken(CParser.VARIABLE_MODIFIER, 0); }
		public VariableValueChangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableValueChange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterVariableValueChange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitVariableValueChange(this);
		}
	}

	public final VariableValueChangeContext variableValueChange() throws RecognitionException {
		VariableValueChangeContext _localctx = new VariableValueChangeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_variableValueChange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(205);
				((VariableValueChangeContext)_localctx).pointer = match(T__20);
				}
			}

			setState(208);
			variable();
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
			case VARIABLE_MODIFIER:
				{
				setState(209);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==VARIABLE_MODIFIER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(210);
				expression(0);
				}
				break;
			case VARIABLE_SINGLE_MODIFIER:
				{
				setState(211);
				match(VARIABLE_SINGLE_MODIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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

	public static class MethodCallContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode L_PAREN() { return getToken(CParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(CParser.R_PAREN, 0); }
		public ArgumentArrayContext argumentArray() {
			return getRuleContext(ArgumentArrayContext.class,0);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitMethodCall(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			variable();
			setState(215);
			match(L_PAREN);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << STRING) | (1L << ID) | (1L << INT) | (1L << HEX) | (1L << BIN) | (1L << L_PAREN))) != 0)) {
				{
				setState(216);
				argumentArray();
				}
			}

			setState(219);
			match(R_PAREN);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CParser.STRING, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode INT() { return getToken(CParser.INT, 0); }
		public TerminalNode HEX() { return getToken(CParser.HEX, 0); }
		public TerminalNode BIN() { return getToken(CParser.BIN, 0); }
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_value);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(223);
				match(INT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				match(HEX);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(225);
				match(BIN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(226);
				methodCall();
				}
				break;
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

	public static class ExpressionContext extends ParserRuleContext {
		public Token pointer;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode L_PAREN() { return getToken(CParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(CParser.R_PAREN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode OPERATOR() { return getToken(CParser.OPERATOR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				{
				setState(230);
				((ExpressionContext)_localctx).pointer = match(T__20);
				setState(231);
				expression(4);
				}
				break;
			case L_PAREN:
				{
				setState(232);
				match(L_PAREN);
				setState(233);
				expression(0);
				setState(234);
				match(R_PAREN);
				}
				break;
			case STRING:
			case ID:
			case INT:
			case HEX:
			case BIN:
				{
				setState(236);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(239);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(240);
					match(OPERATOR);
					setState(241);
					expression(4);
					}
					} 
				}
				setState(246);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(CParser.L_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(CParser.R_PAREN, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(L_PAREN);
			setState(248);
			expression(0);
			setState(249);
			match(R_PAREN);
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

	public static class ArgumentArrayContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentArrayContext argumentArray() {
			return getRuleContext(ArgumentArrayContext.class,0);
		}
		public ArgumentArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterArgumentArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitArgumentArray(this);
		}
	}

	public final ArgumentArrayContext argumentArray() throws RecognitionException {
		ArgumentArrayContext _localctx = new ArgumentArrayContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_argumentArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			expression(0);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(252);
				match(T__21);
				setState(253);
				argumentArray();
				}
			}

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

	public static class MethodArgumentArrayContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public MethodArgumentArrayContext methodArgumentArray() {
			return getRuleContext(MethodArgumentArrayContext.class,0);
		}
		public MethodArgumentArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodArgumentArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterMethodArgumentArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitMethodArgumentArray(this);
		}
	}

	public final MethodArgumentArrayContext methodArgumentArray() throws RecognitionException {
		MethodArgumentArrayContext _localctx = new MethodArgumentArrayContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_methodArgumentArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(ID);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(257);
				match(T__21);
				setState(258);
				methodArgumentArray();
				}
			}

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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(ID);
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(262);
				match(T__22);
				setState(263);
				variable();
				}
				break;
			}
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

	public static class OffsetContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OffsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).enterOffset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener) ((CListener)listener).exitOffset(this);
		}
	}

	public final OffsetContext offset() throws RecognitionException {
		OffsetContext _localctx = new OffsetContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_offset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(T__23);
			setState(267);
			expression(0);
			setState(268);
			match(T__24);
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
		case 23:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u0111\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\7\2>\n\2\f\2\16"+
		"\2A\13\2\3\3\3\3\3\3\3\3\3\3\5\3H\n\3\3\4\3\4\3\4\7\4M\n\4\f\4\16\4P\13"+
		"\4\3\5\3\5\3\6\3\6\7\6V\n\6\f\6\16\6Y\13\6\3\6\3\6\3\6\3\6\5\6_\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7g\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nz\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\7\f\u0087\n\f\f\f\16\f\u008a\13\f\3\f\5\f\u008d\n\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\5\17\u009b\n\17"+
		"\3\17\3\17\3\17\3\17\5\17\u00a1\n\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u00ac\n\20\3\21\3\21\3\21\3\21\3\22\3\22\5\22\u00b4\n"+
		"\22\3\23\5\23\u00b7\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u00c1\n\23\3\24\5\24\u00c4\n\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\3\25\3\26\5\26\u00d1\n\26\3\26\3\26\3\26\3\26\5\26\u00d7\n\26"+
		"\3\27\3\27\3\27\5\27\u00dc\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u00e6\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00f0\n"+
		"\31\3\31\3\31\3\31\7\31\u00f5\n\31\f\31\16\31\u00f8\13\31\3\32\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\5\33\u0101\n\33\3\34\3\34\3\34\5\34\u0106\n\34"+
		"\3\35\3\35\3\35\5\35\u010b\n\35\3\36\3\36\3\36\3\36\3\36\6?NW\u0088\3"+
		"\60\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2"+
		"\4\3\2\34!\4\2\26\26\"\"\2\u011a\2?\3\2\2\2\4G\3\2\2\2\6I\3\2\2\2\bQ\3"+
		"\2\2\2\n^\3\2\2\2\ff\3\2\2\2\16h\3\2\2\2\20l\3\2\2\2\22p\3\2\2\2\24~\3"+
		"\2\2\2\26\u0084\3\2\2\2\30\u0090\3\2\2\2\32\u0095\3\2\2\2\34\u009a\3\2"+
		"\2\2\36\u00ab\3\2\2\2 \u00ad\3\2\2\2\"\u00b1\3\2\2\2$\u00b6\3\2\2\2&\u00c3"+
		"\3\2\2\2(\u00ca\3\2\2\2*\u00d0\3\2\2\2,\u00d8\3\2\2\2.\u00e5\3\2\2\2\60"+
		"\u00ef\3\2\2\2\62\u00f9\3\2\2\2\64\u00fd\3\2\2\2\66\u0102\3\2\2\28\u0107"+
		"\3\2\2\2:\u010c\3\2\2\2<>\5\4\3\2=<\3\2\2\2>A\3\2\2\2?@\3\2\2\2?=\3\2"+
		"\2\2@\3\3\2\2\2A?\3\2\2\2BH\5\f\7\2CD\5\36\20\2DE\7\3\2\2EH\3\2\2\2FH"+
		"\5\6\4\2GB\3\2\2\2GC\3\2\2\2GF\3\2\2\2H\5\3\2\2\2IJ\7\4\2\2JN\7\36\2\2"+
		"KM\5\b\5\2LK\3\2\2\2MP\3\2\2\2NO\3\2\2\2NL\3\2\2\2O\7\3\2\2\2PN\3\2\2"+
		"\2QR\t\2\2\2R\t\3\2\2\2SW\7\5\2\2TV\5\4\3\2UT\3\2\2\2VY\3\2\2\2WX\3\2"+
		"\2\2WU\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z_\7\6\2\2[\\\5\36\20\2\\]\7\3\2\2]"+
		"_\3\2\2\2^S\3\2\2\2^[\3\2\2\2_\13\3\2\2\2`g\5 \21\2ag\5\16\b\2bg\5\20"+
		"\t\2cg\5\22\n\2dg\5\34\17\2eg\5\24\13\2f`\3\2\2\2fa\3\2\2\2fb\3\2\2\2"+
		"fc\3\2\2\2fd\3\2\2\2fe\3\2\2\2g\r\3\2\2\2hi\7\7\2\2ij\5\62\32\2jk\5\n"+
		"\6\2k\17\3\2\2\2lm\7\b\2\2mn\5\62\32\2no\5\n\6\2o\21\3\2\2\2pq\7\t\2\2"+
		"qr\7)\2\2rs\7\36\2\2st\7\n\2\2tu\5\60\31\2uv\7\13\2\2vy\5\60\31\2wx\7"+
		"\f\2\2xz\5\60\31\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7*\2\2|}\5\n\6\2}\23"+
		"\3\2\2\2~\177\7\r\2\2\177\u0080\7)\2\2\u0080\u0081\5\60\31\2\u0081\u0082"+
		"\7*\2\2\u0082\u0083\5\26\f\2\u0083\25\3\2\2\2\u0084\u0088\7\5\2\2\u0085"+
		"\u0087\5\30\r\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0089\3"+
		"\2\2\2\u0088\u0086\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008b"+
		"\u008d\5\32\16\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u008f\7\6\2\2\u008f\27\3\2\2\2\u0090\u0091\7\16\2\2\u0091"+
		"\u0092\5\60\31\2\u0092\u0093\7\17\2\2\u0093\u0094\5\n\6\2\u0094\31\3\2"+
		"\2\2\u0095\u0096\7\20\2\2\u0096\u0097\7\17\2\2\u0097\u0098\5\n\6\2\u0098"+
		"\33\3\2\2\2\u0099\u009b\7\21\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2"+
		"\2\u009b\u009c\3\2\2\2\u009c\u009d\7\22\2\2\u009d\u009e\7\36\2\2\u009e"+
		"\u00a0\7)\2\2\u009f\u00a1\5\66\34\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3"+
		"\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7*\2\2\u00a3\u00a4\5\n\6\2\u00a4"+
		"\35\3\2\2\2\u00a5\u00ac\5&\24\2\u00a6\u00ac\5$\23\2\u00a7\u00ac\5*\26"+
		"\2\u00a8\u00ac\5,\27\2\u00a9\u00ac\5\"\22\2\u00aa\u00ac\5(\25\2\u00ab"+
		"\u00a5\3\2\2\2\u00ab\u00a6\3\2\2\2\u00ab\u00a7\3\2\2\2\u00ab\u00a8\3\2"+
		"\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\37\3\2\2\2\u00ad\u00ae"+
		"\7\23\2\2\u00ae\u00af\7\36\2\2\u00af\u00b0\5\n\6\2\u00b0!\3\2\2\2\u00b1"+
		"\u00b3\7\24\2\2\u00b2\u00b4\5\60\31\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4"+
		"\3\2\2\2\u00b4#\3\2\2\2\u00b5\u00b7\7\21\2\2\u00b6\u00b5\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\7\25\2\2\u00b9\u00c0\7"+
		"\36\2\2\u00ba\u00c1\5:\36\2\u00bb\u00bc\7\26\2\2\u00bc\u00bd\7\5\2\2\u00bd"+
		"\u00be\5\64\33\2\u00be\u00bf\7\6\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00ba\3"+
		"\2\2\2\u00c0\u00bb\3\2\2\2\u00c1%\3\2\2\2\u00c2\u00c4\7\21\2\2\u00c3\u00c2"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\7\25\2\2"+
		"\u00c6\u00c7\7\36\2\2\u00c7\u00c8\7\26\2\2\u00c8\u00c9\5\60\31\2\u00c9"+
		"\'\3\2\2\2\u00ca\u00cb\7\27\2\2\u00cb\u00cc\5\60\31\2\u00cc\u00cd\7\26"+
		"\2\2\u00cd\u00ce\5\60\31\2\u00ce)\3\2\2\2\u00cf\u00d1\7\27\2\2\u00d0\u00cf"+
		"\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d6\58\35\2\u00d3"+
		"\u00d4\t\3\2\2\u00d4\u00d7\5\60\31\2\u00d5\u00d7\7#\2\2\u00d6\u00d3\3"+
		"\2\2\2\u00d6\u00d5\3\2\2\2\u00d7+\3\2\2\2\u00d8\u00d9\58\35\2\u00d9\u00db"+
		"\7)\2\2\u00da\u00dc\5\64\33\2\u00db\u00da\3\2\2\2\u00db\u00dc\3\2\2\2"+
		"\u00dc\u00dd\3\2\2\2\u00dd\u00de\7*\2\2\u00de-\3\2\2\2\u00df\u00e6\7\34"+
		"\2\2\u00e0\u00e6\58\35\2\u00e1\u00e6\7\37\2\2\u00e2\u00e6\7 \2\2\u00e3"+
		"\u00e6\7!\2\2\u00e4\u00e6\5,\27\2\u00e5\u00df\3\2\2\2\u00e5\u00e0\3\2"+
		"\2\2\u00e5\u00e1\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5"+
		"\u00e4\3\2\2\2\u00e6/\3\2\2\2\u00e7\u00e8\b\31\1\2\u00e8\u00e9\7\27\2"+
		"\2\u00e9\u00f0\5\60\31\6\u00ea\u00eb\7)\2\2\u00eb\u00ec\5\60\31\2\u00ec"+
		"\u00ed\7*\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00f0\5.\30\2\u00ef\u00e7\3\2"+
		"\2\2\u00ef\u00ea\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f6\3\2\2\2\u00f1"+
		"\u00f2\f\5\2\2\u00f2\u00f3\7$\2\2\u00f3\u00f5\5\60\31\6\u00f4\u00f1\3"+
		"\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\61\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\7)\2\2\u00fa\u00fb\5\60\31"+
		"\2\u00fb\u00fc\7*\2\2\u00fc\63\3\2\2\2\u00fd\u0100\5\60\31\2\u00fe\u00ff"+
		"\7\30\2\2\u00ff\u0101\5\64\33\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2"+
		"\2\u0101\65\3\2\2\2\u0102\u0105\7\36\2\2\u0103\u0104\7\30\2\2\u0104\u0106"+
		"\5\66\34\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\67\3\2\2\2\u0107"+
		"\u010a\7\36\2\2\u0108\u0109\7\31\2\2\u0109\u010b\58\35\2\u010a\u0108\3"+
		"\2\2\2\u010a\u010b\3\2\2\2\u010b9\3\2\2\2\u010c\u010d\7\32\2\2\u010d\u010e"+
		"\5\60\31\2\u010e\u010f\7\33\2\2\u010f;\3\2\2\2\33?GNW^fy\u0088\u008c\u009a"+
		"\u00a0\u00ab\u00b3\u00b6\u00c0\u00c3\u00d0\u00d6\u00db\u00e5\u00ef\u00f6"+
		"\u0100\u0105\u010a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}