package com.jme3.math;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class Matrix4fTest 
{
	private Matrix4f m1;
	private Matrix4f m2;
	
	@Before
	public void setUp(){
		m1 = new Matrix4f(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
		m2 = new Matrix4f();
	}

	@Test
	public void testCalculateLeibnizIdentity()
	{
		m2.calculateLeibniz();
		
		assertEquals(m2.fA0, 1.0f, 0.000001);
		assertEquals(m2.fA1, 0.0f, 0.000001);
		assertEquals(m2.fA2, 0.0f, 0.000001);
		assertEquals(m2.fA3, 0.0f, 0.000001);
		assertEquals(m2.fA4, 0.0f, 0.000001);
		assertEquals(m2.fA5, 0.0f, 0.000001);
		
		assertEquals(m2.fB0, 0.0f, 0.000001);
		assertEquals(m2.fB1, 0.0f, 0.000001);
		assertEquals(m2.fB2, 0.0f, 0.000001);
		assertEquals(m2.fB3, 0.0f, 0.000001);
		assertEquals(m2.fB4, 0.0f, 0.000001);
		assertEquals(m2.fB5, 1.0f, 0.000001);
	}
	
	@Test
	public void testCalculateLeibniz()
	{
		m1.calculateLeibniz();
		
		assertEquals(m1.fA0, -4.0f, 0.000001);
		assertEquals(m1.fA1, -8.0f, 0.000001);
		assertEquals(m1.fA2, -12.0f, 0.000001);
		assertEquals(m1.fA3, -4.0f, 0.000001);
		assertEquals(m1.fA4, -8.0f, 0.000001);
		assertEquals(m1.fA5, -4.0f, 0.000001);
		
		assertEquals(m1.fB0, -4.0f, 0.000001);
		assertEquals(m1.fB1, -8.0f, 0.000001);
		assertEquals(m1.fB2, -12.0f, 0.000001);
		assertEquals(m1.fB3, -4.0f, 0.000001);
		assertEquals(m1.fB4, -8.0f, 0.000001);
		assertEquals(m1.fB5, -4.0f, 0.000001);
	}
	
	@Test
	public void testSetContents()
	{
		m2.set(m1);
		
		assertEquals(m2.m00, 1, 0.000001);
		assertEquals(m2.m01, 2, 0.000001);
		assertEquals(m2.m02, 3, 0.000001);
		assertEquals(m2.m03, 4, 0.000001);
		
		assertEquals(m2.m10, 5, 0.000001);
		assertEquals(m2.m11, 6, 0.000001);
		assertEquals(m2.m12, 7, 0.000001);
		assertEquals(m2.m13, 8, 0.000001);
		
		assertEquals(m2.m20, 9, 0.000001);
		assertEquals(m2.m21, 10, 0.000001);
		assertEquals(m2.m22, 11, 0.000001);
		assertEquals(m2.m23, 12, 0.000001);
		
		assertEquals(m2.m30, 13, 0.000001);
		assertEquals(m2.m31, 14, 0.000001);
		assertEquals(m2.m32, 15, 0.000001);
		assertEquals(m2.m33, 16, 0.000001);
	}

}
