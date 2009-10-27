package raytracer;

import javax.vecmath.*;

public class Hit {
	private double t = 0d;
	private Color3f color = null;
        private int indexObject=0;

        
	
	public Hit() {
		// ToDo: initialize the value of t and
		// the color
		// ...
        t=Double.MAX_VALUE;
        color = new Color3f(0.0f, 0.0f, 0.0f);
        indexObject=0;
	}
	
	public Hit(double t, Color3f color, int index) {
		super();
		this.t = t;
		this.color = color;
                indexObject=index;
	}

	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
	}

	public Color3f getColor() {
		return color;
	}

	public void setColor(Color3f color) {
		this.color = color;
	}
        
        public void setIndex(int i)
        {
            indexObject=i;
        }
        
        public int getIndex()
        {
            return indexObject;
        }
	
}
