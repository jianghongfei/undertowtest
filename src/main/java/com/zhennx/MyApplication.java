package com.zhennx;

/**
 * @author Jiang Hongfei <jiang.hongfei@mhccenter.com>
 */
import java.util.LinkedHashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new LinkedHashSet<Class<?>>();
        resources.add(HelloResource.class);
        return resources;
    }
}