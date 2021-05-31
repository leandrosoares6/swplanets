package br.com.leandro.swplanets.application.responses;

import br.com.leandro.swplanets.domain.entities.Planet;

public class PlanetResponse {

	private final String id;

	private final String name;

	private final String climate;

	private final String terrain;

	public PlanetResponse(Planet planet) {
		this.id = planet.getId();
		this.name = planet.getName().toString();
		this.climate = planet.getClimate();
		this.terrain = planet.getTerrain();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getClimate() {
		return climate;
	}

	public String getTerrain() {
		return terrain;
	}

}
