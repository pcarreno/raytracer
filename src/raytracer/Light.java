/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package raytracer;

/**
 *
 * @author Administrador
 */

import javax.vecmath.*;
public class Light {

    private Point3d position = null;
	private Color3f color = null;
    private int type=0;


  public Light()
  {
      position=new Point3d();
      color=new Color3f();

  }

  public Light(Color3f color, int type)
  {
      this.color=color;
      this.type=type;
  }

  public Light(Point3d point, Color3f color, int type)
  {
      this.position=point;
      this.color=color;
      this.type=type;
  }

  public Color3f getColor()
  {
      return color;
  }

  public Point3d getPosition()
  {
      return position;
  }

  public int getType()
  {
      return type;
  }
}
