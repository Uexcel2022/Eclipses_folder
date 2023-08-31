package hashset;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
	
	public static void main(String[] args) {
		Sets st = new Sets();
		st.set();
		st.treeSet();
		
	}
	
	void set() {
		Set<String> element   = new HashSet<>();  //follows random order. can not be sorted
		element.add("A");
		element.add("B");
		element.add("C");
		element.add("D");
		
		System.out.println("Elements : " + element);
		System.out.println("Str contains A : " + element.contains("A"));
		element.remove("D");
		System.out.println("Removed element D: " + element);
		
		
		for(String n : element) {
			
			System.out.print(n + " ");
		}
	}
		
		void treeSet() {
			TreeSet<String> element   = new TreeSet<>();  //Sorted by default
			element.add("D");
			element.add("B");
			element.add("C");
			element.add("A");
			
			System.out.println("Elements : " + element);
			System.out.println("Str contains A : " + element.contains("A"));
			element.remove("B");
			System.out.println("Removed element D: " + element);
			
			
			for(String n : element) {
				
				System.out.print(n + " ");
				
			}
	 
	 }
		
}

