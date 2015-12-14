package com.badmagicbacon.paste.rest;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.badmagicbacon.paste.PasteContent;
import com.badmagicbacon.paste.service.PasteService;

@Component
@Path("/contents")
public class PasteContentService {
	
	@Resource(name = "pasteService")
	private PasteService pasteService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response copy(PasteContent content) {
		pasteService.copy(content, "test1");
		return Response.status(200).entity("content created.").build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response paste(@RequestParam String username) {
		PasteContent content = pasteService.paste("test1");
		System.out.println(username);
		return Response.status(200).entity(content).build();
	}

}
