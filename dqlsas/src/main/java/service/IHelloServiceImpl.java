package service;

import org.springframework.stereotype.Service;

@Service("iHelloService")
public class IHelloServiceImpl implements IHelloService{
    //打印参数，并返回一串字符串
    public String sayHello(String something) {
        System.out.println("接收客户端信息："+something);
        return "你好我是服务端！";
    }

}