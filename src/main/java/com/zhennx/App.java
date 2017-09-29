package com.zhennx;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Hello world!
 */
public class App {
    public static void main(final String[] args) {
        Injector injector = Guice.createInjector(new ApplicationModule());

        ServletServer server = injector.getInstance(ServletServer.class);
        server.start();
    }

//    public static void main(final String[] args) {
//        DeploymentInfo servletBuilder =
//                Servlets.deployment().setDeploymentName("wm.war").setClassLoader(App.class.getClassLoader()).setContextPath("/wm")
//                        .addInitParameter("resteasy.guice.modules", ApplicationModule.class.getName())
//                        .addListener(new ListenerInfo(GuiceResteasyBootstrapServletContextListener.class))
//                        .addServlets(Servlets.servlet("Resteasy", HttpServletDispatcher.class).addMapping("/*"));
//
//        DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
//        manager.deploy();
//
//        // HttpHandler servletDeploymentHandler = manager.start();
//
//        // PathHandler pathHandler = Handlers.path(Handlers.redirect("/wm")).addPrefixPath("/wm", servletDeploymentHandler);
//
//        Undertow server = Undertow.builder().addHttpListener(8080, "localhost").build();
//
//        server.start();
//    }
}
