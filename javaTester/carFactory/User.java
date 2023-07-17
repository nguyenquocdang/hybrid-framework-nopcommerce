package carFactory;


public class User {

	public static void main(String[] args) {
		getCar("Honda").viewCar();
		getCar("Honda").driverCar();
		
		getCar("Huyndai").viewCar();
		getCar("Huyndai").driverCar();
		
		getCar("Toyota").viewCar();
		getCar("Toyota").driverCar();
		
		getCar("Mer").viewCar();

		
	}

	public static Car getCar(String carName) {
		Car car = null;
	
		if (carName.equals("Honda")) {
			car = new Honda();
		} else if (carName.equals("Huyndai")) {
			car = new Huyndai();
		} else if (carName.equals("Toyota")) {
			car = new Toyata();
		} else if (carName.equals("Ford")) {
			car = new Ford();
		} else {
			throw new RuntimeException("Car name is not valid!");
		}
		return car;
	}
}
