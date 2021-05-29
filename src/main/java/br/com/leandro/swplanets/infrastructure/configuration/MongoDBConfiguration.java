package br.com.leandro.swplanets.infrastructure.configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.leandro.swplanets.infrastructure.repositories.mongodb.ISpringDataMongoPlanetRepository;

@EnableMongoRepositories(basePackageClasses = ISpringDataMongoPlanetRepository.class)
public class MongoDBConfiguration {
  
}
