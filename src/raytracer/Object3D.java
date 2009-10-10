package raytracer;


public abstract class Object3D {
	abstract boolean intersect(Ray r, Hit h, Range range);
}
