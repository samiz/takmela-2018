package utils;

public class OptionNotHandledException extends RuntimeException
{
	public OptionNotHandledException(String msg)
	{
		super(msg);
	}
	
	public OptionNotHandledException(Object obj)
	{
		super(obj == null ? "null" : obj.toString());
	}

	private static final long serialVersionUID = 1L;

}
