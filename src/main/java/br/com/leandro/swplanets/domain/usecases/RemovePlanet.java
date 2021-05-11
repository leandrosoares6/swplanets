package br.com.leandro.swplanets.domain.usecases;

import java.util.Optional;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.exceptions.EntityNotFoundException;
import br.com.leandro.swplanets.domain.ports.PlanetRepository;

public class RemovePlanet {
  private PlanetRepository planetRepository;

  public RemovePlanet(PlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }

  public void execute(String id) {
    Optional<Planet> planetFromDd = planetRepository.findById(id);

    if (!planetFromDd.isPresent()) {
      throw new EntityNotFoundException("Entity not found.");
    }

    planetRepository.destroy(planetFromDd.get());
  }
}
