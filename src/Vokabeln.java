class Vokabeln
{
	private int vokabelID;
	private String norwegisch;
	private String deutsch;
	private String anmerkung;
	private int kapitelnr;
	private String wortart;
	
	public Sonnensystem(int id,String norwegisch, String deutsch, String anmerkung, int kapitelnr, String wortart)
	{
		this.sonnensystemID = id;
		this.norwegisch = norwegisch;	
		this.deutsch = deutsch;	
		this.anmerkung = anmerkung;	
		this.kapitelnr = kapitelnr;	
		this.wortart = wortart;
	}

	public String getWortart()
	{
		return wortart;
	}

	public int getKapitelnr()
	{
		return kapitelnr;
	}
}