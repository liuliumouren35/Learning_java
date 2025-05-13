package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect
public class MyAspect1 {

    @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void pt(){}

    @Before("pt()")//在目标方法执行之前执行
    public void before(){
        log.info("before ...");
    }

    @Around("pt()")//在目标方法执行之前和之后执行
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before ...");

        //调用目标对象的原始方法执行
        Object result = proceedingJoinPoint.proceed();

        log.info("around after ...");
        return result;
    }

    @After("pt()")//在目标方法执行之后执行
    public void after(){
        log.info("after ...");
    }

    @AfterReturning("pt()")//在目标方法执行之后执行，如果目标方法正常执行完毕，则执行
    public void afterReturning(){
        log.info("afterReturning ...");
    }

    @AfterThrowing("pt()")//在目标方法执行之后执行，如果目标方法抛出异常，则执行
    public void afterThrowing(){
        log.info("afterThrowing ...");
    }
}
