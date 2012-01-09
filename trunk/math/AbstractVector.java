/**
 * @author chris van egmond
 */

package com.jme3.math;

public abstract class AbstractVector {
	
	public abstract boolean isUnitVector();
	public abstract float length();
	public abstract float lengthSquared();
	
	public abstract AbstractVector mult(float scalar);
	public abstract AbstractVector multLocal(float scalar);
	public abstract AbstractVector divide(float scalar);
	public abstract AbstractVector divideLocal(float scalar);
	public abstract AbstractVector negate();
	public abstract AbstractVector negateLocal();
	
	public abstract AbstractVector normalize();
	public abstract AbstractVector normalizeLocal();
	
	public abstract AbstractVector zero();
	
	public abstract float[] toArray(float[] floats);
	public abstract boolean equals(Object o);
	public abstract int hashCode();
	
	public abstract String toString();
	
	public abstract float get(int index);
	public abstract void set(int index, float value);

}
