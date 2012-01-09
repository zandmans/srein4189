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

}
