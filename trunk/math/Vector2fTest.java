package com.jme3.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class Vector2fTest {

	@Test
	public void testEquals() {
		Vector2f v1 = new Vector2f(1,5);
		Vector2f v2 = new Vector2f(1,5);
		Vector2f v3 = new Vector2f(2,5);
		Vector2f v4 = new Vector2f(1,5.01f);
		Vector2f v5 = new Vector2f(100,500);
		assertTrue(v1.equals(v1));
		assertTrue(v2.equals(v2));
		assertTrue(v2.equals(v1));
		assertFalse(v1.equals(v3));
		assertFalse(v1.equals(v4));
		assertFalse(v1.equals(v5));
		assertFalse(v1.equals("This is no Vector2f object"));
	}

}
