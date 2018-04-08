package hi.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/")
@Api
@Component
public class Controller {

	@Path("/hi")
	@GET
	 @ApiOperation(            //Swagger Annotation
             value = "Say hello by entering your name",
             response = Hello.class)
     @ApiResponses(value = {       //Swagger Annotation
             @ApiResponse(code = 200, message = "Resource found"),
             @ApiResponse(code = 404, message = "Resource not found")
     })
	public String hi() {
		return "hi how are you";
	}
	
	
	@Path("/hii")
	@GET
	 @ApiOperation(            //Swagger Annotation
             value = "Say hello by entering your name",
             response = Hello.class)
     @ApiResponses(value = {       //Swagger Annotation
             @ApiResponse(code = 200, message = "Resource found"),
             @ApiResponse(code = 404, message = "Resource not found")
     })
	public String hii() {
		return "hi how are you";
	}
	
	
	@GET
	@Path("/hello")
    @ApiOperation("Get message")
    @Produces(MediaType.TEXT_PLAIN)
    public String message() {
        return "Hello";
    }
}
