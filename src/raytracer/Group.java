package raytracer;

import java.util.Vector;

public class Group extends Object3D {
	Vector<Object3D> vector = null;
	
	public Group() {
		vector = new Vector<Object3D>();
	}
	
	public void add(Object3D o3D) {
		vector.add(o3D);
	}
	
	boolean intersect(Ray r, Hit h, Range range) {
		boolean retVal = false;
        for (int j=0; j<vector.size(); j++)
       {
         retVal=vector.get(j).intersect(r, h, range);
       }
		return retVal;
	}

}
