import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


class Datenbankzugriff
{
	public static int getAnz(String table) throws Exception
	{
		int anz = 0;
		Class.forName("org.hsqldb.jdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select count(*) from "+table+";");
		rs.next();
		anz = rs.getInt(1); 
		
		rs.close();
		stmt.close();
		conn.close();
		
		return anz;
				
	
	}
	
	
	public static Vokabeln[] getVokabeln() throws Exception
	{
		Class.forName("org.hsqldb.jdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from Vokabeln;");

		int anz =  getAnz("Vokabeln");


		Vokabeln[] vBox = new Vokabeln[anz];
		int i = 0;

		while(rs.next())
		{
			vBox[i++] = new Vokabeln(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
			
		}
		
		rs.close();
		stmt.close();
		conn.close();

		return vBox;
	}
	
	public static Vokabeln[] getVokabelnByKapitel(int kapitelnr) throws Exception
	{
		int anz =  getAnz("Vokabeln");
		Vokabeln[] aid = getVokabeln();

		Vokabeln vokabeln = aid[0];
		
		for(int i =0; i<anz; i++)
		{
			if(kapitelnr == aid[i].getKapitelnr())
			{
				vokabeln = aid[i];
			}
		}
		return vokabeln;
	
	}
	
	public static Vokabeln[] getVokabelnByWortart(String wortart) throws Exception
	{
		int anz =  getAnz("Vokabeln");
		Vokabeln[] aid = getVokabeln();

		Vokabeln vokabeln = aid[0];
		
		for(int i =0; i<anz; i++)
		{
			if(wortart == aid[i].getWortart())
			{
				vokabeln = aid[i];
			}
		}
		return vokabeln;
	
	}

	
	public static void addVokabeln(String norwegisch, String deutsch, String anmerkung, int kapitelnr, String wortart) throws Exception
	{
		Class.forName("org.hsqldb.jdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
		Statement stmt = conn.createStatement();
		
		stmt.execute("Insert into Vokabeln Values (default, '"+norwegisch+"', '"+deutsch+"', '"+anmerkung+"', "+kapitelnr+", '"+wortart+"');");
		
		stmt.close();
		conn.close();
	
	}
}
