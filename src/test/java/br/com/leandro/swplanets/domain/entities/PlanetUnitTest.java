package br.com.leandro.swplanets.domain.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import br.com.leandro.swplanets.domain.exceptions.DomainException;

class PlanetUnitTest {
  
  @Test
  void shouldCreatePlanetObject_whenPassingValidData() {
    final Planet planet = new Planet("Tatooine", "arid", "desert");

    assertTrue(UUID.fromString(planet.getId()) instanceof UUID);
    assertEquals("Tatooine", planet.getName().toString());
    assertEquals("arid", planet.getClimate());
    assertEquals("desert", planet.getTerrain());
  }

  @Test
  void shouldNotCreatePlanetObject_whenPassingInvalidName() {
    assertThrows(DomainException.class, () -> {
      new Planet("", "arid", "desert");
    });
  }
}
