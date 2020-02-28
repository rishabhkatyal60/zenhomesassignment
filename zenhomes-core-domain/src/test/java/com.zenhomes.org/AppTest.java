package com.zenhomes.org;

import com.zenhomes.org.model.domain.Consumption;
import com.zenhomes.org.model.domain.Village;

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
	public void testApp() {

		final Village village1 = new Village(1, "Villarriba");
		System.out.println(village1);

		for (int i = 0; i < 24; i++) {
			final Consumption consumption = new Consumption(i, i, 100.00, village1);
			village1.addConsumption(consumption);
		}

		System.out.println(village1);
		assertTrue(village1.getConsumptions().size() == 24);

		final int duration24 = 24;
		final double consumption24h = village1.consumptionReport(duration24);
		assertEquals(2400.0, consumption24h);
		System.out.println("24h consumption: " + consumption24h);

		final int duration12 = 12;
		final double consumption12h = village1.consumptionReport(duration12);
		assertEquals(1200.0, consumption12h);
		System.out.println("24h consumption: " + consumption12h);

	}
}
