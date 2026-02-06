package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public void longtime(ProceedingJoinPoint joinPoint){
       long start = System.currentTimeMillis();// start codeee

        // execute the join point  ---
        try{
            joinPoint.proceed();

        }catch (Throwable e) {
            System.out.println("Something went wrong during the execution");
        } finally {
            long end = System.currentTimeMillis();

            long totalExecutionTime = end - start;

            System.out.println("Total time of execution :" + totalExecutionTime + "ms...");



        }


    }

}
