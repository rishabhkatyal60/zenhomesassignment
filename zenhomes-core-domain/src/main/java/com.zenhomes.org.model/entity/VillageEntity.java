package com.zenhomes.org.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.zenhomes.org.model.domain.Consumption;
import com.zenhomes.org.model.domain.Village;

/**
 * 
 * @author
 * Mock for database storage
 */
public class VillageEntity {

	private List<Village> villages = new ArrayList<Village>();

	public VillageEntity() {
		final Village village1 = new Village(1, "Villarriba");
		final Village village2 = new Village(2, "Villabajo");
		villages.add(village1);
		villages.add(village2);
		
		for (int i = 0; i < 24; i++) {
			final Consumption consumption = new Consumption(i, i, 100.00, village1);
			village1.addConsumption(consumption);
		}

		for (int i = 0; i < 24; i++) {
			final Consumption consumption = new Consumption(i, i, 200.00, village2);
			village2.addConsumption(consumption);
		}

	}
	
	public Village getByCounterId(final int counter) {
		return villages.get(counter-1);
	}

	public List<Village> getVillages() {
		return villages;
	}
	
}
