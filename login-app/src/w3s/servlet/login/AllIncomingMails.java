package w3s.servlet.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AllIncomingMails")
public class AllIncomingMails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentUserId = (String) request.getSession().getAttribute("sessionMailId");
		System.out.println("Incoming mails");
		
		try {		
				
				List<Mail> InboxMails = LoginUtils.getIncomingMails(currentUserId);
			
				HttpSession session = request.getSession();
				
				session.setAttribute("allInboxMailsCount", InboxMails.size());

				session.setAttribute("allInboxMails", InboxMails);			
				
				response.sendRedirect("mails.jsp");

			} catch (Exception e) {
				System.out.println("CATCH INCOMING MAILS ");
				e.printStackTrace();
			}

	}

}
