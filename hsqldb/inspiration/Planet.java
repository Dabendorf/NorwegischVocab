

class Planet
{
	private int planetID;
	private String name;
	private Sonnensystem sonnensystem;

	public Planet(int id,String name,Sonnensystem sonnensystem)
	{
		planetID = id;
		this.name = name;
		this.sonnensystem = sonnensystem;		
	}

	public String getName()
	{
		return name;
	}

	public int getID()
	{
		return planetID;
	}
	
	public Sonnensystem getSonnensystem()
	{
		return sonnensystem;
	}
}