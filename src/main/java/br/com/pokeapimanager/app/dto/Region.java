package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Region extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8190225409373297572L;

	private Location locations;

	@JsonProperty("version_groups")
	private List<VersionGroup> versionGroups;

	public Location getLocations() {
		return locations;
	}

	public void setLocations(Location locations) {
		this.locations = locations;
	}

	public List<VersionGroup> getVersionGroups() {
		if (versionGroups == null) {
			versionGroups = new ArrayList<VersionGroup>();
		}
		return versionGroups;
	}

	public void setVersionGroups(List<VersionGroup> versionGroups) {
		this.versionGroups = versionGroups;
	}
}
