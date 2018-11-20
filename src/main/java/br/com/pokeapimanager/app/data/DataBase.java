package br.com.pokeapimanager.app.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.pokeapimanager.app.entity.Team;
import br.com.pokeapimanager.app.entity.User;

public class DataBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6991825047046594420L;
	
	private static DataBase instance;
	private List<User> users;
	private Map<User, Map<String, Team>> teams;
	
	private DataBase() {
		users = new ArrayList<User>();
		teams = new LinkedHashMap<User, Map<String, Team>>();
	}
	
	public static DataBase getInstance() {
		if (instance == null) {
			instance = new DataBase();
		}
		return instance;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public Map<User, Map<String, Team>> getTeams() {
		return teams;
	}
	
	public void setTeams(Map<User, Map<String, Team>> teams) {
		this.teams = teams;
	}
}
