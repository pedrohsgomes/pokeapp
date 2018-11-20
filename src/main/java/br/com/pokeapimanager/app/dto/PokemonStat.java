package br.com.pokeapimanager.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PokemonStat extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 367263485667487237L;

	private Stat stat;
	
	private int effort;
	
	@JsonProperty("base_stat")
	private int baseStat;

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

	public int getEffort() {
		return effort;
	}

	public void setEffort(int effort) {
		this.effort = effort;
	}

	public int getBaseStat() {
		return baseStat;
	}

	public void setBaseStat(int baseStat) {
		this.baseStat = baseStat;
	}
}
