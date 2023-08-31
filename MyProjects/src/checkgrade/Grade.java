package checkgrade;

public class Grade {
	void checkGrade(int score) {
		if (score < 40) {
			if (score < 0)
				System.out.println("Invalid score");
			else
				System.out.println("Failed.");
		} else if (score < 50) {
			System.out.println("Pass");
		} else if (score < 60) {
			System.out.println("Grade is credit");
		} else if (score < 70) {
			System.out.println("Grade is good");
		} else if (score < 80) {
			System.out.println("Grade is excellent");
		} else if (score <= 100) {
			System.out.println("Grade is outstanding");
		} else if (score > 100) {
			System.out.println("Invalid score");
		}

	}

	public static void main(String[] args) {
		Grade ck = new Grade();
		ck.checkGrade(50);
		System.out.println(ck.checkGrade2(50));
	}

	public String checkGrade2(int score) {

		if (score > 100) {
			return "Invalid score";
		} else if (score >= 80) {
			return "Outstanding";
		} else if (score >= 70) {
			return "Excellent";
		} else if (score >= 60) {
			return " good";
		} else if (score >= 50) {
			return "Credit";
		} else if (score >= 40) {
			return "Pass";
		} else if (score < 40) {
			if (score < 0) {
				return "Invalid score";
			} else {
				return "Fail";
			}
		}

		return "Could not resolve request";
	}

}
