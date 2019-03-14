package ru.ttv.meteringvaluesregistrationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MeteringvaluesregistrationserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeteringvaluesregistrationserviceApplication.class, args);
    }

}
