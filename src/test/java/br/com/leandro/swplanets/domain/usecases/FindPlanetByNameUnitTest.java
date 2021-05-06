package br.com.leandro.swplanets.domain.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.exceptions.EntityNotFoundException;
import br.com.leandro.swplanets.domain.ports.PlanetRepository;

public class FindPlanetByNameUnitTest {
  private static final String INVALID_NAME = "";
  private Planet anyPlanet;
  private PlanetRepository planetRepository;
  private FindPlanetByName findPlanetByName;

  @BeforeEach
  void setUp() {
    anyPlanet = new Planet((long) 1, "Alderaan", "temperate", "grasslands");
    planetRepository = mock(PlanetRepository.class);
    findPlanetByName = new FindPlanetByName(planetRepository);
  }

  @Test
  void shouldGetPlanet_whenSearchedPlanetExists() {
    when(planetRepository.findByName("Alderaan")).thenReturn(anyPlanet);
    Planet result = findPlanetByName.execute("Alderaan");
    assertEquals(anyPlanet, result);
  }

  @Test
  void shouldThrowException_whenSearchedPlanetNotExists() {
    assertThrows(EntityNotFoundException.class, () -> {
      findPlanetByName.execute(INVALID_NAME);
    });
  }
}
