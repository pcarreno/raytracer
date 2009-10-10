grammar RayTracer;

@members {

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
	}

scene	:	object+;
object	: 	light | camera | (sphere|plane);
light	:	LIGHTSOURCE OPEN_BRACKET coordenate3D COLOR color CLOSE_BRACKET
		{ligth+= "luz = " + $coordenate3D.text + ", " + $color.text + ";";
		System.out.println (ligth);};
camera	:	{camera += "camara = " + "position ";}
		CAMERA OPEN_BRACKET LOCATION coordenate=coordenate3D 
		{camera += $coordenate.text + ", lookat ";
		}
		LOOK_AT coordenate2=coordenate3D {
		camera +=$coordenate2.text + ";";
		System.out.println(camera);} CLOSE_BRACKET;
sphere	:	{typeObject=typeSphere;
		/*sphere+= "esfera = ";*/}
		SPHERE OPEN_BRACKET coordenate3D
		/*{sphere+= $coordenate3D.text+ ", ";}*/
		COMMA number
		{
		double [] tempRadio= new double [1];
		tempRadio [0] = Double.valueOf($number.text).doubleValue();
		spheres.add (tempRadio);
		/*sphere+= $number.text + ", ";*/}
		pigment CLOSE_BRACKET
		/*{System.out.println(sphere);
		sphere="";}*/;
plane 	:	{typeObject=typePlane;
		plane+= "plano = ";}
		PLANE OPEN_BRACKET coordenate3D
		{plane+= $coordenate3D.text+ ", ";}
		COMMA number
		{plane+= $number.text + ", ";}
		pigment CLOSE_BRACKET
		{System.out.println(plane);
		plane="";};
pigment	:	PIGMENT OPEN_BRACKET COLOR color CLOSE_BRACKET
		{color+= $color.text;
		 double [] color1 = new double [3]; 
		
		// Para determinar el color
		if (color.equals("Yellow"))
		{
		color1 [0] = 1.0; color1 [1] =1.0; color1 [2] = 0.0;
		} else if (color.equals("Blue"))
		 {color1 [0] = 0.0; color1 [1] =0.0; color1 [2] = 1.0;
		} else if (color.equals("Red"))
		{  color1 [0] = 1.0; color1 [1] =0.0; color1 [2] = 0.0;
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
		    break;} };
coordenate3D
	:	LESS_THAN num1=number COMMA num2=number COMMA num3=number GREATER_THAN
		{ double [] temp = new double [3];
		  temp [0]=Double.valueOf($num1.text).doubleValue();
		  temp [1]= Double.valueOf($num2.text).doubleValue();
		  temp [2] = Double.valueOf($num3.text).doubleValue();
		  switch (typeObject){
			case 1:
			  break;
			case 2:
			 spheres.add(temp);
			  break;}
		};
number	:	('-')? DIGIT ('.')? DIGIT*;
color	:	TYPE_COLOR ;



LIGHTSOURCE :	'light_source';
CAMERA 	:	 'camera';
LOCATION:	 'location';
PIGMENT	:	 'pigment';
PLANE	:	 'plane';
SPHERE	:	 'sphere';
LOOK_AT	:	 'look_at';
COLOR	:	 'color';
TYPE_COLOR
	:	 'Yellow'
		 |'Blue' 
		 |'Red' 
		 |'Green' 
		 | 'White' ;
OPEN_BRACKET:	 '{';
CLOSE_BRACKET:     '}';
LESS_THAN 
	:	'<';
GREATER_THAN
	:	'>';
COMMA 	:	',';
DIGIT	:	'0'..'9'+;
NEWLINE	:	'\r'? '\n' {skip();};
WHITESPACE  	:   	(' '|'\t')+ {skip();} ;







	
