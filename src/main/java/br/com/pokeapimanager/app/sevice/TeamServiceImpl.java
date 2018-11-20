package br.com.pokeapimanager.app.sevice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.pokeapimanager.app.data.DataBase;
import br.com.pokeapimanager.app.dto.PokemonDto;
import br.com.pokeapimanager.app.entity.Team;
import br.com.pokeapimanager.app.entity.User;

@Service("teamServeice")
public class TeamServiceImpl implements TeamService {

	@Override
	public boolean createTeam(User user, String teamName) {
		boolean result = false;
		if (user != null && teamName != null && !teamName.isEmpty()) {
			Team team = new Team(user, teamName);
			if (!DataBase.getInstance().getTeams().containsKey(user)) {
				Map<String,Team> teams = new LinkedHashMap<String,Team>();
				int size = DataBase.getInstance().getTeams().size();
				teams.put(teamName, team);
				DataBase.getInstance().getTeams().put(user, teams);
				result = size < DataBase.getInstance().getTeams().size();
			} else {
				int size = DataBase.getInstance().getTeams().size();
				DataBase.getInstance().getTeams().get(user).put(teamName, team);
				result = size < DataBase.getInstance().getTeams().get(user).size(); 
			}			
		}		
		return result;
	}
	
	@Override
	public boolean addPokemonToTeam(User user, String teamName, PokemonDto pokemon) {
		boolean result = false;
		Team team = findTeam(user, teamName);
		if (team != null && team.getPokemons().size() < 6) {
			result = team.getPokemons().contains(pokemon) ? false : team.getPokemons().add(pokemon);			
		} else if (team != null && team.getPokemons().size() == 6) {
			result = true;
		}
		return result;
	}
	
	@Override
	public boolean removePokemonToTeam(User user, String teamName, PokemonDto pokemon) {
		boolean result = false;
		Team team = findTeam(user, teamName);
		if (team != null && team.getPokemons().size() > 0) {
			result = team.getPokemons().contains(pokemon) ? team.getPokemons().remove(pokemon) : false;			
		} else {
			result = true;
		}
		return result;
	}
	
	@Override
	public Team findTeam(User user, String teamName) {	
		Team teamRemote = null;
		if (DataBase.getInstance().getTeams().containsKey(user)) {			
			teamRemote = DataBase.getInstance().getTeams().get(user).get(teamName);
		}		
		return teamRemote;
	}
	
	@Override
	public List<Team> findAllTeams(User user){
		List<Team> teamRemote = new ArrayList<>();
		if (DataBase.getInstance().getTeams().containsKey(user)) {			
			teamRemote.addAll(DataBase.getInstance().getTeams().get(user).values());
		}		
		return teamRemote;
	}

	@Override
	public boolean isTeamExist(String userName, String name) {
		return findTeam(new User(userName, ""), name) == null ? false : true;
	}

	@Override
	public void updateTeam(User user, String oldName, Team team) {
		if (isTeamExist(user.getUserName(), oldName)) {
			DataBase.getInstance().getTeams().get(user).remove(oldName);
			DataBase.getInstance().getTeams().get(user).put(team.getName(), team);
		}		
	}

	@Override
	public void deleteTeam(User user, String name) {
		if (isTeamExist(user.getUserName(), name)) {
			DataBase.getInstance().getTeams().get(user).remove(name);
		}
	}

	@Override
	public void deleteAllTeams(String userName) {
		if (userName != null && !userName.isEmpty()) {
			User user = new User(userName, "");
			if (!DataBase.getInstance().getTeams().containsKey(user)) {
				DataBase.getInstance().getTeams().remove(user);
			}
		}
	}
}