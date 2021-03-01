package tech.kbth.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class Application {
    public static void main(String[] args) {
       ConfigurableApplicationContext context =  SpringApplication.run(Application.class,args);
        System.out.println(context.getBeanDefinitionCount());
    }
}
