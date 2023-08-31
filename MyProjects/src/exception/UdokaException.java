package exception;

@SuppressWarnings("serial")
public class UdokaException extends Throwable {

	public UdokaException(String message) {
		super(message);
	}

	public UdokaException() {
		super("Unknown!");
	}

}
