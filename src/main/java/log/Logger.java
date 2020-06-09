package log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class Logger {
    @AfterReturning(pointcut = "within(service.impl.*)", returning = "result")
    public void log(JoinPoint joinPoint, Object result) {
        System.out.println("[MyLogger] @AfterReturning");
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[MyLogger] executed %s.%s [args=%s]", className, methodName, args));
        String strResult = (result == null) ? "[null]" : result.toString();
        System.out.println("[MyLogger] Result: " + strResult);
    }
}
