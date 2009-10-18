grammar RayTracer;

@members {

	public Vector <double[]> spheres = new Vector <double []>();
	public double [] ambientLight = new double [3];
	public Vector <double []> ligths = new Vector <double[]>();
	public String camera="";
	public String num1="", num2="", num3="", num0="";
	public String plane= "";
	public String color= "";
	public int typeObject = 0;
	public boolean flag;
	public static final int typePlane = 1;
	public static final int typeSphere = 2;
	public static final int typeCamera = 3;
	public static final int typeLigth = 4;
	public static final int typeAmbientalL=5;
	}

scene	:	ambient_light object+;
object	: 	light | camera | (sphere|plane);
light	:	{typeObject=typeLigth;}
		LIGHTSOURCE OPEN_BRACKET coordenate3D COLOR color CLOSE_BRACKET
		/*{ligth+= "luz = " + $coordenate3D.text + ", " + $color.text + ";";
		System.out.println (ligth);}*/;
camera	:	{camera += "camara = " + "position ";}
		CAMERA OPEN_BRACKET LOCATION coordenate=coordenate3D 
		{camera += $coordenate.text + ", lookat ";
		}
		LOOK_AT coordenate2=coordenate3D {
		camera +=$coordenate2.text + ";";
		System.out.println(camera);} CLOSE_BRACKET;
sphere	:	{typeObject=typeSphere;
		flag=false;}
		SPHERE OPEN_BRACKET coordenate3D
		/*{sphere+= $coordenate3D.text+ ", ";}*/
		COMMA number
		{
		double [] tempRadio= new double [1];
		tempRadio [0] = Double.valueOf($number.text).doubleValue();
		spheres.add (tempRadio);
		/*sphere+= $number.text + ", ";*/}
		pigment (constantLights)? CLOSE_BRACKET
		{if(!flag){
		  double [] temp = new double [4];
		  temp [0]=0.1;
		  temp [1]=0.7;
		  temp [2]= 0.1;
		  temp [3] = 10.0;
		  spheres.add(temp);}
		};
plane 	:	{typeObject=typePlane;
		plane+= "plano = ";}
		PLANE OPEN_BRACKET coordenate3D
		{plane+= $coordenate3D.text+ ", ";}
		COMMA number
		{plane+= $number.text + ", ";}
		pigment (constantLights)? CLOSE_BRACKET
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
		 {color1 [0] = 0.0; color1 [1] =1.0; color1 [2] = 0.0;
		} else if (color.equals("White"))
		 {color1 [0] = 1.0; color1 [1] =1.0; color1 [2] = 1.0;}
		 color = ""; 
		 
		 // Para saber a que vector se agrega
		  switch (typeObject){
		    case 1:
		      break;
		   case 2:
		    spheres.add(color1);
		   case 3:
		    break;
		   case 4:
		    ligths.add(color1);
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
			  break;
			case 3:
			 break;
			case 4:
			 ligths.add(temp);
			 break;
			case 5:
 			 break;}
		};
number	:	('-')? DIGIT ('.')? DIGIT*;
color	:	TYPE_COLOR
		{color+= $TYPE_COLOR.text;
		 double [] color1 = new double [3]; 
		 if (color.equals("Yellow"))														{
			color1 [0] = 1.0; color1 [1] =1.0; color1 [2] = 0.0;
		} else if (color.equals("Blue"))
			 {color1 [0] = 0.0; color1 [1] =0.0; color1 [2] = 1.0;
		} else if (color.equals("Red"))														{  color1 [0] = 1.0; color1 [1] =0.0; color1 [2] = 0.0;											} else if (color.equals("Green"))
			{color1 [0] = 0.0; color1 [1] =1.0; color1 [2] = 0.0;
		} else if (color.equals("White"))
			{color1 [0] = 1.0; color1 [1] =1.0; color1 [2] = 1.0;}
		color = ""; 
		switch (typeObject){
		   case 4:
		    ligths.add(color1);
		    break;
		   case 5:
		    for (int i=0; i<3; i++){	
   		     ambientLight[i]=color1[i];}
		   break;
		   default:
		    break;}};	
ambient_light	:{typeObject=typeAmbientalL;}
		GLOBAL OPEN_BRACKET AMBIENTLIGHT COLOR color CLOSE_BRACKET ;												// Para determinar el color														
constantLights
	:{flag=true;} 
	'finish' OPEN_BRACKET 'ambient' num0=number 'diffuse' num1=number 'specular' num2=number 'brilliance' num3=number CLOSE_BRACKET
	  {
	   double [] temp = new double [4];
	   temp [0]=Double.valueOf($num0.text).doubleValue();
	   temp [1]= Double.valueOf($num1.text).doubleValue();
	   temp [2] = Double.valueOf($num2.text).doubleValue();
	   temp [3]=Double.valueOf($num3.text).doubleValue();
	    switch (typeObject)
	    {
	    case 1:
	      break;
	    case 2:
	      spheres.add(temp);
	      break;
	    case 3:
	      break;
	    case 4:
	      break;
	    case 5:
	      break;
	    }
	  }	;

AMBIENTLIGHT
	:	'ambient_light';
GLOBAL 
	:	'global_settings';
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
		 |'White' ;
OPEN_BRACKET:	 '{';
CLOSE_BRACKET:   '}';
LESS_THAN 
	:	'<';
GREATER_THAN
	:	'>';
COMMA 	:	',';
DIGIT	:	'0'..'9'+;
NEWLINE	:	'\r'? '\n' {skip();};
WHITESPACE:    (' '|'\t')+ {skip();} ;







	
