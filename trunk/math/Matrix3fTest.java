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
	
	@Test
	public void testIsIdentity(){
		Matrix3f id = new Matrix3f(); // should default to identity matrix
		Matrix3f nonid = new Matrix3f(0,1,0,1,0,0,0,0,1);
		assertTrue(id.isIdentity());
		assertFalse(nonid.isIdentity());
	}
	
	
	@Test
	public void testComputeRoots()
	{
		double[] roots = new double[3];
		m3f.computeRoots(roots);
		
		//assertEquals(roots,new double[3]);
	}
	
	@Test
	public void testFromAngleAxis(){
		Matrix3f bla = new Matrix3f();
		bla.fromAngleAxis(20.0f, new Vector3f(0,7,0));

		assertEquals(bla.m00, 0.4081, 0.0001);
		assertEquals(bla.m01, 0, 0.0001);
		assertEquals(bla.m02, 0.9129, 0.0001);
		assertEquals(bla.m10, 0, 0.0001);
		assertEquals(bla.m11, 1, 0.0001);
		assertEquals(bla.m12, 0, 0.0001);
		assertEquals(bla.m20, -0.9129, 0.0001);
		assertEquals(bla.m21, 0, 0.0001);
		assertEquals(bla.m22, 0.4081, 0.0001);
	}
	
	@Test
	public void testMultMatrix(){
		Matrix3f ma = new Matrix3f(2,2,2, 3,3,3, .1f,.1f,.1f);
		Matrix3f mb = new Matrix3f(0.5f,0.5f,0.5f, 10f,10f,10f, 5f,4f,3f);
		Matrix3f id = new Matrix3f();
		assertTrue( ma.equals(ma.mult(id)));
		assertTrue( mb.equals(mb.mult(id)));
		Matrix3f product = ma.mult(mb);

		assertEquals(product.m00, 31, 0.00000001);
		assertEquals(product.m01, 29, 0.00000001);
		assertEquals(product.m02, 27, 0.00000001);
		assertEquals(product.m10, 46.5, 0.00000001);
		assertEquals(product.m11, 43.5, 0.00000001);
		assertEquals(product.m12, 40.5, 0.00000001);
		assertEquals(product.m20, 1.55, 0.00001);
		assertEquals(product.m21, 1.45, 0.00001);
		assertEquals(product.m22, 1.35, 0.00001);
	}
	
	@Test
	public void testMultVector(){
		Vector3f vec = new Vector3f(5,10,-2.5f);
		Vector3f res = m3f.mult(vec);
		assertEquals(res.x, 17.5, 0.0000001);
		assertEquals(res.y, 55, 0.0000001);
		assertEquals(res.z, 92.5, 0.0000001);
	}
	
	@Test
	public void testTranspose(){
		m3f.transpose();
		assertEquals(m3f.m00, 1, 0.00000001);
		assertEquals(m3f.m01, 4, 0.00000001);
		assertEquals(m3f.m02, 7, 0.00000001);
		assertEquals(m3f.m10, 2, 0.00000001);
		assertEquals(m3f.m11, 5, 0.00000001);
		assertEquals(m3f.m12, 8, 0.00000001);
		assertEquals(m3f.m20, 3, 0.00000001);
		assertEquals(m3f.m21, 6, 0.00000001);
		assertEquals(m3f.m22, 9, 0.00000001);
		
		Matrix3f bla = m3f.transposeNew();
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
	public void testInvert(){
		Matrix3f id = new Matrix3f();
		id.invertLocal();
		assertEquals(id.m00, 1, 0.00000001);
		assertEquals(id.m01, 0, 0.00000001);
		assertEquals(id.m02, 0, 0.00000001);
		assertEquals(id.m10, 0, 0.00000001);
		assertEquals(id.m11, 1, 0.00000001);
		assertEquals(id.m12, 0, 0.00000001);
		assertEquals(id.m20, 0, 0.00000001);
		assertEquals(id.m21, 0, 0.00000001);
		assertEquals(id.m22, 1, 0.00000001);		
		
		Matrix3f original = new Matrix3f(2,2,2,1,10,1,-1,7,-5);
		Matrix3f inverted = original.invert();
		original.invertLocal();		
		assertEquals(original.m00, 0.7917, 0.0001);
		assertEquals(original.m01, -0.3333, 0.0001);
		assertEquals(original.m02, 0.25, 0.0001);
		assertEquals(original.m10, -0.0556, 0.0001);
		assertEquals(original.m11, 0.1111, 0.0001);
		assertEquals(original.m12, 0, 0.0001);
		assertEquals(original.m20, -0.2361, 0.0001);
		assertEquals(original.m21, 0.2222, 0.0001);
		assertEquals(original.m22, -0.25, 0.0001);

		assertTrue(original.equals(inverted));
		
		m3f.invertLocal();
		assertEquals(m3f.m00, 0, 0.00000001);
		assertEquals(m3f.m01, 0, 0.00000001);
		assertEquals(m3f.m02, 0, 0.00000001);
		assertEquals(m3f.m10, 0, 0.00000001);
		assertEquals(m3f.m11, 0, 0.00000001);
		assertEquals(m3f.m12, 0, 0.00000001);
		assertEquals(m3f.m20, 0, 0.00000001);
		assertEquals(m3f.m21, 0, 0.00000001);
		assertEquals(m3f.m22, 0, 0.00000001);
		
		
	}
}