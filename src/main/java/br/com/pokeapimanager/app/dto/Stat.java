package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Stat extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1345764435189268018L;

	private Characteristics characteristics;
	
	@JsonProperty("game_index")
	private int gameIndex;
	
	private List<Name> names;

	public Characteristics getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(Characteristics characteristics) {
		this.characteristics = characteristics;
	}

	public int getGameIndex() {
		return gameIndex;
	}

	public void setGameIndex(int gameIndex) {
		this.gameIndex = gameIndex;
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
}
