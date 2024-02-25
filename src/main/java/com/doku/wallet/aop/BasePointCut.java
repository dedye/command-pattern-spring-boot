package com.doku.wallet.aop;
import org.aspectj.lang.annotation.Pointcut;

public class BasePointCut {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restController() {
        // Do nothing because of X and Y.
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RestControllerAdvice *)")
    public void restControllerAdvice() {
        // Do nothing because of X and Y.
    }

    @Pointcut("@annotation(com.doku.wallet.annotation.Role)")
    public void role() {
        // Do nothing because of X and Y.
    }

    @Pointcut("execution(* *.*(..))")
    public void allMethod() {
        // Do nothing because of X and Y.
    }

    @Pointcut("execution(public * *(..))")
    public void publicOperation() {
        // Do nothing because of X and Y.
    }

    @Pointcut("within(com.doku.wallet..*)")
    public void logAnyFunctionWithinResource() {
        // Do nothing because of X and Y.
    }
}
