package drf.dev.sp.aspect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"drf.dev.sp.aspect.config", "drf.dev.sp.aspect.controller"})
@SpringBootApplication
public class SpringAspectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringAspectApplication.class, args);
    }
}
