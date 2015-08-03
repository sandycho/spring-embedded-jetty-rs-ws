package com.example.server.bindings;

import com.example.server.cxf.rest.hello.HelloFromCxfRestService;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceCxfRestServicesConfigModule extends ServletModule {
	@Override
    protected void configureServlets() {
        bind(HelloFromCxfRestService.class);
        serve("/cxf-cxf-rest/*").with(GuiceContainer.class);
    }
}
