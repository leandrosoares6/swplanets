package br.com.leandro.swplanets.domain.ports;

import java.util.List;

import br.com.leandro.swplanets.domain.entities.Planet;

public interface PlanetRepository {
  public void save(Planet planet);

  public Planet findById(Long id);

  public List<Planet> findAll(int page, int size);
}
