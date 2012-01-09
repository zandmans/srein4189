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
	
	@Test
	public void testEquals(){
		Matrix3f tm = new Matrix3f(1,2,3,4,5,6,7,8,9);
		assertTrue( m3f.equals(tm) );
		assertTrue( m3f.equals(m3f) );
		assertFalse( m3f.equals(25) );
		tm = new Matrix3f(2,2,3,4,5,6,7,8,9);
		assertFalse( m3f.equals(tm) );
		tm = new Matrix3f(1,2.1f,3,4,5,6,7,8,9);
		assertFalse( m3f.equals(tm) );
		tm = new Matrix3f(1,2,2.99f,4,5,6,7,8,9);
		assertFalse( m3f.equals(tm) );
		tm = new Matrix3f(1,2,3,4.5f,5,6,7,8,9);
		assertFalse( m3f.equals(tm) );
		tm = new Matrix3f(1,2,3,4,500,6,7,8,9);
		assertFalse( m3f.equals(tm) );
		tm = new Matrix3f(1,2,3,4,5,60,7,8,9);
		assertFalse( m3f.equals(tm) );
		tm = new Matrix3f(1,2,3,4,5,6,7.000001f,8,9);
		assertFalse( m3f.equals(tm) );
		tm = new Matrix3f(1,2,3,4,5,6,7,8.1f,9);
		assertFalse( m3f.equals(tm) );
		tm = new Matrix3f(1,2,3,4,5,6,7,8,9.1f);
		assertFalse( m3f.equals(tm) );
	}
	
	@Test
	public void testDeterminant(){
		Matrix3f bla = new Matrix3f(1.5f, 0, 0, 2.5f, -3f, 0, 7, 15.25f, 0.2f);
		assertEquals(bla.determinant(), -0.9f, 0.000001);
	}
	
	@Test
	public void testAbsoluteLocal(){
		Matrix3f bla = new Matrix3f(-1, 2, -3, 4, -5, 6, -7, 8, -9);
		bla.absoluteLocal();
		assertEquals(bla.m00, 1, 0.00000001);
		assertEquals(bla.m01, 2, 0.00000001);
		assertEquals(bla.m02, 3, 0.00000001);
		assertEquals(bla.m10, 4, 0.00000001);
		assertEquals(bla.m11, 5, 0.00000001);
		assertEquals(bla.m12, 6, 0.00000001);
		assertEquals(bla.m20, 7, 0.00000001);
		assertEquals(bla.m21, 8, 0.00000001);
		assertEquals(bla.m22, 9, 0.00000001);
	}
	
	@Test
	public void testGetIntInt(){
		assertEquals(m3f.get(0,0), m3f.m00, 0.00001);
		assertEquals(m3f.get(0,1), m3f.m01, 0.00001);
		assertEquals(m3f.get(0,2), m3f.m02, 0.00001);
		
		assertEquals(m3f.get(1,0), m3f.m10, 0.00001);
		assertEquals(m3f.get(1,1), m3f.m11, 0.00001);
		assertEquals(m3f.get(1,2), m3f.m12, 0.00001);
		
		assertEquals(m3f.get(2,0), m3f.m20, 0.00001);
		assertEquals(m3f.get(2,1), m3f.m21, 0.00001);
		assertEquals(m3f.get(2,2), m3f.m22, 0.00001);
	}
}