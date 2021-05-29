package br.com.leandro.swplanets.domain.usecases;

import java.util.Optional;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.exceptions.EntityNotFoundException;
import br.com.leandro.swplanets.domain.ports.IPlanetRepository;

public class FindPlanetById {
  private IPlanetRepository planetRepository;

  public FindPlanetById(IPlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }

  public Planet execute(String id) {
    Optional<Planet> planetFromDd = planetRepository.findById(id);

    if (!planetFromDd.isPresent()) {
      throw new EntityNotFoundException("Entity not found.");
    }

    return planetFromDd.get();
  }
}
