package br.com.leandro.swplanets.domain.usecases;

import java.util.Optional;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.exceptions.EntityExistsException;
import br.com.leandro.swplanets.domain.ports.PlanetRepository;

public class AddPlanet {
  private PlanetRepository planetRepository;

  public AddPlanet( PlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }

  public void execute(Planet planet) {
    Optional<Planet> planetFromDd = planetRepository.findById(planet.getId());

    if (planetFromDd.isPresent()) {
      throw new EntityExistsException();
    }

    planetRepository.save(planet);
  }
}
