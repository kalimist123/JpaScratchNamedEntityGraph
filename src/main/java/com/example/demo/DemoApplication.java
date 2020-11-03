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


            Product product1  = new Product();
            product1.setName("p1");

            OrderItem orderItem1  = new OrderItem();






            Employee employee = new Employee();
            employee.setId(new EmployeeId(1L, 100L));
            employee.setName("Vlad Mihalcea");


            employeeRepository.save(employee);
           Optional<Employee> employee1 =  employeeRepository.findById(new EmployeeId(1L, 100L));
           if(employee1.isPresent())
           {
               Employee employeefound = employee1.get();
               log.info("employee found with name:" + employeefound.getName());
           }
            // save a few customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }


}
