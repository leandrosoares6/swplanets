package br.com.leandro.swplanets.domain.usecases;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.leandro.swplanets.application.viewmodels.IListPlanetsViewModel;
import br.com.leandro.swplanets.domain.ports.IPlanetRepository;

public class ListPlanetsUnitTest {

	private IPlanetRepository planetRepository;

	private ListPlanets listPlanets;

	@BeforeEach
	void setUp() {
		planetRepository = mock(IPlanetRepository.class);
		IListPlanetsViewModel viewModel = mock(IListPlanetsViewModel.class);
		listPlanets = new ListPlanets(planetRepository, viewModel);
	}

	@Test
	void shouldListAllPlanets() {
		listPlanets.execute(Optional.of(1), Optional.of(10));
		verify(planetRepository).findAll(1, 10);
	}

}
