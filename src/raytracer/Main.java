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

    int size = 500;
	Group group = null;
	Image image = null;
	Camera	camera = null;

    	public void createScene(Vector <double []> temp) {
		// Create a red sphere
        group = new Group();

        for (int i=0; i<temp.size()-1; i+=3){
           double [] temp0 = new double [3];
           double [] temp2 = new double [1];
           double [] temp3 = new double [3];
            temp0=temp.get(i);
            temp2=temp.get(i+1);
            temp3=temp.get(i+2);
            Sphere s1 = new Sphere(new Point3d(temp0[0], temp0[1], temp0[2]), temp2[0],
			new Color3f((float)temp3[0], (float)temp3[1], (float)temp3[2]));
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
            m.createScene(parser.getVector());

            m.image = new Image(m.size, m.size);
            m.camera = new OrtographicCamera(1d);

		// ToDo: For each pixel in the image,
		// ask the camera to cast a ray
		// then find if there are intersections of the
		// ray with all objects in the scene
		// Set the color of the image when necessary
		for (int x = m.size/2; x < -m.size/2; x--) {
            int right= x * (2/m.size);
			for (int y = m.size/2; y < -m.size/2; y--) {
				int up= y*(2/m.size);
               Ray r= m.camera.generateRay(new Point2d(right,up));
               Hit h=new Hit();
               Range range = new Range();
               m.group.intersect(r, h, range);
            }
		// ToDo: Write the image at the end
		// ...
        }
    }


}
