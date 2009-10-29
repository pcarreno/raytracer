package raytracer;

import javax.vecmath.*;

public class Ray {
	private Point3d origin;
	private Vector3d direction;
	
	public Ray() {
		origin = new Point3d();
		direction = new Vector3d();
	}
	
	public Ray(Point3d origin, Vector3d direction) {
		this.origin = origin;
		this.direction = direction;
		this.direction.normalize();
	}

	public Point3d getOrigin() {
		return origin;
	}

	public void setOrigin(Point3d origin) {
		this.origin = origin;
	}

	public Vector3d getDirection() {
		return direction;
	}

	public void setDirection(Vector3d direction) {
		this.direction = direction;
	}
        
    Point3d getIntersectionPoint(double t)
    {
        double x=this.getOrigin().x+this.getDirection().x*t;
        double y=this.getOrigin().y+this.getDirection().y*t;
        double z=this.getOrigin().z+this.getDirection().z*t;
        return (new Point3d(x,y,z));
    }
	
}
