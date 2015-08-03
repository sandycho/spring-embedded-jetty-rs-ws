package com.example.server.bindings;

import com.example.server.cxf.rest.hello.HelloFromCxfRestService;
import com.example.server.web_content.WsService;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceWsServicesConfigModule extends ServletModule {
	@Override
	protected void configureServlets() {
		bind(WsService.class);
		serve("/web/*").with(GuiceContainer.class);
	}
}
