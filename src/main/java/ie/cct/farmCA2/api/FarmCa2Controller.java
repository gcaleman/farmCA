package ie.cct.farmCA2.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.cct.farmCA2.model.Animal;
import ie.cct.farmCA2.service.AnimalService;

@RequestMapping("api/v1/animal")
@RestController
public class FarmCa2Controller {

	private AnimalService animalService;

	@Autowired
	public FarmCa2Controller(AnimalService animalService) {
		super();
		this.animalService = animalService;
	}

	@PostMapping
	public void addAnimals(@RequestBody Animal animal) {
		animalService.addAnimal(animal);
	}

	@GetMapping
	public List<Animal> getAllAnimals() {
		return animalService.getAllAnimals();
	}

	@GetMapping("average-weight-by-type")
	public double getAllAnimalsByType(@RequestParam("type") String type) {
		return animalService.averageWeightByType(type);
	}

	@GetMapping("ready-for-sale")
	public int animalReadyForSaleByType(@RequestParam("type") String type) {
		return animalService.animalReadyForSaleByType(type);
	}
	
	@GetMapping("stock-value")
	public double calculateStockValue() {
		return animalService.calculateStockValue();
	}

}
