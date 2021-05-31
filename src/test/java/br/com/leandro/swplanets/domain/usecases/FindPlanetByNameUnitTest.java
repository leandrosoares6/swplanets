package br.com.leandro.swplanets.domain.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.exceptions.EntityNotFoundException;
import br.com.leandro.swplanets.domain.exceptions.DomainException;
import br.com.leandro.swplanets.domain.ports.IPlanetRepository;
import br.com.leandro.swplanets.domain.valueobjects.Name;

public class FindPlanetByNameUnitTest {

	private static final String INVALID_NAME = "";

	private Planet anyPlanet;

	private IPlanetRepository planetRepository;

	private FindPlanetByName findPlanetByName;

	@BeforeEach
	void setUp() {
		anyPlanet = new Planet("Alderaan", "temperate", "grasslands");
		planetRepository = mock(IPlanetRepository.class);
		findPlanetByName = new FindPlanetByName(planetRepository);
	}

	@Test
	void shouldGetPlanet_whenSearchedPlanetExists() {
		Name name = new Name("Alderaan");
		when(planetRepository.findByName(name)).thenReturn(anyPlanet);
		Planet result = findPlanetByName.execute(name);
		assertEquals(anyPlanet, result);
	}

	@Test
	void shouldThrowException_whenSearchedPlanetNotExists() {
		assertThrows(EntityNotFoundException.class, () -> {
			findPlanetByName.execute(new Name("INVALID_PLANET"));
		});
	}

	@Test
	void shouldThrowException_whenPassingInvalidName() {
		assertThrows(DomainException.class, () -> {
			findPlanetByName.execute(new Name(INVALID_NAME));
		});
	}

}
