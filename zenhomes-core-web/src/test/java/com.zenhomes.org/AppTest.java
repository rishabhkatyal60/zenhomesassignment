package com.zenhomes.org;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * You have to design and build the system that allows to receive and collect
	 * data about energy consumption from different villages. As a result, your
	 * system should, on demand, give out the consumption report per village for the
	 * last 24h.
	 */
	public void testPost() {
		assertTrue(true);
	}
}
