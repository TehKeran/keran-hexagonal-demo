package org.keran.launcher.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"org.keran"})
@ComponentScan(basePackages = {"org.keran"})
public class LauncherApplication implements CommandLineRunner {


    public static void main(String[] args){
        SpringApplication.run(LauncherApplication.class, args);
        System.out.println("main method");
    }

    @Override
    public void run(String... args) {
        System.out.println("Hola chicos!");
    }
}
