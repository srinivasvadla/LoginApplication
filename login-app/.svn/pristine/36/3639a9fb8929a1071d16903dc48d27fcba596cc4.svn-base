package w3s.servlet.login;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

@WebServlet("/sendMail")
@MultipartConfig
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "D:/uploads";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String toMail = req.getParameter("tomail");
		String mailContent = req.getParameter("mailContent");
		String mailSub = req.getParameter("subject");

		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		System.out.println("isMultipart >>>" + isMultipart);

		// process only if its multipart content
		if (isMultipart) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(req);
				
				System.out.println(multiparts.size());
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						System.out.println("file name : " + name);
						File file = new File(UPLOAD_DIRECTORY + File.separator
								+ name);
						System.out.println("File path : "
								+ file.getAbsolutePath());
						item.write(file);
					} else {
						System.out.println("isFormFieldisFormFieldisFormField");
					}
				}

				// File uploaded successfully
				System.out.println("File Uploaded Successfully");
			} catch (Exception ex) {
				System.out.println("File Upload Failed due to " + ex);
			}

		} else {
			System.out.println("File not detected!!!!!!!!!!!");
		}

		String fromMail = (String) req.getSession().getAttribute(
				"sessionMailId");

		if (fromMail == null) {
			res.sendRedirect("loginpage.jsp");
		}

		if (StringUtils.isNotBlank(toMail)
				&& StringUtils.isNotBlank(mailContent)) {
			// send logic
			try {
				boolean isThereOnDB = LoginUtils.validateMailId(toMail);
				if (isThereOnDB) {
					boolean isMailSent = LoginUtils.sendMessage(fromMail,
							toMail, mailContent, mailSub, null);
					if (isMailSent) {
						HttpSession session = req.getSession();
						session.setAttribute("mailStatusMsg", "Mail sent to  "
								+ toMail);

						session.setAttribute("frommail", fromMail);
						res.sendRedirect("createMail.jsp");
					}

				} else {
					HttpSession session = req.getSession();
					session.setAttribute("mailStatusMsg",
							"Sorry  we could not find anything with this :"
									+ toMail);
					res.sendRedirect("createMail.jsp");
				}

			} catch (SQLException e) {
				System.out.println("mailservlet  in catch");
				e.printStackTrace();
			}
		} else {
			req.getSession().setAttribute("mailStatusMsg",
					"pls provide mail and content");
			res.sendRedirect("createMail.jsp");
		}

	}

}
