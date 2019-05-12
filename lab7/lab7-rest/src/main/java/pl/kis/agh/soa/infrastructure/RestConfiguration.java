package pl.kis.agh.soa.infrastructure;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RestConfiguration extends Application {

    public RestConfiguration() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("v1");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("soa/rest");
        beanConfig.setResourcePackage("pl.kis.agh.soa.endpoint");
        beanConfig.setScan(true);
    }

}
