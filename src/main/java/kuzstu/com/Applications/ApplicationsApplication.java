package kuzstu.com.Applications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:beans.xml"})
public class ApplicationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationsApplication.class, args);
	}

}
