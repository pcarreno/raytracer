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
import java.io.*;
import java.util.Vector;
import javax.vecmath.*;

public class Main {

    int size = 300;
	Group group = new Group();;
	Image image = null;
	Camera	camera = null;


    	public void createScene(Vector <double []> temp, double ratio) {
		// Create a red sphere
         for (int i=0; i<temp.size(); i+=3){
           double [] temp0 = new double [3];
           double [] temp2 = new double [1];
           double [] temp3 = new double [3];
            temp0=temp.get(i);
            temp2=temp.get(i+1);
            temp3=temp.get(i+2);
            Sphere s1;
            if(temp0[0]>1&&temp0[1]>1&&temp0[2]>1){
            s1 = new Sphere(new Point3d(temp0[0]*ratio, temp0[1]*ratio, temp0[2]*ratio),
            temp2[0]*ratio, new Color3f((float)temp3[0], (float)temp3[1], (float)temp3[2]));
            }else
            {
            s1 = new Sphere(new Point3d(temp0[0], temp0[1], temp0[2]),
            temp2[0], new Color3f((float)temp3[0], (float)temp3[1], (float)temp3[2]));
            }
            group.add(s1);
        }
        /*Sphere s1 = new Sphere(new Point3d(0.5d, 0.5d, -0.5d), 0.3d,
				new Color3f(1f, 0f, 0f));
		// Create a blue sphere
		Sphere s2 = new Sphere(new Point3d(0.1d, 0.5d, -1.5d), 0.3d,
				new Color3f(0f, 0f, 1f));
		// Now create a group
		group = new Group();
		group.add(s1);
		group.add(s2);*/
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

	// TODO Auto-generated method stub
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
            m.createScene(parser.getVector(), ratio);

            m.image = new Image(m.size, m.size);
            m.camera = new OrtographicCamera(1d);


		for (int x = 0; x < m.size; x++) {
            double right=(x*ratio)-1;
			for (int y =0; y <m.size; y++) {
				double up= (y*ratio)-1;
               Ray r= m.camera.generateRay(new Point2d(right,up));
               Hit h=new Hit();
               Range range = new Range();
               m.group.intersect(r, h, range);
               m.image.setColor(x, y, h.getColor());
              }
        }
        m.image.writeImage();
    }


}
