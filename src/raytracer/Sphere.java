package raytracer;

import javax.vecmath.*;

public class Sphere extends Object3D {
	private Point3d center = null;
	private double radius = 1d;
	private Color3f color = null;
	boolean DEBUG = false;
    private double diffuse;
    private double specular;
    private double brilliance;
    private double ambient;

	public Sphere() {
		this.center = new Point3d();
		this.radius = 1d;
		this.color = new Color3f(1f, 1f, 1f);
	}
	
	public Sphere(Point3d center, double radius, Color3f color, double ambient, double diffuse, double specular, double brilliance) {
		super();
		this.center = center;
		this.radius = radius;
		this.color  = color;
        this.ambient=ambient;
        this.diffuse=diffuse;
        this.specular=specular;
        this.brilliance=brilliance;
	}

	boolean intersect(Ray r, Hit h, Range range, Light a, Light b) {
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
           if(firstT<h.getT())
               {
                   Point3d iPoint= getIntersectionPoint(firstT, r);
                   Vector3d normal=getNormal(iPoint);
                   Color3f diffuseI=new Color3f();
                   Color3f specularI=new Color3f();
                   Color3f finalColor=new Color3f();
                   Color3f ambientI = new Color3f ((float)(a.getColor().x*this.ambient*this.color.x),
                           (float)(a.getColor().y*this.ambient*this.color.y), (float)(a.getColor().z*this.ambient*this.color.z));
                   //Dirección del punto de intercepción a la luz
                   //Iluminación difusa
                   Vector3d directionL = new Vector3d(b.getPosition().x-iPoint.x, b.getPosition().y-iPoint.y,
                           b.getPosition().z-iPoint.z);
                   directionL.normalize();
                   double cos=normal.dot(directionL);
                   if(cos>0){
                       diffuseI = new Color3f((float)(b.getColor().x*this.diffuse*this.color.x*cos), (float)(b.getColor().y
                               *this.diffuse*this.color.x*cos),(float)(b.getColor().z*this.diffuse*this.color.z*cos));
                       Vector3d directionR=new Vector3d(2*cos*(directionL.x-normal.x),2*cos*(directionL.y-normal.y),
                               2*cos*(directionL.z-normal.z));
                       double cosAlpha=directionR.dot(r.getDirection());
                       if(cosAlpha>0){
                           specularI = new Color3f((float)(b.getColor().x*this.specular*Math.pow(cosAlpha, this.brilliance)),
                                   (float)(b.getColor().y*this.specular*Math.pow(cosAlpha, this.brilliance)),
                                   (float)(b.getColor().z*this.specular*Math.pow(cosAlpha, this.brilliance)));
                                    }
                       }
                        finalColor=new Color3f((float)(this.color.x+ambientI.x+diffuseI.x+specularI.x), (float)(this.color.y+ambientI.y+diffuseI.y+specularI.y),
                       (float)(this.color.z+ambientI.z+diffuseI.z+specularI.z));
                   h.setColor(finalColor);
                   h.setT(firstT);
                // se debe retornar T
               }
           retVal=true;
        }
        return retVal;
    }

    Point3d getIntersectionPoint(double t, Ray r)
    {
        double x=r.getOrigin().x+r.getDirection().x*t;
        double y=r.getOrigin().y+r.getDirection().y*t;;
        double z=r.getOrigin().z+r.getDirection().z*t;;
        return (new Point3d(x,y,z));
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
