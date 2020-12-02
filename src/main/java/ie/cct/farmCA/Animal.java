package ie.cct.farmCA;

// Class responsible for creating the animals;

public class Animal {

	// In order to create a new animal, 2 attributes are necessary (type and weight)
	protected String type;
	protected float weight;
	
	// Default constructor		
	public Animal() {
		super();
		
	}

	// Constructor for the class 'Animal';
	// Receives type and weight sent by the user;
	public Animal(String type, float weight) {
		super();
		this.type = type;
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

}
