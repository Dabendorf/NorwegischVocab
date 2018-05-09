

class Sonnensystem
{
	private int sonnensystemID;
	private String name;

	public Sonnensystem(int id,String name)
	{
		sonnensystemID = id;
		this.name = name;		
	}

	public String getName()
	{
		return name;
	}

	public int getID()
	{
		return sonnensystemID;
	}
}