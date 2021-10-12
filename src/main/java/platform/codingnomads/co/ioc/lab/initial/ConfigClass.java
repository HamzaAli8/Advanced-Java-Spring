package platform.codingnomads.co.ioc.lab.initial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("platform.codingnomads.co.ioc.lab.initial")
public class ConfigClass {

    @Bean
    public Framework framework() {
        return Framework.builder().name("Spring Boot").version("2.6").build();
    }

    @Bean
    public IDE ide2() {
        return IDE.builder().name("IntelliJ IDEA").version("2022.1").build();
    }

    @Bean
    public IDE ide(){

        return IDE.builder().name("New IntelliJ IDEA2").version("20221.2").build();
    }

    @Bean
    public JDK jdk() {
        return JDK.builder().name("OpenJDK").version("11").build();
    }

    @Bean
    public Computer computer() {
        return Computer.builder().name("MacBook Air").version("15").build();
    }

    @Bean
    public OperatingSystem operatingSystem() {
        return OperatingSystem.builder().name("Big Sur").version("11.5.2").build();
    }
}
