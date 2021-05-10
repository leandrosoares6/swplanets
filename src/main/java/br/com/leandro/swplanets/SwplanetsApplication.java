package br.com.leandro.swplanets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SwplanetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwplanetsApplication.class, args);
	}

	@Autowired
    public ConfigurableApplicationContext context;

}
