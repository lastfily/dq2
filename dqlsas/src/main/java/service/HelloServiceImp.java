package service;

import javax.jws.WebService;

public class HelloServiceImp implements HelloService {

    public String sayHello(String name) {
        return "大家好，我是"+name;
    }
}
