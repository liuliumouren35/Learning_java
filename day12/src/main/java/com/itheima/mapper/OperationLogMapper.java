package com.itheima.mapper;

import com.itheima.pojo.OperationLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationLogMapper {

    /**
     * 插入日志数据
     * @param log OperationLog 对象
     */
    @Insert("INSERT INTO operate_log (operate_user, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "VALUES (#{operateUser}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime})")
    void insert(OperationLog log);

}  