package protactice;
import java.util.Random;
public class Switch {

 public Switch( int grade){
	 switch(grade) {
	 case 50:{
		 System.out.println("You pass barely!");
	 }
	 }
 }
 public static void main(String[] args) {
	 Random rd = new Random();
	 int num = rd.nextInt(0, 9);
	 System.out.println(num);
//	new Switch(50);
//	 String A = "Came";
//	 String B = (A.equals("Come")) ? "True": "False";
//	 System.out.println(B);
}
}
