/**
 * @author chris van egmond
 */
package com.jme3.math;

import java.nio.FloatBuffer;

public abstract class AbstractMatrix {

	
	public abstract AbstractMatrix adjoint();
	public abstract float determinant();
	public abstract AbstractMatrix zero();
	public abstract FloatBuffer fillFloatBuffer(FloatBuffer fb, boolean columnMajor);
	public abstract void fillFloatArray(float[] f, boolean columnMajor);
	
	public abstract void get(float[] data, boolean rowMajor);
	public abstract float get(int i, int j);
	
	public abstract AbstractMatrix invert();
	public abstract AbstractMatrix invertLocal();
	
	public abstract void loadIdentity();
	public abstract boolean isIdentity();
	
	public abstract void multLocal(float scalar);
}
