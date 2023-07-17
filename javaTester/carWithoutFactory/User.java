package carWithoutFactory;

public class User {

	public static void main(String[] args) {
		// Sáng T7
		Honda hond = new Honda();
		hond.viewCar();
		hond.driveCar();
		
		// Chiều T7
		Toyota toy = new Toyota();
		toy.viewCar();
		toy.driveCar();
		
		// Sáng CN
		Huyndai huyn = new Huyndai();
		huyn.viewCar();
		huyn.driveCar();
		
		// Chiều CN
		Ford ford = new Ford();
		ford.viewCar();
		ford.driveCar();
	}

}
