package br.com.leandro.swplanets.application.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leandro.swplanets.domain.entities.Planet;
import br.com.leandro.swplanets.domain.ports.PlanetRepository;
import br.com.leandro.swplanets.domain.usecases.ListPlanets;

@RestController
@RequestMapping("/planets")
public class PlanetRestController {

  @Autowired
  private PlanetRepository planetRepository;

  @GetMapping({ "", "/{page}", "/{page}/{size}" })
  public List<Planet> index(@PathVariable("page") Optional<Integer> page,
      @PathVariable("size") Optional<Integer> size) {
    ListPlanets listPlanets = new ListPlanets(planetRepository);
    return listPlanets.execute(page, size);
  }
}
