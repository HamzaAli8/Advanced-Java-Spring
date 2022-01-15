package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;





@Aspect
@Component
public class PrintableAspect {

    @Pointcut("@annotation(platform.codingnomads.co.aspectorientedprogramming.lab.config.Printable)")
    public void executePrinting(){
    }



    @Before("executePrinting()")
    public void PrintCall(JoinPoint joinPoint){


        System.out.println("Should say I am printing before this");
    }



}
