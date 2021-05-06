package br.com.leandro.swplanets.domain.usecases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.ports.PlanetRepository;

public class AddPlanetUnitTest {
  private PlanetRepository planetRepository;
  private AddPlanet addPlanet;

  @BeforeEach
  void setUp() {
    planetRepository = mock(PlanetRepository.class);
    addPlanet = new AddPlanet(planetRepository);
  }

  @Test
  void shouldAddPlanet_whenPassingValidData() {
    Planet planet = new Planet((long) 1, "Alderaan", "temperate", "grasslands");
    addPlanet.execute(planet);

    verify(planetRepository).findById(planet.getId());
    verify(planetRepository).save(any(Planet.class));
  }
}
