package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import service.IHelloService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class RmiS {

    @ResponseBody
    @RequestMapping("/aaa")
    public String demo1(HttpServletRequest req){
        System.out.println(req.getParameter("aaa"));
        ApplicationContext context =new ClassPathXmlApplicationContext("classpath:spring-rmi-client.xml");
        IHelloService rmiService=context.getBean(IHelloService.class);
        rmiService.sayHello("服务器"+req.getParameter("aaa"));
        System.out.println(rmiService.sayHello("服务器"+req.getParameter("aaa")));
        return "ccc.jsp";
    }
}