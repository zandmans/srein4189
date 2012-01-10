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

}
