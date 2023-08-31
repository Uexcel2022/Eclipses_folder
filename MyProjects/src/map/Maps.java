package map;

import java.util.HashMap;
//import java.util.Hashtable;
import java.util.Map;
//import java.util.Map.Entry;

public class Maps {
	
	public static void main(String[] args) {
		Maps mp = new Maps();
		mp.map();
	}
	
	void map() {
		
		Map <String, Integer> employee  = new HashMap<>();
		employee.put("Jide Olu", 50000);
		employee.put("Precious Okun", 70000);
		employee.put("Kelve Luiz", 45000);
//		System.out.println("Size: " + employee.size());
//		
//		if(employee.containsKey("Jide Olu"))
//		System.out.println("Jide Olu" +" : "+ employee.get("Jide Olu"));
	
		
		for(String m : employee.keySet()) {
			System.out.println(m + " : " + employee.get(m));
					
		}
	

	} 

}


