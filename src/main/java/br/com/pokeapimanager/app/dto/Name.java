package br.com.pokeapimanager.app.dto;

public class Name extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8733767271546674932L;

	private Language language;

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public Name() {
	}
}
