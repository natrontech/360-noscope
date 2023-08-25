package io.natron.noscope360.analyze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class AnalyzeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyzeApplication.class, args);
	}

}
