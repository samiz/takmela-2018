package analyzer.errors;

public class ArbitraryError extends Error
{
	public final String Message;

	public ArbitraryError(String message)
	{
		Message = message;
	}

	public String toString()
	{
		return Message;
	}
}
