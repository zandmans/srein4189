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
	
	@Test
	public void testIsIdentity(){
		Quaternion q1 = new Quaternion(0,0,0,1);
		Quaternion q2 = new Quaternion(1,0,0,1);
		Quaternion q3 = new Quaternion(0,0,1,0);
		Quaternion q4 = new Quaternion(0,0,0,0);
		assertTrue(q1.isIdentity());
		assertFalse(q2.isIdentity());
		assertFalse(q3.isIdentity());
		assertFalse(q4.isIdentity());
	}
	
	@Test
	public void testFromAngles(){
		Quaternion q1 = new Quaternion(1,0,0,10);
		float[] angles = {2.0f, 1.2f, 1.0f}; 
		q1 = q1.fromAngles(angles);
		assertEquals(q1.w, 0.1636f, 0.0001f);
		assertEquals(q1.x, 0.7557f, 0.0001f);
		assertEquals(q1.y, 0.6007f, 0.0001f);
		assertEquals(q1.z, -0.2032f, 0.0001f);
		
		angles = q1.toAngles(null);
		assertEquals(angles[0], 2.0f, 0.0001);
		assertEquals(angles[1], 1.2f, 0.0001);
		assertEquals(angles[2], 1.0f, 0.0001);
		
	}
	
	@Test
	public void testEquals(){
		Quaternion q1 = new Quaternion(0,0,0,0);
		Quaternion q2 = new Quaternion(0,0,0,0);
		assertTrue(q1.equals(q2));
		assertTrue(q1.equals(q1));

		q2 = new Quaternion(1,0,0,0);
		assertFalse(q1.equals(q2));
		q2 = new Quaternion(0,-1,0,0);
		assertFalse(q1.equals(q2));
		q2 = new Quaternion(0,0,-0.001f,0);
		assertFalse(q1.equals(q2));
		q2 = new Quaternion(0,0,0,0.00001f);
		assertFalse(q1.equals(q2));
		assertFalse(q1.equals(null));
		
	}

}
