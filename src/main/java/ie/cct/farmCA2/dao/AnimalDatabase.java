package ie.cct.farmCA2.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ie.cct.farmCA2.model.Animal;

@Repository("AnimalDao")
public class AnimalDatabase implements AnimalDao {

	private static List<Animal> DB = new ArrayList<>();
	private static final double chickenValue = 5.0;
	private static final double cowValue = 500.0;
	private static final double pigValue = 250.0;

	@Override
	public int insertAnimal(Animal animal) {
		DB.add(new Animal(animal.getType(), animal.getWeight()));
		return 1;
	}

	@Override
	public List<Animal> selectAllAnimals() {
		return DB;
	}

	private static List<Animal> selectAnimalType(String type) {
		List<Animal> list = new ArrayList<Animal>();
		DB.stream().filter(animal -> animal.getType().equals(type)).forEach(list::add);
		return list;
	}

	@Override
	public double averageWeightByType(String type) {
		List<Animal> listType = selectAnimalType(type);
		double weightTotal = 0.0;
		for (int i = 0; i < listType.size(); i++) {
			weightTotal += listType.get(i).getWeight();
		}
		return weightTotal / listType.size();
	}

	@Override
	public int animalReadyForSailByType(String type) {
		List<Animal> listType = selectAnimalType(type);
		int count = 0;
		boolean valid = false;
		for (int i = 0; i < listType.size(); i++) {
			Animal check = listType.get(i);
			valid = check.canBeSold();
			if (valid) {
				count++;
			}
		}
		return count;
	}

	@Override
	public double stockValue() {
		double chickenValueTotal = chickenValue * this.animalReadyForSailByType("chicken");
		double cowValueTotal = cowValue * this.animalReadyForSailByType("cow");
		double pigValueTotal = pigValue * this.animalReadyForSailByType("pig");
		double value = chickenValueTotal + cowValueTotal + pigValueTotal;

		return value;
	}

}
