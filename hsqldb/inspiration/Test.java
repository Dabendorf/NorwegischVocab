import java.io.*;


class Test
{
	private static int anz;
	
	public static void main(String[] args) throws Exception
	{	
	//Datenbankzugriff.getPlaneten();
	
	//Datenbankzugriff.addSonnensystem(textEingabe());

	}
	
	public static String textEingabe() throws Exception
	{
		BufferedReader ein = new BufferedReader(new InputStreamReader(System.in));
        	String s = ein.readLine();
		return s;

	}

	public static void viewSonnensysteme() throws Exception
	{
		anz =  Datenbankzugriff.getAnz("Sonnensysteme");
		Sonnensystem[] sBox = new Sonnensystem[anz];
		sBox = Datenbankzugriff.getSonnensysteme();
		for(int y=0; y<anz; y++)
		{
		System.out.println("ID = "+sBox[y].getID()+" Name = "+sBox[y].getName());
		}

	}

	public static void viewPlaneten() throws Exception
	{
		anz =  Datenbankzugriff.getAnz("Planeten");
		Planet[] pBox = new Planet[anz];
		pBox = Datenbankzugriff.getPlaneten();
		for(int x=0; x<anz; x++)
		{
		System.out.println("ID = "+pBox[x].getID()+" Name = "+pBox[x].getName()+" Sonnensystem = "+(pBox[x].getSonnensystem()).getName());
		}

	}
	
	


}