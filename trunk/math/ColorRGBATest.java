package com.jme3.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorRGBATest {

	@Test
	public void testEquals() {
		ColorRGBA c1 = new ColorRGBA(0.5f,0.5f,0.5f,1f);
		ColorRGBA c2 = new ColorRGBA(0.5f,0.5f,0.5f,1f);
		ColorRGBA c3 = new ColorRGBA(0.5f,0.5f,0.4f,1f);
		ColorRGBA c4 = new ColorRGBA(0.5f,0.4f,0.5f,1f);
		ColorRGBA c5 = new ColorRGBA(0.51f,0.5f,0.5f,1f);
		ColorRGBA c6 = new ColorRGBA(0.5f,0.5f,0.5f,0f);
		assertTrue(c1.equals(c1));
		assertTrue(c1.equals(c2));
		assertFalse(c1.equals(c3));
		assertFalse(c1.equals(c4));
		assertFalse(c1.equals(c5));
		assertFalse(c1.equals(c6));
		assertFalse(c1.equals("Testing is important!"));
	}

}
