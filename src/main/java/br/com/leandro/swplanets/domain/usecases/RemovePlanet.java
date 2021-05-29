package br.com.leandro.swplanets.domain.usecases;

import java.util.Optional;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.exceptions.EntityNotFoundException;
import br.com.leandro.swplanets.domain.ports.IPlanetRepository;

public class RemovePlanet {
  private IPlanetRepository planetRepository;

  public RemovePlanet(IPlanetRepository planetRepository) {
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
