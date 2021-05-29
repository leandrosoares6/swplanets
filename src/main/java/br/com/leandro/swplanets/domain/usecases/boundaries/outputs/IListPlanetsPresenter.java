package br.com.leandro.swplanets.domain.usecases.boundaries.outputs;

import java.util.List;

import br.com.leandro.swplanets.domain.entities.Planet;

public interface IListPlanetsPresenter {
  void present(List<Planet> planet);
}
