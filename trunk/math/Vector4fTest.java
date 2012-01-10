package com.jme3.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class Vector4fTest {

	@Test
	public void testEquals() {
		Vector4f v1 = new Vector4f(1,5,11,13);
		Vector4f v2 = new Vector4f(1,5,11,13);
		Vector4f v3 = new Vector4f(2,5,11,13);
		Vector4f v4 = new Vector4f(1,5.01f,11,13);
		Vector4f v5 = new Vector4f(1,5,12,13);
		Vector4f v6 = new Vector4f(1,5,11,12);
		Vector4f v7 = new Vector4f(100,500,1100,1300);
		assertTrue(v1.equals(v1));
		assertTrue(v2.equals(v2));
		assertTrue(v2.equals(v1));
		assertFalse(v1.equals(v3));
		assertFalse(v1.equals(v4));
		assertFalse(v1.equals(v5));
		assertFalse(v1.equals(v6));
		assertFalse(v1.equals(v7));
		assertFalse(v1.equals("This is no Vector4f object"));
	}

}
