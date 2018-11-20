package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PokemonShape extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2825501572338068325L;

	private List<Name> names;
	
	@JsonProperty("pokemon_species")
	private List<PokemonSpecies> pokemonSpecies;
	
	@JsonProperty("awesome_names")
	private List<AwesomeNames> awesomeNames;

	public List<Name> getNames() {
		if (names == null) {
			names = new ArrayList<Name>();
		}
		return names;
	}

	public void setNames(List<Name> names) {
		this.names = names;
	}

	public List<PokemonSpecies> getPokemonSpecies() {
		if (pokemonSpecies == null) {
			pokemonSpecies = new ArrayList<PokemonSpecies>();
		}
		return pokemonSpecies;
	}

	public void setPokemonSpecies(List<PokemonSpecies> pokemonSpecies) {
		this.pokemonSpecies = pokemonSpecies;
	}

	public List<AwesomeNames> getAwesomeNames() {
		return awesomeNames;
	}

	public void setAwesomeNames(List<AwesomeNames> awesomeNames) {
		this.awesomeNames = awesomeNames;
	}	
}
