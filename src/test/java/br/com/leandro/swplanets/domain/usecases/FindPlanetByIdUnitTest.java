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

public class FindPlanetByIdUnitTest {
  private static final long INVALID_ID = 999;
  private Planet anyPlanet;
  private PlanetRepository planetRepository;
  private FindPlanetById findPlanetById;

  @BeforeEach
  void setUp() {
    anyPlanet = new Planet((long) 1, "Alderaan", "temperate", "grasslands");
    planetRepository = mock(PlanetRepository.class);
    findPlanetById = new FindPlanetById(planetRepository);
  }

  @Test
  void shouldGetPlanet_whenSearchedPlanetExists() {
    when(planetRepository.findById(anyPlanet.getId())).thenReturn(anyPlanet);
    Planet result = findPlanetById.execute(anyPlanet.getId());
    assertEquals(anyPlanet, result);
  }

  @Test
  void shouldThrowException_whenSearchedPlanetNotExists() {
    assertThrows(EntityNotFoundException.class, () -> {
      findPlanetById.execute(INVALID_ID);
    });
  }
}