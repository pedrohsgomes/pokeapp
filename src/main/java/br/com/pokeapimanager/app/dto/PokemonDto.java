package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PokemonDto extends ModelDto {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7239549873738342084L;
	
	private int order, height, weight;
	
	@JsonProperty("is_default")
	private boolean defaultSpecies;
	
	@JsonProperty("base_experience")
	private int baseExperience;
	
	private List<PokemonAbility> abilities;
	
	private List<Move> moves;
	
	private PokemonSprites sprites;
	
	private PokemonSpecies species;
	
	private List<PokemonStat> stats;
	
	private List<PokemonType> types;
	
	public PokemonDto() {
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public boolean isDefaultSpecies() {
		return defaultSpecies;
	}

	public void setDefaultSpecies(boolean defaultSpecies) {
		this.defaultSpecies = defaultSpecies;
	}

	public int getBaseExperience() {
		return baseExperience;
	}

	public void setBaseExperience(int baseExperience) {
		this.baseExperience = baseExperience;
	}

	public List<PokemonAbility> getAbilities() {
		if (abilities == null) {
			abilities = new ArrayList<PokemonAbility>();
		}
		return abilities;
	}

	public void setAbilities(List<PokemonAbility> abilities) {
		this.abilities = abilities;
	}

	public List<Move> getMoves() {
		if (moves == null) {
			moves = new ArrayList<Move>();
		}
		return moves;
	}

	public void setMoves(List<Move> moves) {		
		this.moves = moves;
	}

	public PokemonSprites getSprites() {
		return sprites;
	}

	public void setSprites(PokemonSprites sprites) {
		this.sprites = sprites;
	}

	public PokemonSpecies getSpecies() {
		return species;
	}

	public void setSpecies(PokemonSpecies species) {
		this.species = species;
	}

	public List<PokemonStat> getStats() {
		if (stats == null) {
			stats = new ArrayList<PokemonStat>();
		}
		return stats;
	}

	public void setStats(List<PokemonStat> stats) {
		this.stats = stats;
	}

	public List<PokemonType> getTypes() {
		if (types == null) {
			types = new ArrayList<PokemonType>();
		}
		return types;
	}

	public void setTypes(List<PokemonType> types) {
		this.types = types;
	}
	
	public void get() {
		if (url != null && !url.isEmpty()) {
			RestTemplate restTemplate = new RestTemplate();
			// Add the String message converter
			restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
			HttpHeaders headers = new HttpHeaders();
			headers.set( "User-Agent", "cheese");
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<?> entity = new HttpEntity<Object>(headers);	     
		    ResponseEntity<PokemonDto> response = restTemplate.exchange(url, HttpMethod.GET, entity, PokemonDto.class);
		    PokemonDto poke = response.getBody();
		    id = poke.id;		    
			order = poke.order;
			height = poke.height; 
			weight = poke.weight;
			baseExperience = poke.baseExperience;
			defaultSpecies = poke.defaultSpecies;
			species = poke.species;
			sprites = poke.sprites;
			getAbilities().addAll(poke.getAbilities());		
		}
	}
	
	public void get(String pokemonName) {
		this.name = pokemonName;
		url = "http://pokeapi.co/api/v2/pokemon/" + pokemonName;
		get();
	}
}