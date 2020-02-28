package com.zenhomes.org.service;

import com.zenhomes.org.dto.Counter;
import com.zenhomes.org.model.domain.Village;
import com.zenhomes.org.service.impl.ReportService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/counter")
public class CounterService {
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Counter getCounter(@PathParam("id") int id) {

		final ReportService service = new ReportService();
		final Village village = service.getInformation(id);
		final Counter counter = new Counter();

		counter.setId(village.getId());
		counter.setVillage_name(village.getName());

		return counter;
	}
}