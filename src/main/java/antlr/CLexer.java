package antlr;// Generated from C.g4 by ANTLR 4.7.1

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"STRING", "LIBRARY", "ID", "INT", "HEX", "BIN", "VARIABLE_MODIFIER", "VARIABLE_SINGLE_MODIFIER", 
		"OPERATOR", "NOT", "WS", "SINGLE_COMMENT", "BLOCK_COMMENT", "L_PAREN", 
		"R_PAREN"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'#'", "'{'", "'}'", "'if'", "'while'", "'for'", "'from'", 
		"'to'", "'by'", "'switch'", "'case'", "'->'", "'defualt'", "'public'", 
		"'func'", "'namespace'", "'return'", "'var'", "'='", "'sizeof'", "','", 
		"'::'", "'['", "']'", null, null, null, null, null, null, null, null, 
		null, "'!'", null, null, null, "'('", "')'"
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


	public CLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "C.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u014f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\7\33\u00c2\n\33\f\33\16\33\u00c5\13\33\3\33\3\33\3\34\3\34\6\34"+
		"\u00cb\n\34\r\34\16\34\u00cc\3\34\7\34\u00d0\n\34\f\34\16\34\u00d3\13"+
		"\34\3\34\3\34\3\35\6\35\u00d8\n\35\r\35\16\35\u00d9\3\35\7\35\u00dd\n"+
		"\35\f\35\16\35\u00e0\13\35\3\36\5\36\u00e3\n\36\3\36\6\36\u00e6\n\36\r"+
		"\36\16\36\u00e7\3\36\3\36\6\36\u00ec\n\36\r\36\16\36\u00ed\5\36\u00f0"+
		"\n\36\3\36\3\36\6\36\u00f4\n\36\r\36\16\36\u00f5\5\36\u00f8\n\36\3\37"+
		"\3\37\3\37\3\37\6\37\u00fe\n\37\r\37\16\37\u00ff\3 \3 \3 \3 \6 \u0106"+
		"\n \r \16 \u0107\3!\3!\3!\3\"\3\"\3\"\3\"\5\"\u0111\n\"\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0126\n#\3$\3$\3%\6%\u012b"+
		"\n%\r%\16%\u012c\3%\3%\3&\3&\3&\3&\7&\u0135\n&\f&\16&\u0138\13&\3&\3&"+
		"\3&\3&\3\'\3\'\3\'\3\'\7\'\u0142\n\'\f\'\16\'\u0145\13\'\3\'\3\'\3\'\3"+
		"\'\3\'\3(\3(\3)\3)\4\u0136\u0143\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*\3\2\13\3"+
		"\2$$\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\5\2\62;CHch\5\2,-//\61\61\5\2\'"+
		"(``~~\4\2>>@@\5\2\13\f\17\17\"\"\2\u016a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5U\3\2\2\2\7W\3\2\2\2\tY\3\2\2"+
		"\2\13[\3\2\2\2\r^\3\2\2\2\17d\3\2\2\2\21h\3\2\2\2\23m\3\2\2\2\25p\3\2"+
		"\2\2\27s\3\2\2\2\31z\3\2\2\2\33\177\3\2\2\2\35\u0082\3\2\2\2\37\u008a"+
		"\3\2\2\2!\u0091\3\2\2\2#\u0096\3\2\2\2%\u00a0\3\2\2\2\'\u00a7\3\2\2\2"+
		")\u00ab\3\2\2\2+\u00ad\3\2\2\2-\u00b4\3\2\2\2/\u00b6\3\2\2\2\61\u00b9"+
		"\3\2\2\2\63\u00bb\3\2\2\2\65\u00bd\3\2\2\2\67\u00c8\3\2\2\29\u00d7\3\2"+
		"\2\2;\u00f7\3\2\2\2=\u00f9\3\2\2\2?\u0101\3\2\2\2A\u0109\3\2\2\2C\u0110"+
		"\3\2\2\2E\u0125\3\2\2\2G\u0127\3\2\2\2I\u012a\3\2\2\2K\u0130\3\2\2\2M"+
		"\u013d\3\2\2\2O\u014b\3\2\2\2Q\u014d\3\2\2\2ST\7=\2\2T\4\3\2\2\2UV\7%"+
		"\2\2V\6\3\2\2\2WX\7}\2\2X\b\3\2\2\2YZ\7\177\2\2Z\n\3\2\2\2[\\\7k\2\2\\"+
		"]\7h\2\2]\f\3\2\2\2^_\7y\2\2_`\7j\2\2`a\7k\2\2ab\7n\2\2bc\7g\2\2c\16\3"+
		"\2\2\2de\7h\2\2ef\7q\2\2fg\7t\2\2g\20\3\2\2\2hi\7h\2\2ij\7t\2\2jk\7q\2"+
		"\2kl\7o\2\2l\22\3\2\2\2mn\7v\2\2no\7q\2\2o\24\3\2\2\2pq\7d\2\2qr\7{\2"+
		"\2r\26\3\2\2\2st\7u\2\2tu\7y\2\2uv\7k\2\2vw\7v\2\2wx\7e\2\2xy\7j\2\2y"+
		"\30\3\2\2\2z{\7e\2\2{|\7c\2\2|}\7u\2\2}~\7g\2\2~\32\3\2\2\2\177\u0080"+
		"\7/\2\2\u0080\u0081\7@\2\2\u0081\34\3\2\2\2\u0082\u0083\7f\2\2\u0083\u0084"+
		"\7g\2\2\u0084\u0085\7h\2\2\u0085\u0086\7w\2\2\u0086\u0087\7c\2\2\u0087"+
		"\u0088\7n\2\2\u0088\u0089\7v\2\2\u0089\36\3\2\2\2\u008a\u008b\7r\2\2\u008b"+
		"\u008c\7w\2\2\u008c\u008d\7d\2\2\u008d\u008e\7n\2\2\u008e\u008f\7k\2\2"+
		"\u008f\u0090\7e\2\2\u0090 \3\2\2\2\u0091\u0092\7h\2\2\u0092\u0093\7w\2"+
		"\2\u0093\u0094\7p\2\2\u0094\u0095\7e\2\2\u0095\"\3\2\2\2\u0096\u0097\7"+
		"p\2\2\u0097\u0098\7c\2\2\u0098\u0099\7o\2\2\u0099\u009a\7g\2\2\u009a\u009b"+
		"\7u\2\2\u009b\u009c\7r\2\2\u009c\u009d\7c\2\2\u009d\u009e\7e\2\2\u009e"+
		"\u009f\7g\2\2\u009f$\3\2\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7g\2\2\u00a2"+
		"\u00a3\7v\2\2\u00a3\u00a4\7w\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7p\2\2"+
		"\u00a6&\3\2\2\2\u00a7\u00a8\7x\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa\7t\2"+
		"\2\u00aa(\3\2\2\2\u00ab\u00ac\7?\2\2\u00ac*\3\2\2\2\u00ad\u00ae\7u\2\2"+
		"\u00ae\u00af\7k\2\2\u00af\u00b0\7|\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2"+
		"\7q\2\2\u00b2\u00b3\7h\2\2\u00b3,\3\2\2\2\u00b4\u00b5\7.\2\2\u00b5.\3"+
		"\2\2\2\u00b6\u00b7\7<\2\2\u00b7\u00b8\7<\2\2\u00b8\60\3\2\2\2\u00b9\u00ba"+
		"\7]\2\2\u00ba\62\3\2\2\2\u00bb\u00bc\7_\2\2\u00bc\64\3\2\2\2\u00bd\u00c3"+
		"\7$\2\2\u00be\u00c2\n\2\2\2\u00bf\u00c0\7^\2\2\u00c0\u00c2\7$\2\2\u00c1"+
		"\u00be\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\u00c7\7$\2\2\u00c7\66\3\2\2\2\u00c8\u00ca\7>\2\2\u00c9\u00cb\t\3\2\2"+
		"\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd"+
		"\3\2\2\2\u00cd\u00d1\3\2\2\2\u00ce\u00d0\t\4\2\2\u00cf\u00ce\3\2\2\2\u00d0"+
		"\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7@\2\2\u00d58\3\2\2\2\u00d6\u00d8"+
		"\t\3\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\u00de\3\2\2\2\u00db\u00dd\t\4\2\2\u00dc\u00db\3\2"+
		"\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		":\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e3\7/\2\2\u00e2\u00e1\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e6\t\5\2\2\u00e5\u00e4\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u00ef\3\2\2\2\u00e9\u00eb\7\60\2\2\u00ea\u00ec\t\5\2\2\u00eb\u00ea\3"+
		"\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00f0\3\2\2\2\u00ef\u00e9\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f8\3\2"+
		"\2\2\u00f1\u00f3\7\60\2\2\u00f2\u00f4\t\5\2\2\u00f3\u00f2\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2"+
		"\2\2\u00f7\u00e2\3\2\2\2\u00f7\u00f1\3\2\2\2\u00f8<\3\2\2\2\u00f9\u00fa"+
		"\7\62\2\2\u00fa\u00fb\7z\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fe\t\6\2\2\u00fd"+
		"\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100>\3\2\2\2\u0101\u0102\7\62\2\2\u0102\u0103\7d\2\2\u0103\u0105"+
		"\3\2\2\2\u0104\u0106\4\62\63\2\u0105\u0104\3\2\2\2\u0106\u0107\3\2\2\2"+
		"\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108@\3\2\2\2\u0109\u010a\5"+
		"E#\2\u010a\u010b\7?\2\2\u010bB\3\2\2\2\u010c\u010d\7-\2\2\u010d\u0111"+
		"\7-\2\2\u010e\u010f\7/\2\2\u010f\u0111\7/\2\2\u0110\u010c\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0111D\3\2\2\2\u0112\u0126\t\7\2\2\u0113\u0114\7@\2\2\u0114"+
		"\u0126\7@\2\2\u0115\u0116\7>\2\2\u0116\u0126\7>\2\2\u0117\u0126\t\b\2"+
		"\2\u0118\u0119\7~\2\2\u0119\u0126\7~\2\2\u011a\u011b\7(\2\2\u011b\u0126"+
		"\7(\2\2\u011c\u0126\t\t\2\2\u011d\u011e\7?\2\2\u011e\u0126\7?\2\2\u011f"+
		"\u0120\7#\2\2\u0120\u0126\7?\2\2\u0121\u0122\7@\2\2\u0122\u0126\7?\2\2"+
		"\u0123\u0124\7>\2\2\u0124\u0126\7?\2\2\u0125\u0112\3\2\2\2\u0125\u0113"+
		"\3\2\2\2\u0125\u0115\3\2\2\2\u0125\u0117\3\2\2\2\u0125\u0118\3\2\2\2\u0125"+
		"\u011a\3\2\2\2\u0125\u011c\3\2\2\2\u0125\u011d\3\2\2\2\u0125\u011f\3\2"+
		"\2\2\u0125\u0121\3\2\2\2\u0125\u0123\3\2\2\2\u0126F\3\2\2\2\u0127\u0128"+
		"\7#\2\2\u0128H\3\2\2\2\u0129\u012b\t\n\2\2\u012a\u0129\3\2\2\2\u012b\u012c"+
		"\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u012f\b%\2\2\u012fJ\3\2\2\2\u0130\u0131\7\61\2\2\u0131\u0132\7\61\2\2"+
		"\u0132\u0136\3\2\2\2\u0133\u0135\13\2\2\2\u0134\u0133\3\2\2\2\u0135\u0138"+
		"\3\2\2\2\u0136\u0137\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0139\3\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0139\u013a\7\f\2\2\u013a\u013b\3\2\2\2\u013b\u013c\b&"+
		"\2\2\u013cL\3\2\2\2\u013d\u013e\7\61\2\2\u013e\u013f\7,\2\2\u013f\u0143"+
		"\3\2\2\2\u0140\u0142\13\2\2\2\u0141\u0140\3\2\2\2\u0142\u0145\3\2\2\2"+
		"\u0143\u0144\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0146\3\2\2\2\u0145\u0143"+
		"\3\2\2\2\u0146\u0147\7,\2\2\u0147\u0148\7\61\2\2\u0148\u0149\3\2\2\2\u0149"+
		"\u014a\b\'\2\2\u014aN\3\2\2\2\u014b\u014c\7*\2\2\u014cP\3\2\2\2\u014d"+
		"\u014e\7+\2\2\u014eR\3\2\2\2\33\2\u00c1\u00c3\u00ca\u00cc\u00cf\u00d1"+
		"\u00d7\u00d9\u00dc\u00de\u00e2\u00e7\u00ed\u00ef\u00f5\u00f7\u00fd\u00ff"+
		"\u0107\u0110\u0125\u012c\u0136\u0143\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}