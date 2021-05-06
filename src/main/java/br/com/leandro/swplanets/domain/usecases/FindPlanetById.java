package br.com.leandro.swplanets.domain.usecases;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.exceptions.EntityNotFoundException;
import br.com.leandro.swplanets.domain.ports.PlanetRepository;

public class FindPlanetById {
  private PlanetRepository planetRepository;

  public FindPlanetById(PlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }

  public Planet execute(Long id) {
    Planet planetFromDd = planetRepository.findById(id);

    if (planetFromDd == null) {
      throw new EntityNotFoundException();
    }

    return planetFromDd;
  }
}
