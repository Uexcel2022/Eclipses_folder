package brocode;

import java.util.ArrayList;

//import java.util.Iterator;
//import java.io.File;
public class Collections {

	public static void main(String[] args) {
		
//	File file = new File("C:/Users/Uexcel/OneDrive - msoffice365e/Documents/JavaText/Regex.txt");
		
  
	}
	
	public void arrayList() {	
//		ArrayList<String> food = new ArrayList<>();
//		food.add("Cord");
//		food.add("Rice");
//		food.add("beens");
//		
//		food.add(0, "Eba"); 
//		food.remove("Rice");
//		food.remove(1);
//		food.set(3, "Yarm"); //replacement;
//	    System.out.println( food.contains("Rice"))
//		System.out.println(food.get(0));
//		System.out.println(food.add("cook"));
//		food.clear();
		
//		for(String n: food) {
//			System.out.println(n);
//		}
//		
//		Iterator<String> it = food.iterator();
//		while(true) {
//			if(it.hasNext()) {
//				System.out.println(it.next());
//			}
//		}
		
//	2D ArrayList 
		
		ArrayList<ArrayList<String>>gloceryList = new ArrayList<>();
		
		ArrayList <String> backeryStuffs = new ArrayList<>();
		backeryStuffs.add("Bread");
		backeryStuffs.add("Plantain-Ships");
		backeryStuffs.add("Cake");
		
		ArrayList<String> provition = new ArrayList<>();
		provition.add("Banvita");
		provition.add("MilK");
		
		
		ArrayList<String> drinks = new ArrayList<>();
		drinks.add("Coke");
		drinks.add("Berlys");
		drinks.add("Don-Simon");
		
		gloceryList.add(backeryStuffs);
		gloceryList.add(provition);
		gloceryList.add(drinks);
		
		for(ArrayList<String> n: gloceryList) {
			for(String j : n) {
				System.out.println(j);
			}
		}
		
//		System.out.println(gloceryList);
//		System.out.println(gloceryList.get(0).get(0));
		
//		Iterator <ArrayList<String>>  it = gloceryList.iterator();
//		while(true) {
//			if(it.hasNext()) {
//				 Iterator<String> n = it.next().iterator();
//				 while(true) {
//					 if(n.hasNext()) {
//						 System.out.println(n.next());
//					 }else break;
//				 }
//			}else break;
//		}
//		
		
	}
	
}
