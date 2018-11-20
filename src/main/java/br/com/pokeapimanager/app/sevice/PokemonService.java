package br.com.pokeapimanager.app.sevice;

import java.util.List;

import br.com.pokeapimanager.app.dto.Ability;
import br.com.pokeapimanager.app.dto.Move;
import br.com.pokeapimanager.app.dto.PokemonDto;

public interface PokemonService {

	/**
	 * A simple return of pokemons just with name and url
	 * @return a list of pokemons 
	 */
	List<PokemonDto> getAllPokemonSimple();

	/**
	 * A return of completes pokemons  
	 * @return a list of pokemons
	 */
	List<PokemonDto> getAllPokemon();

	/**
	 * A simple list of abilities just with name and url
	 * @return a list of abilities
	 */
	List<Ability> getAllAbilitiesSimple();

	boolean addMove(String userName, String teamName, String pokemonName, String moveName);

	boolean removeMove(String userName, String teamName, String pokemonName, String moveName);

	List<Move> getMovesByTeam(String userName, String teamName, String pokemonName);

	PokemonDto getPokemonByTeam(String userName, String teamName, String pokemonName);

	List<Move> getAllMovesSimple();
}