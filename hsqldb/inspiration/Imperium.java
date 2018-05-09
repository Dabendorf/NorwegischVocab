

class Imperium
{
	private int imperiumID;
	private String name;

	public Imperium(int id,String name)
	{
		imperiumID = id;
		this.name = name;		
	}

	public String getName()
	{
		return name;
	}

	public int getID()
	{
		return imperiumID;
	}
}