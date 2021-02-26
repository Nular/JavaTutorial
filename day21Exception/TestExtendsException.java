package day21Exception;

public class TestExtendsException extends Exception{
	private static final long serialVersionUID = 2214470838232700412L;
	private int errorCode;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public TestExtendsException(int errorCode) {
		super();
		this.errorCode = errorCode;
	}
	public TestExtendsException() {
		super();
	}
	public TestExtendsException(String message) {
		super(message);
	}
	public TestExtendsException(Throwable cause) {
		super(cause);
	}
	public TestExtendsException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
