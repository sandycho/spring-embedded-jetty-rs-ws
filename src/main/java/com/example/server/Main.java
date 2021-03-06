package com.example.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.example.server.bindings.GuiceServletInjector;
import com.google.inject.servlet.GuiceFilter;




public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        
        
        
        ServletContextHandler context = new ServletContextHandler(server, "/");
        context.addServlet(DefaultServlet.class, "/rest/*");
        context.addEventListener(new GuiceServletInjector()); // Guice
        
        context.addFilter(GuiceFilter.class, "/*", null);

        
        
        
        
        server.start();
        System.out.println("Press any key to stop server...");
        System.in.read();
        System.out.println("Stopping...");
        server.stop();
        server.join();
    }
}
