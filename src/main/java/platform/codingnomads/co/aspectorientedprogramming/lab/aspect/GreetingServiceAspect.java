package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServiceAspect {

    @Before("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    public void before(){
        System.out.println("Before");
    }

    @After("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    public void after(){

        System.out.println("After");
    }

    @AfterReturning("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    public void afterReturning(){

        System.out.println("After Returning");
    }

    @AfterThrowing("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    public void afterThrowing(){

        System.out.println("After Throwing Exception");
    }


    @Before("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.bye())")
    public void before2(){
        System.out.println("Before 2");
    }








}
