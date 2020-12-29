package com.hzy.annotation;

import java.lang.annotation.*;

/**
 * @Author: hzy
 * @Date: 2020/12/29
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
    String value() default "hello world";
}