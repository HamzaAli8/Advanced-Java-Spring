package platform.codingnomads.co.corespring.lab;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean

    public Cat cat (){

        return new Cat("Leo",3);
    }

    @Bean
    public Owner owner (){

        Owner o = new Owner();
        o.setCat(cat());
        o.setName("Hamza");
        return o;
    }




}
