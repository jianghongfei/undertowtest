package com.zhennx;

/**
 * @author Jiang Hongfei <jiang.hongfei@mhccenter.com>
 */

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        // Since resources are registered in ApplicationModule,
        // it should not be registered here,
        // otherwise injection of Guice won't work.

        return super.getClasses();
    }
}