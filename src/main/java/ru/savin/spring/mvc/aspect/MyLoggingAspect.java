package ru.savin.spring.mvc.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* ru.savin.spring.mvc.dao.*.*(..))")
    public Object aroundAllRepositoryMethodAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String methodName = methodSignature.getName();
        System.out.println("Метод начинает работу " + methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("Закончил свою работу метод " + methodName);

        return targetMethodResult;
    }

}
