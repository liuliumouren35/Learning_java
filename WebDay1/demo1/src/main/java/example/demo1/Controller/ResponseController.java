package example.demo1.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

import example.demo1.pojo.Address;
import example.demo1.pojo.Result;
@RestController
public class ResponseController {
  @RequestMapping("/hello2")
  public Result hello() {
    System.out.println("hello world");
    return Result.success("操作成功", "hello");
  } 
  @RequestMapping("/getAddress")
  public Result getAddress() {
    Address address = new Address();
    address.setProvince("北京");
    address.setCity("海淀区");
    return Result.success("获取地址成功", address);
  }
  @RequestMapping("/ListAddress")
  public Result ListAddress() {
    List<Address> addresses = new ArrayList<>();
    Address address1 = new Address();
    address1.setProvince("北京");
    address1.setCity("海淀区");
    addresses.add(address1);
    
    Address address2 = new Address();
    address2.setProvince("上海");
    address2.setCity("浦东新区");
    addresses.add(address2);
    return Result.success("获取地址列表成功", addresses);
  }
  @RequestMapping("/response")
  public Result response() {
    return Result.success("操作成功", null);
  }
  @RequestMapping("/response2")
  public Result response2() {
    return Result.error("操作失败");
  }
  @RequestMapping("/response3")
  public Result response3() {
    return Result.success("操作成功", "hello");
  }
}