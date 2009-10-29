/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package raytracer;

/**
 *
 * @author Administrador
 */
import org.antlr.runtime.*;
import java.util.Vector;
import javax.vecmath.*;

public class Main {

    int size = 300;
    Group group = new Group();;
    Image image = null;
    Camera camera = null;
    Light ambiental = new Light();
    Light point = new Light();
    public static final int pointLight=1;
    public static final int ambientLight=2;


    	public void createScene(Vector <double []> temp, Vector <double[]> ligths, double[] ambientL) {
		//Se instancian la luz ambiental y la luz puntual segun lo escena que recibe el parser
         ambiental = new Light(new Color3f((float)ambientL[0],(float)ambientL[1], (float)ambientL[2]), ambientLight);
         for(int j=0; j<ligths.size(); j+=2)
         {
         double [] temp0 = new double [3];
         double [] temp1=new double [3];
         temp0=ligths.get(j);
         temp1=ligths.get(j+1);
         point=new Light(new Point3d(temp0[0], temp0[1], temp0[2]), new Color3f((float)temp1[0], (float)temp1[1],
                 (float)temp1[2]), pointLight);
         }
		 //Se crean las esferas definidas en la escena .pov
         for (int i=0; i<temp.size(); i+=4){
           double [] temp0 = new double [3];
           double [] temp2 = new double [2];
           double [] temp3 = new double [3];
           double [] temp4= new double [4];
           //Posición
           temp0=temp.get(i);
           //Color
           temp3=temp.get(i+1);
           //Factores iluminacion local
           temp4=temp.get(i+2);
           //Radio y factor de reflexion
           temp2=temp.get(i+3);
           Sphere s1 = new Sphere(new Point3d(temp0[0], temp0[1], temp0[2]),
           temp2[0], new Color3f((float)temp3[0], (float)temp3[1], (float)temp3[2]), temp4[0], temp4[1], temp4[2], temp4[3], temp2[1]);
           group.add(s1);
        }
	}
    /**
     * @param args the command line arguments
     */
		public static void main(String[] args) throws Exception {

			Main m = new Main();
			//Ejecucion del parser que traduce lo recibido de PovRay a algo util para Java
            CharStream input = new ANTLRFileStream("input.txt");
            RayTracerLexer lex = new RayTracerLexer (input);
            CommonTokenStream tokens = new CommonTokenStream(lex);

            RayTracerParser parser = new RayTracerParser(tokens);
            parser.scene();
            double ratio=2/(double)m.size; // Valor utilizado para el mapeo de los pixels a la escena del mundo.
            m.createScene(parser.getVector(),parser.getLigths(), parser.getAmbientLigth());
            m.image = new Image(m.size, m.size);
            m.camera = new OrtographicCamera(1d);
			//Se generan los rayos para cada uno de los pixeles, y se calcula su intercepcion con los objetos
			//Se recibe el color resultante y se adiciona a la imagen
			for (int x = 0; x < m.size; x++) {
				double right=(x*ratio)-1;
					for (int y =0; y <m.size; y++) {
						double up= (y*ratio)-1;
						Ray r= m.camera.generateRay(new Point2d(right,up));
						Hit h=new Hit();
						Range range = new Range(0.0d, Double.MAX_VALUE);
						h.setColor(m.group.iluminate(r, h, range, m.ambiental, m.point));
						m.group.cleanCounter(0);
						m.image.setColor(x, y, h.getColor());
					}
			}

			m.image.writeImage();
    }


}