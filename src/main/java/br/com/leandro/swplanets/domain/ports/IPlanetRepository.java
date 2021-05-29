package br.com.leandro.swplanets.domain.ports;

import java.util.List;
import java.util.Optional;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.valueobjects.Name;

public interface IPlanetRepository {
  public void save(Planet planet);

  public Optional<Planet> findById(String id);

  public Planet findByName(Name name);

  public List<Planet> findAll(int page, int size);

  public void destroy(Planet planet);
}
