package com.example.server.cxf.rest.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cxf_rest_hello")
public class HelloFromCxfRestService {
	@GET
    @Path("/{msg}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHelloFromRest(final @PathParam("msg") String msg) {
        return "Hello from CXF-REST(esto es un mensaje diferente): "+msg;
    }
}
