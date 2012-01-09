/**
 * @author chris van egmond
 */
package com.jme3.math;

import java.nio.FloatBuffer;

public abstract class AbstractMatrix {

	public float m00, m01, m02;
	public float m10, m11, m12;
	public float m20, m21, m22;
	
	public abstract AbstractMatrix adjoint();
	public abstract float determinant();
	public abstract FloatBuffer fillFloatBuffer(FloatBuffer fb, boolean columnMajor);
	public abstract void fillFloatArray(float[] f, boolean columnMajor);
	
	public abstract void get(float[] data, boolean rowMajor);
	public abstract float get(int i, int j);
	
	public abstract AbstractMatrix invert();
	public abstract AbstractMatrix invertLocal();
	
	public abstract void loadIdentity();
	public abstract boolean isIdentity();
	
	public abstract void multLocal(float scalar);
	public abstract void scale(Vector3f scale);
	
	public abstract void set(float[] matrix);
	public abstract void set(float[] matrix, boolean rowMajor);
	public abstract void set(float[][] matrix);
	public abstract void set(int i, int j, float value);
	
	public abstract FloatBuffer toFloatBuffer();
	
	public abstract AbstractMatrix transpose();
	public abstract AbstractMatrix transposeLocal();
	
	public abstract AbstractMatrix zero();
}
