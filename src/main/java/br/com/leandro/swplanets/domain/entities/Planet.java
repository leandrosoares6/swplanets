package br.com.leandro.swplanets.domain.entities;

import java.util.Objects;

import br.com.leandro.swplanets.domain.valueobjects.Name;

public class Planet {
  private Long id;
  private Name name;
  private String climate;
  private String terrain;

  public Planet() {
  }

  public Planet(Long id, String name, String climate, String terrain) {
    this(id, new Name(name), climate, terrain);
  }

  public Planet(Long id, Name name, String climate, String terrain) {
    this.id = id;
    this.name = name;
    this.climate = climate;
    this.terrain = terrain;
  }

  public Long getId() {
    return id;
  }

  public Name getName() {
    return this.name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public String getClimate() {
    return climate;
  }

  public void setClimate(String climate) {
    this.climate = climate;
  }

  public String getTerrain() {
    return terrain;
  }

  public void setTerrain(String terrain) {
    this.terrain = terrain;
  }

  public Planet name(Name name) {
    setName(name);
    return this;
  }

  public Planet climate(String climate) {
    setClimate(climate);
    return this;
  }

  public Planet terrain(String terrain) {
    setTerrain(terrain);
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Planet id(Long id) {
    setId(id);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Planet)) {
      return false;
    }
    Planet planet = (Planet) o;
    return Objects.equals(id, planet.id) && Objects.equals(name, planet.name) && Objects.equals(climate, planet.climate)
        && Objects.equals(terrain, planet.terrain);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, climate, terrain);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", climate='" + getClimate() + "'"
        + ", terrain='" + getTerrain() + "'" + "}";
  }

}