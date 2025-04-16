package example.demo1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/aaa")
    public String hello(){
      System.out.println("hello world");
      return "hello world";
    }

}
 