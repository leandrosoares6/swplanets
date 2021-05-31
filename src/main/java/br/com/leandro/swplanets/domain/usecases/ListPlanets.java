package br.com.leandro.swplanets.domain.usecases;

import java.util.List;
import java.util.Optional;

import br.com.leandro.swplanets.application.responses.PlanetResponse;
import br.com.leandro.swplanets.application.viewmodels.IListPlanetsViewModel;
import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.ports.IPlanetRepository;
import br.com.leandro.swplanets.domain.usecases.boundaries.inputs.IListPlanets;

public class ListPlanets implements IListPlanets {

	private IPlanetRepository planetRepository;

	private IListPlanetsViewModel viewModel;

	public ListPlanets(IPlanetRepository planetRepository, IListPlanetsViewModel viewModel) {
		this.planetRepository = planetRepository;
		this.viewModel = viewModel;
	}

	public List<PlanetResponse> execute(Optional<Integer> page, Optional<Integer> size) {
		int validPage = page.isPresent() && page.get() >= 0 ? page.get() : 0;
		int validSize = size.isPresent() && size.get() <= 50 && size.get() > 0 ? size.get() : 10;
		List<Planet> planets = planetRepository.findAll(validPage, validSize);
		return viewModel.presentPlanets(planets);
	}

}
