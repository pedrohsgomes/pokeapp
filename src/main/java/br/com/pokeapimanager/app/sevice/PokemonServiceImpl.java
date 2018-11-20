package br.com.pokeapimanager.app.sevice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.pokeapimanager.app.controller.AbilityPage;
import br.com.pokeapimanager.app.controller.MovePage;
import br.com.pokeapimanager.app.controller.PokemonPage;
import br.com.pokeapimanager.app.dto.Ability;
import br.com.pokeapimanager.app.dto.Move;
import br.com.pokeapimanager.app.dto.PokemonDto;
import br.com.pokeapimanager.app.entity.Team;
import br.com.pokeapimanager.app.entity.User;

@Service("pokemonService")
public class PokemonServiceImpl implements PokemonService {
	
	@Autowired
    TeamService teamService;

	/* 
	 * return a list of all simple pokemons representation
	 */
	@Override
	public List<PokemonDto> getAllPokemonSimple() {
		List<PokemonDto> pokemons = new ArrayList<PokemonDto>();
		
		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Add the String message converter
		restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

		String url = "http://pokeapi.co/api/v2/pokemon/?offset=0";
		HttpHeaders headers = new HttpHeaders();
		headers.set( "User-Agent", "cheese");
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<?> entity = new HttpEntity<Object>(headers);	     
	    ResponseEntity<PokemonPage> response = restTemplate.exchange(url, HttpMethod.GET, entity, PokemonPage.class);
		PokemonPage pages = response.getBody();
		pokemons.addAll(pages.getResults());
		
		int i = 20;
		while (i <= pages.getCount()) {
//		while (i <= 2) {
			response = restTemplate.exchange(pages.getNext(), HttpMethod.GET, entity, PokemonPage.class);
			pages = response.getBody();			
			pokemons.addAll(pages.getResults());
			i += 20;
		}

		return pokemons;
	}
	
	@Override
	public List<PokemonDto> getAllPokemon() {
		List<PokemonDto> pokemons = getAllPokemonSimple();
		for (PokemonDto pokemon : pokemons) {
			pokemon.get();
		}
		return pokemons;
	}
	
	/* 
	 * return a list of all simple abilities representation
	 */
	@Override
	public List<Ability> getAllAbilitiesSimple() {
		List<Ability> abilities = new ArrayList<Ability>();
		
		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Add the String message converter
		restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

		String url = "http://pokeapi.co/api/v2/ability/?offset=0";
		HttpHeaders headers = new HttpHeaders();
		headers.set( "User-Agent", "cheese");
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<?> entity = new HttpEntity<Object>(headers);	     
	    ResponseEntity<AbilityPage> response = restTemplate.exchange(url, HttpMethod.GET, entity, AbilityPage.class);
	    AbilityPage pages = response.getBody();
		abilities.addAll(pages.getResults());
		
		int i = 20;
//		while (i <= 1) {
		while (i <= pages.getCount()) {
			response = restTemplate.exchange(pages.getNext(), HttpMethod.GET, entity, AbilityPage.class);
			pages = response.getBody();			
			abilities.addAll(pages.getResults());
			i += 20;
		}

		return abilities;
	}
	
	@Override
	public List<Move> getAllMovesSimple() {
		List<Move> moves = new ArrayList<Move>();
		
		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Add the String message converter
		restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

		String url = "http://pokeapi.co/api/v2/move/?offset=0";
		HttpHeaders headers = new HttpHeaders();
		headers.set( "User-Agent", "cheese");
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<?> entity = new HttpEntity<Object>(headers);	     
	    ResponseEntity<MovePage> response = restTemplate.exchange(url, HttpMethod.GET, entity, MovePage.class);
	    MovePage pages = response.getBody();
		moves.addAll(pages.getResults());
		
		int i = 20;
//		while (i <= 1) {
		while (i <= pages.getCount()) {
			response = restTemplate.exchange(pages.getNext(), HttpMethod.GET, entity, MovePage.class);
			pages = response.getBody();			
			moves.addAll(pages.getResults());
			i += 20;
		}

		return moves;
	}

	@Override
	public boolean addMove(String userName, String teamName, String pokemonName, String moveName) {
		PokemonDto pokemon = new PokemonDto();
		pokemon.setName(pokemonName);
		Move move = new Move(moveName);
		int size = pokemon.getMoves().size();
		Team team = teamService.findTeam(new User(userName, ""),  teamName);
		if (team.getPokemons().contains(pokemon)) {
			pokemon = team.getPokemons().get(team.getPokemons().indexOf(pokemon));
			if (!pokemon.getMoves().contains(move)) {
				move.get(moveName);				
				pokemon.getMoves().add(move);
			}
		}		
		return size < pokemon.getMoves().size();
	}
	
	@Override
	public boolean removeMove(String userName, String teamName, String pokemonName, String moveName) {
		PokemonDto pokemon = new PokemonDto();
		pokemon.setName(pokemonName);
		Move move = new Move(moveName);		
		int size = pokemon.getMoves().size();
		Team team = teamService.findTeam(new User(userName, ""),  teamName);
		if (team.getPokemons().contains(pokemon)) {
			pokemon = team.getPokemons().get(team.getPokemons().indexOf(pokemon));
			if (pokemon.getMoves().contains(move)) {				
				pokemon.getMoves().remove(move);
			}
		}		
		return size < pokemon.getMoves().size();
	}	
	
	@Override
	public List<Move> getMovesByTeam(String userName, String teamName, String pokemonName) {
		PokemonDto pokemon = new PokemonDto();
		pokemon.setName(pokemonName);
		Team team = teamService.findTeam(new User(userName, ""),  teamName);
		List<Move> result = new ArrayList<Move>();
		if (team.getPokemons().contains(pokemon)) {
			pokemon = team.getPokemons().get(team.getPokemons().indexOf(pokemon));
			result  = pokemon.getMoves();
		}		
		return result;
	}
	
	@Override
	public PokemonDto getPokemonByTeam(String userName, String teamName, String pokemonName) {
		PokemonDto pokemon = new PokemonDto();
		pokemon.setName(pokemonName);
		Team team = teamService.findTeam(new User(userName, ""),  teamName);
		if (team.getPokemons().contains(pokemon)) {
			pokemon  = team.getPokemons().get(team.getPokemons().indexOf(pokemon));
		}		
		return pokemon;
	}
}