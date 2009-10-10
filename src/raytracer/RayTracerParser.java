package raytracer;

// $ANTLR 3.1.2 D:\\Pamela\\Quinto semestre\\Computaci�n  Gr�fica\\Practica Final\\Compilador RayTracer\\RayTracer.g 2009-09-26 18:51:12



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Vector;

public class RayTracerParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LIGHTSOURCE", "OPEN_BRACKET", "COLOR", "CLOSE_BRACKET", "CAMERA", "LOCATION", "LOOK_AT", "SPHERE", "COMMA", "PLANE", "PIGMENT", "LESS_THAN", "GREATER_THAN", "DIGIT", "TYPE_COLOR", "NEWLINE", "WHITESPACE", "'-'", "'.'"
    };
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
    public static final int CLOSE_BRACKET=7;
    public static final int SPHERE=11;

    // delegates
    // delegators


        public RayTracerParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public RayTracerParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);

        }

    public String[] getTokenNames() { return RayTracerParser.tokenNames; }
    public String getGrammarFileName() { return "RayTracer.g"; }



    	public Vector <double[]> spheres = new Vector <double []>();
    	public String ligth= "";
    	public String camera="";
    	public String coordenate="";
    	public String coordenate2="";
    	public String num1="", num2="", num3="";
    	public String sphere= "";
    	public String plane= "";
    	public String color= "";
    	public int typeObject = 0;
    	public static final int typePlane =1;
    	public static final int typeSphere = 2;
    	public static final int typeCamera = 3;
    	public static final int typeLigth =4;

        Vector getVector(){
        return spheres;}

    // $ANTLR start "scene"
    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:21:1: scene : ( object )+ ;
    public final void scene() throws RecognitionException {
        try {
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:21:7: ( ( object )+ )
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:21:9: ( object )+
            {
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:21:9: ( object )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==LIGHTSOURCE||LA1_0==CAMERA||LA1_0==SPHERE||LA1_0==PLANE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:21:9: object
            	    {
            	    pushFollow(FOLLOW_object_in_scene16);
            	    object();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "scene"


    // $ANTLR start "object"
    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:22:1: object : ( light | camera | ( sphere | plane ) );
    public final void object() throws RecognitionException {
        try {
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:22:8: ( light | camera | ( sphere | plane ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case LIGHTSOURCE:
                {
                alt3=1;
                }
                break;
            case CAMERA:
                {
                alt3=2;
                }
                break;
            case SPHERE:
            case PLANE:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:22:11: light
                    {
                    pushFollow(FOLLOW_light_in_object25);
                    light();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:22:19: camera
                    {
                    pushFollow(FOLLOW_camera_in_object29);
                    camera();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:22:28: ( sphere | plane )
                    {
                    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:22:28: ( sphere | plane )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==SPHERE) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==PLANE) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:22:29: sphere
                            {
                            pushFollow(FOLLOW_sphere_in_object34);
                            sphere();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:22:36: plane
                            {
                            pushFollow(FOLLOW_plane_in_object36);
                            plane();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "object"


    // $ANTLR start "light"
    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:23:1: light : LIGHTSOURCE OPEN_BRACKET coordenate3D COLOR color CLOSE_BRACKET ;
    public final void light() throws RecognitionException {
        RayTracerParser.coordenate3D_return coordenate3D1 = null;

        RayTracerParser.color_return color2 = null;


        try {
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:23:7: ( LIGHTSOURCE OPEN_BRACKET coordenate3D COLOR color CLOSE_BRACKET )
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:23:9: LIGHTSOURCE OPEN_BRACKET coordenate3D COLOR color CLOSE_BRACKET
            {
            match(input,LIGHTSOURCE,FOLLOW_LIGHTSOURCE_in_light44);
            match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_light46);
            pushFollow(FOLLOW_coordenate3D_in_light48);
            coordenate3D1=coordenate3D();

            state._fsp--;

            match(input,COLOR,FOLLOW_COLOR_in_light50);
            pushFollow(FOLLOW_color_in_light52);
            color2=color();

            state._fsp--;

            match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_light54);
            ligth+= "luz = " + (coordenate3D1!=null?input.toString(coordenate3D1.start,coordenate3D1.stop):null) + ", " + (color2!=null?input.toString(color2.start,color2.stop):null) + ";";
            		System.out.println (ligth);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "light"


    // $ANTLR start "camera"
    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:26:1: camera : CAMERA OPEN_BRACKET LOCATION coordenate= coordenate3D LOOK_AT coordenate2= coordenate3D CLOSE_BRACKET ;
    public final void camera() throws RecognitionException {
        RayTracerParser.coordenate3D_return coordenate = null;

        RayTracerParser.coordenate3D_return coordenate2 = null;


        try {
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:26:8: ( CAMERA OPEN_BRACKET LOCATION coordenate= coordenate3D LOOK_AT coordenate2= coordenate3D CLOSE_BRACKET )
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:26:10: CAMERA OPEN_BRACKET LOCATION coordenate= coordenate3D LOOK_AT coordenate2= coordenate3D CLOSE_BRACKET
            {
            camera += "camara = " + "position ";
            match(input,CAMERA,FOLLOW_CAMERA_in_camera69);
            match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_camera71);
            match(input,LOCATION,FOLLOW_LOCATION_in_camera73);
            pushFollow(FOLLOW_coordenate3D_in_camera77);
            coordenate=coordenate3D();

            state._fsp--;

            camera += (coordenate!=null?input.toString(coordenate.start,coordenate.stop):null) + ", lookat ";

            match(input,LOOK_AT,FOLLOW_LOOK_AT_in_camera86);
            pushFollow(FOLLOW_coordenate3D_in_camera90);
            coordenate2=coordenate3D();

            state._fsp--;


            		camera +=(coordenate2!=null?input.toString(coordenate2.start,coordenate2.stop):null) + ";";
            		System.out.println(camera);
            match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_camera94);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "camera"


    // $ANTLR start "sphere"
    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:33:1: sphere : SPHERE OPEN_BRACKET coordenate3D COMMA number pigment CLOSE_BRACKET ;
    public final void sphere() throws RecognitionException {
        RayTracerParser.number_return number3 = null;


        try {
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:33:8: ( SPHERE OPEN_BRACKET coordenate3D COMMA number pigment CLOSE_BRACKET )
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:33:10: SPHERE OPEN_BRACKET coordenate3D COMMA number pigment CLOSE_BRACKET
            {
            typeObject=typeSphere;
            		/*sphere+= "esfera = ";*/
            match(input,SPHERE,FOLLOW_SPHERE_in_sphere105);
            match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_sphere107);
            pushFollow(FOLLOW_coordenate3D_in_sphere109);
            coordenate3D();

            state._fsp--;

            match(input,COMMA,FOLLOW_COMMA_in_sphere117);
            pushFollow(FOLLOW_number_in_sphere119);
            number3=number();

            state._fsp--;


            		double [] tempRadio= new double [1];
            		tempRadio [0] = Double.valueOf((number3!=null?input.toString(number3.start,number3.stop):null)).doubleValue();
            		spheres.add (tempRadio);
            		/*sphere+= (number3!=null?input.toString(number3.start,number3.stop):null) + ", ";*/
            pushFollow(FOLLOW_pigment_in_sphere127);
            pigment();

            state._fsp--;

            match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_sphere129);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "sphere"


    // $ANTLR start "plane"
    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:46:1: plane : PLANE OPEN_BRACKET coordenate3D COMMA number pigment CLOSE_BRACKET ;
    public final void plane() throws RecognitionException {
        RayTracerParser.coordenate3D_return coordenate3D4 = null;

        RayTracerParser.number_return number5 = null;


        try {
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:46:8: ( PLANE OPEN_BRACKET coordenate3D COMMA number pigment CLOSE_BRACKET )
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:46:10: PLANE OPEN_BRACKET coordenate3D COMMA number pigment CLOSE_BRACKET
            {
            typeObject=typePlane;
            		plane+= "plano = ";
            match(input,PLANE,FOLLOW_PLANE_in_plane145);
            match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_plane147);
            pushFollow(FOLLOW_coordenate3D_in_plane149);
            coordenate3D4=coordenate3D();

            state._fsp--;

            plane+= (coordenate3D4!=null?input.toString(coordenate3D4.start,coordenate3D4.stop):null)+ ", ";
            match(input,COMMA,FOLLOW_COMMA_in_plane157);
            pushFollow(FOLLOW_number_in_plane159);
            number5=number();

            state._fsp--;

            plane+= (number5!=null?input.toString(number5.start,number5.stop):null) + ", ";
            pushFollow(FOLLOW_pigment_in_plane167);
            pigment();

            state._fsp--;

            match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_plane169);
            System.out.println(plane);
            		plane="";

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "plane"


    // $ANTLR start "pigment"
    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:55:1: pigment : PIGMENT OPEN_BRACKET COLOR color CLOSE_BRACKET ;
    public final void pigment() throws RecognitionException {
        RayTracerParser.color_return color6 = null;


        try {
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:55:9: ( PIGMENT OPEN_BRACKET COLOR color CLOSE_BRACKET )
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:55:11: PIGMENT OPEN_BRACKET COLOR color CLOSE_BRACKET
            {
            match(input,PIGMENT,FOLLOW_PIGMENT_in_pigment180);
            match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_pigment182);
            match(input,COLOR,FOLLOW_COLOR_in_pigment184);
            pushFollow(FOLLOW_color_in_pigment186);
            color6=color();

            state._fsp--;

            match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_pigment188);
            color+= (color6!=null?input.toString(color6.start,color6.stop):null);
            		 double [] color1 = new double [3];
            		// Para determinar el color
            		if (color.equals("Yellow"))
                    {
            		color1 [0] = 1.0; color1 [1] =1.0; color1 [2] = 0.0;
                    } else if (color.equals("Blue"))
                    {color1 [0] = 0.0; color1 [1] =0.0; color1 [2] = 1.0;
                    }else if (color.equals("Red"))
                    { color1 [0] = 1.0; color1 [1] =0.0; color1 [2] = 0.0;
                    } else if (color.equals("Green"))
                    {color1 [0] = 1.0; color1 [1] =1.0; color1 [2] = 0.0;
                    } else if (color.equals("White"))
                    {color1 [0] = 1.0; color1 [1] =1.0; color1 [2] = 1.0;}
            		 color = "";

            		 // Para saber a que vector se agrega
            		  switch (typeObject){
            		    case 1:
            		      break;
            		   case 2:
            		    spheres.add(color1);
                        //color1=null;
            		    break;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pigment"

    public static class coordenate3D_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "coordenate3D"
    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:79:1: coordenate3D : LESS_THAN num1= number COMMA num2= number COMMA num3= number GREATER_THAN ;
    public final RayTracerParser.coordenate3D_return coordenate3D() throws RecognitionException {
        RayTracerParser.coordenate3D_return retval = new RayTracerParser.coordenate3D_return();
        retval.start = input.LT(1);

        RayTracerParser.number_return num1 = null;

        RayTracerParser.number_return num2 = null;

        RayTracerParser.number_return num3 = null;


        try {
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:80:2: ( LESS_THAN num1= number COMMA num2= number COMMA num3= number GREATER_THAN )
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:80:4: LESS_THAN num1= number COMMA num2= number COMMA num3= number GREATER_THAN
            {
            match(input,LESS_THAN,FOLLOW_LESS_THAN_in_coordenate3D200);
            pushFollow(FOLLOW_number_in_coordenate3D204);
            num1=number();

            state._fsp--;

            match(input,COMMA,FOLLOW_COMMA_in_coordenate3D206);
            pushFollow(FOLLOW_number_in_coordenate3D210);
            num2=number();

            state._fsp--;

            match(input,COMMA,FOLLOW_COMMA_in_coordenate3D212);
            pushFollow(FOLLOW_number_in_coordenate3D216);
            num3=number();

            state._fsp--;

            match(input,GREATER_THAN,FOLLOW_GREATER_THAN_in_coordenate3D218);
             double [] temp = new double [3];
            		  temp [0]=Double.valueOf((num1!=null?input.toString(num1.start,num1.stop):null)).doubleValue();
            		  temp [1]= Double.valueOf((num2!=null?input.toString(num2.start,num2.stop):null)).doubleValue();
            		  temp [2] = Double.valueOf((num3!=null?input.toString(num3.start,num3.stop):null)).doubleValue();
            		  switch (typeObject){
            			case 1:
            			  break;
            			case 2:
            			 spheres.add(temp);
            			  break;}


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "coordenate3D"

    public static class number_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "number"
    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:92:1: number : ( '-' )? DIGIT ( '.' )? ( DIGIT )* ;
    public final RayTracerParser.number_return number() throws RecognitionException {
        RayTracerParser.number_return retval = new RayTracerParser.number_return();
        retval.start = input.LT(1);

        try {
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:92:8: ( ( '-' )? DIGIT ( '.' )? ( DIGIT )* )
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:92:10: ( '-' )? DIGIT ( '.' )? ( DIGIT )*
            {
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:92:10: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:92:11: '-'
                    {
                    match(input,21,FOLLOW_21_in_number230);

                    }
                    break;

            }

            match(input,DIGIT,FOLLOW_DIGIT_in_number234);
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:92:23: ( '.' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:92:24: '.'
                    {
                    match(input,22,FOLLOW_22_in_number237);

                    }
                    break;

            }

            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:92:30: ( DIGIT )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==DIGIT) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:92:30: DIGIT
            	    {
            	    match(input,DIGIT,FOLLOW_DIGIT_in_number241);

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "number"

    public static class color_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "color"
    // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:93:1: color : TYPE_COLOR ;
    public final RayTracerParser.color_return color() throws RecognitionException {
        RayTracerParser.color_return retval = new RayTracerParser.color_return();
        retval.start = input.LT(1);

        try {
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:93:7: ( TYPE_COLOR )
            // D:\\Pamela\\Quinto semestre\\Computación  Gráfica\\Practica Final\\Compilador\\RayTracer.g:93:9: TYPE_COLOR
            {
            match(input,TYPE_COLOR,FOLLOW_TYPE_COLOR_in_color249);

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "color"

    // Delegated rules




    public static final BitSet FOLLOW_object_in_scene16 = new BitSet(new long[]{0x0000000000002912L});
    public static final BitSet FOLLOW_light_in_object25 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_camera_in_object29 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sphere_in_object34 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plane_in_object36 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIGHTSOURCE_in_light44 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_light46 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_coordenate3D_in_light48 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COLOR_in_light50 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_color_in_light52 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_light54 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAMERA_in_camera69 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_camera71 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LOCATION_in_camera73 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_coordenate3D_in_camera77 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LOOK_AT_in_camera86 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_coordenate3D_in_camera90 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_camera94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPHERE_in_sphere105 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_sphere107 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_coordenate3D_in_sphere109 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COMMA_in_sphere117 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_number_in_sphere119 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_pigment_in_sphere127 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_sphere129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLANE_in_plane145 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_plane147 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_coordenate3D_in_plane149 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COMMA_in_plane157 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_number_in_plane159 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_pigment_in_plane167 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_plane169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIGMENT_in_pigment180 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_pigment182 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COLOR_in_pigment184 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_color_in_pigment186 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_pigment188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_THAN_in_coordenate3D200 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_number_in_coordenate3D204 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COMMA_in_coordenate3D206 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_number_in_coordenate3D210 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COMMA_in_coordenate3D212 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_number_in_coordenate3D216 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_GREATER_THAN_in_coordenate3D218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_number230 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_DIGIT_in_number234 = new BitSet(new long[]{0x0000000000420002L});
    public static final BitSet FOLLOW_22_in_number237 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_DIGIT_in_number241 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_TYPE_COLOR_in_color249 = new BitSet(new long[]{0x0000000000000002L});
}