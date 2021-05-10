package br.com.leandro.swplanets.infrastructure.repositories.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.valueobjects.Name;

public interface SpringDataMongoPlanetRepository extends MongoRepository<Planet, Long> {
  public Planet findByName(Name name);
}
