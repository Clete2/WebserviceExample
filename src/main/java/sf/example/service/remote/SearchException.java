package sf.example.service.remote;

public class SearchException extends RuntimeException {
	private static final long serialVersionUID = -6457989150014485743L;

	public SearchException(String message, Exception e) {
		super(message, e);
	}
}
