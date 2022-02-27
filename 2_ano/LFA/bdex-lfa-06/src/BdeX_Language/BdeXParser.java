// Generated from BdeX.g4 by ANTLR 4.9.2

package BdeX_Language;
import SemanticCheck.*;
import SemanticCheck.Types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BdeXParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, CREATE=16, 
		INTO=17, IN=18, TO=19, FROM=20, WHERE=21, TABLE=22, INTEGER_T=23, DOUBLE_T=24, 
		COLUMN=25, TEXT=26, REMOVE=27, EXTRACT=28, JOIN=29, INSERT=30, MODIFY=31, 
		SAVE=32, READ=33, SHOW=34, SELECOP=35, IDENTIFIER=36, DOUBLE=37, INT=38, 
		STRING=39, WS=40, COMMENT=41, ERROR=42;
	public static final int
		RULE_main = 0, RULE_stat = 1, RULE_declarations = 2, RULE_assignment = 3, 
		RULE_expression = 4, RULE_instruction = 5, RULE_createtable = 6, RULE_createColumn = 7, 
		RULE_extract = 8, RULE_join = 9, RULE_insert = 10, RULE_modify = 11, RULE_remove = 12, 
		RULE_read = 13, RULE_save = 14, RULE_print = 15, RULE_insertStat = 16, 
		RULE_selection = 17, RULE_type = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "stat", "declarations", "assignment", "expression", "instruction", 
			"createtable", "createColumn", "extract", "join", "insert", "modify", 
			"remove", "read", "save", "print", "insertStat", "selection", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'->'", "'+'", "'-'", "'^'", "'*'", "'/'", "'%'", "'('", 
			"')'", "'{'", "'>>'", "'}'", "'|'", "':'", "'create'", "'into'", "'in'", 
			"'to'", "'from'", "'where'", "'Table'", "'int'", "'double'", "'column'", 
			"'text'", "'remove'", "'extract'", "'join'", "'insert'", "'modify'", 
			"'save'", "'read'", "'show'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "CREATE", "INTO", "IN", "TO", "FROM", "WHERE", 
			"TABLE", "INTEGER_T", "DOUBLE_T", "COLUMN", "TEXT", "REMOVE", "EXTRACT", 
			"JOIN", "INSERT", "MODIFY", "SAVE", "READ", "SHOW", "SELECOP", "IDENTIFIER", 
			"DOUBLE", "INT", "STRING", "WS", "COMMENT", "ERROR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "BdeX.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BdeXParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class MainContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BdeXParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << IN) | (1L << TABLE) | (1L << INTEGER_T) | (1L << DOUBLE_T) | (1L << COLUMN) | (1L << TEXT) | (1L << REMOVE) | (1L << INSERT) | (1L << MODIFY) | (1L << SAVE) | (1L << SHOW) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(38);
				stat();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(EOF);
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

	public static class StatContext extends ParserRuleContext {
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TABLE:
			case INTEGER_T:
			case DOUBLE_T:
			case COLUMN:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				declarations();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				assignment();
				}
				break;
			case T__11:
			case IN:
			case REMOVE:
			case INSERT:
			case MODIFY:
			case SAVE:
			case SHOW:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				instruction();
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

	public static class DeclarationsContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(BdeXParser.IDENTIFIER, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declarations);
		try {
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				type();
				setState(52);
				match(IDENTIFIER);
				setState(53);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				type();
				setState(56);
				assignment();
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

	public static class AssignmentContext extends ParserRuleContext {
		public Type eType;
		public String varName;
		public TerminalNode IDENTIFIER() { return getToken(BdeXParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(IDENTIFIER);
			setState(61);
			match(T__1);
			setState(62);
			expression(0);
			setState(63);
			match(T__0);
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
		public Type eType;
		public String varName;
		public Boolean isVar = false;
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this.eType = ctx.eType;
			this.varName = ctx.varName;
			this.isVar = ctx.isVar;
		}
	}
	public static class CreateTableContext extends ExpressionContext {
		public CreatetableContext createtable() {
			return getRuleContext(CreatetableContext.class,0);
		}
		public CreateTableContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterCreateTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitCreateTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitCreateTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleExprContext extends ExpressionContext {
		public TerminalNode DOUBLE() { return getToken(BdeXParser.DOUBLE, 0); }
		public DoubleExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterDoubleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitDoubleExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitDoubleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExprContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(BdeXParser.INT, 0); }
		public IntExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitIntExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubExprContext extends ExpressionContext {
		public ExpressionContext e1;
		public Token op;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddSubExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterAddSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitAddSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitAddSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExtractTableContext extends ExpressionContext {
		public ExtractContext extract() {
			return getRuleContext(ExtractContext.class,0);
		}
		public ExtractTableContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterExtractTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitExtractTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitExtractTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReadExprContext extends ExpressionContext {
		public ReadContext read() {
			return getRuleContext(ReadContext.class,0);
		}
		public ReadExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterReadExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitReadExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitReadExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JoinTableContext extends ExpressionContext {
		public JoinContext join() {
			return getRuleContext(JoinContext.class,0);
		}
		public JoinTableContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterJoinTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitJoinTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitJoinTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExpressionContext {
		public ExpressionContext e;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringExprContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(BdeXParser.STRING, 0); }
		public StringExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterStringExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitStringExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitStringExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExprContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(BdeXParser.IDENTIFIER, 0); }
		public VarExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitVarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SignExprContext extends ExpressionContext {
		public Token sign;
		public ExpressionContext e;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SignExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterSignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitSignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitSignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultDivRemExprContext extends ExpressionContext {
		public ExpressionContext e1;
		public Token op;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultDivRemExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterMultDivRemExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitMultDivRemExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitMultDivRemExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreatecolumnContext extends ExpressionContext {
		public CreateColumnContext createColumn() {
			return getRuleContext(CreateColumnContext.class,0);
		}
		public CreatecolumnContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterCreatecolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitCreatecolumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitCreatecolumn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowExprContext extends ExpressionContext {
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PowExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterPowExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitPowExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitPowExpr(this);
			else return visitor.visitChildren(this);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new SignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(66);
				((SignExprContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__3) ) {
					((SignExprContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(67);
				((SignExprContext)_localctx).e = expression(14);
				}
				break;
			case 2:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				match(T__8);
				setState(69);
				((ParenExprContext)_localctx).e = expression(0);
				setState(70);
				match(T__9);
				}
				break;
			case 3:
				{
				_localctx = new CreateTableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				createtable();
				}
				break;
			case 4:
				{
				_localctx = new JoinTableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				join();
				}
				break;
			case 5:
				{
				_localctx = new ExtractTableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				extract();
				}
				break;
			case 6:
				{
				_localctx = new ReadExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75);
				read();
				}
				break;
			case 7:
				{
				_localctx = new CreatecolumnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				createColumn();
				}
				break;
			case 8:
				{
				_localctx = new DoubleExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				match(DOUBLE);
				}
				break;
			case 9:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(INT);
				}
				break;
			case 10:
				{
				_localctx = new StringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				match(STRING);
				}
				break;
			case 11:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				match(IDENTIFIER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(92);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExpressionContext(_parentctx, _parentState));
						((PowExprContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(83);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(84);
						match(T__4);
						setState(85);
						((PowExprContext)_localctx).e2 = expression(13);
						}
						break;
					case 2:
						{
						_localctx = new MultDivRemExprContext(new ExpressionContext(_parentctx, _parentState));
						((MultDivRemExprContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(86);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(87);
						((MultDivRemExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) ) {
							((MultDivRemExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(88);
						((MultDivRemExprContext)_localctx).e2 = expression(13);
						}
						break;
					case 3:
						{
						_localctx = new AddSubExprContext(new ExpressionContext(_parentctx, _parentState));
						((AddSubExprContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(89);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(90);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(91);
						((AddSubExprContext)_localctx).e2 = expression(12);
						}
						break;
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class InstructionContext extends ParserRuleContext {
		public InsertContext insert() {
			return getRuleContext(InsertContext.class,0);
		}
		public RemoveContext remove() {
			return getRuleContext(RemoveContext.class,0);
		}
		public SaveContext save() {
			return getRuleContext(SaveContext.class,0);
		}
		public ModifyContext modify() {
			return getRuleContext(ModifyContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instruction);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case IN:
			case INSERT:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				insert();
				}
				break;
			case REMOVE:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				remove();
				}
				break;
			case SAVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				save();
				}
				break;
			case MODIFY:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				modify();
				}
				break;
			case SHOW:
				enterOuterAlt(_localctx, 5);
				{
				setState(101);
				print();
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

	public static class CreatetableContext extends ParserRuleContext {
		public Type eType;
		public TerminalNode CREATE() { return getToken(BdeXParser.CREATE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public CreatetableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createtable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterCreatetable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitCreatetable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitCreatetable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatetableContext createtable() throws RecognitionException {
		CreatetableContext _localctx = new CreatetableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_createtable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(CREATE);
			setState(105);
			match(T__10);
			setState(111); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106);
				expression(0);
				setState(107);
				match(T__11);
				setState(108);
				type();
				setState(109);
				match(T__0);
				}
				}
				setState(113); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__8) | (1L << CREATE) | (1L << EXTRACT) | (1L << JOIN) | (1L << READ) | (1L << IDENTIFIER) | (1L << DOUBLE) | (1L << INT) | (1L << STRING))) != 0) );
			setState(115);
			match(T__12);
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

	public static class CreateColumnContext extends ParserRuleContext {
		public Type eType;
		public TerminalNode CREATE() { return getToken(BdeXParser.CREATE, 0); }
		public TerminalNode COLUMN() { return getToken(BdeXParser.COLUMN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CreateColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createColumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterCreateColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitCreateColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitCreateColumn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateColumnContext createColumn() throws RecognitionException {
		CreateColumnContext _localctx = new CreateColumnContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_createColumn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(CREATE);
			setState(118);
			match(COLUMN);
			setState(119);
			match(T__11);
			setState(120);
			type();
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

	public static class ExtractContext extends ParserRuleContext {
		public Type eType;
		public ExpressionContext table;
		public TerminalNode EXTRACT() { return getToken(BdeXParser.EXTRACT, 0); }
		public TerminalNode FROM() { return getToken(BdeXParser.FROM, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WHERE() { return getToken(BdeXParser.WHERE, 0); }
		public List<SelectionContext> selection() {
			return getRuleContexts(SelectionContext.class);
		}
		public SelectionContext selection(int i) {
			return getRuleContext(SelectionContext.class,i);
		}
		public ExtractContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extract; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterExtract(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitExtract(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitExtract(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtractContext extract() throws RecognitionException {
		ExtractContext _localctx = new ExtractContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_extract);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(EXTRACT);
			setState(123);
			match(FROM);
			setState(124);
			((ExtractContext)_localctx).table = expression(0);
			setState(125);
			match(T__11);
			{
			setState(126);
			expression(0);
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(127);
					match(T__13);
					setState(128);
					expression(0);
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(134);
				match(WHERE);
				{
				setState(135);
				selection();
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(136);
						match(T__13);
						setState(137);
						selection();
						}
						} 
					}
					setState(142);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				}
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

	public static class JoinContext extends ParserRuleContext {
		public Type eType;
		public ExpressionContext table;
		public TerminalNode JOIN() { return getToken(BdeXParser.JOIN, 0); }
		public TerminalNode TO() { return getToken(BdeXParser.TO, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public JoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitJoin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinContext join() throws RecognitionException {
		JoinContext _localctx = new JoinContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(JOIN);
			setState(146);
			((JoinContext)_localctx).table = expression(0);
			setState(147);
			match(TO);
			setState(148);
			((JoinContext)_localctx).table = expression(0);
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

	public static class InsertContext extends ParserRuleContext {
		public InsertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert; }
	 
		public InsertContext() { }
		public void copyFrom(InsertContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InsertColumnContext extends InsertContext {
		public ExpressionContext column;
		public ExpressionContext colName;
		public ExpressionContext table;
		public TerminalNode INSERT() { return getToken(BdeXParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(BdeXParser.INTO, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InsertColumnContext(InsertContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterInsertColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitInsertColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitInsertColumn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InsertIntoColContext extends InsertContext {
		public ExpressionContext value;
		public ExpressionContext column;
		public TerminalNode INSERT() { return getToken(BdeXParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(BdeXParser.INTO, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InsertIntoColContext(InsertContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterInsertIntoCol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitInsertIntoCol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitInsertIntoCol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InserttoTableContext extends InsertContext {
		public ExpressionContext table;
		public ExpressionContext column;
		public ExpressionContext value;
		public TerminalNode IN() { return getToken(BdeXParser.IN, 0); }
		public List<TerminalNode> INSERT() { return getTokens(BdeXParser.INSERT); }
		public TerminalNode INSERT(int i) {
			return getToken(BdeXParser.INSERT, i);
		}
		public List<TerminalNode> INTO() { return getTokens(BdeXParser.INTO); }
		public TerminalNode INTO(int i) {
			return getToken(BdeXParser.INTO, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<InsertStatContext> insertStat() {
			return getRuleContexts(InsertStatContext.class);
		}
		public InsertStatContext insertStat(int i) {
			return getRuleContext(InsertStatContext.class,i);
		}
		public InserttoTableContext(InsertContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterInserttoTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitInserttoTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitInserttoTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertContext insert() throws RecognitionException {
		InsertContext _localctx = new InsertContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_insert);
		int _la;
		try {
			int _alt;
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new InserttoTableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(150);
						match(INSERT);
						setState(151);
						match(INTO);
						setState(152);
						((InserttoTableContext)_localctx).table = expression(0);
						}
						} 
					}
					setState(157);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(188);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(158);
					match(IN);
					setState(159);
					((InserttoTableContext)_localctx).column = expression(0);
					setState(160);
					match(T__11);
					setState(161);
					((InserttoTableContext)_localctx).value = expression(0);
					setState(162);
					match(T__0);
					}
					break;
				case 2:
					{
					setState(164);
					match(T__11);
					{
					setState(165);
					expression(0);
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__13) {
						{
						{
						setState(166);
						match(T__13);
						setState(168);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__8) | (1L << CREATE) | (1L << EXTRACT) | (1L << JOIN) | (1L << READ) | (1L << IDENTIFIER) | (1L << DOUBLE) | (1L << INT) | (1L << STRING))) != 0)) {
							{
							setState(167);
							expression(0);
							}
						}

						}
						}
						setState(174);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					setState(175);
					match(T__0);
					}
					break;
				case 3:
					{
					setState(177);
					match(T__11);
					{
					setState(178);
					insertStat();
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__13) {
						{
						{
						setState(179);
						match(T__13);
						setState(180);
						insertStat();
						}
						}
						setState(185);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					setState(186);
					match(T__0);
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new InsertColumnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(INSERT);
				setState(191);
				((InsertColumnContext)_localctx).column = expression(0);
				setState(192);
				match(T__11);
				setState(193);
				((InsertColumnContext)_localctx).colName = expression(0);
				setState(194);
				match(INTO);
				setState(195);
				((InsertColumnContext)_localctx).table = expression(0);
				setState(196);
				match(T__0);
				}
				break;
			case 3:
				_localctx = new InsertIntoColContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				match(INSERT);
				setState(199);
				((InsertIntoColContext)_localctx).value = expression(0);
				setState(200);
				match(INTO);
				setState(201);
				((InsertIntoColContext)_localctx).column = expression(0);
				setState(202);
				match(T__0);
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

	public static class ModifyContext extends ParserRuleContext {
		public ModifyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modify; }
	 
		public ModifyContext() { }
		public void copyFrom(ModifyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ModifyColPosContext extends ModifyContext {
		public ExpressionContext position;
		public ExpressionContext column;
		public ExpressionContext value;
		public TerminalNode MODIFY() { return getToken(BdeXParser.MODIFY, 0); }
		public TerminalNode IN() { return getToken(BdeXParser.IN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ModifyColPosContext(ModifyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterModifyColPos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitModifyColPos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitModifyColPos(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModifyTablePosContext extends ModifyContext {
		public ExpressionContext col;
		public ExpressionContext position;
		public ExpressionContext table;
		public ExpressionContext value;
		public TerminalNode MODIFY() { return getToken(BdeXParser.MODIFY, 0); }
		public TerminalNode IN() { return getToken(BdeXParser.IN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ModifyTablePosContext(ModifyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterModifyTablePos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitModifyTablePos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitModifyTablePos(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModifyTableColSelContext extends ModifyContext {
		public ExpressionContext table;
		public TerminalNode MODIFY() { return getToken(BdeXParser.MODIFY, 0); }
		public TerminalNode IN() { return getToken(BdeXParser.IN, 0); }
		public TerminalNode WHERE() { return getToken(BdeXParser.WHERE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<InsertStatContext> insertStat() {
			return getRuleContexts(InsertStatContext.class);
		}
		public InsertStatContext insertStat(int i) {
			return getRuleContext(InsertStatContext.class,i);
		}
		public List<SelectionContext> selection() {
			return getRuleContexts(SelectionContext.class);
		}
		public SelectionContext selection(int i) {
			return getRuleContext(SelectionContext.class,i);
		}
		public ModifyTableColSelContext(ModifyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterModifyTableColSel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitModifyTableColSel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitModifyTableColSel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifyContext modify() throws RecognitionException {
		ModifyContext _localctx = new ModifyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_modify);
		int _la;
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new ModifyTableColSelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				match(MODIFY);
				{
				setState(207);
				insertStat();
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(208);
					match(T__13);
					setState(209);
					insertStat();
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(215);
				match(IN);
				setState(216);
				((ModifyTableColSelContext)_localctx).table = expression(0);
				setState(217);
				match(WHERE);
				{
				setState(218);
				selection();
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(219);
					match(T__13);
					setState(220);
					selection();
					}
					}
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(226);
				match(T__0);
				}
				break;
			case 2:
				_localctx = new ModifyTablePosContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				match(MODIFY);
				setState(229);
				((ModifyTablePosContext)_localctx).col = expression(0);
				setState(230);
				match(T__13);
				setState(231);
				((ModifyTablePosContext)_localctx).position = expression(0);
				setState(232);
				match(IN);
				setState(233);
				((ModifyTablePosContext)_localctx).table = expression(0);
				setState(234);
				match(T__11);
				setState(235);
				((ModifyTablePosContext)_localctx).value = expression(0);
				setState(236);
				match(T__0);
				}
				break;
			case 3:
				_localctx = new ModifyColPosContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(238);
				match(MODIFY);
				setState(239);
				((ModifyColPosContext)_localctx).position = expression(0);
				setState(240);
				match(IN);
				setState(241);
				((ModifyColPosContext)_localctx).column = expression(0);
				setState(242);
				match(T__11);
				setState(243);
				((ModifyColPosContext)_localctx).value = expression(0);
				setState(244);
				match(T__0);
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

	public static class RemoveContext extends ParserRuleContext {
		public ExpressionContext column;
		public ExpressionContext table;
		public TerminalNode REMOVE() { return getToken(BdeXParser.REMOVE, 0); }
		public TerminalNode FROM() { return getToken(BdeXParser.FROM, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WHERE() { return getToken(BdeXParser.WHERE, 0); }
		public List<SelectionContext> selection() {
			return getRuleContexts(SelectionContext.class);
		}
		public SelectionContext selection(int i) {
			return getRuleContext(SelectionContext.class,i);
		}
		public RemoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_remove; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterRemove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitRemove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitRemove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RemoveContext remove() throws RecognitionException {
		RemoveContext _localctx = new RemoveContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_remove);
		int _la;
		try {
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				match(REMOVE);
				setState(249);
				((RemoveContext)_localctx).column = expression(0);
				setState(250);
				match(FROM);
				setState(251);
				((RemoveContext)_localctx).table = expression(0);
				setState(252);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(REMOVE);
				setState(255);
				match(FROM);
				setState(256);
				((RemoveContext)_localctx).table = expression(0);
				setState(257);
				match(WHERE);
				{
				setState(258);
				selection();
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(259);
					match(T__13);
					setState(260);
					selection();
					}
					}
					setState(265);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(266);
				match(T__0);
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

	public static class ReadContext extends ParserRuleContext {
		public Type eType;
		public TerminalNode READ() { return getToken(BdeXParser.READ, 0); }
		public TerminalNode FROM() { return getToken(BdeXParser.FROM, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitRead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitRead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_read);
		try {
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				match(READ);
				setState(271);
				match(FROM);
				setState(272);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				match(READ);
				setState(274);
				type();
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

	public static class SaveContext extends ParserRuleContext {
		public ExpressionContext table;
		public TerminalNode SAVE() { return getToken(BdeXParser.SAVE, 0); }
		public TerminalNode TO() { return getToken(BdeXParser.TO, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SaveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_save; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterSave(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitSave(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitSave(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SaveContext save() throws RecognitionException {
		SaveContext _localctx = new SaveContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_save);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(SAVE);
			setState(278);
			((SaveContext)_localctx).table = expression(0);
			setState(279);
			match(TO);
			setState(280);
			expression(0);
			setState(281);
			match(T__0);
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

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode SHOW() { return getToken(BdeXParser.SHOW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(SHOW);
			setState(284);
			expression(0);
			setState(285);
			match(T__0);
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

	public static class InsertStatContext extends ParserRuleContext {
		public String varName;
		public Boolean isVar = false;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InsertStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterInsertStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitInsertStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitInsertStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertStatContext insertStat() throws RecognitionException {
		InsertStatContext _localctx = new InsertStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_insertStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			expression(0);
			setState(288);
			match(T__14);
			setState(289);
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

	public static class SelectionContext extends ParserRuleContext {
		public String varName;
		public Boolean isVar = false;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SELECOP() { return getToken(BdeXParser.SELECOP, 0); }
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			expression(0);
			setState(292);
			match(SELECOP);
			setState(293);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INTEGER_T() { return getToken(BdeXParser.INTEGER_T, 0); }
		public TerminalNode DOUBLE_T() { return getToken(BdeXParser.DOUBLE_T, 0); }
		public TerminalNode TEXT() { return getToken(BdeXParser.TEXT, 0); }
		public TerminalNode TABLE() { return getToken(BdeXParser.TABLE, 0); }
		public TerminalNode COLUMN() { return getToken(BdeXParser.COLUMN, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BdeXListener ) ((BdeXListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BdeXVisitor ) return ((BdeXVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TABLE) | (1L << INTEGER_T) | (1L << DOUBLE_T) | (1L << COLUMN) | (1L << TEXT))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u012c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\3\2\3\3\3\3\3\3\5"+
		"\3\64\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4=\n\4\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6T\n\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6_\n\6\f\6\16\6b\13\6\3\7\3\7\3"+
		"\7\3\7\3\7\5\7i\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\6\br\n\b\r\b\16\bs\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0084\n\n\f\n"+
		"\16\n\u0087\13\n\3\n\3\n\3\n\3\n\7\n\u008d\n\n\f\n\16\n\u0090\13\n\5\n"+
		"\u0092\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\7\f\u009c\n\f\f\f\16\f"+
		"\u009f\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ab\n\f\7\f"+
		"\u00ad\n\f\f\f\16\f\u00b0\13\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00b8\n\f\f"+
		"\f\16\f\u00bb\13\f\3\f\3\f\5\f\u00bf\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00cf\n\f\3\r\3\r\3\r\3\r\7\r\u00d5\n\r"+
		"\f\r\16\r\u00d8\13\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00e0\n\r\f\r\16\r\u00e3"+
		"\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u00f9\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\7\16\u0108\n\16\f\16\16\16\u010b\13\16\3\16"+
		"\3\16\5\16\u010f\n\16\3\17\3\17\3\17\3\17\3\17\5\17\u0116\n\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\u009d\3\n\25\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&\2\5\3\2\5\6\3\2\b\n\3\2\30\34\2\u0140\2+\3\2\2\2\4\63"+
		"\3\2\2\2\6<\3\2\2\2\b>\3\2\2\2\nS\3\2\2\2\fh\3\2\2\2\16j\3\2\2\2\20w\3"+
		"\2\2\2\22|\3\2\2\2\24\u0093\3\2\2\2\26\u00ce\3\2\2\2\30\u00f8\3\2\2\2"+
		"\32\u010e\3\2\2\2\34\u0115\3\2\2\2\36\u0117\3\2\2\2 \u011d\3\2\2\2\"\u0121"+
		"\3\2\2\2$\u0125\3\2\2\2&\u0129\3\2\2\2(*\5\4\3\2)(\3\2\2\2*-\3\2\2\2+"+
		")\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7\2\2\3/\3\3\2\2\2\60\64\5\6"+
		"\4\2\61\64\5\b\5\2\62\64\5\f\7\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2"+
		"\2\2\64\5\3\2\2\2\65\66\5&\24\2\66\67\7&\2\2\678\7\3\2\28=\3\2\2\29:\5"+
		"&\24\2:;\5\b\5\2;=\3\2\2\2<\65\3\2\2\2<9\3\2\2\2=\7\3\2\2\2>?\7&\2\2?"+
		"@\7\4\2\2@A\5\n\6\2AB\7\3\2\2B\t\3\2\2\2CD\b\6\1\2DE\t\2\2\2ET\5\n\6\20"+
		"FG\7\13\2\2GH\5\n\6\2HI\7\f\2\2IT\3\2\2\2JT\5\16\b\2KT\5\24\13\2LT\5\22"+
		"\n\2MT\5\34\17\2NT\5\20\t\2OT\7\'\2\2PT\7(\2\2QT\7)\2\2RT\7&\2\2SC\3\2"+
		"\2\2SF\3\2\2\2SJ\3\2\2\2SK\3\2\2\2SL\3\2\2\2SM\3\2\2\2SN\3\2\2\2SO\3\2"+
		"\2\2SP\3\2\2\2SQ\3\2\2\2SR\3\2\2\2T`\3\2\2\2UV\f\17\2\2VW\7\7\2\2W_\5"+
		"\n\6\17XY\f\16\2\2YZ\t\3\2\2Z_\5\n\6\17[\\\f\r\2\2\\]\t\2\2\2]_\5\n\6"+
		"\16^U\3\2\2\2^X\3\2\2\2^[\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\13\3"+
		"\2\2\2b`\3\2\2\2ci\5\26\f\2di\5\32\16\2ei\5\36\20\2fi\5\30\r\2gi\5 \21"+
		"\2hc\3\2\2\2hd\3\2\2\2he\3\2\2\2hf\3\2\2\2hg\3\2\2\2i\r\3\2\2\2jk\7\22"+
		"\2\2kq\7\r\2\2lm\5\n\6\2mn\7\16\2\2no\5&\24\2op\7\3\2\2pr\3\2\2\2ql\3"+
		"\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\7\17\2\2v\17\3\2\2\2"+
		"wx\7\22\2\2xy\7\33\2\2yz\7\16\2\2z{\5&\24\2{\21\3\2\2\2|}\7\36\2\2}~\7"+
		"\26\2\2~\177\5\n\6\2\177\u0080\7\16\2\2\u0080\u0085\5\n\6\2\u0081\u0082"+
		"\7\20\2\2\u0082\u0084\5\n\6\2\u0083\u0081\3\2\2\2\u0084\u0087\3\2\2\2"+
		"\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0091\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0088\u0089\7\27\2\2\u0089\u008e\5$\23\2\u008a\u008b\7\20\2\2"+
		"\u008b\u008d\5$\23\2\u008c\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0088\3\2\2\2\u0091\u0092\3\2\2\2\u0092\23\3\2\2\2\u0093\u0094\7\37\2"+
		"\2\u0094\u0095\5\n\6\2\u0095\u0096\7\25\2\2\u0096\u0097\5\n\6\2\u0097"+
		"\25\3\2\2\2\u0098\u0099\7 \2\2\u0099\u009a\7\23\2\2\u009a\u009c\5\n\6"+
		"\2\u009b\u0098\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009e\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009e\u00be\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7\24\2\2"+
		"\u00a1\u00a2\5\n\6\2\u00a2\u00a3\7\16\2\2\u00a3\u00a4\5\n\6\2\u00a4\u00a5"+
		"\7\3\2\2\u00a5\u00bf\3\2\2\2\u00a6\u00a7\7\16\2\2\u00a7\u00ae\5\n\6\2"+
		"\u00a8\u00aa\7\20\2\2\u00a9\u00ab\5\n\6\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab"+
		"\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2"+
		"\2\2\u00b1\u00b2\7\3\2\2\u00b2\u00bf\3\2\2\2\u00b3\u00b4\7\16\2\2\u00b4"+
		"\u00b9\5\"\22\2\u00b5\u00b6\7\20\2\2\u00b6\u00b8\5\"\22\2\u00b7\u00b5"+
		"\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7\3\2\2\u00bd\u00bf\3\2"+
		"\2\2\u00be\u00a0\3\2\2\2\u00be\u00a6\3\2\2\2\u00be\u00b3\3\2\2\2\u00bf"+
		"\u00cf\3\2\2\2\u00c0\u00c1\7 \2\2\u00c1\u00c2\5\n\6\2\u00c2\u00c3\7\16"+
		"\2\2\u00c3\u00c4\5\n\6\2\u00c4\u00c5\7\23\2\2\u00c5\u00c6\5\n\6\2\u00c6"+
		"\u00c7\7\3\2\2\u00c7\u00cf\3\2\2\2\u00c8\u00c9\7 \2\2\u00c9\u00ca\5\n"+
		"\6\2\u00ca\u00cb\7\23\2\2\u00cb\u00cc\5\n\6\2\u00cc\u00cd\7\3\2\2\u00cd"+
		"\u00cf\3\2\2\2\u00ce\u009d\3\2\2\2\u00ce\u00c0\3\2\2\2\u00ce\u00c8\3\2"+
		"\2\2\u00cf\27\3\2\2\2\u00d0\u00d1\7!\2\2\u00d1\u00d6\5\"\22\2\u00d2\u00d3"+
		"\7\20\2\2\u00d3\u00d5\5\"\22\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2"+
		"\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d9\u00da\7\24\2\2\u00da\u00db\5\n\6\2\u00db\u00dc\7\27\2\2"+
		"\u00dc\u00e1\5$\23\2\u00dd\u00de\7\20\2\2\u00de\u00e0\5$\23\2\u00df\u00dd"+
		"\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\7\3\2\2\u00e5\u00f9\3\2"+
		"\2\2\u00e6\u00e7\7!\2\2\u00e7\u00e8\5\n\6\2\u00e8\u00e9\7\20\2\2\u00e9"+
		"\u00ea\5\n\6\2\u00ea\u00eb\7\24\2\2\u00eb\u00ec\5\n\6\2\u00ec\u00ed\7"+
		"\16\2\2\u00ed\u00ee\5\n\6\2\u00ee\u00ef\7\3\2\2\u00ef\u00f9\3\2\2\2\u00f0"+
		"\u00f1\7!\2\2\u00f1\u00f2\5\n\6\2\u00f2\u00f3\7\24\2\2\u00f3\u00f4\5\n"+
		"\6\2\u00f4\u00f5\7\16\2\2\u00f5\u00f6\5\n\6\2\u00f6\u00f7\7\3\2\2\u00f7"+
		"\u00f9\3\2\2\2\u00f8\u00d0\3\2\2\2\u00f8\u00e6\3\2\2\2\u00f8\u00f0\3\2"+
		"\2\2\u00f9\31\3\2\2\2\u00fa\u00fb\7\35\2\2\u00fb\u00fc\5\n\6\2\u00fc\u00fd"+
		"\7\26\2\2\u00fd\u00fe\5\n\6\2\u00fe\u00ff\7\3\2\2\u00ff\u010f\3\2\2\2"+
		"\u0100\u0101\7\35\2\2\u0101\u0102\7\26\2\2\u0102\u0103\5\n\6\2\u0103\u0104"+
		"\7\27\2\2\u0104\u0109\5$\23\2\u0105\u0106\7\20\2\2\u0106\u0108\5$\23\2"+
		"\u0107\u0105\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a"+
		"\3\2\2\2\u010a\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010d\7\3\2\2\u010d"+
		"\u010f\3\2\2\2\u010e\u00fa\3\2\2\2\u010e\u0100\3\2\2\2\u010f\33\3\2\2"+
		"\2\u0110\u0111\7#\2\2\u0111\u0112\7\26\2\2\u0112\u0116\5\n\6\2\u0113\u0114"+
		"\7#\2\2\u0114\u0116\5&\24\2\u0115\u0110\3\2\2\2\u0115\u0113\3\2\2\2\u0116"+
		"\35\3\2\2\2\u0117\u0118\7\"\2\2\u0118\u0119\5\n\6\2\u0119\u011a\7\25\2"+
		"\2\u011a\u011b\5\n\6\2\u011b\u011c\7\3\2\2\u011c\37\3\2\2\2\u011d\u011e"+
		"\7$\2\2\u011e\u011f\5\n\6\2\u011f\u0120\7\3\2\2\u0120!\3\2\2\2\u0121\u0122"+
		"\5\n\6\2\u0122\u0123\7\21\2\2\u0123\u0124\5\n\6\2\u0124#\3\2\2\2\u0125"+
		"\u0126\5\n\6\2\u0126\u0127\7%\2\2\u0127\u0128\5\n\6\2\u0128%\3\2\2\2\u0129"+
		"\u012a\t\4\2\2\u012a\'\3\2\2\2\31+\63<S^`hs\u0085\u008e\u0091\u009d\u00aa"+
		"\u00ae\u00b9\u00be\u00ce\u00d6\u00e1\u00f8\u0109\u010e\u0115";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}