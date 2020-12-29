package com.hzy.aspect;

import com.hzy.annotation.MyLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @Author: hzy
 * @Date: 2020/12/29
 */
@Aspect // 1.表明这是一个切面类
@Component
public class MyLogAspect {

    // 2. PointCut表示这是一个切点，@annotation表示这个切点切到一个注解上，后面带该注解的全类名
    // 切面最主要的就是切点，所有的故事都围绕切点发生
    // logPointCut()代表切点名称
    @Pointcut("@annotation(com.hzy.annotation.MyLog)")
    public void logPointCut(){};

    // 3. 通知
    @After("logPointCut() && @annotation(myLog)")
    public void logAfter(MyLog myLog) {
        System.out.println("方法执行前" + myLog.value());
    }
}