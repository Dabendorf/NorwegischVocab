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
		int anz =0;
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
	
	
	public static Sonnensystem[] getSonnensysteme() throws Exception
	{
		Class.forName("org.hsqldb.jdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from Sonnensysteme;");

		int anz =  getAnz("Sonnensysteme");


		Sonnensystem[] sBox = new Sonnensystem[anz];
		int i = 0;

		while(rs.next())
		{
			sBox[i++] = new Sonnensystem(rs.getInt(1), rs.getString(2));
			
		}
		
		rs.close();
		stmt.close();
		conn.close();

		return sBox;


	}
	
	public static Sonnensystem getSonnensystemByID(int ID) throws Exception
	{
		int anz =  getAnz("Sonnensysteme");
		Sonnensystem[] aid = getSonnensysteme();

		Sonnensystem sonnensystem = aid[0];
		
		for(int i =0; i<anz; i++)
		{
			if(ID == aid[i].getID())
			{
				sonnensystem = aid[i];
			}
		}
		return sonnensystem;
	
	}
	
	public static Sonnensystem getSonnensystemByName(String name) throws Exception
	{
		int anz =  getAnz("Sonnensysteme");
		Sonnensystem[] aid = getSonnensysteme();

		Sonnensystem sonnensystem = aid[0];
		
		for(int i =0; i<anz; i++)
		{
			if(name == aid[i].getName())
			{
				sonnensystem = aid[i];
			}
		}
		return sonnensystem;
	
	}
	
	public static void addSonnensystem(String name) throws Exception
	{
		Class.forName("org.hsqldb.jdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
		Statement stmt = conn.createStatement();
		
		stmt.execute("Insert into Sonnensysteme Values (default, '"+name+"');");
		
		stmt.close();
		conn.close();
	
	}
	
		
	public static Planet[] getPlaneten() throws Exception
	{
		Class.forName("org.hsqldb.jdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from Planeten;");

		int anz =  getAnz("Planeten");


		Planet[] pBox = new Planet[anz];
		int i = 0;

		while(rs.next())
		{
			pBox[i++] = new Planet(rs.getInt(1), rs.getString(2), getSonnensystemByID(rs.getInt(3)));
			
		}
		
		rs.close();
		stmt.close();
		conn.close();

		return pBox;


	}
	
	public static void addPlanet(String name,String planetenname, String sonnenSName) throws Exception
	{
		Class.forName("org.hsqldb.jdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
		Statement stmt = conn.createStatement();
		
		stmt.execute("Insert into Planeten Values ("+planetenname+","+getSonnensystemByName(sonnenSName).getID()+");");
		
		stmt.close();
		conn.close();
	
	}

	

}
