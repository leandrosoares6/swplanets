package br.com.leandro.swplanets.domain.usecases;

import br.com.leandro.swplanets.application.requests.PlanetRequest;
import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.exceptions.EntityExistsException;
import br.com.leandro.swplanets.domain.ports.IPlanetRepository;
import br.com.leandro.swplanets.domain.valueobjects.Name;

public class AddPlanet {
  private IPlanetRepository planetRepository;

  public AddPlanet(IPlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }

  public String execute(PlanetRequest planetRequest) {
    Planet planetFromDd = planetRepository
      .findByName(new Name(planetRequest.getName()));

    if (planetFromDd != null) {
      throw new EntityExistsException("Entity already exists.");
    }

    Planet planet = new Planet(
      planetRequest.getName(),
      planetRequest.getClimate(),
      planetRequest.getTerrain()
    );

    planetRepository.save(planet);

    return planet.getId();
  }
}
