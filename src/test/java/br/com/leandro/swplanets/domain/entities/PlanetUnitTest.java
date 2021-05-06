package br.com.leandro.swplanets.domain.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.leandro.swplanets.domain.exceptions.InvalidNameException;

class PlanetUnitTest {
  
  @Test
  void shouldCreatePlanetObject_whenPassingValidData() {
    final Planet planet = new Planet((long) 1, "Tatooine", "arid", "desert");

    assertEquals(1, planet.getId());
    assertEquals("Tatooine", planet.getName().toString());
    assertEquals("arid", planet.getClimate());
    assertEquals("desert", planet.getTerrain());
  }

  @Test
  void shouldNotCreatePlanetObject_whenPassingInvalidName() {
    assertThrows(InvalidNameException.class, () -> {
      new Planet((long) 1, "", "arid", "desert");
    });
  }
}
