package com.zhennx;

/**
 * @author Jiang Hongfei <jiang.hongfei@mhccenter.com>
 */

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @Inject
    private IService service;

    private int counter = 0;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return service.sayHello("World, " + counter++);
    }
}