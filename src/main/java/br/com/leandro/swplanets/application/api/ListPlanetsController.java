package br.com.leandro.swplanets.application.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.leandro.swplanets.application.responses.PlanetResponse;
import br.com.leandro.swplanets.application.viewmodels.IListPlanetsViewModel;
import br.com.leandro.swplanets.domain.ports.IPlanetRepository;
import br.com.leandro.swplanets.domain.usecases.ListPlanets;

@RestController
@RequestMapping("/planets")
public class ListPlanetsController {

	@Autowired
	private IPlanetRepository planetRepository;

	@Autowired
	private IListPlanetsViewModel viewModel;

	@GetMapping
	public List<PlanetResponse> index(@RequestParam(name = "page") Optional<Integer> page,
			@RequestParam(name = "size") Optional<Integer> size) {
		ListPlanets listPlanets = new ListPlanets(planetRepository, viewModel);
		return listPlanets.execute(page, size);
	}

}
