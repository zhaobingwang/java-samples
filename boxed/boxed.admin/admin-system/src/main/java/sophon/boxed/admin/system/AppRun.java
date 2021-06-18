package sophon.boxed.admin.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sophon.boxed.annotation.rest.AnonymousGetMapping;

@RestController
@SpringBootApplication
public class AppRun {

    public static void main(String[] args) {
        SpringApplication.run(AppRun.class, args);
    }

    @AnonymousGetMapping("/")
    public String index() {
        return "Backend service started successfully";
    }
}
