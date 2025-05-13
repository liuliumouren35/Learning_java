package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationLog {
    private Integer id; //ID
    private Integer operateUser; //操作人ID
    private LocalDateTime operateTime; //操作时间
    private String className; //操作的类名
    private String methodName; //操作的方法名
    private String methodParams; //方法参数 (可以考虑存储为JSON字符串)
    private String returnValue; //返回值 (可以考虑存储为JSON字符串)
    private Long costTime; //方法执行耗时 (ms)
} 