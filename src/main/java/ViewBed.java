
import java.io.*;
import java.util.List;import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;@WebServlet("/ViewBed")
public class ViewBed extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<a href='BedAvailability.html'>Add new Patient</a>");
		pw.print("<h1>Bed Availability </h1>");
		List<Patient> list = PatientDao.getAllEmployees();
		pw.println("<table border='1' width=100%");
		pw.println("<tr><th>ID</th><th>Name</th><th>DATE</th><th>Edit</th><th>Delete</th></tr>");
		for (Patient p : list) {
			pw.println("<tr><td>"+p.getId()+"</td><td>"+p.getName()+"</td><td>"+p.getDate()+"</td><td><a href='EditBed?id="+p.getId()+"'>Edit</a></td><td><a href='DeleteBed?id="+p.getId()+"'>Delete</a></td></tr>");
		}
		pw.println("</table>");
	}
}

