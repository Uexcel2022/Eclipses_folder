package collectionsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortNew {
	private String name;
	private int age;

	public SortNew() {
		this.name = "NoName";
		this.age = 0;
	}

	public SortNew(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
	public static Comparator<SortNew> nameComparator = new Comparator<>() {

		@Override
		public int compare(SortNew s1, SortNew s2) {
			return s1.getName().compareTo(s2.getName());
		}

	};

	public static Comparator<SortNew> ageComparator = new Comparator<>() {

		@Override
		public int compare(SortNew obj1, SortNew obj2) {
			return obj1.getAge() - obj2.getAge();
		}

	};

	public static void main(String[] args) {

		ArrayList<SortNew> sortNew = new ArrayList<>();
		sortNew.add(new SortNew("Udoka", 23));
		sortNew.add(new SortNew("Jide", 38));
		sortNew.add(new SortNew("Mercy", 50));

		sortNew.forEach((data) -> System.out.println(data.getName() + " " + data.getAge()));

		System.out.println("\nAfter sorting by name\n");

		Collections.sort(sortNew, nameComparator);

		sortNew.forEach((data) -> System.out.println(data.getName() + " " + data.getAge()));

		System.out.println("\nAfter sorting by age\n");

		Collections.sort(sortNew, ageComparator);

		sortNew.forEach((data) -> System.out.println(data.getName() + " " + data.getAge()));

	}

}
