package onabstraction;

public abstract class GraphicObject {
	int x;
	int y;
	
	void moveTo(int newY, int newX) {
		System.out.println("New y : " + newY + "; NewX " + newX);
	}
	
	abstract void  draw();
	abstract void resize();
}
