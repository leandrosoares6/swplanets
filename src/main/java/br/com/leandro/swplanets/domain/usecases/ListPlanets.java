package br.com.leandro.swplanets.domain.usecases;

import java.util.List;
import java.util.Optional;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.ports.PlanetRepository;

public class ListPlanets {
  private PlanetRepository planetRepository;

  public ListPlanets(PlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }

  public List<Planet> execute(Optional<Integer> page, Optional<Integer> size) {
    int validPage = page.isPresent() && page.get() >= 0 ? page.get() : 0;
    int validSize = size.isPresent() && size.get() <= 50 && size.get() > 0 ? size.get() : 10;
    return planetRepository.findAll(validPage, validSize);
  }
}
