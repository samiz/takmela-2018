package takmela.engine;

public class ParseEngine2
{
	/*
	public final List<Rule> rules;
	
	private final Map<String, Rule> namedRules = new HashMap<>();
	private AnalysisResult analysis;
	
	private List<String> input;
	private final Map<Pair<String, Integer>, Set<Frame>> continuations = new HashMap<>();
	private final List<Frame> activeProcesses = new ArrayList<>();
	
	public ParseEngine2(List<Rule> rules)
	{
		this.rules = rules;
		for (Rule r : rules)
		{
			namedRules.put(r.Name, r);
		}
		
		Analyzer analyzer = new Analyzer();
	    analyzer.analyze(rules);
	    analysis = analyzer.getResult();
	    log(analysis.fullFirstSets);
	}
	
	public void parse(String startSymbol, List<String> input)
	{
		this.input = input;
		spawn(startSymbol, 0);
		run();
	}
	
	private void run()
	{
		for(Frame f : activeProcesses)
		{
			run(f);
		}
	}
	
	private void run(Frame f)
	{
		if(f.RuleOption == -1)
		{
			Rule r = namedRules.get(f.RuleName);
			LLst<Expr> chosen = null;
			int chosenI = -1;
			for(int i=0; i<r.Options.size(); ++i)
			{
				LLst<Expr> opt = r.Options.get(i);
				Set<String> fs = analysis.firstSets.getOrDefault(new Pair<>(r.Name, i), new HashSet<>());
				if(leftCall(opt))
				{
					spawn cont;
				}
				else if(match(fs, f.InputPos))
				{
					chosen = opt;
					chosenI = i;
					break;
				}
			}
			if(chosen != null)
			{
				f.RuleOption = chosenI;
				f.Seq = chosen;
				process(f);
			}
		}
	}
	
	private void process(Frame f)
	{
		
	}
	
	private boolean leftCall(LLst<Expr> opt)
	{
		return opt != null && opt.head instanceof Call && analysis.leftCalls.contains((Call) opt.head);
	}
	
	private void spawn(String startSymbol, int inputPos)
	{
		Frame f = new Frame(startSymbol, -1, null, inputPos, -1, null);
		activeProcesses.add(f);
	}
	
	private boolean match(Set<String> strs, int inputPos)
	{
		return Utils.any(strs, (t)->match(t, inputPos));
	}
	
	private boolean match(String value, int inputPos)
	{
		if(inputPos >=input.size())
		{
			log("eof");
			return false;
		}
		String inp = input.get(inputPos);
		boolean result = inp.equals(value);
		log("....match `", value, "`: ", result? "success" : "fail");
		if(result && value.equals("13"))
		{
			log("break");
		}
		return result;
	}
	
	private void log(Object... items)
	{
		System.out.println(Utils.join(items, ""));
	}
	*/
}
