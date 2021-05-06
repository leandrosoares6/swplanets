package br.com.leandro.swplanets.domain.ports;

import br.com.leandro.swplanets.domain.entities.Planet;

public interface PlanetRepository {
  void save(Planet planet);
  Planet findById(Long id);
}
