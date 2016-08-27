package com.liqiong.lucy.annotation;

import com.liqiong.lucy.module.Module;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by LiQiong on 2016/8/27.19:18
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
    Class<? extends Object> clazz() default Object.class;
}