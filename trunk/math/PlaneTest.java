package com.jme3.math;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlaneTest {
	
	Plane plane;

	@Before
	public void setUp(){
		plane = new Plane(new Vector3f(1f,1f,1f), 0.0f);
	}
	
	
	@Test
	public void testIsOnPlane() {
		assertTrue(plane.isOnPlane(new Vector3f(0.0f, 0.0f, 0.0f)));
		assertFalse(plane.isOnPlane(new Vector3f(1.0f, 0.0f, 0.0f)));
	}

}
