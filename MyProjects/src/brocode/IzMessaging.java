package brocode;

public class IzMessaging<X, Y> {
	X x;
	Y y;

	public IzMessaging(X x, Y y) {
		this.x = x;
		this.y = y;
	}

	public X getValueY() {
		return x;
	}

	public Y getValueX() {
		return y;
	}

}
