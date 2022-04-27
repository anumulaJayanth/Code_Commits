package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.Dao;

/**
 * Servlet implementation class InsertFlight
 */
@WebServlet("/InsertFlight")
public class InsertFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		String price=request.getParameter("price");
		
		HashMap<String,String> flight=new HashMap<>();
		flight.put("name", name);
		flight.put("source", source);
		flight.put("destination", destination);
		flight.put("date", date);
		flight.put("time", time);
		flight.put("price", price);	
			try {
				Dao dao = new Dao();
				HttpSession session=request.getSession();
				if(dao.insertFlight(flight)) {
					session.setAttribute("message", "Flight Added Successfully");
				}
				else {
					session.setAttribute("message", "Invalid Details");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		response.sendRedirect("AdminHome.jsp");
		
	}
}
