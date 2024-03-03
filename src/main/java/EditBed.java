import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 
/**
 * Servlet implementation class EditBed
 */
@WebServlet("/EditBed")   
public class EditBed extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<h1>Update Corona</h1><hr>");
		String id=req.getParameter("id");
		//int id=Integer.parseInt(sid);
		Patient p=PatientDao.getPatientById(id);
		pw.println("<form action='EditBed2' method=get>");
		pw.println("<table>");
		pw.println("<tr><td>ID: <td><input type=text name=id size=20 value="+p.getId()+"></tr>");
		pw.println("<tr><td>Name: <td><input type=text name=name size=20 value="+p.getName()+"></tr>");
		pw.println("<tr><td>Date: <td><input type=text name=date size=20 value="+p.getDate()+"></tr>");

		pw.println("<tr><td><input type=submit value='Save'></td></tr></table></form>");
	}
}