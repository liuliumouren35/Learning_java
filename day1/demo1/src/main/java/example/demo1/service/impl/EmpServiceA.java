package example.demo1.service.impl;

import example.demo1.service.EmpService;
import example.demo1.dao.EmpDao;
import example.demo1.pojo.Emp;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component// @Service("empServiceA")  //Spring会自动扫描到这个类，并将其实例化为一个bean
public class EmpServiceA implements EmpService {
  @Autowired
  private EmpDao empDao ;
   
   @Override
   public List<Emp> emp(){
    List<Emp> emps = empDao.emp();
    emps.stream().forEach(emp -> {
      int genderCode = Integer.parseInt(emp.getGender());
      emp.setGender(genderCode == 1 ? "男" : "女");
    });
        return emps;
   }
}
