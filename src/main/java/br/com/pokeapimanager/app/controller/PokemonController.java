package br.com.pokeapimanager.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokeapimanager.app.dto.Ability;
import br.com.pokeapimanager.app.dto.Move;
import br.com.pokeapimanager.app.dto.PokemonDto;
import br.com.pokeapimanager.app.entity.Team;
import br.com.pokeapimanager.app.entity.User;
import br.com.pokeapimanager.app.sevice.PokemonService;
import br.com.pokeapimanager.app.sevice.TeamService;
import br.com.pokeapimanager.app.sevice.UserService;

@RestController
public class PokemonController {

	private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);
	
	@Autowired
	private PokemonService pokemonService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    TeamService teamService;

	@RequestMapping(value = "/pokemons", method = RequestMethod.GET)
	public @ResponseBody List<PokemonDto> pokemonList() {
		logger.debug("get json pokemons list");
		List<PokemonDto> pokemons = pokemonService.getAllPokemonSimple();
		System.out.println(pokemons.size());		
		return pokemons;
	}
	
	@RequestMapping(value = "/abilities", method = RequestMethod.GET)
	public @ResponseBody List<Ability> abilityList() {
		logger.debug("get json abilities list");
		List<Ability> abilities = pokemonService.getAllAbilitiesSimple();
		System.out.println(abilities.size());		
		return abilities;
	}
	
	@RequestMapping(value = "/moves", method = RequestMethod.GET)
	public @ResponseBody List<Move> moveList() {
		logger.debug("get json moves list");
		List<Move> moves = pokemonService.getAllMovesSimple();
		System.out.println(moves.size());		
		return moves;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/addMove", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Move>> addMove(String userName, String teamName, String pokemonName, String moveName) {
		logger.debug("adding a move to pokemon" + moveName);
		boolean result = pokemonService.addMove(userName, teamName, pokemonName, moveName);
		logger.debug("added move result" + result);
		List<Move> moves = pokemonService.getMovesByTeam(userName, teamName, pokemonName);
		if (result) {
			return new ResponseEntity<List<Move>>(moves, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Move>>(moves, HttpStatus.SEE_OTHER);
		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/removeMove", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Move>> removeMove(String userName, String teamName, String pokemonName, String moveName) {
		logger.debug("removing a move to pokemon" + moveName);
		boolean result = pokemonService.removeMove(userName, teamName, pokemonName, moveName);
		logger.debug("removed move result" + result);
		List<Move> moves = pokemonService.getMovesByTeam(userName, teamName, pokemonName);
		if (result) {
			return new ResponseEntity<List<Move>>(moves, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Move>>(moves, HttpStatus.SEE_OTHER);
		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/getPokemonByTeam", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<PokemonDto> getPokemonByTeam(String userName, String teamName, String pokemonName) {
		logger.debug("finding a pokemon" + pokemonName);
		PokemonDto pokemon = pokemonService.getPokemonByTeam(userName, teamName, pokemonName);
		return new ResponseEntity<PokemonDto>(pokemon, HttpStatus.OK);			
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/addPokemon", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<PokemonDto>> addPokemon(String userName, String teamName, String pokemonName) {
		logger.debug("adding pokemon to team " + pokemonName);
		PokemonDto pokemon = new PokemonDto();
		pokemon.get(pokemonName);
		User user = new User(userName, "");
		boolean result = teamService.addPokemonToTeam(user, teamName, pokemon);
		logger.debug("added pokemon result" + result);
		Team team = teamService.findTeam(user, teamName);
		if (result) {
			return new ResponseEntity<List<PokemonDto>>(team.getPokemons(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<PokemonDto>>(team.getPokemons(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/removePokemon", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<PokemonDto>> removePokemon(String userName, String teamName, String pokemonName) {
		logger.debug("adding pokemon to team " + pokemonName);
		PokemonDto pokemon = new PokemonDto();
		pokemon.setName(pokemonName);
		User user = new User(userName, "");
		boolean result = teamService.removePokemonToTeam(user, teamName, pokemon);
		logger.debug("added pokemon result" + result);
		Team team = teamService.findTeam(user, teamName);
		if (result) {			
			return new ResponseEntity<List<PokemonDto>>(team.getPokemons(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<PokemonDto>>(team.getPokemons(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> registerUser(String userName, String password) {
		logger.debug("creating a user " + userName);
		boolean result = userService.createUser(userName, password);
		logger.debug("create user result" + result);
		
		if (result) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.SEE_OTHER);
		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> login(String userName, String password) {
		logger.debug("creating a user " + userName);
		boolean result = userService.login(userName, password);
		logger.debug("create user result" + result);
		
		if (result) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.SEE_OTHER);
		}
	}
}