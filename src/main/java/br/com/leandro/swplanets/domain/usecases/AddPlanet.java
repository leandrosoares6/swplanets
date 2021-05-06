package br.com.leandro.swplanets.domain.usecases;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.exceptions.PlanetExistsException;
import br.com.leandro.swplanets.domain.ports.PlanetRepository;

public class AddPlanet {
  private PlanetRepository planetRepository;

  public AddPlanet( PlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }

  public void execute(Planet planet) {
    Planet planetFromDd = planetRepository.findById(planet.getId());

    if (planetFromDd != null) {
      throw new PlanetExistsException();
    }

    planetRepository.save(planet);
  }
}
