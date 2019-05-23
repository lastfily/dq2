import service.HelloServiceImp;
import service.HelloServiceImpService;

public class TestCxf {
    public static void main(String[] args) {
        HelloServiceImp service=new HelloServiceImpService().getHelloServiceImpPort();
        System.out.println(service.sayHello("CXF"));
    }
}
