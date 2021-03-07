package org.example;

import org.springframework.stereotype.Component;

@Component
public class Middle implements Programmer {
    public void doCoding() {
        System.out.println("Мидл: исправил ошибки джуна");
    }
}
