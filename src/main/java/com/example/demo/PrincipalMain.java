package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PrincipalMain {


    public static void main(String[] args) {

        SpringApplication.run(PrincipalMain.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/primeFactors")
    public String primeFactors(@RequestParam(value = "number", defaultValue = "1") int number) {
        String ret="[";
        int result=number;

        while (result!=1){
            int divid=2;
            while (result%divid != 0){
                divid++;
            }
            ret=ret+""+divid;
            result = result/divid;
            if (result!=1) ret=ret+",";
        }
        //ret=ret+"]";

        return String.format("\"number\" : %d,\n \"decomposition\" : %s]", number , ret);
    }

}
