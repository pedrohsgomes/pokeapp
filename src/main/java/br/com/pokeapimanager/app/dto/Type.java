package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Type extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3670265423575995684L;

	private Generation generation;
	private List<Name> names;
	private List<PokemonDto> pokemon;
	private List<Move> moves;
	public Generation getGeneration() {
		return generation;
	}
	public void setGeneration(Generation generation) {
		this.generation = generation;
	}
	public List<Name> getNames() {
		if (names == null) {
			names = new ArrayList<Name>();
		}
		return names;
	}
	public void setNames(List<Name> names) {
		this.names = names;
	}
	public List<PokemonDto> getPokemon() {
		if (pokemon == null) {
			pokemon = new ArrayList<PokemonDto>();
		}
		return pokemon;
	}
	public void setPokemon(List<PokemonDto> pokemon) {
		this.pokemon = pokemon;
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
}
