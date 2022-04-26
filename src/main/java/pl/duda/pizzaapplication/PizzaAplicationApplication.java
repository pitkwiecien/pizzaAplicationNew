package pl.duda.pizzaapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PizzaAplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaAplicationApplication.class, args);
    }

}
