package br.com.pokeapimanager.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AwesomeNames extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5098300817430911063L;

	@JsonProperty("awesome_name")
	private String awesomeName;
	private Language language;	
	public String getAwesomeName() {
		return awesomeName;
	}
	public void setAwesomeName(String awesomeName) {
		this.awesomeName = awesomeName;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
}
