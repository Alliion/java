package com.example.pr24.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeAspect {
    /**
     * Логирует время выполнеяния метода
     * @param joinPoint
     * @return результат метода на которого повесели анотацию
     * @throws Throwable
     */
    @Around(value = "@annotation(com.example.pr24.annotations.LogTime)")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long timeStart = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long timeWork = System.currentTimeMillis() - timeStart;

        log.info(joinPoint.getSignature() + " worked for " + timeWork + "ms");

        return proceed;
    }
}
