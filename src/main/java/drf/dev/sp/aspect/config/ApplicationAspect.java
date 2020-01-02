package drf.dev.sp.aspect.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ApplicationAspect {
    @Around("@annotation(drf.dev.sp.aspect.annotation.MakeGlobalLogging)")
    public Object aroundMakeGlobalLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object obj = joinPoint.proceed();

        long end = System.currentTimeMillis();
        log.info("Method: {}, Time: {}", joinPoint.getSignature(), (end - start));

        return obj;
    }

    @Pointcut("@annotation(drf.dev.sp.aspect.annotation.MakeThrowable)")
    public void callMakeThrowable() { }

    @AfterThrowing(pointcut = "callMakeThrowable()", throwing = "exception")
    public void throwMakeThrowable(RuntimeException exception) {
        log.error("Get error: {} - {}", exception.getClass(), exception.getMessage());
    }

    @Pointcut("@annotation(drf.dev.sp.aspect.annotation.MakeTransactional)")
    public void callMakeTransactional() { }

    @Before("callMakeTransactional()")
    public void beforeMakeTransactional(JoinPoint joinPoint) {
        log.info("Start transaction: {}", joinPoint.getSignature());
    }

    @After("callMakeTransactional()")
    public void afterMakeTransactional(JoinPoint joinPoint) {
        log.info("End transaction: {}", joinPoint.getSignature());
    }

    @Pointcut("execution(* drf.dev.sp.aspect.controller.ApplicationController.index()))")
    public void callApplicationControllerIndex() { }

    @Before("callApplicationControllerIndex()")
    public void beforeApplicationControllerIndex() {
        log.info("Run: index()");
    }
}
