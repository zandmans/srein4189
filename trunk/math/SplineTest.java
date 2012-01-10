package com.jme3.math;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class SplineTest {

	@Test
	public void testInterpolate() {
		List<Vector4f> l1 = new ArrayList<Vector4f>();
		l1.add(new Vector4f(1.0f,2.0f,3.0f,4.0f));
		l1.add(new Vector4f(1.0f,2.0f,3.0f,4.0f));
		
		List<Float> l2 = new ArrayList<Float>();
		l2.add(1.0f);
		l2.add(1.0f);
		l2.add(1.0f);		
		
		Spline s1 = new Spline(l1,l2);
		
		assertEquals(s1.interpolate(1.0f, 1, new Vector3f(1.0f,2.0f,3.0f)), new Vector3f(1.0f,2.0f,3.0f));
	}

}
