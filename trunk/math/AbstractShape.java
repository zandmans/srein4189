package com.jme3.math;

public abstract class AbstractShape {

	public Vector3f origin;
	public Vector3f direction;
	
	/**
     * Constructor instantiates a new object. As default, the
     * origin is (0,0,0) and the direction is (0,0,0).
     *
     */
	public AbstractShape()
	{
		origin = new Vector3f();
		direction = new Vector3f();
	}
	
	/**
     * Edited by: Thijs
     * Moved from Line.java
     * 
     * @param point
     * @return
     */
    public float distance(Vector3f point) {
        return FastMath.sqrt(distanceSquared(point));
    }
	
	public abstract float distanceSquared(Vector3f point);
	
	/**
    *
    * <code>getOrigin</code> retrieves the origin point.
    *
    * @return the origin.
    */
   public Vector3f getOrigin() {
       return origin;
   }
   
   /**
   *
   * <code>setOrigin</code> sets the origin.
   * @param origin the origin.
   */
  public void setOrigin(Vector3f origin) {
      this.origin.set(origin);
  }
  
  /**
  *
  * <code>getDirection</code> retrieves the direction vector.
  * @return the direction.
  */
 public Vector3f getDirection() {
     return direction;
 }

 /**
  *
  * <code>setDirection</code> sets the direction vector.
  * @param direction the direction.
  */
 public void setDirection(Vector3f direction) {
     this.direction.set(direction);
 }
	
	
}
