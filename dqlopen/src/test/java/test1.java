import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.RmiService;


public class test1 {
	private static ApplicationContext context;
	@Test
	public void demo1(){
		context =new ClassPathXmlApplicationContext("classpath:spring-rmi-client.xml");

//		ApplicationContext context2 =new FileSystemXmlApplicationContext("classpath:spring-rmi-client.xml");
		RmiService service =context.getBean(RmiService.class);
//		RmiService service2 =context2.getBean(RmiService.class);
//		String str=service.sayHello("我是小虎啊啊啊啊");
		service.sayHello();
		System.out.println(service.sayHello());
//		System.out.println(service2);
	}
}