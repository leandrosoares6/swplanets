package br.com.leandro.swplanets.domain.usecases;

import java.util.Optional;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.exceptions.EntityNotFoundException;
import br.com.leandro.swplanets.domain.ports.PlanetRepository;

public class FindPlanetById {
  private PlanetRepository planetRepository;

  public FindPlanetById(PlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }

  public Planet execute(Long id) {
    Optional<Planet> planetFromDd = planetRepository.findById(id);

    if (!planetFromDd.isPresent()) {
      throw new EntityNotFoundException();
    }

    return planetFromDd.get();
  }
}
