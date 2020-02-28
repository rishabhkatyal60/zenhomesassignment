package com.zenhomes.org.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zenhomes.org.dto.Consumption;
import com.zenhomes.org.service.dto.ConsumptionDTO;
import com.zenhomes.org.service.impl.ReportService;

@Path("/consumption")
public class ConsumptionService {
	@GET
	@Path("/{duration}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Consumption> getCounter(@PathParam("duration") int duration) {
		
		final ReportService service = new ReportService();

		final List<ConsumptionDTO> dtos = service.getConsumption(duration);
		
		final List<Consumption> list = new ArrayList<Consumption>();

		for (ConsumptionDTO consumptionDTO : dtos) {
			final Consumption consumption = new Consumption();
			consumption.setName(consumptionDTO.getName());
			consumption.setConsumption(consumptionDTO.getConsumption());
			
			list.add(consumption);
		}
		
		return list;
	}

}