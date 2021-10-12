package platform.codingnomads.co.ioc.lab.initial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
            ApplicationContext ctx = new AnnotationConfigApplicationContext(
                    ConfigClass.class);
            TechClass Tech = ctx.getBean(TechClass.class);
            System.out.println(Tech.createAwesomeSoftware());
        }
}
