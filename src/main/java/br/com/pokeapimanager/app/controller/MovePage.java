package br.com.pokeapimanager.app.controller;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pokeapimanager.app.dto.Move;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MovePage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3586211714382154826L;

	private int count;
	private String previous;
	private String next;
	private List<Move> results;
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
	public List<Move> getResults() {
		return results;
	}
	public void setResults(List<Move> results) {
		this.results = results;
	}
}
