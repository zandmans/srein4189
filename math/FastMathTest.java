package com.jme3.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class FastMathTest {
	
	

	@Test
	public void testIsPowerOfTwo() {
		assertTrue(FastMath.isPowerOfTwo(1));
		assertTrue(FastMath.isPowerOfTwo(2));
		assertTrue(FastMath.isPowerOfTwo(4));
		assertTrue(FastMath.isPowerOfTwo(8));
		assertTrue(FastMath.isPowerOfTwo(16));
		assertTrue(FastMath.isPowerOfTwo(32));
		assertTrue(FastMath.isPowerOfTwo(64));
		assertTrue(FastMath.isPowerOfTwo(128));
		assertTrue(FastMath.isPowerOfTwo(256));
		assertTrue(FastMath.isPowerOfTwo(512));
		assertTrue(FastMath.isPowerOfTwo(1024));
		assertFalse(FastMath.isPowerOfTwo(-1));
		assertFalse(FastMath.isPowerOfTwo(-2));
		assertFalse(FastMath.isPowerOfTwo(0));
		assertFalse(FastMath.isPowerOfTwo(3));
		assertFalse(FastMath.isPowerOfTwo(6));
		assertFalse(FastMath.isPowerOfTwo(24));
		assertFalse(FastMath.isPowerOfTwo(50));
		assertFalse(FastMath.isPowerOfTwo(100));
		assertFalse(FastMath.isPowerOfTwo(200));
	}
	
	@Test
	public void testNearestPowerOfTwo(){
		assertEquals(FastMath.nearestPowerOfTwo(-100000), 0);
		assertEquals(FastMath.nearestPowerOfTwo(0), 0);
		assertEquals(FastMath.nearestPowerOfTwo(1), 1);
		assertEquals(FastMath.nearestPowerOfTwo(2), 2);
		assertEquals(FastMath.nearestPowerOfTwo(3), 4);
		assertEquals(FastMath.nearestPowerOfTwo(4), 4);
		assertEquals(FastMath.nearestPowerOfTwo(5), 8);
		assertEquals(FastMath.nearestPowerOfTwo(7), 8);
		assertEquals(FastMath.nearestPowerOfTwo(12), 16);
		assertEquals(FastMath.nearestPowerOfTwo(513), 1024);
		assertEquals(FastMath.nearestPowerOfTwo(1555), 2048);
	}
	
	@Test
	public void testCopySign(){
		assertEquals(FastMath.copysign(1, -1), -1, 0.0000001);
		assertEquals(FastMath.copysign(-1, -1), -1, 0.0000001);
		assertEquals(FastMath.copysign(1, 1), 1, 0.0000001);
		assertEquals(FastMath.copysign(-1, -1), -1, 0.0000001);
		assertEquals(FastMath.copysign(0, -1), 0, 0.0000001);
		assertEquals(FastMath.copysign(0, 1), 0, 0.0000001);
		assertEquals(FastMath.copysign(1, 0), 1, 0.0000001);
		assertEquals(FastMath.copysign(1, -0), 1, 0.0000001);
	}

}
