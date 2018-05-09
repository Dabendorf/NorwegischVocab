

class RaumHafen
{
	private int raumHafenID;
	private String name;
	private Planet planet;
	private Imperium imperium;

	public RaumHafen(int id,String name,Planet planet,Imperium imperium)
	{
		raumHafenID = id;
		this.name = name;
		this.planet = planet;
		this.imperium = imperium;		
	}

	public String getName()
	{
		return name;
	}

	public int getID()
	{
		return raumHafenID;
	}

		public Planet getPlanet()
	{
		return planet;
	}

		public Imperium getImperium()
	{
		return imperium;
	}
}