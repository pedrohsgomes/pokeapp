package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class VersionGroup extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5627466175633970291L;

	private List<Version> versions;

	public List<Version> getVersions() {
		if (versions == null) {
			versions = new ArrayList<Version>();
		}
		return versions;
	}

	public void setVersions(List<Version> versions) {
		this.versions = versions;
	}
}
