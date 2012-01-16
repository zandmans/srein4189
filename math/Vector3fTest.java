package com.jme3.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class Vector3fTest {

	@Test
	public void testEquals() {
		Vector3f v1 = new Vector3f(1,5,11);
		Vector3f v2 = new Vector3f(1,5,11);
		Vector3f v3 = new Vector3f(2,5,11);
		Vector3f v4 = new Vector3f(1,5.01f,11);
		Vector3f v5 = new Vector3f(1,5,110);
		Vector3f v6 = new Vector3f(100,500,1100);
		assertTrue(v1.equals(v1));
		assertTrue(v2.equals(v2));
		assertTrue(v2.equals(v1));
		assertFalse(v1.equals(v3));
		assertFalse(v1.equals(v4));
		assertFalse(v1.equals(v5));
		assertFalse(v1.equals(v6));
		assertFalse(v1.equals("This is no Vector3f object"));
	}
	
	@Test
	public void testInterpolateLinear() {
		float scale = 0.5f;
		Vector3f startValue = new Vector3f(0,0,0);
		Vector3f endValue = new Vector3f(10,6,-7);
		Vector3f result = Vector3f.interpolateLinear(scale, startValue, endValue);
		assertEquals(result.x, 5.0f, 0.0000001f);
		assertEquals(result.y, 3.0f, 0.0000001f);
		assertEquals(result.z, -3.5f, 0.0000001f);
		
		scale = 1.0f/3.0f;
		endValue = new Vector3f(-0.1f,9,0);
		result = Vector3f.interpolateLinear(scale, startValue, endValue);
		assertEquals(result.x, -0.0333f, 0.0001f);
		assertEquals(result.y, 3f, 0.0000001f);
		assertEquals(result.z, 0.0f, 0.0000001f);
	}
	
	@Test
	public void testExtrapolateLinear(){
		float scale = 0.5f;
		Vector3f startValue = new Vector3f(0,0,0);
		Vector3f endValue = new Vector3f(10,6,-7);
		Vector3f result = Vector3f.extrapolateLinear(scale, startValue, endValue);
		assertEquals(result.x, 5.0f, 0.0000001f);
		assertEquals(result.y, 3.0f, 0.0000001f);
		assertEquals(result.z, -3.5f, 0.0000001f);
		
		scale = 1.0f/3.0f;
		endValue = new Vector3f(-0.1f,9,0);
		result = Vector3f.extrapolateLinear(scale, startValue, endValue);
		assertEquals(result.x, -0.0333f, 0.0001f);
		assertEquals(result.y, 3f, 0.0000001f);
		assertEquals(result.z, 0.0f, 0.0000001f);
		
		scale = 2.5f;
		endValue = new Vector3f(15.5f,-3f,10f);
		result = Vector3f.extrapolateLinear(scale, startValue, endValue);
		assertEquals(result.x, 38.75f, 0.0000001f);
		assertEquals(result.y, -7.5f, 0.0000001f);
		assertEquals(result.z, 25f, 0.0000001f);
	}
	
	@Test
	public void testSphericalToCartesian(){
		Vector3f start = new Vector3f(3.0f, -5.0f, 0.5f);
		Vector3f result = new Vector3f();
		result = Vector3f.sphericalToCartesian(start, result);

		assertEquals(result.x, 0.7468f, 0.0001f);
		assertEquals(result.y, 1.4383f, 0.0001f);
		assertEquals(result.z, 2.5246f, 0.0001f);
	}

	@Test
	public void testCartesianToSpherical(){
		Vector3f start = new Vector3f(0.0f, 0.0f, 0.0f);
		Vector3f result = new Vector3f();
		result = Vector3f.cartesianToSpherical(start, result);

		assertEquals(result.x, 1.1921E-7f, 0.0000001f);
		assertEquals(result.y, 0.0f, 0.0000001f);
		assertEquals(result.z, 0.0f, 0.0000001f);
		
		start.x = -5f;
		result = Vector3f.cartesianToSpherical(start, result);

		assertEquals(result.x, 5.0f, 0.0000001f);
		assertEquals(result.y, Math.PI, 0.0000001f);
		assertEquals(result.z, 0.0f, 0.0000001f);
	}

	@Test
	public void testSphericalToCartesianZ(){
		Vector3f start = new Vector3f(3.0f, -5.0f, 0.5f);
		Vector3f result = new Vector3f();
		result = Vector3f.sphericalToCartesianZ(start, result);

		assertEquals(result.x, 0.7468f, 0.0001f);
		assertEquals(result.y, 2.5246f, 0.0001f);
		assertEquals(result.z, 1.4383f, 0.0001f);
	}

	@Test
	public void testCartesianZToSpherical(){

		Vector3f start = new Vector3f(0.0f, 0.0f, 0.0f);
		Vector3f result = new Vector3f();
		result = Vector3f.cartesianZToSpherical(start, result);

		assertEquals(result.x, 1.1921E-7f, 0.0000001f);
		assertEquals(result.y, -1.5708f, 0.0001f);
		assertEquals(result.z, 0.0f, 0.0000001f);
		
		start.x = -5f;
		result = Vector3f.cartesianZToSpherical(start, result);

		assertEquals(result.x, 5.0f, 0.0000001f);
		assertEquals(result.y, 0.0f, 0.0000001f);
		assertEquals(result.z, Math.PI, 0.0000001f);
	}
	
	@Test
	public void testInterpolateBezier(){
		float u = 0.3f;
		Vector3f p0 = new Vector3f(0,0,0);
		Vector3f p1 = new Vector3f(5,0,0);
		Vector3f p2 = new Vector3f(5,10,8);
		Vector3f p3 = new Vector3f(0,10,8);
		Vector3f result = new Vector3f();
		
		result = Vector3f.interpolateBezier(u, p0, p1, p2, p3, result);
		Vector3f result2 = Vector3f.interpolateBezier(u, p0, p1, p2, p3, null);
		Vector3f result3 = Vector3f.interpolateBezier(u, p0, p1, p2, p3);

		assertEquals(result.x, 3.1500f, 0.0001f);
		assertEquals(result.y, 2.1600f, 0.0001f);
		assertEquals(result.z, 1.7280f, 0.0001f);
		assertEquals(result2.x, 3.1500f, 0.0001f);
		assertEquals(result2.y, 2.1600f, 0.0001f);
		assertEquals(result2.z, 1.7280f, 0.0001f);
		assertEquals(result3.x, 3.1500f, 0.0001f);
		assertEquals(result3.y, 2.1600f, 0.0001f);
		assertEquals(result3.z, 1.7280f, 0.0001f);
		
		assertEquals( Vector3f.getBezierP1toP2Length(p0, p1, p2, p3), 
					  16.3650f, 
					  0.0001f);
	}
	
	@Test
	public void testInterpolateCatmullRom(){
		float u = 0.3f;
		float T = 0.5f;
		Vector3f p0 = new Vector3f(0,0,0);
		Vector3f p1 = new Vector3f(5,0,0);
		Vector3f p2 = new Vector3f(5,10,8);
		Vector3f p3 = new Vector3f(0,10,8);
		Vector3f result = new Vector3f();

		result = Vector3f.interpolateCatmullRom(u, T, p0, p1, p2, p3, result);
		Vector3f result2 = Vector3f.interpolateCatmullRom(u, T, p0, p1, p2, p3, null);
		Vector3f result3 = Vector3f.interpolateCatmullRom(u, T, p0, p1, p2, p3);

		assertEquals(result.x, 5.5250f, 0.0001f);
		assertEquals(result.y, 2.5800f, 0.0001f);
		assertEquals(result.z, 2.0640f, 0.0001f);
		assertEquals(result2.x, 5.5250f, 0.0001f);
		assertEquals(result2.y, 2.5800f, 0.0001f);
		assertEquals(result2.z, 2.0640f, 0.0001f);
		assertEquals(result3.x, 5.5250f, 0.0001f);
		assertEquals(result3.y, 2.5800f, 0.0001f);
		assertEquals(result3.z, 2.0640f, 0.0001f);
		
		assertEquals( Vector3f.getCatmullRomP1toP2Length(p0, p1, p2, p3, 0.0f, 1.0f, 0.75f), 
					  13.0070f, 
					  0.0001f);
	}
	
}
