package pkg_password_id;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class idApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.example.hanghaememo.HanghaememoApplication.class, args);
    }

}

