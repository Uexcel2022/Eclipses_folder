package collectionhashset;

import java.util.HashSet;
import java.util.Set;
import java.util.*;


class Contacts{
	
}


public class Sets {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Sets st = new Sets();
//		st.set();
		st.treeSet();
		
		// Generic
		
//		Contacts A =new Contacts();
//		Contacts B =new Contacts();
//		Contacts C =new Contacts();
//		
//		HashSet<Contacts> hs = new HashSet<>();
//		hs.add(A);
//		hs.add(B);
//		hs.add(C);
//		
//		Iterator<Contacts> i =  hs.iterator();
//			while(i.hasNext()) {
//				System.out.println(i.next());
//			}

		
//		Non-Generic
		
		Contacts a = new Contacts();
		HashSet hs = new HashSet();
		
		hs.add(a);
		hs.add("String Object");
		hs.add(6);
		
		
	}
	
	void set() {
		Set<String> element   = new HashSet<>();  //follows random order. can not be sorted
	
		element.add("A");
		element.add("C");
		element.add("B");
		element.add("D");
	
		System.out.println(element.add("D"));  //set does'nt accept duplicate value;
		
		Iterator<String> i =  element.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
//		System.out.println("Elements : " + element);
//		System.out.println("Str contains A : " + element.contains("A"));
//		element.remove("D");
//		System.out.println("Removed element D: " + element);
//		
//		
//		for(String n : element) {
//			
//			System.out.print(n + " ");
//		}
	}
		
		void treeSet() {
			TreeSet<String> element   = new TreeSet<>();  //Sorted by default
		
			element.add("D");
			element.add("B");
			element.add("C");
			element.add("A");
		
			
			System.out.println(element.add("D")); // doesn't accept duplicates
			System.out.println(element.size());
			
			System.out.println("Elements : " + element);
			System.out.println("Str contains A : " + element.contains("A"));
			element.remove("B");
			System.out.println("Removed element B: " + element);
			
			
			
			for(String n : element) {
				
				System.out.print(n + " ");
				
			}
	 
	 }
		
}

