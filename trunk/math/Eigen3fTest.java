package com.jme3.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class Eigen3fTest {

	@Test
	public void testcalculateEigen() {
		Eigen3f e1 = new Eigen3f();
		e1.calculateEigen(new Matrix3f(1,2,3,4,5,6,7,8,9));
		
		String output = "";
		for(Vector3f ev: e1.eigenVectors)
		{
			output += ev.toString() + ", ";
		}
		
		//assertEquals(e1.eigenValues,output);
		//assertEquals(e1.eigenVectors,output);
	}

}
