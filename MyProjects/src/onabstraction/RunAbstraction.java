package onabstraction;

public class RunAbstraction {
	public static void main(String[] args) {
	GraphicObject ab = new Circle();
	GraphicObject ab2 = new Triangle();
	ab.draw();
	ab.resize();
	ab2.draw();
	ab2.resize();
	ab.moveTo(5, 7);
	
	}
}
