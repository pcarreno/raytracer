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
		Point3d punto = new Point3d(x, y,0.0);
		Vector3d vector = new Vector3d(0.0, 0.0, -1.0);
		Ray ray = new Ray(punto, vector);
		return ray;
	}
}
