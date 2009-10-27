package raytracer;

import java.util.Vector;
import javax.vecmath.*;

public class Group extends Object3D {
	Vector<Object3D> vector = null;
        public static final int MAX_RECURTION=5;
        public int counterRecurtion=0;
        
    int objectSelected;
	
	public Group() {
		vector = new Vector<Object3D>();
	}
	
	public void add(Object3D o3D) {
		vector.add(o3D);
 	}
	
	boolean intersect(Ray r, Hit h, Range range, Light ambiental, Light point) 
    {
            boolean retVal = false;
		    return retVal;
	}
        
       
        Vector3d getNormal (Point3d a)
        {
          return new Vector3d();
        }
    void cleanCounter(int i)
    {
        counterRecurtion=i;
    }
    //Local and semi-global illumination
    Color3f iluminate( Ray r,  Hit h, Range range, Light ambiental, Light point)
    {
        counterRecurtion++;
        boolean retVal=false;
        Object3D obj=new Sphere();
        Color3f diffuseI=new Color3f();
        Color3f specularI=new Color3f();
        Color3f finalColor=new Color3f();
        Color3f finalColor2=new Color3f();
        for (int j=0; j<vector.size(); j++)
        {
             retVal=vector.get(j).intersect(r, h, range, ambiental, point);
              if(retVal==true)
              {
              obj=vector.elementAt(j);
		     // iluminate(r, h, range, ambiental, point);
             }
        }


      Point3d iPoint= r.getIntersectionPoint(h.getT());
	  Vector3d normal=obj.getNormal(iPoint);
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
           Vector3d directionR=new Vector3d(2*cos*(directionL.x-normal.x),2*cos*(directionL.y-normal.y),
                               2*cos*(directionL.z-normal.z));
           double cosAlpha=directionR.dot(r.getDirection());
                 if(cosAlpha>0){
                     specularI = new Color3f((float)(point.getColor().x*obj.specular*Math.pow(cosAlpha, obj.brilliance)),
                                 (float)(point.getColor().y*obj.specular*Math.pow(cosAlpha, obj.brilliance)),
                                 (float)(point.getColor().z*obj.specular*Math.pow(cosAlpha, obj.brilliance)));
                                }
                  }
	    finalColor=new Color3f((float)(finalColor.x+ambientI.x+diffuseI.x+specularI.x), 
		(float)(finalColor.y +ambientI.y+diffuseI.y+specularI.y),
        (float)(finalColor.z+ambientI.z+diffuseI.z+specularI.z));

        //h.setColor(finalColor);
                       
	    if(counterRecurtion < MAX_RECURTION && obj.reflection>0.01)
		 {
		   r.getDirection().negate();
           double theta=2*normal.dot(r.getDirection());
		   Vector3d directionRay=new Vector3d(r.getDirection().x-theta*normal.x, r.getDirection().y-theta*normal.y,
		   r.getDirection().z-theta*normal.z);
           iPoint.add(directionRay);
           iPoint.scale(0.0001);
		   Ray r2= new Ray(iPoint, directionRay);
           Hit h2=new Hit();
		   finalColor2=iluminate(r2, h2, range, ambiental, point);
		 }
        finalColor=new Color3f((float)(finalColor.x+finalColor2.x*obj.reflection), (float)(finalColor.y+finalColor2.y*obj.reflection), (float)
        (finalColor.z+finalColor.y*obj.reflection));
        return finalColor;
    }
}
