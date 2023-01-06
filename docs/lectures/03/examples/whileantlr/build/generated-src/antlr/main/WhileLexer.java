// Generated from WhileLexer.g4 by ANTLR 4.9.2
package org.example;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WhileLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMA=1, SEMI=2, ASSIGN=3, LPARENT=4, RPARENT=5, NOT=6, AND=7, OR=8, XOR=9, 
		EQ=10, NEQ=11, LESS=12, GT=13, LEQ=14, GTE=15, PLUS=16, MINUS=17, DIV=18, 
		MUL=19, MOD=20, BSHL=21, BSHR=22, BAND=23, BOR=24, BXOR=25, BNOT=26, TRUE=27, 
		FALSE=28, VAR=29, BEGIN=30, END=31, IF=32, THEN=33, ELSE=34, WHILE=35, 
		DO=36, WRITE=37, READ=38, SKIPP=39, NUM=40, ID=41, WS=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMA", "SEMI", "ASSIGN", "LPARENT", "RPARENT", "NOT", "AND", "OR", 
			"XOR", "EQ", "NEQ", "LESS", "GT", "LEQ", "GTE", "PLUS", "MINUS", "DIV", 
			"MUL", "MOD", "BSHL", "BSHR", "BAND", "BOR", "BXOR", "BNOT", "TRUE", 
			"FALSE", "VAR", "BEGIN", "END", "IF", "THEN", "ELSE", "WHILE", "DO", 
			"WRITE", "READ", "SKIPP", "NUM", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "';'", "':='", "'('", "')'", "'not'", "'and'", "'or'", "'xor'", 
			"'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'/'", "'*'", 
			"'%'", "'<<'", "'>>'", "'&'", "'|'", "'^'", "'~'", "'true'", "'false'", 
			"'var'", "'begin'", "'end'", "'if'", "'then'", "'else'", "'while'", "'do'", 
			"'write'", "'read'", "'skip'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMA", "SEMI", "ASSIGN", "LPARENT", "RPARENT", "NOT", "AND", 
			"OR", "XOR", "EQ", "NEQ", "LESS", "GT", "LEQ", "GTE", "PLUS", "MINUS", 
			"DIV", "MUL", "MOD", "BSHL", "BSHR", "BAND", "BOR", "BXOR", "BNOT", "TRUE", 
			"FALSE", "VAR", "BEGIN", "END", "IF", "THEN", "ELSE", "WHILE", "DO", 
			"WRITE", "READ", "SKIPP", "NUM", "ID", "WS"
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


	public WhileLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "WhileLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u00e8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3"+
		"\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3"+
		"!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3&"+
		"\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\6)\u00da\n)\r)\16"+
		")\u00db\3*\3*\7*\u00e0\n*\f*\16*\u00e3\13*\3+\3+\3+\3+\2\2,\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,\3\2\6\3\2\62;\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17"+
		"\17\"\"\2\u00e9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5Y\3\2\2\2\7[\3\2\2\2\t^\3\2\2\2\13"+
		"`\3\2\2\2\rb\3\2\2\2\17f\3\2\2\2\21j\3\2\2\2\23m\3\2\2\2\25q\3\2\2\2\27"+
		"t\3\2\2\2\31w\3\2\2\2\33y\3\2\2\2\35{\3\2\2\2\37~\3\2\2\2!\u0081\3\2\2"+
		"\2#\u0083\3\2\2\2%\u0085\3\2\2\2\'\u0087\3\2\2\2)\u0089\3\2\2\2+\u008b"+
		"\3\2\2\2-\u008e\3\2\2\2/\u0091\3\2\2\2\61\u0093\3\2\2\2\63\u0095\3\2\2"+
		"\2\65\u0097\3\2\2\2\67\u0099\3\2\2\29\u009e\3\2\2\2;\u00a4\3\2\2\2=\u00a8"+
		"\3\2\2\2?\u00ae\3\2\2\2A\u00b2\3\2\2\2C\u00b5\3\2\2\2E\u00ba\3\2\2\2G"+
		"\u00bf\3\2\2\2I\u00c5\3\2\2\2K\u00c8\3\2\2\2M\u00ce\3\2\2\2O\u00d3\3\2"+
		"\2\2Q\u00d9\3\2\2\2S\u00dd\3\2\2\2U\u00e4\3\2\2\2WX\7.\2\2X\4\3\2\2\2"+
		"YZ\7=\2\2Z\6\3\2\2\2[\\\7<\2\2\\]\7?\2\2]\b\3\2\2\2^_\7*\2\2_\n\3\2\2"+
		"\2`a\7+\2\2a\f\3\2\2\2bc\7p\2\2cd\7q\2\2de\7v\2\2e\16\3\2\2\2fg\7c\2\2"+
		"gh\7p\2\2hi\7f\2\2i\20\3\2\2\2jk\7q\2\2kl\7t\2\2l\22\3\2\2\2mn\7z\2\2"+
		"no\7q\2\2op\7t\2\2p\24\3\2\2\2qr\7?\2\2rs\7?\2\2s\26\3\2\2\2tu\7#\2\2"+
		"uv\7?\2\2v\30\3\2\2\2wx\7>\2\2x\32\3\2\2\2yz\7@\2\2z\34\3\2\2\2{|\7>\2"+
		"\2|}\7?\2\2}\36\3\2\2\2~\177\7@\2\2\177\u0080\7?\2\2\u0080 \3\2\2\2\u0081"+
		"\u0082\7-\2\2\u0082\"\3\2\2\2\u0083\u0084\7/\2\2\u0084$\3\2\2\2\u0085"+
		"\u0086\7\61\2\2\u0086&\3\2\2\2\u0087\u0088\7,\2\2\u0088(\3\2\2\2\u0089"+
		"\u008a\7\'\2\2\u008a*\3\2\2\2\u008b\u008c\7>\2\2\u008c\u008d\7>\2\2\u008d"+
		",\3\2\2\2\u008e\u008f\7@\2\2\u008f\u0090\7@\2\2\u0090.\3\2\2\2\u0091\u0092"+
		"\7(\2\2\u0092\60\3\2\2\2\u0093\u0094\7~\2\2\u0094\62\3\2\2\2\u0095\u0096"+
		"\7`\2\2\u0096\64\3\2\2\2\u0097\u0098\7\u0080\2\2\u0098\66\3\2\2\2\u0099"+
		"\u009a\7v\2\2\u009a\u009b\7t\2\2\u009b\u009c\7w\2\2\u009c\u009d\7g\2\2"+
		"\u009d8\3\2\2\2\u009e\u009f\7h\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7n\2"+
		"\2\u00a1\u00a2\7u\2\2\u00a2\u00a3\7g\2\2\u00a3:\3\2\2\2\u00a4\u00a5\7"+
		"x\2\2\u00a5\u00a6\7c\2\2\u00a6\u00a7\7t\2\2\u00a7<\3\2\2\2\u00a8\u00a9"+
		"\7d\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7i\2\2\u00ab\u00ac\7k\2\2\u00ac"+
		"\u00ad\7p\2\2\u00ad>\3\2\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7p\2\2\u00b0"+
		"\u00b1\7f\2\2\u00b1@\3\2\2\2\u00b2\u00b3\7k\2\2\u00b3\u00b4\7h\2\2\u00b4"+
		"B\3\2\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7j\2\2\u00b7\u00b8\7g\2\2\u00b8"+
		"\u00b9\7p\2\2\u00b9D\3\2\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7n\2\2\u00bc"+
		"\u00bd\7u\2\2\u00bd\u00be\7g\2\2\u00beF\3\2\2\2\u00bf\u00c0\7y\2\2\u00c0"+
		"\u00c1\7j\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7g\2\2"+
		"\u00c4H\3\2\2\2\u00c5\u00c6\7f\2\2\u00c6\u00c7\7q\2\2\u00c7J\3\2\2\2\u00c8"+
		"\u00c9\7y\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7v\2\2"+
		"\u00cc\u00cd\7g\2\2\u00cdL\3\2\2\2\u00ce\u00cf\7t\2\2\u00cf\u00d0\7g\2"+
		"\2\u00d0\u00d1\7c\2\2\u00d1\u00d2\7f\2\2\u00d2N\3\2\2\2\u00d3\u00d4\7"+
		"u\2\2\u00d4\u00d5\7m\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7r\2\2\u00d7P"+
		"\3\2\2\2\u00d8\u00da\t\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dcR\3\2\2\2\u00dd\u00e1\t\3\2\2"+
		"\u00de\u00e0\t\4\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df"+
		"\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2T\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4"+
		"\u00e5\t\5\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\b+\2\2\u00e7V\3\2\2\2\5"+
		"\2\u00db\u00e1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}