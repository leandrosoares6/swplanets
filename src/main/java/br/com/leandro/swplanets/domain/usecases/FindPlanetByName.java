package br.com.leandro.swplanets.domain.usecases;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.exceptions.EntityNotFoundException;
import br.com.leandro.swplanets.domain.ports.IPlanetRepository;
import br.com.leandro.swplanets.domain.valueobjects.Name;

public class FindPlanetByName {

	private IPlanetRepository planetRepository;

	public FindPlanetByName(IPlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}

	public Planet execute(Name name) {
		Planet planetFromDd = planetRepository.findByName(name);

		if (planetFromDd == null) {
			throw new EntityNotFoundException("Entity not found.");
		}

		return planetFromDd;
	}

}
