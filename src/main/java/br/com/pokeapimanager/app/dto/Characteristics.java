package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Characteristics extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2814489889396150976L;

	@JsonProperty("gene_modulo")
	private int geneModulo;
	
	@JsonProperty("possible_values")
	private List<Integer> possibleValues;
	
	private List<Description> descriptions;

	public int getGeneModulo() {
		return geneModulo;
	}

	public void setGeneModulo(int geneModulo) {
		this.geneModulo = geneModulo;
	}

	public List<Integer> getPossibleValues() {
		if (possibleValues == null) {
			possibleValues = new ArrayList<Integer>();
		}
		return possibleValues;
	}

	public void setPossibleValues(List<Integer> possibleValues) {
		this.possibleValues = possibleValues;
	}

	public List<Description> getDescriptions() {
		if (descriptions == null) {
			descriptions = new ArrayList<Description>();
		}
		return descriptions;
	}

	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}
}
