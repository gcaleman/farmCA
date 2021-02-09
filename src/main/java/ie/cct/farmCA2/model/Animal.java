package ie.cct.farmCA2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Animal {

	private String type;
	private double weight;

	public Animal(@JsonProperty("type") String type, @JsonProperty("weight") double weight) {
		this.type = type;
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public final boolean canBeSold() {
		boolean valid = false;
		if (this.type.equalsIgnoreCase("chicken")) {
			if (this.weight >= 0.5) {
				valid = true;
			}
		} else if (this.type.equalsIgnoreCase("cow")) {
			if (this.weight >= 300) {
				valid = true;
			}
		} else if (this.type.equalsIgnoreCase("pig")) {
			if (this.weight >= 100) {
				valid = true;
			}
		}
		return valid;
	}

}
