package com.zenhomes.org.service;

import java.util.List;

import com.zenhomes.org.model.domain.Village;
import com.zenhomes.org.service.dto.ConsumptionDTO;

public interface Service {

	public void addConsumption(final Village village, final double amount);
	
	public Village getInformation(final int counter);

	public List<ConsumptionDTO> getConsumption(final int duration);
	
}
