package example.demo1.dao.impl;

import example.demo1.dao.EmpDao;
import example.demo1.pojo.Emp;
import java.util.List;
import example.demo1.utils.XmlParserUtils;

public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> emp() {
      String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
      System.out.println(file);
      List<Emp> emps = XmlParserUtils.parse(file, Emp.class);
      return emps;
    }

}
