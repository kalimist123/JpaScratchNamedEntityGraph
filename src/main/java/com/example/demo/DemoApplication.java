package com.example.demo;

import com.example.demo.models.*;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

//https://vladmihalcea.com/the-best-way-to-map-a-composite-primary-key-with-jpa-and-hibernate/
//https://vladmihalcea.com/a-beginners-guide-to-jpa-and-hibernate-cascade-types/

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args)
    {

        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);

    }


    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    @Bean
    public CommandLineRunner demo(CustomerRepository repository, EmployeeRepository employeeRepository,
                                  OrderRepository orderRepository, PostRepository postRepository) {
        return (args) -> {


            List<Post> posts = postRepository.findAll();



        };
    }


}
