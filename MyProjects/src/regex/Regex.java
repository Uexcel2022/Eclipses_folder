package regex;

//import java.util.regex.Pattern;
//import java.util.regex.Matcher;
//import java.util.Scanner;

public class Regex {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);

//		Pattern myPattern = Pattern.compile("(\\+234[7-9]||0[8-9])[01][0-9]{8}");
//		Matcher myMatch = myPattern.matcher("08038263822");
//		Boolean checkMatch = myMatch.matches();
//		System.out.println(checkMatch);

//		 Boolean checking  = Pattern.matches("[b-e][n-q]", "cz"); //any ch
//		 System.out.println(checking);

//		String word = "It rained yesterday. the rain was so heavey and like to play when it rains";
//
//		String[] string = word.split(" ");
//		Pattern pattern = Pattern.compile("rain.*");
//		for (String n : string) {
//			Matcher matcher = pattern.matcher(n);
//			Boolean isFound = matcher.matches();
//			if (isFound) {
//				System.out.println(matcher.group() +"\nStarts from index :"+ matcher.start() +"\nend at index: "+ matcher.end());
//			}
//		}

//		Pattern pattern = Pattern.compile("[a-z]+\\.?[a-z0-9_]*@[a-z0-9]+\\.?[a-z]+\\.[a-z]{2,3}+");  
//		Matcher match = pattern.matcher("exce_udoka@365gmail.com");
//		Boolean isFound = match.matches();
//		if(isFound) {
//			System.out.println(match.group());
//		}
		
		new CredentialsValidation();
		 
		
//		
	}
}





















