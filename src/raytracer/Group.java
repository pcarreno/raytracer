package raytracer;

import java.util.Vector;
import javax.vecmath.*;

public class Group extends Object3D {
	Vector<Object3D> vector = null;
    int objectSelected;
	
	public Group() {
		vector = new Vector<Object3D>();
	}
	
	public void add(Object3D o3D) {
		vector.add(o3D);
 	}
	
	boolean intersect(Ray r, Hit h, Range range, Light a, Light b) {
		boolean retVal = false;
        for (int j=0; j<vector.size(); j++)
       {
         retVal=vector.get(j).intersect(r, h, range, a, b);
       }
		return retVal;
	}
    //Local illumination

  /*  Color3f iluminate(Light a, Light b, Hit h, Ray r)
    {
        return vector.get(h.getIndex()).iluminate(a, b, h, r);
    }*/
}
