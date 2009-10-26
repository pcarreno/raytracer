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
		// Create a red sphere
         System.out.println(ligths.size());
         ambiental = new Light(new Color3f((float)ambientL[0],(float)ambientL[1], (float)ambientL[2]), ambientLight);
         for(int j=0; j<ligths.size(); j+=2)
         {
         double [] temp0 = new double [3];
         double [] temp1=new double [3];
         temp0=ligths.get(j);
         temp1=ligths.get(j+1);
         System.out.println(temp0[0]);
         point=new Light(new Point3d(temp0[0], temp0[1], temp0[2]), new Color3f((float)temp1[0], (float)temp1[1], 
                 (float)temp1[2]), pointLight);       
         }
         for (int i=0; i<temp.size(); i+=4){
           double [] temp0 = new double [3];
           double [] temp2 = new double [1];
           double [] temp3 = new double [3];
           double [] temp4= new double [4];
            temp0=temp.get(i);
            temp2=temp.get(i+1);
            temp3=temp.get(i+2);
            temp4=temp.get(i+3);
            Sphere s1 = new Sphere(new Point3d(temp0[0], temp0[1], temp0[2]),
            temp2[0], new Color3f((float)temp3[0], (float)temp3[1], (float)temp3[2]), temp4[0], temp4[1], temp4[2], temp4[3], 1.5);
            group.add(s1);
        }
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

          Main m = new Main();
            CharStream input = new ANTLRFileStream("input.txt");
            // El nombre del lexer comienza con el nombre del archivo .g.
            // en este caso, Expr
            RayTracerLexer lex = new RayTracerLexer (input);
            // Las siguientes líneas son para el Lexer
            CommonTokenStream tokens = new CommonTokenStream(lex);
            // El nombre del parser también comienza con el nombre del archivo
            RayTracerParser parser = new RayTracerParser(tokens);
            parser.scene();
            double ratio=2/(double)m.size;
            m.createScene(parser.getVector(),parser.getLigths(), parser.getAmbientLigth());

            m.image = new Image(m.size, m.size);
            m.camera = new OrtographicCamera(1d);

            Color3f temp=new Color3f();
	for (int x = 0; x < m.size; x++) {
            double right=(x*ratio)-1;
			for (int y =0; y <m.size; y++) {
				double up= (y*ratio)-1;
               Ray r= m.camera.generateRay(new Point2d(right,up));
               Hit h=new Hit();
               Range range = new Range(0.0001, Double.MAX_VALUE);
               m.group.intersect(r, h, range, m.ambiental, m.point);
               m.image.setColor(x, y, h.getColor());
              // m.image.setColor(x, y, m.group.iluminate(m.ambiental, m.point, h, r));
              }
        }
        m.image.writeImage();
    }


}
