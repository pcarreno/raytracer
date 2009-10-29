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

	//Multiplica las componentes de dos colores
    Color3f mulColors(Color3f a, Color3f b)
    {
    	Color3f temp=new Color3f(a.x*b.x, a.y*b.y,a.z*b.z);
    	return temp;
    }
    //Ilumanicion local y reflexion
    Color3f iluminate( Ray r,  Hit h, Range range, Light ambiental, Light point)
    {
        counterRecurtion++;
        boolean retVal=false;
        float temp=0.0f;
        Object3D obj=new Sphere();
        Color3f diffuseI=new Color3f(); //Iluminacion difusa
        Color3f specularI=new Color3f(); //Iluminacion especual
        Color3f finalColor=new Color3f(); //Sumas de todas las iluminaciones
        Color3f finalColor2=new Color3f(); //Color del rayo reflejado
        Color3f ambientI=new Color3f(); //Iluminacion ambiental

		//Itera sobre todos los objetos de las escena y devuelve del menor t
		for (int j=0; j<vector.size(); j++)
        {
             retVal=vector.get(j).intersect(r, h, range, ambiental, point);
              if(retVal==true)
              {
              obj=vector.elementAt(j);
             }
        }

		Point3d iPoint= r.getIntersectionPoint(h.getT()); //Punto de intercepcion
		Vector3d normal=obj.getNormal(iPoint); //Normal del objeto al punto de intercepcion
		//Iluminacion Ambiental
		temp=(float)obj.ambient; //Componente ambiental del objeto
		ambientI =  mulColors(ambiental.getColor(), obj.color); //Multiplico el color de la luz ambiental y el del objeto
		ambientI.scale(temp);//El color resultante se multiplica por el coeficiente ambiental del objeto
		finalColor.add(ambientI); //Sumo la iluminacion ambiental al color final

		//Iluminacion difusa
		//Direccion del punto de intercepcion a la luz
		Vector3d directionL=new Vector3d(point.getPosition());
		directionL.sub(iPoint);
		directionL.normalize();
		float lightDistance= (float)point.getPosition().distance(iPoint); //Distancia del punto de intercepcion a la luz puntual
		float facAtt=(float)(1/Math.pow(lightDistance, 2.0)); //Factor de atenuación difuso
		double cos=normal.dot(directionL); //Angulo entre la normal y la luz
		if(cos>0){
			   diffuseI = mulColors(obj.color, point.getColor()); //Color de la luz puntual por color del objeto
			   temp=(float)obj.diffuse; //Coeficiente difuso del objeto
			   diffuseI.scale(temp); // Se multiplica el color resulttante por el coeficiente difuso
			   diffuseI.scale(facAtt); // Se multiplica por el factor de atenuacion
			   finalColor.add(diffuseI); //Se suma la iluminacion difusa al color final

			   //Iluminacion especular
			   //Rayo reflejado por el rayo incidente de la luz
			   Vector3d directionR=new Vector3d(directionL);
			   directionR.negate();
			   directionR.normalize();
			   Vector3d auxNormal=new Vector3d(normal);
			   auxNormal.scale(2*cos);
			   directionR.add(auxNormal);
			   directionR.normalize();
			   double cosAlpha=(directionR.dot(r.getDirection()))*-1;
                 if(cosAlpha>0){
                     specularI = new Color3f(point.getColor()); // Solo se utiliza el color de la luz
                     temp= (float)(obj.specular*Math.pow(cosAlpha, obj.brilliance)); // Coeficiente especular
                     specularI.scale(temp);//Se multiplica el color por el coeficiente
                     finalColor.add(specularI); //Se suma la iluminacion especular al color final
					 }
        }
		//Si no se ha llegado a la maxima recursion se intercepta el rayo reflejado con los objetos de las escena
	    if(counterRecurtion < MAX_RECURTION && obj.reflection>0.01)
		 {
			//Calculo la direccion del rayo reflejado
		   double theta=-2*normal.dot(r.getDirection());
		   Vector3d directionRay= new Vector3d(normal);
		   directionRay.scale(theta);
		   directionRay.add(r.getDirection());
			//Creo el nuevo rayo y lo intercepto
		   Ray r2= new Ray(iPoint, directionRay);
           Hit h2=new Hit();
		   finalColor2=iluminate(r2, h2, range, ambiental, point);
		 }
	    temp=(float)obj.reflection; //Coeficiente de reflexion
        finalColor2.scale(temp); //Color resultante por coeficiente de reflexion
	    finalColor.add(finalColor2); //Sumo el color del rayo reflejado al color final
        finalColor.clamp(0.0f, 1.0f); //Comprueba que los colores esten en el rango correcto
        return finalColor;
    }
}