

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SavePatient")
public class SavePatient extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String date=req.getParameter("date");
		
		
		Patient p=new Patient();
		p.setId(id);
		p.setName(name);
		p.setDate(date);
		
		
		int status=PatientDao.save(p);
		if(status>0)
		{
			pw.println("Record inserted successfully");
			req.getRequestDispatcher("BedAvailability.html").include(req, res);
			
		}
		else
		{
			pw.println("Sorry not inserted");
		}
		
	}
}
