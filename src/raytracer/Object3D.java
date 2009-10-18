package raytracer;


import javax.vecmath.*;

public abstract class Object3D {
	abstract boolean intersect(Ray r, Hit h, Range range,Light a, Light b);
}
