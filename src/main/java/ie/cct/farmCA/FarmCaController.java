package ie.cct.farmCA;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.cct.exceptions.*;

// Class controller of the application;

// Annotation RestController indicates that the class is the application controller;
@RestController
public class FarmCaController {

	// ArrayLists created to store the information about the animals;
	private ArrayList<Animal> animalList;
	private ArrayList<Animal> cowList;
	private ArrayList<Animal> chickenList;
	private ArrayList<Animal> pigList;
	private ArrayList<Animal> cowWeightList;
	private ArrayList<Animal> pigWeightList;
	private ArrayList<Animal> chickenWeightList;

	public FarmCaController() {
		// Creating 'arraylists' as instance of the class Animal;
		animalList = new ArrayList<Animal>(); // List of all animals created
		cowList = new ArrayList<Animal>(); // List of all the cows type created
		chickenList = new ArrayList<Animal>(); // List of all the the chickens type created
		pigList = new ArrayList<Animal>(); // List of all the pigs type created
		cowWeightList = new ArrayList<Animal>(); // List of all the cows that have the selling weight to be sold
		pigWeightList = new ArrayList<Animal>(); // List of all the pigs that have the selling weight to be sold
		chickenWeightList = new ArrayList<Animal>(); // List of all the chickens that have the selling weight to be sold
	}

	// Method responsible for adding new animals to the system;
	// Method returns the 'SuccessResponse' class constructor;
	// PostMapping annotation indicates an HTTP Post request for the path
	// (/add-animal);
	// ResquestBody annotation indicates that the method's parameter (type Animal)
	// is the body of the post request;
	@PostMapping("add-animal")
	public SuccessResponse addAnimal(@RequestBody Animal animals) {

		// Variables that specifies the minimum selling weight of each animal;
		float cowMinimumWeight = 300.0f;
		float pigMinimumWeight = 100.0f;
		float chickenMinimumWeight = 0.5f;

		// add the animal from the post body to the animalList
		animalList.add(animals);
		// if animal type is cow, adds it to the cowList and
		// checks if the animal has the selling weight, if it does add
		// it to the ready to be sold list;
		if (animals.getType().equalsIgnoreCase("cow")) {
			cowList.add(animals);

			if (animals.getWeight() >= cowMinimumWeight) {
				cowWeightList.add(animals);
			}
			// if animal type is pig, adds it to the 'pigList' and
			// checks if the animal has the selling weight, if it does add
			// it to the ready to be sold list;
		} else if (animals.getType().equalsIgnoreCase("pig")) {
			pigList.add(animals);

			if (animals.getWeight() >= pigMinimumWeight) {
				pigWeightList.add(animals);
			}
			// if animal type is chicken, adds it to the 'chickenList' and
			// checks if the animal has the selling weight, if it does add
			// it to the ready to be sold list;
		} else if (animals.getType().equalsIgnoreCase("chicken")) {
			chickenList.add(animals);

			if (animals.getWeight() >= chickenMinimumWeight) {
				chickenWeightList.add(animals);
			}
			// If animal type is not pig, cow or chicken method sends back the
			// 'NotAcceptableException' class constructor;
		} else {
			throw new NotAcceptableException(
					"Invalid animal type! Only cows, pigs and chickens are acceptable in the warehouse!");
		}
		// returning 'SuccessResponse' to obtain an JASON type response from the server;
		return new SuccessResponse("Animal " + animals.getType() + " added successfully!");
	}

	// Method responsible for calculating the average weight of an animal type in
	// the system;
	// GetMapping annotation indicates the HTTP GET path (/average-weight) necessary
	// to run the method;
	// ResquestParam annotation indicates the user must send a parameter type String
	// to the method;
	@GetMapping("average-weight")
	public float averageWeight(@RequestParam(required = true) String type) {
		// checks if there is any animal in the system
		// if not, returns the 'NotFoundException' class constructor;
		if (animalList.size() == 0) {
			throw new NotFoundException("No animals in the warehouse!");
		} else {

			Float weight = 0.0f;

			// If there is animals in the system;
			// Checks the animal type for cow, chicken and pig;
			// In case type is consistent, checks if there is any animal
			// of that type in the system;
			// In case there is, sum the weight of all the animals
			// and divides by the number of animals in the list;
			// If there is none animal in the list, returns the 'NotFoundException';
			if (type.equalsIgnoreCase("Cow")) {

				if (cowList.size() != 0) {

					for (Animal cows : cowList) {

						weight += cows.getWeight();
					}
					weight = weight / cowList.size();

				} else {
					throw new NotFoundException("No cows in the warehouse!");
				}

			} else if (type.equalsIgnoreCase("Pig")) {
				if (pigList.size() != 0) {
					for (Animal pigs : pigList) {

						weight += pigs.getWeight();
					}
					weight = weight / pigList.size();
				} else {
					throw new NotFoundException("No pigs in the warehouse!");
				}
			} else if (type.equalsIgnoreCase("Chicken")) {
				if (chickenList.size() != 0) {
					for (Animal chickens : chickenList) {

						weight += chickens.getWeight();
					}
					weight = weight / chickenList.size();
				} else {
					throw new NotFoundException("No chickens in the warehouse!");
				}
			} else {
				// In case animal type is inconsistent, returns the 'NotAcceptableException';
				throw new NotAcceptableException("Invalid animal type!");
			}
			return weight;
		}
	}

