package starting.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import starting.model.Student;

@Path("/")
public interface HelloApi {

	@GET
	@Path("/hello")
	public String helloWorld();
	
	@GET
	@Path("/fetchJson")
	@Produces("application/json")
	public List<Student> fetch();
	
	
	@POST
	@Path("/insert")
	@Consumes("application/json")
	public String insertData(List<Student> studentList);



	@GET
	@Path("/get")
	@Produces("application/json")
	public List<Student> getInfo();

}



