package br.com.leandro.swplanets.infrastructure.repositories.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.ports.PlanetRepository;
import br.com.leandro.swplanets.domain.valueobjects.Name;

@Component
public class MongoDBPlanetRepository implements PlanetRepository {

  private final SpringDataMongoPlanetRepository planetRepository;

  @Autowired
  public MongoDBPlanetRepository(final SpringDataMongoPlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }

  @Override
  public void save(Planet planet) {
    planetRepository.save(planet);
  }

  @Override
  public Optional<Planet> findById(String id) {
    return planetRepository.findById(id);
  }

  @Override
  public Planet findByName(Name name) {
    return planetRepository.findByName(name);
  }

  @Override
  public List<Planet> findAll(int page, int size) {
    return planetRepository.findAll();
  }

  @Override
  public void destroy(Planet planet) {
    planetRepository.delete(planet);
  }

}