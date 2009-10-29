package raytracer;

import javax.vecmath.*;

public class OrtographicCamera extends Camera {
	private double size = 0d;
	
	public OrtographicCamera(double size) {
		this.size = size;
	}
	
	public Ray generateRay(Point2d point) {
		double x = point.x;
		double y = point.y;
		Point3d punto = new Point3d(x, y,0d);
		Vector3d vector = new Vector3d(0d, 0d, -1.0d);
		Ray ray = new Ray(punto, vector);
		return ray;
	}
}
