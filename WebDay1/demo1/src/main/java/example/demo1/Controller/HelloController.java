package example.demo1.Controller;
import example.demo1.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
public class HelloController {
  // 简单参数
  @RequestMapping("/simple")
  public String simpleParam(String name, Integer age) {
    System.out.println("name:" + name + ",age:" + age);
    return "ok";
  }
  // 简单参数
  @RequestMapping("/hello1")
  public String helloWorld() {
    return "你好，世界！欢迎学习 JavaWeb 后端开发！";
  }
  // 实体类参数
  @RequestMapping("/pojo")
  public String pojoParam(User user) {
    System.out.println("user:" + user);
    return "ok";
  }

  // 简单参数
  @RequestMapping("/pojo2")
  public String pojoParam2(User user) {
    System.out.println("user:" + user);
    return "ok";
  }

  // 数组参数
  @RequestMapping("/arrayParam")
  public String arrayParam(String[] hobby) {
    System.out.println("hobby:" + Arrays.toString(hobby));
    return "ok";
  }
// 集合参数
  @RequestMapping("/listParam")
  public String listParam(@RequestParam List<String> hobby) {
    System.out.println("hobby:" + hobby);
    return "ok";
  }
//日期格式的封装
  @RequestMapping("/dataParam")
  public String dataParam(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthday) {
    System.out.println("birthday:" + birthday);
    return "ok";
  }
//Json格式的封装
  @RequestMapping("/JsonParam")
  public String JsonParam(@RequestBody User user) {
    System.out.println("user:" + user);
    return "ok";
  }
//路径参数
  @RequestMapping("/path/{id}")
  public String pathParam(@PathVariable Integer id) {
    System.out.println("id:" + id);
    return "ok";
  }
 //路径参数
  @RequestMapping("/path/{id}/{name}")
  public String pathParam2(@PathVariable Integer id, @PathVariable String name) {
    System.out.println("id:" + id + ",name:" + name);
    return "ok";
  }
  
}