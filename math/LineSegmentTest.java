package com.jme3.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineSegmentTest {

	@Test
	public void testDistanceSquaredRay() {
		Vector3f start = new Vector3f(0,0,0);
		Vector3f end = new Vector3f(10,0,0);
		LineSegment ls = new LineSegment(start, end);

		Vector3f origin = new Vector3f(0,2,0);
		Vector3f direction = new Vector3f(1,0,0);
		Ray r = new Ray(origin, direction);
		assertEquals(ls.distanceSquared(r), 4.0, 0.00001);
		

		origin = new Vector3f(0,2,0);
		direction = new Vector3f(-1,0,0);
		r = new Ray(origin, direction);
		assertEquals(ls.distanceSquared(r), 4.0, 0.00001);

		origin = new Vector3f(10,2,-5);
		direction = new Vector3f(1,5,-3);
		r = new Ray(origin, direction);
		assertEquals(ls.distanceSquared(r),29.0, 0.00001);

		start = new Vector3f(500,-100,10);
		end = new Vector3f(550,0,1);
		ls = new LineSegment(start, end);
		assertEquals(ls.distanceSquared(r),250729.0, 0.00001);

		origin = new Vector3f(10,2,-5);
		direction = new Vector3f(5, -5, 0);
		r = new Ray(origin, direction);
		assertEquals(ls.distanceSquared(r),8510871.0, 0.00001);

		start = new Vector3f(-10,-10,10);
		end = new Vector3f(15,15,-10);
		ls = new LineSegment(start, end);
		origin = new Vector3f(-10,-2,5);
		direction = new Vector3f(5, -100, -20);
		r = new Ray(origin, direction);
		assertEquals(ls.distanceSquared(r),555.0888, 0.0001);

	}
	
	@Test
	public void testDistanceSquaredSegment(){
		Vector3f start = new Vector3f(0,0,0);
		Vector3f end = new Vector3f(10,0,0);
		LineSegment ls = new LineSegment(start, end);

		Vector3f origin = new Vector3f(0,2,0);
		Vector3f direction = new Vector3f(1,0,0);
		LineSegment r = new LineSegment(origin, direction, 100);
		assertEquals(ls.distanceSquared(r), 4.0, 0.00001);
		

		origin = new Vector3f(0,2,0);
		direction = new Vector3f(-1,0,0);
		r = new LineSegment(origin, direction, 100);
		assertEquals(ls.distanceSquared(r), 4.0, 0.00001);

		origin = new Vector3f(10,2,-5);
		direction = new Vector3f(1,5,-3);
		r = new LineSegment(origin, direction, 100);
		assertEquals(ls.distanceSquared(r),252.25, 0.00001);

		start = new Vector3f(500,-100,10);
		end = new Vector3f(550,0,1);
		ls = new LineSegment(start, end);
		assertEquals(ls.distanceSquared(r),307642.90625, 0.00001);

		origin = new Vector3f(10,2,-5);
		direction = new Vector3f(5, -5, 0);
		r = new LineSegment(origin, direction, 100);
		assertEquals(ls.distanceSquared(r),331271.0, 0.00001);

		start = new Vector3f(-10,-10,10);
		end = new Vector3f(15,15,-10);
		ls = new LineSegment(start, end);
		origin = new Vector3f(-10,-2,5);
		direction = new Vector3f(5, -100, -20);
		r = new LineSegment(origin, direction, 100);
		assertEquals(ls.distanceSquared(r),555.0888, 0.0001);
		
	}

}
