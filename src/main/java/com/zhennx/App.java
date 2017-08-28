package com.zhennx;

import io.undertow.Undertow;
import io.undertow.server.handlers.resource.FileResourceManager;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import java.io.File;

/**
 * Hello world!
 */
public class App {
    public static void main(final String[] args) {
        String contextPath = "/";
        String deploymentName = "My Application";

        Undertow.Builder serverBuilder = Undertow.builder().addHttpListener(8080, "localhost");
        UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.start(serverBuilder);

        DeploymentInfo di = server.undertowDeployment(MyApplication.class)
                .setClassLoader(App.class.getClassLoader())
                .setContextPath(contextPath)
                .setDeploymentName(deploymentName)
                .setResourceManager(new FileResourceManager(new File("src/main/webapp"), 1024))
                .addWelcomePage("index.html")
                .addServlets(Servlets.servlet("ExampleServlet", ExampleServlet.class).addMapping("/servlet"));

        server.deploy(di);
    }
}
