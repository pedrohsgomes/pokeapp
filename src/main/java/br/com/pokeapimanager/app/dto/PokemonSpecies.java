package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PokemonSpecies extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8190758216147854353L;

	private int order;
	
	@JsonProperty("gender_rate")
	private int genderRate;
	
	@JsonProperty("capture_rate")
	private int captureRate;
	
	@JsonProperty("base_happiness")
	private int baseHappiness;
	
	@JsonProperty("is_baby")
	private boolean baby;
	
	@JsonProperty("hatch_counter")
	private int hatchCounter;
	
	@JsonProperty("has_gender_differences")
	private boolean genderDifferences;
	
	@JsonProperty("forms_switchable")
	private boolean formsSwitchable;
	
	private PokemonColor color;
	
	private PokemonShape shape;
	
	@JsonProperty("evolves_from_species")
	private PokemonSpecies evolvesFromSpecies;
	
	private Generation generation;
	
	private List<Name> names;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getGenderRate() {
		return genderRate;
	}

	public void setGenderRate(int gender_rate) {
		this.genderRate = gender_rate;
	}

	public int getCaptureRate() {
		return captureRate;
	}

	public void setCaptureRate(int capture_rate) {
		this.captureRate = capture_rate;
	}

	public int getBaseHappiness() {
		return baseHappiness;
	}

	public void setBaseHappiness(int base_happiness) {
		this.baseHappiness = base_happiness;
	}

	public boolean isBaby() {
		return baby;
	}

	public void setBaby(boolean baby) {
		this.baby = baby;
	}

	public int getHatchCounter() {
		return hatchCounter;
	}

	public void setHatchCounter(int hatchCounter) {
		this.hatchCounter = hatchCounter;
	}

	public boolean hasGenderDifferences() {
		return genderDifferences;
	}

	public void setGenderDifferences(boolean hasGenderDifferences) {
		this.genderDifferences = hasGenderDifferences;
	}

	public boolean isFormsSwitchable() {
		return formsSwitchable;
	}

	public void setFormsSwitchable(boolean formsSwitchable) {
		this.formsSwitchable = formsSwitchable;
	}

	public PokemonColor getColor() {
		return color;
	}

	public void setColor(PokemonColor color) {
		this.color = color;
	}

	public PokemonShape getShape() {
		return shape;
	}

	public void setShape(PokemonShape shape) {
		this.shape = shape;
	}

	public PokemonSpecies getEvolvesFromSpecies() {
		return evolvesFromSpecies;
	}

	public void setEvolvesFromSpecies(PokemonSpecies evolvesFromSpecies) {
		this.evolvesFromSpecies = evolvesFromSpecies;
	}

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
}
