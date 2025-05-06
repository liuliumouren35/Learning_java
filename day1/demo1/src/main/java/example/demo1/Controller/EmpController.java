package example.demo1.Controller;
import example.demo1.pojo.Emp;
import example.demo1.pojo.Result;
import example.demo1.service.EmpService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
@RestController
@Component
public class EmpController {
  @Autowired
  private EmpService empService;
  @RequestMapping("/listEmp")
  public Result lsit(){
    List<Emp> emps=empService.emp();
    //3.响应数据
    return Result.success(emps);
  }
} 
