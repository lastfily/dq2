package service;

public class HelloImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        if((name == null) || (name == "")) {
            name = "anonymous";
        }
        return "hello, " + name;
    }
}
