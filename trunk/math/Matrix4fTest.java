package com.jme3.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class Matrix4fTest 
{

	@Test
	public void testCalculateLeibnizIdentity()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.calculateLeibniz();
		
		assertEquals(matrix.fA0, 1.0f, 0.000001);
		assertEquals(matrix.fA1, 0.0f, 0.000001);
		assertEquals(matrix.fA2, 0.0f, 0.000001);
		assertEquals(matrix.fA3, 0.0f, 0.000001);
		assertEquals(matrix.fA4, 0.0f, 0.000001);
		assertEquals(matrix.fA5, 0.0f, 0.000001);
		
		assertEquals(matrix.fB0, 0.0f, 0.000001);
		assertEquals(matrix.fB1, 0.0f, 0.000001);
		assertEquals(matrix.fB2, 0.0f, 0.000001);
		assertEquals(matrix.fB3, 0.0f, 0.000001);
		assertEquals(matrix.fB4, 0.0f, 0.000001);
		assertEquals(matrix.fB5, 1.0f, 0.000001);
	}
	
	@Test
	public void testCalculateLeibniz()
	{
		Matrix4f matrix = new Matrix4f(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
		matrix.calculateLeibniz();
		
		assertEquals(matrix.fA0, -4.0f, 0.000001);
		assertEquals(matrix.fA1, -8.0f, 0.000001);
		assertEquals(matrix.fA2, -12.0f, 0.000001);
		assertEquals(matrix.fA3, -4.0f, 0.000001);
		assertEquals(matrix.fA4, -8.0f, 0.000001);
		assertEquals(matrix.fA5, -4.0f, 0.000001);
		
		assertEquals(matrix.fB0, -4.0f, 0.000001);
		assertEquals(matrix.fB1, -8.0f, 0.000001);
		assertEquals(matrix.fB2, -12.0f, 0.000001);
		assertEquals(matrix.fB3, -4.0f, 0.000001);
		assertEquals(matrix.fB4, -8.0f, 0.000001);
		assertEquals(matrix.fB5, -4.0f, 0.000001);
	}
	
	@Test
	public void testSetContents()
	{
		Matrix4f m1 = new Matrix4f();
		Matrix4f m2 = new Matrix4f(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
		m1.set(m2);
		
		assertEquals(m1.m00, 1, 0.000001);
		assertEquals(m1.m01, 2, 0.000001);
		assertEquals(m1.m02, 3, 0.000001);
		assertEquals(m1.m03, 4, 0.000001);
		
		assertEquals(m1.m10, 5, 0.000001);
		assertEquals(m1.m11, 6, 0.000001);
		assertEquals(m1.m12, 7, 0.000001);
		assertEquals(m1.m13, 8, 0.000001);
		
		assertEquals(m1.m20, 9, 0.000001);
		assertEquals(m1.m21, 10, 0.000001);
		assertEquals(m1.m22, 11, 0.000001);
		assertEquals(m1.m23, 12, 0.000001);
		
		assertEquals(m1.m30, 13, 0.000001);
		assertEquals(m1.m31, 14, 0.000001);
		assertEquals(m1.m32, 15, 0.000001);
		assertEquals(m1.m33, 16, 0.000001);
	}

}
