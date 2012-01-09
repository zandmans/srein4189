package com.jme3.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuaternionTest {

	@Test
	public void testToRotationMatrix4f() 
	{
		Quaternion q1 = new Quaternion(1,2,3,4);
		Matrix4f m1 = new Matrix4f(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
		
		AbstractMatrix result = q1.toRotationMatrix(m1);
		
		assertEquals(result.m00, 0.133f, 0.001);
		assertEquals(result.m01, -0.667f, 0.001);
		assertEquals(result.m02, 0.734f, 0.001);
		
		assertEquals(result.m10, 0.934f, 0.001);
		assertEquals(result.m11, 0.333f, 0.001);
		assertEquals(result.m12, 0.133f, 0.001);
		
		assertEquals(result.m20, -0.333f, 0.001);
		assertEquals(result.m21, 0.667f, 0.001);
		assertEquals(result.m22, 0.666f, 0.001);
	}
	
	@Test
	public void testToRotationMatrix3f() 
	{
		Quaternion q1 = new Quaternion(1,2,3,4);
		Matrix3f m1 = new Matrix3f(1,2,3,4,5,6,7,8,9);
		
		AbstractMatrix result = q1.toRotationMatrix(m1);
		
		assertEquals(result.m00, 0.133f, 0.001);
		assertEquals(result.m01, -0.667f, 0.001);
		assertEquals(result.m02, 0.734f, 0.001);
		
		assertEquals(result.m10, 0.934f, 0.001);
		assertEquals(result.m11, 0.333f, 0.001);
		assertEquals(result.m12, 0.133f, 0.001);
		
		assertEquals(result.m20, -0.333f, 0.001);
		assertEquals(result.m21, 0.667f, 0.001);
		assertEquals(result.m22, 0.666f, 0.001);
	}

}
