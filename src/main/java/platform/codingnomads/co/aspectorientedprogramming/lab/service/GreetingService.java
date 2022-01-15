package platform.codingnomads.co.aspectorientedprogramming.lab.service;

import org.springframework.stereotype.Service;
import platform.codingnomads.co.aspectorientedprogramming.lab.config.Printable;


@Service
public class GreetingService {



    public void greeting() {


        System.out.println("Hello Code Warrior");
    }

    public void bye(){

        System.out.println("See you later Code Warrior");
    }

    @Printable
    public void print(){

        System.out.println("I am printing");
    }



}
