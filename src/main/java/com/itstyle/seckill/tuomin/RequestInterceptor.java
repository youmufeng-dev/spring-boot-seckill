package com.itstyle.seckill.tuomin;

import com.itstyle.seckill.common.entity.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @Author: qiyu
 * @Date: 2020/9/12 6:20 下午
 * @Description:
 */
@Aspect
@Component

public class RequestInterceptor {

    //定义一个空方法 借用其注解抽取切点表达式
    @Pointcut("@annotation(com.itstyle.seckill.tuomin.TuominAnn) ")
    public void point() {}

    @Before("point()")
    public void before(JoinPoint joinPoint) throws Exception{
        System.out.println("进入脱敏 aop-----------------------");
    }


    @Around("point()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Class returnType=((MethodSignature)pjp.getSignature()).getReturnType();
        System.out.println(returnType);
        System.out.println(pjp.getTarget().getClass());
        Object object = pjp.proceed();    //运行doSth()，返回值用一个Object类型来接收
        //object = "Mission Two111";   //改变返回值
        if(returnType.isInstance(object)) {
            returnType.cast(object);
        }
        Result result = (Result)object;
        Object o = result.get("msg");

        if(o instanceof List) {
            DesensitizedUtils.desensitizedList((List<? extends Object>) o);
        }else if(o instanceof Page){
            DesensitizedUtils.desensitizedPage((Page)o);
        }else {
            DesensitizedUtils.getJson(o);
        }

        result.put("msg",o);
    /*    String name = init().getFiled();
        Field[] fields = User.class.getDeclaredFields();
        for(Field field : fields) {
            String name2 = field.getName();
            System.out.println("attribute name:"+name2);

            if(name2.equals(name)) {
                name2 = name2.substring(0,1).toUpperCase()+name2.substring(1); //将属性的首字符大写，方便构造get，set方法
                String rule = initrule().getRule();//获取脱敏规则
                Method m = returnType.getMethod("set"+name2, new Class[] {String.class});//获取到setter方法
                Method m2 = returnType.getMethod("get"+name2);//获取到getter方法
                String value = (String) m2.invoke(object); //执行getter方法
                setNewField(rule,object,m,value);

            }
        }*/
        return result;
    }



    @After("point()")
    public void after(JoinPoint joinPoint){
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            System.out.println(joinPoint.getArgs()[i]);
        }
        System.out.println(joinPoint.getSignature().getName());

        System.out.println("=====checkSecurity====");

    }


}
