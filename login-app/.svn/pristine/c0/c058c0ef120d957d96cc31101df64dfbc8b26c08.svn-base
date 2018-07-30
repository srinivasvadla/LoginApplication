package w3s.servlet.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

@WebServlet("/registerUser")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		
		if(StringUtils.isNotBlank(email) && StringUtils.isNotBlank(pwd)) {
			try {
				    boolean isRegDone = LoginUtils.saveUser(email,pwd);
				    if (isRegDone) {
				    	HttpSession session = request.getSession();
						session.setAttribute("regResponse", "Registration Successfull , Login with Credentials "+email+"   "+pwd); 
						response.sendRedirect("loginpage.jsp");
					}else {
						HttpSession session = request.getSession();
						session.setAttribute("regResponse", "Registration failed "); 
						response.sendRedirect("Signup.jsp");
					}
				    
			} catch (SQLException e) {
				System.out.println("catch");
				e.printStackTrace();
			}
			
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("regResponse", "Inputs cannot be empty!"); 
			response.sendRedirect("Signup.jsp");
		}
    	
    	
    }

}
