package com.itstyle.seckill.tuomin;

import java.lang.annotation.*;

/**
 * agent-console
 *
 * @author lihongbin
 * @date2020/9/11
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Desensitized {

    /*脱敏类型(规则)*/
    SensitiveTypeEnum type();

    /*判断注解是否生效的方法*/
    String isEffictiveMethod() default "";
}
