package example.demo1.Controller;
import example.demo1.pojo.Emp;
import example.demo1.pojo.Result;
import example.demo1.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
  @RequestMapping("/listEmp")
  public Result lsit(){
    //1.读取emp.xml文件
    String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
    System.out.println(file);
    List<Emp> emps = XmlParserUtils.parse(file, Emp.class);
    //2.对数据进行转换处理-gender job
    emps.stream().forEach(emp -> {
      // 将 String 转换为 int 再比较
      int genderCode = Integer.parseInt(emp.getGender());
      emp.setGender(genderCode == 1 ? "男" : "女");

      // 将 String 转换为 int 再比较
      int jobCode = Integer.parseInt(emp.getJob());
      emp.setJob(jobCode == 1 ? "讲师" : jobCode == 2 ? "班主任" : "就业指导");
    });
    
    //3.响应数据
    return Result.success(emps);
  }
}
