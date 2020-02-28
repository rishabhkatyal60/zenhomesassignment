package com.zenhomes.org;

import java.util.List;

import com.zenhomes.org.model.domain.Village;
import com.zenhomes.org.model.entity.VillageEntity;
import com.zenhomes.org.service.Service;
import com.zenhomes.org.service.dto.ConsumptionDTO;
import com.zenhomes.org.service.impl.ReportService;

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
	 * POST /counter_callback { "counter_id": "1", "amount": 10000.123 }
	 */
	public void testAddConsumption() {

		final Service service = new ReportService();
		final Village village = new VillageEntity().getByCounterId(1);
		service.addConsumption(village, 100);

		System.out.println(village);

		assertTrue(true);
	}

	/**
	 * GET /counter?id=1 { "id": "1", "village_name": "Villarriba" }
	 */
	public void testGetInformation() {

		final Village village = new VillageEntity().getByCounterId(1);
		System.out.println(village);

		assertTrue(true);
	}

	/**
	 * GET /consumption_report?duration=24h { "villages": [ { "village_name":
	 * "Villarriba", "consumption": 12345.123 }, { "village_name": "Villabajo",
	 * "consumption": 23456.123 } ] }
	 */
	public void testGetConsumption() {

		final Service service = new ReportService();
		final Village village = new VillageEntity().getByCounterId(1);
		service.addConsumption(village, 100);
		
		final List<ConsumptionDTO> dtos = service.getConsumption(24);
		
		for (ConsumptionDTO consumptionDTO : dtos) {
			System.out.println(consumptionDTO);
		}
		
		assertTrue(true);
	}

}
