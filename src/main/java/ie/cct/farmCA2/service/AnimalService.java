package ie.cct.farmCA2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ie.cct.farmCA2.dao.AnimalDao;
import ie.cct.farmCA2.model.Animal;

@Service
public class AnimalService {

	private AnimalDao animalDao;

	@Autowired
	public AnimalService(@Qualifier("AnimalDao") AnimalDao animalDao) {
		super();
		this.animalDao = animalDao;
	}

	public void addAnimal(Animal animal) {
		animalDao.insertAnimal(animal);
	}

	public List<Animal> getAllAnimals() {
		return animalDao.selectAllAnimals();
	}

	public double averageWeightByType(String type) {
		return animalDao.averageWeightByType(type);
	}

	public int animalReadyForSaleByType(String type) {
		return animalDao.animalReadyForSailByType(type);
	}
	
	public double calculateStockValue() {
		return animalDao.stockValue();
	}

}
