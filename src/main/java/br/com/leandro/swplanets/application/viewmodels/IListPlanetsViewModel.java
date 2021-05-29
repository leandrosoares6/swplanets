package br.com.leandro.swplanets.application.viewmodels;

import java.util.List;

import br.com.leandro.swplanets.application.responses.PlanetResponse;
import br.com.leandro.swplanets.domain.entities.Planet;

public interface IListPlanetsViewModel {
  List<PlanetResponse> presentPlanets(List<Planet> planets);
}
