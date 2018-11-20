
package br.com.pokeapimanager.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PokemonType extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -154301087580210793L;

	private int slot;
	
	private Type type;

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
