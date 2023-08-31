package exception;

@SuppressWarnings("serial")
public class UdokaException2 extends Throwable {

	public UdokaException2(String message) {
		super(message);
	}

	public UdokaException2() {
		super("Unknown!");
	}

}
