package br.com.pokeapimanager.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.pokeapimanager.app.dto.PokemonDto;

public class Team implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8165694365755434883L;

	private String name;
	private User user;	
	private List<PokemonDto> pokemons;
	
	public Team() {
		pokemons = new ArrayList<PokemonDto>();
	}
	
	public Team(User user, String name) {
		this();
		this.name = name;
		this.user = user;
	}
	
	public Team(User user, String name, List<PokemonDto> pokemons) {
		this(user, name);
		this.pokemons = pokemons;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<PokemonDto> getPokemons() {
		return pokemons;
	}
	
	public void setPokemons(List<PokemonDto> pokemons) {
		this.pokemons = pokemons;
	}
}
