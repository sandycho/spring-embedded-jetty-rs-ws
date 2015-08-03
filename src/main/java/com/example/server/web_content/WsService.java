package com.example.server.web_content;

import static javax.ws.rs.core.MediaType.TEXT_HTML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedWriter;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/web")
public class WsService {	
	@GET
	@Path("/example")
	@Produces("text/html")
	public Response getHtml(){
	File f = new File("../example.html"); //hay que poner una ruta relativa desde el directorio /target
	 	System.out.println(f.toString());
	  if (!f.exists()) {
		  System.out.println("No existe");
		  throw new WebApplicationException(404);
	  }
	  
	  String mt = new MimetypesFileTypeMap().getContentType(f);
	  return Response.ok(f, mt).build();
	}
	
	@GET
	@Path("/chain")
	@Produces( TEXT_HTML )
	public String getAll() {
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("filename.txt"), "utf-8"));
		    writer.write("Something");
		    System.out.println("END TRY");
		} catch (IOException ex) {
		  // report
			System.out.println("catch");
		} finally {
			System.out.println("FINALY");
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		return "<html><body><div>Not Found</div></body></html>";
	}
	
	@GET
    @Path("/{msg}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHelloFromRest(final @PathParam("msg") String msg) {
        return "Hello from CXF REST: " + msg;
    }

}
