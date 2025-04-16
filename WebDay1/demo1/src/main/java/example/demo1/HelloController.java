package example.demo1;
import example.demo1.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @RequestMapping("/simple")
  public String simpleParam(String name, Integer age) {
    System.out.println("name:" + name + ",age:" + age);
    return "ok";
  }
  
  @RequestMapping("/hello")
  public String helloWorld() {
    return "你好，世界！欢迎学习 JavaWeb 后端开发！";
  }

  @RequestMapping("/pojo")
  public String pojoParam(User user) {
    System.out.println("user:" + user);
    return "ok";
  }

  @RequestMapping("/pojo2")
  public String pojoParam2(User user) {
    System.out.println("user:" + user);
    return "ok";
  }
}