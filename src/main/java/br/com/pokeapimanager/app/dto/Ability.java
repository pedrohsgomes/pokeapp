package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Ability extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3426163716704745100L;

	@JsonProperty("is_main_series")
	private boolean mainSeries;
	
	private List<PokemonDto> pokemon;
	
	private Generation generation;
	private List<Name> names;
	public boolean isMainSeries() {
		return mainSeries;
	}
	public void setMainSeries(boolean mainSeries) {
		this.mainSeries = mainSeries;
	}
	public List<PokemonDto> getPokemon() {
		if (pokemon == null ) {
			pokemon = new ArrayList<PokemonDto>();
		}
		return pokemon;
	}
	public void setPokemon(List<PokemonDto> pokemon) {
		this.pokemon = pokemon;
	}
	public Generation getGeneration() {
		return generation;
	}
	public void setGeneration(Generation generation) {
		this.generation = generation;
	}
	public List<Name> getNames() {
		if (names == null ) {
			names = new ArrayList<Name>();
		}
		return names;
	}
	public void setNames(List<Name> names) {
		this.names = names;
	}
}
