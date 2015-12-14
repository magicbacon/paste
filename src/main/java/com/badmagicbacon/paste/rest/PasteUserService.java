package com.badmagicbacon.paste.rest;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.badmagicbacon.paste.PasteUser;
import com.badmagicbacon.paste.service.PasteService;

@Component
@Path("/users")
public class PasteUserService {
	
	@Resource(name = "pasteService")
	private PasteService pasteService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(PasteUser user) {
		pasteService.createUser(user);
		return Response.status(200).entity("user created").build();
	}

}
