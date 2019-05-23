package service;

import org.springframework.stereotype.Service;

@Service("rmiService")
public class RmiServiceImpl implements RmiService {
    public String sayHello(){
        System.out.println("hello");

        return "你好，客户端";
    }
}
