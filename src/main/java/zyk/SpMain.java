package zyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpMain {


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpMain.class);
        application.run(args);
    }

}
