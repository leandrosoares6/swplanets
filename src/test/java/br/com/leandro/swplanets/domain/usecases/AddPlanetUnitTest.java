package br.com.leandro.swplanets.domain.usecases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.leandro.swplanets.application.requests.PlanetRequest;
import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.ports.IPlanetRepository;

public class AddPlanetUnitTest {

	private IPlanetRepository planetRepository;

	private AddPlanet addPlanet;

	@BeforeEach
	void setUp() {
		planetRepository = mock(IPlanetRepository.class);
		addPlanet = new AddPlanet(planetRepository);
	}

	@Test
	void shouldAddPlanet_whenPassingValidData() {
		PlanetRequest planet = new PlanetRequest("Alderaan", "temperate", "grasslands");
		addPlanet.execute(planet);
		verify(planetRepository).save(any(Planet.class));
	}

}
