package com.ljw.web.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface Mapper {
    String value() default "";
}
