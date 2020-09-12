package com.itstyle.seckill.tuomin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: qiyu
 * @Date: 2020/9/12 8:19 下午
 * @Description:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface TuominAnn {

    String value() default "";
}
