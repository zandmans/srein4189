package com.jme3.math;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class Matrix3fTest 
{
	private Matrix3f m3f;
	
	@Before
	public void setUp(){
		m3f = new Matrix3f(1,2,3,4,5,6,7,8,9);
	}
	

	@Test
	public void testNormalizeMax()
	{
		float max = m3f.normalizeMax();

		assertEquals(1.0f/9.0f, m3f.m00, 0.000001);
		assertEquals(2.0f/9.0f, m3f.m01, 0.000001);
		assertEquals(3.0f/9.0f, m3f.m02, 0.000001);
		assertEquals(4.0f/9.0f, m3f.m10, 0.000001);
		assertEquals(5.0f/9.0f, m3f.m11, 0.000001);
		assertEquals(6.0f/9.0f, m3f.m12, 0.000001);
		assertEquals(7.0f/9.0f, m3f.m20, 0.000001);
		assertEquals(8.0f/9.0f, m3f.m21, 0.000001);
		assertEquals(1, m3f.m22, 0.000001);
		assertEquals(9, max, 0.000001);
	}
	
	@Test
	public void testScale(){
		Vector3f scale = new Vector3f(2, 2, 0.5f);
		m3f.scale(scale);

		assertEquals(1.0f*scale.x, m3f.m00, 0.000001);
		assertEquals(4.0f*scale.x, m3f.m10, 0.000001);
		assertEquals(7.0f*scale.x, m3f.m20, 0.000001);
		assertEquals(2.0f*scale.y, m3f.m01, 0.000001);
		assertEquals(5.0f*scale.y, m3f.m11, 0.000001);
		assertEquals(8.0f*scale.y, m3f.m21, 0.000001);
		assertEquals(3.0f*scale.z, m3f.m02, 0.000001);
		assertEquals(6.0f*scale.z, m3f.m12, 0.000001);
		assertEquals(9.0f*scale.z, m3f.m22, 0.000001);
		
	}
}