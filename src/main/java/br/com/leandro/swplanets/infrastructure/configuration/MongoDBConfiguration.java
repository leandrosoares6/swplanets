package br.com.leandro.swplanets.infrastructure.configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.leandro.swplanets.infrastructure.repositories.mongodb.SpringDataMongoPlanetRepository;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoPlanetRepository.class)
public class MongoDBConfiguration {
  
}
