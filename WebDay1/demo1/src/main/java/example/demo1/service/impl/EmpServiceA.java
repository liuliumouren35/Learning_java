package example.demo1.service.impl;

import example.demo1.service.EmpService;
import example.demo1.dao.EmpDao;
import example.demo1.pojo.Emp;
import java.util.List;
import example.demo1.dao.impl.EmpDaoA;



public class EmpServiceA implements EmpService {
   private EmpDao empDao = new EmpDaoA();
   
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
