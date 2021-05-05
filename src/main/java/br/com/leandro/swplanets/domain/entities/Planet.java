package br.com.leandro.swplanets.domain.entities;

import java.util.Objects;

public class Planet {
  private String name;
  private String climate;
  private String terrain;
  private String teste;

  public Planet() {
  }

  public Planet(String name, String climate, String terrain) {
    this.name = name;
    this.climate = climate;
    this.terrain = terrain;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getClimate() {
    return this.climate;
  }

  public void setClimate(String climate) {
    this.climate = climate;
  }

  public String getTerrain() {
    return this.terrain;
  }

  public void setTerrain(String terrain) {
    this.terrain = terrain;
  }

  public Planet name(String name) {
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

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Planet)) {
            return false;
        }
        Planet planet = (Planet) o;
        return Objects.equals(name, planet.name) && Objects.equals(climate, planet.climate) && Objects.equals(terrain, planet.terrain);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, climate, terrain);
  }

  @Override
  public String toString() {
    return "{" +
      " name='" + getName() + "'" +
      ", climate='" + getClimate() + "'" +
      ", terrain='" + getTerrain() + "'" +
      "}";
  }

}