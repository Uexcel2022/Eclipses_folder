package arraydeque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;

public class List {

	public static void main(String[] args) {
		list();
		
	}
	

	public static void list() {

		ArrayList<String> fruits = new ArrayList<>();
		ArrayList<String> food = new ArrayList<>();
		ArrayList<String> cart = new ArrayList<>();

		fruits.add("Guava");
		fruits.add("Pineapple");
		fruits.add("Apple");
		fruits.add("Mango");
		fruits.add("Mango");
//		cart.add("Rice");
//		cart.add("Beans");
//		cart.add("Yam");

//		fruits.add(0, "Orange");
//		fruits.remove(1);
//		fruits.remove("Guava");

//		System.out.println(fruits.size());

//		ArrayList(Collection<? extends E> c)  that .addAll() accepts on collections
		
		
		Collections.sort(fruits);
		
		Collections.sort(fruits, Collections.reverseOrder());
		

		cart.addAll(fruits);
		cart.addAll(food);
		
		ListIterator<String> i = fruits.listIterator();

		while (i.hasNext()) {
			Object item = i.next();
			System.out.println(item);
		}
		
		
		
//		iN REVERSE ORDER NEED TO PASS THE LIST SIZE TO THE ITERATOR

//		ListIterator<String> i = fruits.listIterator(fruits.size());
//
//		while (i.hasPrevious()) {
//			Object item = i.previous();
//			System.out.println(item);
//		}
		
		
		

//		Consumer<String> printCart = new Consumer<>() {
//			public void accept(String name) {
//				System.out.println(name);
//			}
//		};
////		
//		cart.forEach(printCart);

	}
	
	public static void deque() {
		ArrayDeque<String> fruits = new ArrayDeque<>();
		ArrayDeque<String> food = new ArrayDeque<>();
//		ArrayDeque<String> cart = new ArrayDeque<>();

		fruits.add("Guava");
		fruits.add("Pineapple");
		fruits.add("Apple");
		fruits.add("Mango");
		
//		fruits.add("Mango");
		
//		fruits.addFirst("Mango");
//		fruits.addLast("Pear");
		
//		System.out.println(fruits.descendingIterator());
		
//	   System.out.println(fruits.getFirst());
//	   System.out.println(fruits.getLast());
	    
//		fruits.removeFirst();
//		fruits.removeLastOccurrence("Mango");
//		fruits.removeLast();
//		fruits.removeFirstOccurrence("Mango");
//		fruits.remove("Apple");
		
		food.add("Rice");
		food.add("Beans");
		food.add("Yam");
		
		

		Iterator<String> dque = fruits.descendingIterator();
		while(dque.hasNext()){
		System.out.println(dque.next());
		}

		Consumer<String> printFruits = new Consumer<>() {
			@Override
			public void accept(String fruit) {
//				System.out.println(fruit);
			}

		};

		fruits.forEach(printFruits);

	}

}
