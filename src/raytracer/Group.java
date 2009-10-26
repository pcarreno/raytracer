package raytracer;

import java.util.Vector;
import javax.vecmath.*;

public class Group extends Object3D {
	Vector<Object3D> vector = null;
        public static final int MAX_RECURTION=5;
        public int countRecurtion=0;
        
    int objectSelected;
	
	public Group() {
		vector = new Vector<Object3D>();
	}
	
	public void add(Object3D o3D) {
		vector.add(o3D);
 	}
	
	boolean intersect(Ray r, Hit h, Range range, Light ambiental, Light point) 
        {
	   // Color3f f;
            boolean retVal = false;
            for (int j=0; j<vector.size(); j++)
           {
             retVal=vector.get(j).intersect(r, h, range, ambiental, point);
               if(retVal){
		iluminate(ambiental, point, r, vector.get(j), h, range);
		}
	   }
            return retVal;
	}
        
        public Object3D getObject(int i)
        {
           return vector.get(i);
        }
        
        Vector3d getNormal (Point3d a)
        {
          return new Vector3d();
        }
    //Local illumination

    void iluminate(Light ambiental, Light point, Ray r, Object3D obj, Hit h, Range g)
    {
        countRecurtion++;
        Point3d iPoint= r.getIntersectionPoint(h.getT());
	Vector3d normal=obj.getNormal(iPoint);
        Color3f diffuseI=new Color3f();
        Color3f specularI=new Color3f();
        Color3f finalColor=new Color3f();
        Color3f ambientI = new Color3f ((float)(ambiental.getColor().x*obj.ambient*obj.color.x),
                 (float)(ambiental.getColor().y*obj.ambient*obj.color.y), (float)(ambiental.getColor().z*obj.ambient*obj.color.z));
        //Dirección del punto de intercepción a la luz
        //Iluminación difusa
        Vector3d directionL = new Vector3d(point.getPosition().x-iPoint.x, point.getPosition().y-iPoint.y,
                         point.getPosition().z-iPoint.z);
        directionL.normalize();
        double cos=normal.dot(directionL);
        if(cos>0){
           diffuseI = new Color3f((float)(point.getColor().x*obj.diffuse*obj.color.x*cos), (float)(point.getColor().y
                               *obj.diffuse*obj.color.x*cos),(float)(point.getColor().z*obj.diffuse*obj.color.z*cos));
            //Direccion del rayo reflejado
	    //Iluminacion especular
	    Vector3d directionR=new Vector3d(2*cos*(directionL.x-normal.x),2*cos*(directionL.y-normal.y),
                               2*cos*(directionL.z-normal.z));
            double cosAlpha=directionR.dot(r.getDirection());
                 if(cosAlpha>0){
                     specularI = new Color3f((float)(point.getColor().x*obj.specular*Math.pow(cosAlpha, obj.brilliance)),
                                 (float)(point.getColor().y*obj.specular*Math.pow(cosAlpha, obj.brilliance)),
                                 (float)(point.getColor().z*obj.specular*Math.pow(cosAlpha, obj.brilliance)));
                                }
                  }
	       finalColor=new Color3f((float)(finalColor.x+obj.color.x+ambientI.x+diffuseI.x+specularI.x), 
		    (float)(finalColor.y +obj.color.y+ambientI.y+diffuseI.y+specularI.y),
                    (float)(finalColor.z+obj.color.z+ambientI.z+diffuseI.z+specularI.z));
	            h.setColor(finalColor);
                       
			    if(countRecurtion < MAX_RECURTION && obj.reflection>0.01)
			    {
				double theta=2*normal.dot(r.getDirection());
				Vector3d directionRay=new Vector3d(theta*normal.x-r.getDirection().x, theta*normal.y-r.getDirection().y,
					theta*normal.z-r.getDirection().z);
				Ray r2= new Ray(iPoint, directionRay);
				intersect(r2, h, g, ambiental, point);
				finalColor=new Color3f((float)(finalColor.x*obj.reflection), (float)(finalColor.y*obj.reflection),
				(float)(finalColor.z*obj.reflection));
				h.setColor(new Color3f((float)(h.getColor().x+finalColor.x), (float)(h.getColor().y+finalColor.y),
				    (float)(h.getColor().z+finalColor.z)));
			   }

	       

	        
    }
}
