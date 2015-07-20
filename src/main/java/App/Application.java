package App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Dinesh on 7/19/2015.
 */
@SpringBootApplication
@EntityScan("model")
@EnableJpaRepositories("dao")
@ComponentScan("controller")
public class Application {
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }
}
