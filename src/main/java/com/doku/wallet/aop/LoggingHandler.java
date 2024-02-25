package com.doku.wallet.aop;

import com.doku.wallet.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import reactor.core.publisher.Mono;
import java.util.Optional;

@Slf4j
@Aspect
@Component
public class LoggingHandler extends BasePointCut {

    @Autowired
    private JsonUtils jsonUtils;

    @Before("restController() && allMethod() && args(..)")
    public void logBefore(JoinPoint joinPoint) {
        Object request = Optional.ofNullable(joinPoint)
                .filter(j -> j.getArgs().length > 0)
                .map(l -> l.getArgs()[0])
                .orElse(null);
        log.info("REQUEST DATA : {}",jsonUtils.toJsonStringFromServletRequest(request));
    }

    @AfterReturning(pointcut = "restControllerAdvice() && allMethod()", returning = "response")
    public void logAfterError(Object response) {
        log.warn("RESPONSE ERROR : {}",jsonUtils.toJsonStringFromObject(response));
    }

    @SuppressWarnings("unchecked")
    @Around("restController() && allMethod()")
    public Mono<Object> logAround(ProceedingJoinPoint proceedingJoinPoint) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Mono<Object> mono;
        try {
            mono = (Mono<Object>) proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }

        stopWatch.stop();
        log.info("Execution time with class : {}, method : {}, and time : {} ms",
                proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                proceedingJoinPoint.getSignature().getName(),
                stopWatch.getTotalTimeMillis());

        return mono.doOnNext(data -> log.info("RESPONSE DATA : {}",jsonUtils.toJsonStringFromObject(data)));
    }
}
