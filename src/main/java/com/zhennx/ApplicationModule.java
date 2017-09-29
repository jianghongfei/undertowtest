package com.zhennx;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.TypeLiteral;

/**
 * @author Jiang Hongfei <jiang.hongfei@mhccenter.com>
 */
//public class ApplicationModule implements Module {
//    public void configure(Binder binder) {
//        binder.bind(IService.class).to(Service.class);
//
//    }
//}

public class ApplicationModule extends AbstractModule {
    protected void configure() {
        bind(IService.class).to(Service.class);
        bind(HelloResource.class);
    }
}