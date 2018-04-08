package hi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@ApplicationPath("/api")
@Component
public  class JerseyConfig extends ResourceConfig {


	public JerseyConfig() {

		this.packages("hi.api");
		configureSwagger();
	}
	
    private void configureSwagger() {

        register(ApiListingResource.class);

        BeanConfig beanConfig = new BeanConfig();

        beanConfig.setVersion("1.0.2");

        beanConfig.setSchemes(new String[]{"http"});

        beanConfig.setHost("localhost:9090");

        beanConfig.setBasePath("/api");

        beanConfig.setResourcePackage("hi.api");

        beanConfig.setPrettyPrint(true);

        beanConfig.setScan(true);

    }


	
	
    @Component
    @Primary
    public static class CombinedSwaggerResourcesProvider implements SwaggerResourcesProvider {

        @Resource
        private InMemorySwaggerResourcesProvider inMemorySwaggerResourcesProvider;

        @Override
        public List<SwaggerResource> get() {

            SwaggerResource jerseySwaggerResource = new SwaggerResource();
            jerseySwaggerResource.setLocation("/api/swagger.json");
            jerseySwaggerResource.setSwaggerVersion("2.0");
            jerseySwaggerResource.setName("Jersey");
            
            return Stream.concat(Stream.of(jerseySwaggerResource), inMemorySwaggerResourcesProvider.get().stream()).collect(Collectors.toList());
        }

    }
	
	
	
	
	
}
