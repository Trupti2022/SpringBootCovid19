import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@WebServlet("/PatientDao")
public class PatientDao extends HttpServlet
	

	{
		public static Connection getConnection()
		{
			Connection con=null;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","1234");
			}
			catch(Exception ae)
			{	ae.printStackTrace();}
			return con;
		}

	public static int save(Patient p)
	{
		int status=0;
		try
		{
			Connection con=PatientDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Patient(id,name,date1) values(?,?,?)");
			ps.setString(1,p.getId());
			ps.setString(2,p.getName());
			ps.setString(3,p.getDate());
			status=ps.executeUpdate();
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
		return status;
	}
	public static int update(Patient p)
	{
		int status=0;
		try
		{
			Connection con=PatientDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update Patient set name=?,date1=? where id=?");
			ps.setString(1, p.getName());
			ps.setString(2,p.getDate());
			ps.setString(3, p.getId());
			status=ps.executeUpdate();
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
		return status;
	}

	public static int delete(String id)
	{
		int status=0;
		try
		{
			Connection con=PatientDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from Patient where id=?");
			ps.setString(1,id);
			status=ps.executeUpdate();
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
		return status;
	}

	public static Patient getPatientById(String id)
	{
		Patient p=new Patient();
		try
		{
			Connection con=PatientDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Patient where id=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				p.setId(rs.getString(1));
				p.setName(rs.getString(2));
				p.setDate(rs.getString(3));
					}
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
		return p;
	}

	public static List<Patient> getAllEmployees()
	{
		List<Patient> list=new ArrayList<Patient>();
		try
		{
			Connection con=PatientDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Patient");
				ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Patient p=new Patient();
				p.setId(rs.getString(1));
				p.setName(rs.getString(2));
				p.setDate(rs.getString(3));
				list.add(p);
					}
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
		return list;
	}


}
