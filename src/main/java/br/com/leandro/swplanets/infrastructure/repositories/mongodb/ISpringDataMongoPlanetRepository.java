package br.com.leandro.swplanets.infrastructure.repositories.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.valueobjects.Name;

@Repository
public interface ISpringDataMongoPlanetRepository extends MongoRepository<Planet, String> {

	public Planet findByName(Name name);

}
