package br.com.pokeapimanager.app.controller;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pokeapimanager.app.dto.Ability;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AbilityPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 653475520966900978L;

	private int count;
	private String previous;
	private String next;
	private List<Ability> results;
	
	public AbilityPage() {
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

	public List<Ability> getResults() {
		return results;
	}

	public void setResults(List<Ability> results) {
		this.results = results;
	}
}
