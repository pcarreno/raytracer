package raytracer;

import javax.vecmath.*;

public class Sphere extends Object3D {
	private Point3d center = null;
	private double radius = 1d;
	private Color3f color = null;
	boolean DEBUG = false;

	public Sphere() {
		this.center = new Point3d();
		this.radius = 1d;
		this.color = new Color3f(1f, 1f, 1f);
	}
	
	public Sphere(Point3d center, double radius, Color3f color) {
		super();
		this.center = center;
		this.radius = radius;
		this.color  = color;
	}

	boolean intersect(Ray r, Hit h, Range range) {
		// ToDo:
		boolean retVal = false;
        double Aq= r.getDirection().dot(r.getDirection());
        double Bq = 2*r.getDirection().dot(new Vector3d(r.getOrigin().x-center.x,
                r.getOrigin().y-center.y, r.getOrigin().z-center.z));
        double Cq = (Math.pow(r.getOrigin().x-center.x,2)+Math.pow(r.getOrigin().y-center.y,2)
                + Math.pow(r.getOrigin().z-center.z,2))-Math.pow(radius, 2);
        
        double discriminant = Math.pow(Bq,2)-(4*Aq*Cq);
         //Hay intersección, si se cumple esta condición... solo se ne
        // necesita el primer valor que es el de la primera intersección
        if (discriminant >=0)
        {
           discriminant=Math.sqrt(discriminant);
           double firstT=(-Bq-discriminant)/(2*Aq);
           if(firstT>range.minT && firstT<range.maxT)
               {
                   h.setColor(this.color);
                   range.maxT=firstT;
                   h.setT(firstT);
                // se debe retornar T
               }
           retVal=true;
        }
        return retVal;
        
        // Compute the intersection of the ray with the
		// Sphere and update what needs to be updated
		// Valid values for t must be within the "range"
		
		// ...
	}
	
}