	// Method responsible for counting the number of animals
	// from a certain type that are ready to be sold;
	// GetMapping annotation indicates the HTTP GET path (/weight-count) necessary
	// to run the method;
	// ResquestParam annotation indicates the user must send a parameter type String
	// to the method;
	@GetMapping("weight-count")
	public Integer sellingWeight(@RequestParam(required = true) String type) {
		// checks if there is any animal in the system
		// if not, returns the 'NotFoundException' class constructor;
		if (animalList.size() == 0) {
			throw new NotFoundException("No animals in the warehouse!");
		} else {
			// Checks the animal type for cow, pig or chicken;
			// returns the number of animals that are in the weight list;
			// if there isn't any, returns the 'NotFoundException';
			// If animal type is inconsistent, returns the 'NotAcceptableException';
			if (type.equalsIgnoreCase("Cow")) {

				if (cowList.size() == 0) {
					throw new NotFoundException("No cows in the warehouse!");

				} else {
					if (cowWeightList.size() == 0) {
						throw new NotFoundException("No cows in the minimum weight!");
					} else {
						return cowWeightList.size();
					}

				}

			} else if (type.equalsIgnoreCase("Pig")) {
				if (pigList.size() == 0) {
					throw new NotFoundException("No pigs in the warehouse!");

				} else {
					if (pigWeightList.size() == 0) {
						throw new NotFoundException("No pigs in the minimum weight!");
					} else {
						return pigWeightList.size();
					}
				}
			} else if (type.equalsIgnoreCase("Chicken")) {
				if (chickenList.size() == 0) {
					throw new NotFoundException("No chickens in the warehouse!");

				} else {
					if (chickenWeightList.size() == 0) {
						throw new NotFoundException("No chickens in the minimum weight!");
					} else {
						return chickenWeightList.size();
					}
				}
			} else {
				throw new NotAcceptableException("Invalid animal type!");
			}
		}

	}

	// Method responsible for calculating the value of all animals in the system;
	// GetMapping annotation indicates the HTTP GET path (/total-value) necessary to
	// run the method;
	@GetMapping("total-value")
	public float totalValue() {

		// default value for each animal;
		float cowPrice = 500.0f;
		float pigPrice = 250.0f;
		float chickenPrice = 5.0f;

		float totalValue = 0.0f;

		// checks if there is any animal in the system
		// if not, returns the 'NotFoundException' class constructor;
		if (animalList.size() == 0) {
			throw new NotFoundException("No animals in the warehouse!");
		} else {
			// checks if there is any animals in the selling weight;
			// if not returns 'NotFoundException';
			if (cowWeightList.size() == 0 && pigWeightList.size() == 0 && chickenWeightList.size() == 0) {
				throw new NotFoundException("None of the animals are ready to be selled.");
			} else {
				// calculates the value of every animal in the selling weight;
				totalValue = cowWeightList.size() * cowPrice + pigWeightList.size() * pigPrice
						+ chickenWeightList.size() * chickenPrice;
			}
		}
		return totalValue;

	}

	// Method responsible for calculating the value of all animals in the system,
	// where the value is to be set by the user;
	// GetMapping annotation indicates the HTTP GET path (/total-set-values)
	// necessary to run the method;
	// RequestParam annotation indicates that the user needs to send the parameters
	// to the method,
	// where the parameter is the value for each animal;
	@GetMapping("total-set-values")
	public float totalValue(@RequestParam float cow, @RequestParam float pig, @RequestParam float chicken) {

		float cowPrice = cow;
		float pigPrice = pig;
		float chickenPrice = chicken;

		float totalValue = 0.0f;

		// Identical to the Method above;
		if (animalList.size() == 0) {
			throw new NotFoundException("No animals in the warehouse!");
		} else {
			if (cowWeightList.size() == 0 && pigWeightList.size() == 0 && chickenWeightList.size() == 0) {
				throw new NotFoundException("None of the animals are ready to be selled.");
			} else {
				totalValue = cowWeightList.size() * cowPrice + pigWeightList.size() * pigPrice
						+ chickenWeightList.size() * chickenPrice;
			}
			return totalValue;
		}
	}

}
