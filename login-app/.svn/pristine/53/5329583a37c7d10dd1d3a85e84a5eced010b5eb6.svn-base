package w3s.servlet.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AllOutboxMails")
public class AllOutboxMails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentUserId = (String) request.getSession().getAttribute("sessionMailId");
		System.out.println("from outbox mails");

		try {

			
		
			List<Mail> outboxMails = LoginUtils.getAllSentMails(currentUserId);
			
			System.out.println("ENTER All MAILS ");
			HttpSession session = request.getSession();
			session.setAttribute("alloutboxMailsCount", outboxMails.size());			
			session.setAttribute("alloutboxMails", outboxMails);
			
			response.sendRedirect("outboxmails.jsp");

		} catch (Exception e) {
			System.out.println("CATCH outbox MAILS ");
			e.printStackTrace();
		}

	}

}
