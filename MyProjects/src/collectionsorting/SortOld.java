package collectionsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

class Cars {
	String name;
	String type;
	Integer ID;

	public Cars(String name, String type, Integer ID) {
		this.name = name;
		this.type = type;
		this.ID = ID;
	}

}

class CompareName implements Comparator<Object> {

	@Override
	public int compare(Object obj1, Object obj2) {
		Cars c1 = (Cars) obj1;
		Cars c2 = (Cars) obj2;

		return c1.name.compareTo(c2.name);
	}

}

class CompareType implements Comparator<Object> {

	@Override
	public int compare(Object obj1, Object obj2) {
		Cars c1 = (Cars) obj1;
		Cars c2 = (Cars) obj2;
		return c1.type.compareTo(c2.type);
	}

}

public class SortOld {

	public static void main(String[] args) {

		ArrayList<Cars> carList = new ArrayList<>();
		carList.add(new Cars("Toyota", "Land Cruiser", 125367352));
		carList.add(new Cars("Hyundai", "Azera", 263893892));
		carList.add(new Cars("Honda", "Accord", 563202725));

		carList.forEach((car) -> System.out.println(car.name + " " + car.type + " " + car.ID));

//		Collections.sort(carList, new CompareName());
//
//		System.out.println();
		
		
//
		carList.forEach((car) -> System.out.println(car.name + " " + car.type + " " + car.ID));
		
		
		
		
//
		Collections.sort(carList, new CompareType());
		
		System.out.println();

		Consumer<Cars> printCar = new Consumer<>() {

			@Override
			public void accept(Cars car) {
				System.out.println(car.name + " " + car.type + " " + car.ID);

			}

		};

		carList.forEach(printCar);

	}

	public void printCar(Cars car) {

	}

}
