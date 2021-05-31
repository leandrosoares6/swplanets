package br.com.leandro.swplanets.infrastructure.repositories.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.ports.IPlanetRepository;
import br.com.leandro.swplanets.domain.valueobjects.Name;

@Component
public class MongoDBPlanetRepository implements IPlanetRepository {

	private final ISpringDataMongoPlanetRepository planetRepository;

	@Autowired
	public MongoDBPlanetRepository(final ISpringDataMongoPlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}

	@Override
	public void save(Planet planet) {
		planetRepository.save(planet);
	}

	@Override
	public Optional<Planet> findById(String id) {
		return planetRepository.findById(id);
	}

	@Override
	public Planet findByName(Name name) {
		return planetRepository.findByName(name);
	}

	@Override
	public List<Planet> findAll(int page, int size) {
		PageRequest paging = PageRequest.of(page, size);
		Page<Planet> pagePlanets = planetRepository.findAll(paging);
		return pagePlanets.getContent();
	}

	@Override
	public void destroy(Planet planet) {
		planetRepository.delete(planet);
	}

}