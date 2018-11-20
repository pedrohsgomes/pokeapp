package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PokemonColor extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9196098997138734540L;
	
	private List<Name> names;
	
	@JsonProperty("pokemon_species")
	private List<PokemonSpecies> pokemonSpecies;

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

}
