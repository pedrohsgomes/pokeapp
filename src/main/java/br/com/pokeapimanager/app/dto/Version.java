package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Version extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6086995205260820524L;

	private List<Name> names;
	
	@JsonProperty("version_group")
	private VersionGroup version_group;

	public List<Name> getNames() {
		if (names == null) {
			names = new ArrayList<Name>();
		}
		return names;
	}

	public void setNames(List<Name> names) {
		this.names = names;
	}

	public VersionGroup getVersion_group() {
		return version_group;
	}

	public void setVersion_group(VersionGroup version_group) {
		this.version_group = version_group;
	}
}
