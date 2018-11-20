package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Generation extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6960469937085592675L;

	private List<Ability> abilities;
	private List<Name> names;
	
	@JsonProperty("main_region")
	private Region mainRegion;
	
	private List<Move> moves;
	
	@JsonProperty("pokemon_species")
	private List<PokemonSpecies> pokemonSpecies;
	
	private List<Type> types;
	
	@JsonProperty("version_groups")
	private List<VersionGroup> versionGroups;

	public List<Ability> getAbilities() {
		if (abilities == null) {
			abilities = new ArrayList<Ability>();
		}
		return abilities;
	}

	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
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

	public Region getMainRegion() {
		return mainRegion;
	}

	public void setMainRegion(Region mainRegion) {
		this.mainRegion = mainRegion;
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

	public List<PokemonSpecies> getPokemonSpecies() {
		if (pokemonSpecies == null) {
			pokemonSpecies = new ArrayList<PokemonSpecies>();
		}
		return pokemonSpecies;
	}

	public void setPokemonSpecies(List<PokemonSpecies> pokemonSpecies) {
		this.pokemonSpecies = pokemonSpecies;
	}

	public List<Type> getTypes() {
		if (types == null) {
			types = new ArrayList<Type>();
		}
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
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