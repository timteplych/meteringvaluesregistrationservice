package ru.ttv.meteringvaluesregistrationservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Teplykh Timofey  10.03.2019
 */

@Aspect
@Component
public class PerformanceLogAspect {

    @Around("execution(* ru.ttv.meteringvaluesregistrationservice.controller..*.*(..))")
    public Object AroundUserController(ProceedingJoinPoint joinPoint){
        Object value = null;
        final long begin = System.currentTimeMillis();
        try {
            value = joinPoint.proceed();
        }catch (final Throwable e){
            e.printStackTrace();
        }
        final long finish = System.currentTimeMillis();
        final long delta = finish - begin;

        final String className = joinPoint.getTarget().getClass().getSimpleName();
        final String methodName = joinPoint.getSignature().getName();
        System.out.println("LOG: "+className+"."+methodName+" "+delta+"ms.");

        return value;
    }
}
