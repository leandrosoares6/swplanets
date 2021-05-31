package br.com.leandro.swplanets.domain.usecases.boundaries.inputs;

import java.util.List;
import java.util.Optional;

import br.com.leandro.swplanets.application.responses.PlanetResponse;

public interface IListPlanets {

	List<PlanetResponse> execute(Optional<Integer> page, Optional<Integer> size);

}
