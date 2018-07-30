package w3s.servlet.login;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AllMails")
public class AllMails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fromMail = (String) request.getSession().getAttribute("frommail");

		String currentUserId = (String) request.getSession().getAttribute("sessionMailId");
		System.out.println("from ALLMails   ");

		try {

			//refgfdhjh
		System.out.println("in All mail Servlet servlet");
			List<Mail> outboxMails = LoginUtils.getAllSentMails(currentUserId);
			List<Mail> InboxMails = LoginUtils.getIncomingMails(currentUserId);
			System.out.println("ENTER All MAILS ");
			HttpSession session = request.getSession();
			session.setAttribute("alloutboxMailsCount", outboxMails.size());
			session.setAttribute("allInboxMailsCount", InboxMails.size());

//			if (outboxMails.size() == 0) {
//				session.setAttribute("allOutBoxMails", "no mails ");
//			}
//			if (InboxMails.size() == 0) {
//				session.setAttribute("allOutBoxMails", "no mails ");
//			}
			session.setAttribute("allInboxMails", InboxMails);
			session.setAttribute("alloutboxMails", outboxMails);
			System.out.println("ENTER  ELSE All MAILS ");
			response.sendRedirect("mails.jsp");

		} catch (Exception e) {
			System.out.println("CATCH All MAILS ");
			e.printStackTrace();
		}

	}

}
