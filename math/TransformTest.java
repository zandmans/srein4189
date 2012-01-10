package com.jme3.math;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TransformTest {

	private Transform t1;
	
	
	@Before
	public void setUp(){
		t1 = new Transform();
	}
	
	@Test
	public void testToString() {
		assertEquals(t1.toString(), "Transform[0.0, 0.0, 0.0]\n[0.0, 0.0, 0.0, 1.0]\n[1.0, 1.0, 1.0]");
	}

}
