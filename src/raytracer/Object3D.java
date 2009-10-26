package raytracer;


import javax.vecmath.*;

public abstract class Object3D {
    
    double specular;
    double diffuse;
    double ambient;
    double brilliance;
    double reflection;
    Color3f color;
    
    abstract Vector3d getNormal(Point3d a);
    abstract boolean intersect(Ray r, Hit h, Range range, Light ambiental, Light point);
}
