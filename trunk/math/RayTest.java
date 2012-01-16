package com.jme3.math;

import static org.junit.Assert.*;

import java.nio.FloatBuffer;

import org.junit.Before;
import org.junit.Test;

public class RayTest {

	private Ray r1, r2;
	
	@Before
	public void setUp(){
		r1 = new Ray();
		r2 = new Ray(new Vector3f(0.5f,1.0f,1.5f), new Vector3f(2.5f,2.0f,5.5f));
	}
	
	@Test
	public void testGetOrigin()
	{
		assertEquals(r1.getOrigin(), new Vector3f());
		assertEquals(r2.getOrigin(), new Vector3f(0.5f,1.0f,1.5f));
	}
	
	@Test
	public void testGetDirection()
	{
		assertEquals(r1.getDirection(), new Vector3f());
		assertEquals(r2.getDirection(), new Vector3f(2.5f,2.0f,5.5f));
	}
	
	@Test
	public void testSetOrigin()
	{
		r1.setOrigin(r2.getOrigin());
		assertEquals(r1.getOrigin(), r2.getOrigin());
	}
	
	@Test
	public void testSetDirection()
	{
		r1.setDirection(r2.getDirection());
		assertEquals(r1.getDirection(), r2.getDirection());
	}
	
	@Test
	public void testDistanceSquared()
	{
		float f1 = r1.distanceSquared(new Vector3f());
		assertEquals(f1, 0, 0.0000001);
		
		float f2 = r2.distanceSquared(new Vector3f());
		assertEquals(f2, 3.5, 0000001);
	}
	
	@Test
	public void testDistance()
	{
		float f1 = r1.distance(new Vector3f());
		assertEquals(f1, 0, 0.0000001);
		
		float f2 = r2.distance(new Vector3f());
		assertEquals(f2, 1.87082874, 0000001);
	}
	
	@Test
	public void testOrthogonalLineFit()
	{		
		FloatBuffer buffer = FloatBuffer.allocate(3);
		buffer.put(1.0f);
		buffer.put(1.6f);
		buffer.put(2.3f);
		
		r1.orthogonalLineFit(buffer);
		assertEquals(r1.getOrigin(),new Vector3f(1.0f,1.6f,2.3f));
		assertEquals(r1.getDirection(),new Vector3f(1,0,0));
	}
	
	@Test
	public void testRandom()
	{
		Vector3f v1 = r2.random();
		
		assertTrue(v1.x < Math.max(r2.getOrigin().x, r2.getDirection().x));
		assertTrue(v1.y < Math.max(r2.getOrigin().y, r2.getDirection().y));
		assertTrue(v1.z < Math.max(r2.getOrigin().z, r2.getDirection().z));
		
		assertTrue(v1.x > Math.min(r2.getOrigin().x, r2.getDirection().x));
		assertTrue(v1.y > Math.min(r2.getOrigin().y, r2.getDirection().y));
		assertTrue(v1.z > Math.min(r2.getOrigin().z, r2.getDirection().z));
	}

}
