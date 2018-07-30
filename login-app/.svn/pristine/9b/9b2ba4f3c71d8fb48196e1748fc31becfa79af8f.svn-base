package w3s.servlet.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GetDeletedMail")
public class GetDeletedMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection  con=	LoginUtils.getConnection();
		if(con!=null){
			System.out.println("connnection created in deletmail servlet");
		}
		else{
			System.out.println("no connection from getDeleteMail");
		}
		
		try {
			String currentUserId = (String) request.getSession().getAttribute("sessionMailId");
			

			
			List<Mail> deletedmails = LoginUtils.getDeletedMail(currentUserId);
			System.out.println("enter from getDeleteMail");
			
			System.out.println(deletedmails.size());

			HttpSession session = request.getSession();
			session.setAttribute("deletedmails", deletedmails);
			session.setAttribute("deletedmailsCount", deletedmails.size());

			response.sendRedirect("deletedmail.jsp");

			System.out.println("exit from getDeleteMail");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
