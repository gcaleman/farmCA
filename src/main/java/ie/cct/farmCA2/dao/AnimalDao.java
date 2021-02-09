package ie.cct.farmCA2.dao;

import java.util.List;

import ie.cct.farmCA2.model.Animal;

public interface AnimalDao {

	int insertAnimal(Animal animal);

	List<Animal> selectAllAnimals();

	static List<Animal> selectAnimalType(String type) {
		return null;
	}

	double averageWeightByType(String type);

	int animalReadyForSailByType(String type);
	
	double stockValue();

}
