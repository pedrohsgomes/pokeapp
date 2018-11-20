package br.com.pokeapimanager.app.controller;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pokeapimanager.app.dto.ModelDto;
import br.com.pokeapimanager.app.dto.PokemonDto;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PokemonPage extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4772875124419909249L;
	
	private int count;
	private String previous;
	private String next;
	private List<PokemonDto> results;
	
	public PokemonPage() {	
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public List<PokemonDto> getResults() {
		if (results == null) {
			results = new ArrayList<PokemonDto>();
		}
		return results;
	}

	public void setResults(List<PokemonDto> results) {
		this.results = results;
	}
}
