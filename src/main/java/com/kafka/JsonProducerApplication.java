package com.kafka;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.constants.Constants;
import com.kafka.model.JsonProducer;

@SpringBootApplication
public class JsonProducerApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		new JsonProducer(Constants.JSON_FILE);
		
		SpringApplication.run(JsonProducerApplication.class, args);
	}

}
