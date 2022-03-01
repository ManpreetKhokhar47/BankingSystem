package bus;

public class RaiseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String message = "RAISE EXCEPTION : non valid input" ;
	
	public RaiseException()
	{
		super(message) ;
	}
	
	public RaiseException(String msg)
	{
	 super (msg);
	}

}
