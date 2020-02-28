package com.zenhomes.org.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.zenhomes.org.model.domain.Village;
import com.zenhomes.org.service.impl.ReportService;

@Path("/callback")
public class Callback {
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(String input) {

		String array[] = new String[2];
		array = input.split(",");
		
		final String counter_id = array[0].split(":")[1];
		final String amount = array[1].split(":")[1];
		
		final Service service = new ReportService();
		final Village village = service.getInformation(Integer.valueOf(counter_id));
		
		service.addConsumption(village, Double.valueOf(amount));
		
		final String result = "counter_id: " + counter_id + " amount: " + amount + " saved with success!";
		return Response.status(201).entity(result).build();
	}

}
