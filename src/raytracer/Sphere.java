package raytracer;

import javax.vecmath.*;

public class Sphere extends Object3D {
	private Point3d center = null;
	private double radius = 1d;
	//private Color3f color = null;
	boolean DEBUG = false;
     //   private double diffuse;
     //   private double specular;
     //   private double brilliance;
     //   private double ambient;

	public Sphere() {
		this.center = new Point3d();
		this.radius = 1d;
		this.color = new Color3f(1f, 1f, 1f);
	}
	
	public Sphere(Point3d center, double radius, Color3f color, double ambient, double diffuse, double specular, double brilliance, double reflection) {
		super();
		this.center = center;
		this.radius = radius;
		this.color  = color;
        this.ambient=ambient;
        this.diffuse=diffuse;
        this.specular=specular;
        this.brilliance=brilliance;
        this.reflection=reflection;
	}

	boolean intersect(Ray r, Hit h, Range range, Light ambiental, Light point) {
		// ToDo:
        boolean retVal = false;
        Vector3d origenRayo = new Vector3d(r.getOrigin().x, r.getOrigin().y, r.getOrigin().z);
        Vector3d origenEsfera= new Vector3d(this.center.x, this.center.y, this.center.z);
        double Aq= 1;
        double Bq = 2*(r.getDirection().dot(origenRayo)) - 2*(r.getDirection().dot(origenEsfera));
        double Cq = origenRayo.dot(origenRayo) - 2*(origenRayo.dot(origenEsfera)) - Math.pow(this.radius,2) + origenEsfera.dot(origenEsfera);
        double discriminant = Bq*Bq-(4*Aq*Cq);
         //Hay intersección, si se cumple esta condición... solo se ne
        // necesita el primer valor que es el de la primera intersección
        if (discriminant >=0)
        {
           double firstT=(-Bq-Math.sqrt(discriminant))/(2*Aq);
           if(firstT>range.getMinT() && firstT<h.getT())
               {
                   h.setT(firstT);
                   retVal=true;
               }

        }
        return retVal;
    }



    Vector3d getNormal (Point3d temp)
    {
        double x=(temp.x-this.center.x);
        double y=(temp.y-this.center.y);
        double z=(temp.z-this.center.z);
        Vector3d a=new Vector3d(x,y,z);
        a.normalize();
        return (a);
    }

}
