package ru.ttv.meteringvaluesregistrationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.integration.annotation.IntegrationComponentScan;

@SpringBootApplication
@EnableAspectJAutoProxy
@IntegrationComponentScan
public class MeteringvaluesregistrationserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeteringvaluesregistrationserviceApplication.class, args);
    }

}
