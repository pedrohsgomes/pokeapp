package br.com.pokeapimanager.app.sevice;

import java.util.List;

import br.com.pokeapimanager.app.dto.PokemonDto;
import br.com.pokeapimanager.app.entity.Team;
import br.com.pokeapimanager.app.entity.User;

public interface TeamService {

	boolean createTeam(User user, String teamName);

	boolean addPokemonToTeam(User user, String teamName, PokemonDto pokemon);
	
	boolean removePokemonToTeam(User user, String teamName, PokemonDto pokemon);

	Team findTeam(User user, String teamName);

	List<Team> findAllTeams(User user);

	boolean isTeamExist(String userName, String name);

	void updateTeam(User user, String oldName, Team team);

	void deleteTeam(User user, String name);

	void deleteAllTeams(String userName);	

}