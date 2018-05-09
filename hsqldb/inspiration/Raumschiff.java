

class Raumschiff
{
	private int raumschiffID;
	private String name;
	private RaumHafen raumhafen;

	public Raumschiff(int id,String name,RaumHafen raumhafen)
	{
		raumschiffID = id;
		this.name = name;
		this.raumhafen = raumhafen;		
	}

	public String getName()
	{
		return name;
	}

	public int getID()
	{
		return raumschiffID;
	}

	public RaumHafen getRaumHafen()
	{
		return raumhafen;
	}
}