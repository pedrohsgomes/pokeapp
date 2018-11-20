package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MoveTarget extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6915935676178150002L;

	private List<Description> descriptions;
	
	private List<Move> moves;
	
	private List<Name> names;

	public List<Description> getDescriptions() {
		if (descriptions == null) {
			descriptions = new ArrayList<Description>();
		}
		return descriptions;
	}

	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}

	public List<Move> getMoves() {
		if (moves == null) {
			moves = new ArrayList<Move>();
		}
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
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
