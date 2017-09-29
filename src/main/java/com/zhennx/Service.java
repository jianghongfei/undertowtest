package com.zhennx;

/**
 * @author Jiang Hongfei <jiang.hongfei@mhccenter.com>
 */
public class Service implements IService {
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
