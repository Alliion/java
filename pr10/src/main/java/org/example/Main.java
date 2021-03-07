package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Programmer junior = context.getBean("junior", Junior.class);
        Programmer middle = context.getBean("middle", Middle.class);
        Programmer senior = context.getBean("senior", Senior.class);

        junior.doCoding();
        middle.doCoding();
        senior.doCoding();
    }
}
