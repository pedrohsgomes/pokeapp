package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.List;

public class Language extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -946435556750577840L;

	private boolean official;
	private String iso639, iso3166;
	
	private List<Name> names;

	public boolean isOfficial() {
		return official;
	}

	public void setOfficial(boolean official) {
		this.official = official;
	}

	public String getIso639() {
		return iso639;
	}

	public void setIso639(String iso639) {
		this.iso639 = iso639;
	}

	public String getIso3166() {
		return iso3166;
	}

	public void setIso3166(String iso3166) {
		this.iso3166 = iso3166;
	}

	public List<Name> getNames() {
		if (names == null ) {
			names = new ArrayList<Name>();
		}
		return names;
	}

	public void setNames(List<Name> names) {
		this.names = names;
	}
}
