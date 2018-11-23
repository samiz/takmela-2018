package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CmdLineParser
{
	public final Map<String, List<String>> KwArgs = new HashMap<>();
	public final Map<String, String> SingletonKwArgs = new HashMap<>();
	public final Set<String> Switches = new HashSet<>();
	public final List<String> RestArgs = new ArrayList<>();

	private String[] args;
	private int i;
	
	public CmdLineParser(
			Set<String> switchKeys, 
			Set<String> kwKeys, 
			Set<String> singletonKwKeys,
			String[] args) throws CmdLineParseException
	{
		if(switchKeys == null) { switchKeys = new HashSet<>(); }
		if(kwKeys == null) { kwKeys = new HashSet<>(); }
		if(singletonKwKeys == null) { singletonKwKeys = new HashSet<>(); }
		
		this.args = args;
		i = 0;
		boolean endOfSwitchesAndKw = false;
		while(still())
		{
			String a = take();
			if(kwKeys.contains(a))
			{
				if(endOfSwitchesAndKw)
				{
					throw new CmdLineParseException("All string arguments must be at end of command line");
				}
				String b = take("Argument for " + a);
				Utils.addMapList(KwArgs, a, b);
			}
			else if(singletonKwKeys.contains(a))
			{
				if(endOfSwitchesAndKw)
				{
					throw new CmdLineParseException("All string arguments must be at end of command line");
				}
				String b = take("Argument for " + a);
				if(SingletonKwArgs.containsKey(a))
				{
					throw new CmdLineParseException("Only one argument accepted for " + a);
				}
				SingletonKwArgs.put(a, b);
				
			}
			else if(switchKeys.contains(a))
			{
				if(endOfSwitchesAndKw)
				{
					throw new CmdLineParseException("All string arguments must be at end of command line");
				}
				Switches.add(a);
			}
			else
			{
				endOfSwitchesAndKw = true;
				RestArgs.add(a);
			}
		}
	}

	private boolean still()
	{
		return i < args.length;
	}
	
	private String take() throws CmdLineParseException
	{
		return take("Expected command line argument");
	}
	
	private String take(String expected) throws CmdLineParseException
	{
		if(!still())
		{
			throw new CmdLineParseException(expected);
		}
		return args[i++];
	}
}
