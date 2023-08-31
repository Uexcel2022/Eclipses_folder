package interfaces;

interface Show {
	void Add();
}

public class Calculator2 implements Show {
	int x, y;

	public Calculator2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void Add() {
		System.out.println(String.format("%s + %s = %s", x, y, x + y));
	}

	public static void main(String[] args) {
		Addiction ad = new Addiction();
		ad.addition(new Calculator2(3, 5));
		ad.addition(new Low(3, 7));
	}

}

class Addiction {
	void addition(Show show) {
		show.Add();
	}

}


class Low implements Show{
int x, y;

public Low(int x, int y) {
	this.x = x;
	this.y = y;
}

	public void Add() {
		System.out.println(String.format("%s + %s = %s",x, y, x+y));
	}
	
}


