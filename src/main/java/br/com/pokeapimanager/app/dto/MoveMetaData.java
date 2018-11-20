package br.com.pokeapimanager.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MoveMetaData extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6345868393539762138L;

	private Move category;
	
	@JsonProperty("min_hits")
	private int minHits;
	
	@JsonProperty("max_hits")
	private int maxHits;
	
	@JsonProperty("min_turns")
	private int minTurns;
	
	@JsonProperty("max_turns")
	private int maxTurns;
	
	private int drain, healing;
	
	@JsonProperty("crit_rate")
	private int critRate;
	
	@JsonProperty("ailment_chance")
	private int ailmentChance;
	
	@JsonProperty("flinch_chance")
	private int flinchChance;
	
	@JsonProperty("stat_chance")
	private int statChance;

	public Move getCategory() {
		return category;
	}

	public void setCategory(Move category) {
		this.category = category;
	}

	public int getMinHits() {
		return minHits;
	}

	public void setMinHits(int minHits) {
		this.minHits = minHits;
	}

	public int getMaxHits() {
		return maxHits;
	}

	public void setMaxHits(int maxHits) {
		this.maxHits = maxHits;
	}

	public int getMinTurns() {
		return minTurns;
	}

	public void setMinTurns(int minTurns) {
		this.minTurns = minTurns;
	}

	public int getMaxTurns() {
		return maxTurns;
	}

	public void setMaxTurns(int maxTurns) {
		this.maxTurns = maxTurns;
	}

	public int getDrain() {
		return drain;
	}

	public void setDrain(int drain) {
		this.drain = drain;
	}

	public int getHealing() {
		return healing;
	}

	public void setHealing(int healing) {
		this.healing = healing;
	}

	public int getCritRate() {
		return critRate;
	}

	public void setCritRate(int critRate) {
		this.critRate = critRate;
	}

	public int getAilmentChance() {
		return ailmentChance;
	}

	public void setAilmentChance(int ailmentChance) {
		this.ailmentChance = ailmentChance;
	}

	public int getFlinchChance() {
		return flinchChance;
	}

	public void setFlinchChance(int flinchChance) {
		this.flinchChance = flinchChance;
	}

	public int getStatChance() {
		return statChance;
	}

	public void setStatChance(int statChance) {
		this.statChance = statChance;
	}
}
