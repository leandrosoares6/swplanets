package br.com.leandro.swplanets.application.viewmodels;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import br.com.leandro.swplanets.application.responses.PlanetResponse;
import br.com.leandro.swplanets.domain.entities.Planet;

@Component
public class ListPlanetsViewModel implements IListPlanetsViewModel {

	@Override
	public List<PlanetResponse> presentPlanets(List<Planet> planets) {
		Stream<PlanetResponse> planetsResponse = planets.stream().map(planet -> new PlanetResponse(planet));
		return planetsResponse.collect(Collectors.toList());
	}

}
