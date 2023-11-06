package ma.nemo.assignment;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
@RestController
public class NiceStoreApplication implements CommandLineRunner, WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(NiceStoreApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
	}
}
