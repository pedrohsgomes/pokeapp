package br.com.pokeapimanager.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PokemonAbility extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7351907101060158506L;

	private int slot;
	
	@JsonProperty("is_hidden")
	private boolean hidden;
	
	private Ability ability;

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}
}
