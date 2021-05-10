package br.com.leandro.swplanets.application.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.leandro.swplanets.application.requests.PlanetRequest;
import br.com.leandro.swplanets.application.responses.PlanetResponse;
import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.ports.PlanetRepository;
import br.com.leandro.swplanets.domain.usecases.AddPlanet;
import br.com.leandro.swplanets.domain.usecases.ListPlanets;

@RestController
@RequestMapping("/planets")
public class PlanetRestController {

  @Autowired
  private PlanetRepository planetRepository;

  @GetMapping({ "", "/{page}", "/{page}/{size}" })
  public List<PlanetResponse> index(@PathVariable("page") Optional<Integer> page,
      @PathVariable("size") Optional<Integer> size) {
    ListPlanets listPlanets = new ListPlanets(planetRepository);
    List<Planet> planets = listPlanets.execute(page, size);
    Stream<PlanetResponse> planetsResponse = planets
      .stream()
      .map(planet -> new PlanetResponse(planet));
    return planetsResponse.collect(Collectors.toList());
  }

  @PostMapping
  public ResponseEntity<String> create(@RequestBody PlanetRequest request) {
    AddPlanet addPlanet = new AddPlanet(planetRepository);
    String id = addPlanet.execute(request);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(id).toUri();

			return ResponseEntity.created(uri).build();
  }
}
