package br.com.leandro.swplanets.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.exceptions.InvalidNameException;

class PlanetUnitTest {
  
  @Test
  void shouldCreateAPlanet_whenPassingValidData() {
    final Planet planet = new Planet((long) 1, "test", "test", "test");

    assertEquals(1, planet.getId());
    assertEquals("test", planet.getName().toString());
    assertEquals("test", planet.getClimate());
    assertEquals("test", planet.getTerrain());
  }

  @Test
  void shouldNotCreateAPlanet_whenPassingInvalidName() {
    assertThrows(InvalidNameException.class, () -> {
      new Planet((long) 1, "", "test", "test");
    });
  }
}
