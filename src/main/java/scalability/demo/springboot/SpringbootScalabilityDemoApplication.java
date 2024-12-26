package scalability.demo.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringbootScalabilityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootScalabilityDemoApplication.class, args);
    }

}
