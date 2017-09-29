package com.zhennx;

import io.undertow.Undertow;
import io.undertow.server.handlers.resource.FileResourceManager;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.ListenerInfo;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import java.io.File;

/**
 * @author Jiang Hongfei <jiang.hongfei@mhccenter.com>
 */
public class ServletServer {public void start() {
        String contextPath = "/";
        String deploymentName = "My Application";

        Undertow.Builder serverBuilder = Undertow.builder().addHttpListener(8080, "localhost");
        UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.start(serverBuilder);

        // Without MyApplication.class, ApplicationPath should be prepended to path of every resource.
        DeploymentInfo di = server.undertowDeployment(MyApplication.class)
                .setClassLoader(App.class.getClassLoader())
                .setContextPath(contextPath)
                .setDeploymentName(deploymentName)
                .addInitParameter("resteasy.guice.modules", ApplicationModule.class.getName())
                .addListener(new ListenerInfo(GuiceResteasyBootstrapServletContextListener.class))
                .setResourceManager(new FileResourceManager(new File("src/main/webapp"), 1024))
                .addWelcomePage("index.html")
                .addServlets(Servlets.servlet("ExampleServlet", ExampleServlet.class).addMapping("/servlet"));

        server.deploy(di);
    }
}
