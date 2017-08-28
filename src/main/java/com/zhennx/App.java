package com.zhennx;

import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.FileResourceManager;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.Servlets;

import javax.servlet.ServletException;

import java.io.File;

import static io.undertow.servlet.Servlets.defaultContainer;
import static io.undertow.servlet.Servlets.servlet;

/**
 * Hello world!
 */
public class App {
    public static final String ROOT = "/";

    public static void main(final String[] args) {

        try {

            DeploymentInfo servletBuilder = Servlets.deployment()
                    .setClassLoader(App.class.getClassLoader())
                    .setContextPath(ROOT)
                    .setResourceManager(new FileResourceManager(new File("src/main/webapp"), 1024))
                    .addWelcomePage("index.html")
                    .setDeploymentName("test.war")
                    //.addListener(new ListenerInfo(MySessionListener.class))

                    .addServlets(
                            servlet("ExampleServlet", ExampleServlet.class)
                                    .addInitParam("message", "Hello World")
                                    .addMapping("/servlet"));

            final PathHandler servletPath = new PathHandler();

            DeploymentManager manager = defaultContainer().addDeployment(servletBuilder);
            manager.deploy();
            servletPath.addPrefixPath(servletBuilder.getContextPath(), manager.start());

            Undertow server = Undertow.builder()
                    .addHttpListener(8080, "localhost")
                    .setHandler(servletPath)
                    .build();

            server.start();
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
