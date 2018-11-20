package br.com.pokeapimanager.app.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Move extends ModelDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8782782534050162302L;

	private int accuracy, priority, power;
	
	@JsonProperty("effect_chance")
	private int effectChance;
	
	@JsonProperty("pp")
	private int powerPoints;
	
	private Generation generation;
	
	private MoveMetaData meta;
	
	private List<Name> names;
	
	private MoveTarget target;
	
	private Type type;

	public Move() {
	}
	
	public Move(String moveName) {
		name = moveName;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getEffectChance() {
		return effectChance;
	}

	public void setEffectChance(int effectChance) {
		this.effectChance = effectChance;
	}

	public int getPowerPoints() {
		return powerPoints;
	}

	public void setPowerPoints(int powerPoints) {
		this.powerPoints = powerPoints;
	}

	public Generation getGeneration() {
		return generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

	public MoveMetaData getMeta() {
		return meta;
	}

	public void setMeta(MoveMetaData meta) {
		this.meta = meta;
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

	public MoveTarget getTarget() {
		return target;
	}

	public void setTarget(MoveTarget target) {
		this.target = target;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public void get() {
		if (url != null && !url.isEmpty()) {
			RestTemplate restTemplate = new RestTemplate();
			// Add the String message converter
			restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
			HttpHeaders headers = new HttpHeaders();
			headers.set( "User-Agent", "cheese");
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<?> entity = new HttpEntity<Object>(headers);	     
		    ResponseEntity<Move> response = restTemplate.exchange(url, HttpMethod.GET, entity, Move.class);
		    Move move = response.getBody();
		    id = move.id;		    
		    accuracy = move.accuracy;
		    priority = move.priority;
		    power = move.power;
		    effectChance = move.effectChance;
		    powerPoints = move.powerPoints;
		    generation = move.generation;			
			meta = move.meta;
			names = move.names;
			target = move.target;
			type = move.type;	
		}
	}
	
	public void get(String moveName) {
		this.name = moveName;
		url = "http://pokeapi.co/api/v2/move/" + moveName;
		get();
	}
}
