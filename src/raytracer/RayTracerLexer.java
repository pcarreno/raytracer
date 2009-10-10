package raytracer;

// $ANTLR 3.1.2 D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g 2009-09-26 18:43:40

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class RayTracerLexer extends Lexer {
    public static final int GREATER_THAN=16;
    public static final int PIGMENT=14;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int WHITESPACE=20;
    public static final int TYPE_COLOR=18;
    public static final int EOF=-1;
    public static final int COLOR=6;
    public static final int OPEN_BRACKET=5;
    public static final int PLANE=13;
    public static final int LOOK_AT=10;
    public static final int NEWLINE=19;
    public static final int LIGHTSOURCE=4;
    public static final int CAMERA=8;
    public static final int COMMA=12;
    public static final int LESS_THAN=15;
    public static final int LOCATION=9;
    public static final int DIGIT=17;
    public static final int SPHERE=11;
    public static final int CLOSE_BRACKET=7;

    // delegates
    // delegators

    public RayTracerLexer() {;} 
    public RayTracerLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public RayTracerLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "RayTracer.g"; }

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:3:7: ( '-' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:3:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:4:7: ( '.' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:4:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "LIGHTSOURCE"
    public final void mLIGHTSOURCE() throws RecognitionException {
        try {
            int _type = LIGHTSOURCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:26:13: ( 'light_source' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:26:15: 'light_source'
            {
            match("light_source"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LIGHTSOURCE"

    // $ANTLR start "CAMERA"
    public final void mCAMERA() throws RecognitionException {
        try {
            int _type = CAMERA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:27:9: ( 'camera' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:27:12: 'camera'
            {
            match("camera"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CAMERA"

    // $ANTLR start "LOCATION"
    public final void mLOCATION() throws RecognitionException {
        try {
            int _type = LOCATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:28:9: ( 'location' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:28:12: 'location'
            {
            match("location"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOCATION"

    // $ANTLR start "PIGMENT"
    public final void mPIGMENT() throws RecognitionException {
        try {
            int _type = PIGMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:29:9: ( 'pigment' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:29:12: 'pigment'
            {
            match("pigment"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PIGMENT"

    // $ANTLR start "PLANE"
    public final void mPLANE() throws RecognitionException {
        try {
            int _type = PLANE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:30:7: ( 'plane' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:30:10: 'plane'
            {
            match("plane"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLANE"

    // $ANTLR start "SPHERE"
    public final void mSPHERE() throws RecognitionException {
        try {
            int _type = SPHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:31:8: ( 'sphere' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:31:11: 'sphere'
            {
            match("sphere"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SPHERE"

    // $ANTLR start "LOOK_AT"
    public final void mLOOK_AT() throws RecognitionException {
        try {
            int _type = LOOK_AT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:32:9: ( 'look_at' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:32:12: 'look_at'
            {
            match("look_at"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOOK_AT"

    // $ANTLR start "COLOR"
    public final void mCOLOR() throws RecognitionException {
        try {
            int _type = COLOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:33:7: ( 'color' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:33:10: 'color'
            {
            match("color"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLOR"

    // $ANTLR start "TYPE_COLOR"
    public final void mTYPE_COLOR() throws RecognitionException {
        try {
            int _type = TYPE_COLOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:35:2: ( 'Yellow' | 'Blue' | 'Red' | 'Green' | 'White' )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 'Y':
                {
                alt1=1;
                }
                break;
            case 'B':
                {
                alt1=2;
                }
                break;
            case 'R':
                {
                alt1=3;
                }
                break;
            case 'G':
                {
                alt1=4;
                }
                break;
            case 'W':
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:35:5: 'Yellow'
                    {
                    match("Yellow"); 


                    }
                    break;
                case 2 :
                    // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:35:14: 'Blue'
                    {
                    match("Blue"); 


                    }
                    break;
                case 3 :
                    // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:35:21: 'Red'
                    {
                    match("Red"); 


                    }
                    break;
                case 4 :
                    // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:35:27: 'Green'
                    {
                    match("Green"); 


                    }
                    break;
                case 5 :
                    // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:35:36: 'White'
                    {
                    match("White"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPE_COLOR"

    // $ANTLR start "OPEN_BRACKET"
    public final void mOPEN_BRACKET() throws RecognitionException {
        try {
            int _type = OPEN_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:36:13: ( '{' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:36:16: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPEN_BRACKET"

    // $ANTLR start "CLOSE_BRACKET"
    public final void mCLOSE_BRACKET() throws RecognitionException {
        try {
            int _type = CLOSE_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:37:14: ( '}' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:37:20: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSE_BRACKET"

    // $ANTLR start "LESS_THAN"
    public final void mLESS_THAN() throws RecognitionException {
        try {
            int _type = LESS_THAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:39:2: ( '<' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:39:4: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS_THAN"

    // $ANTLR start "GREATER_THAN"
    public final void mGREATER_THAN() throws RecognitionException {
        try {
            int _type = GREATER_THAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:41:2: ( '>' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:41:4: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER_THAN"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:42:8: ( ',' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:42:10: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            int _type = DIGIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:43:7: ( ( '0' .. '9' )+ )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:43:9: ( '0' .. '9' )+
            {
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:43:9: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:43:9: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:44:9: ( ( '\\r' )? '\\n' )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:44:11: ( '\\r' )? '\\n'
            {
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:44:11: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:44:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:45:14: ( ( ' ' | '\\t' )+ )
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:45:19: ( ' ' | '\\t' )+
            {
            // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:45:19: ( ' ' | '\\t' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    public void mTokens() throws RecognitionException {
        // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:8: ( T__21 | T__22 | LIGHTSOURCE | CAMERA | LOCATION | PIGMENT | PLANE | SPHERE | LOOK_AT | COLOR | TYPE_COLOR | OPEN_BRACKET | CLOSE_BRACKET | LESS_THAN | GREATER_THAN | COMMA | DIGIT | NEWLINE | WHITESPACE )
        int alt5=19;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:10: T__21
                {
                mT__21(); 

                }
                break;
            case 2 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:16: T__22
                {
                mT__22(); 

                }
                break;
            case 3 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:22: LIGHTSOURCE
                {
                mLIGHTSOURCE(); 

                }
                break;
            case 4 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:34: CAMERA
                {
                mCAMERA(); 

                }
                break;
            case 5 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:41: LOCATION
                {
                mLOCATION(); 

                }
                break;
            case 6 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:50: PIGMENT
                {
                mPIGMENT(); 

                }
                break;
            case 7 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:58: PLANE
                {
                mPLANE(); 

                }
                break;
            case 8 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:64: SPHERE
                {
                mSPHERE(); 

                }
                break;
            case 9 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:71: LOOK_AT
                {
                mLOOK_AT(); 

                }
                break;
            case 10 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:79: COLOR
                {
                mCOLOR(); 

                }
                break;
            case 11 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:85: TYPE_COLOR
                {
                mTYPE_COLOR(); 

                }
                break;
            case 12 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:96: OPEN_BRACKET
                {
                mOPEN_BRACKET(); 

                }
                break;
            case 13 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:109: CLOSE_BRACKET
                {
                mCLOSE_BRACKET(); 

                }
                break;
            case 14 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:123: LESS_THAN
                {
                mLESS_THAN(); 

                }
                break;
            case 15 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:133: GREATER_THAN
                {
                mGREATER_THAN(); 

                }
                break;
            case 16 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:146: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 17 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:152: DIGIT
                {
                mDIGIT(); 

                }
                break;
            case 18 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:158: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 19 :
                // D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g:1:166: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\30\uffff";
    static final String DFA5_eofS =
        "\30\uffff";
    static final String DFA5_minS =
        "\1\11\2\uffff\1\151\1\141\1\151\13\uffff\1\143\6\uffff";
    static final String DFA5_maxS =
        "\1\175\2\uffff\2\157\1\154\13\uffff\1\157\6\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\10\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
        "\1\22\1\23\1\3\1\uffff\1\4\1\12\1\6\1\7\1\5\1\11";
    static final String DFA5_specialS =
        "\30\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\17\1\16\2\uffff\1\16\22\uffff\1\17\13\uffff\1\14\1\1\1\2"+
            "\1\uffff\12\15\2\uffff\1\12\1\uffff\1\13\3\uffff\1\7\4\uffff"+
            "\1\7\12\uffff\1\7\4\uffff\1\7\1\uffff\1\7\11\uffff\1\4\10\uffff"+
            "\1\3\3\uffff\1\5\2\uffff\1\6\7\uffff\1\10\1\uffff\1\11",
            "",
            "",
            "\1\20\5\uffff\1\21",
            "\1\22\15\uffff\1\23",
            "\1\24\2\uffff\1\25",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\26\13\uffff\1\27",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__21 | T__22 | LIGHTSOURCE | CAMERA | LOCATION | PIGMENT | PLANE | SPHERE | LOOK_AT | COLOR | TYPE_COLOR | OPEN_BRACKET | CLOSE_BRACKET | LESS_THAN | GREATER_THAN | COMMA | DIGIT | NEWLINE | WHITESPACE );";
        }
    }
 

}