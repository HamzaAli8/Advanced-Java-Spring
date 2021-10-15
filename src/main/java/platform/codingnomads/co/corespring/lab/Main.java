package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);

            Cat x = ctx.getBean(Cat.class);
            Owner o = ctx.getBean(Owner.class);

        System.out.println(x);
        System.out.println(o);

    }
}
