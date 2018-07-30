package w3s.servlet.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginUtils {
	public static final String sql = "select * from gmail_users where username = ? and password = ? and user_status = ?";
	public static final String regSql = "insert into gmail_users(username,password,user_status) values(?,?,?)";
	public static final String deleteMail = "delete from all_mails where mail_unique_id = ?";
	public static final String sendMessageSql = "insert into all_mails(from_mail,to_mail,message,mailed_date_time,subject,file_name) values(?,?,?,?,?,?)";
	public static final String selectQueryForMail = "select * from gmail_users where username = ?";
	public static final String getMails = "select  * from all_mails where from_mail=? ORDER BY mail_unique_id DESC";
	public static final String getIncomingMails = "select  * from all_mails where to_mail=? ORDER BY mail_unique_id DESC";
	public static final String getAmailByUniqID = "select  * from all_mails where mail_unique_id = ?";
	public static final String logindetailshistory="insert into loginhistory (user_login_details,date_logged_in) values(?,?)";
	
	public static final String trashsendMessageSql = "insert into mails_deleted(mail_uniq_id,from_mail_id,to_mail,message,mailed_date_time,subject,user_id,deleted_date_time,file_name) values(?,?,?,?,?,?,?,?,?)";
	public static final String getDeletedMail="select * from  mails_deleted where user_id = ?";
	private static String url = "jdbc:mysql://localhost:4040/srinu";
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String username = "root";
	private static String password = "root";
	private static Connection con;
	 static Date date=null;

	public static boolean validateUser(String email, String pwd) throws SQLException {
		boolean loginStatus = false;

		Connection con = getConnection();
		System.out.println(con != null ? "Connection is Created" : "con is null");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, pwd);
		ps.setString(3, "ACTIVE");

		ResultSet rs = ps.executeQuery();
		System.out.println("inside the LoginUtils validate users");
		if (rs != null) {
			while (rs.next()) {
				
				String dbUser = rs.getString("username");
				String dbPwd = rs.getString("password");
				System.out.println( "in the LoginUtils validate users while");
				
				System.out.println("dbuser : " + dbUser);
				System.out.println("db pwd : " + dbPwd);
				loginStatus = true;

			}

		} else {
			System.out.println("No records found with given values");
			loginStatus = false;
		}

		return loginStatus;

	}

	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(url, username, password);
				if (con != null) {
					System.out.println("DB connection created");
				} else {
					System.out.println("Failed to create the database connection.");
				}

			} catch (SQLException ex) {

			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver not found.");
		}
		return con;
	}

	public static boolean saveUser(String email, String pwd) throws SQLException {
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement(regSql);
		ps.setString(1, email);
		ps.setString(2, pwd);
		ps.setString(3, "ACTIVE");

		int rowsAffected = ps.executeUpdate();

		return rowsAffected == 1 ? true : false;

	}

	public static boolean validateMailId(String toMail) throws SQLException {
		System.out.println("searching " + toMail + "   on the db");
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(selectQueryForMail);
		ps.setString(1, toMail);

		ResultSet rs = ps.executeQuery();

		if (rs != null) {
			while (rs.next()) {
				System.out.println("Result set having some records ");
				String dbReturnedEmail = rs.getString("username");
				System.out.println("dbReturnedEmail : " + dbReturnedEmail);
				if (toMail.equalsIgnoreCase(dbReturnedEmail)) {
					return true;
				}
			}

		} else {
			System.out.println("result set is empty");
		}

		return false;
	}

	public static boolean sendMessage(String fromMail, String toMail, String mailContent, String mailSub,String file_name) throws SQLException {
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement(sendMessageSql);
		ps.setString(1, fromMail);
		ps.setString(2, toMail);
		ps.setString(3, mailContent);
		ps.setString(4, new Date().toString());
		ps.setString(5, mailSub);
		ps.setString(6, file_name);

		int rowsAffected = ps.executeUpdate();
		return rowsAffected == 1 ? true : false;
	}
	// Get the all mails from the user
	public static List<Mail> getAllSentMails(String fromMail) throws SQLException {
		System.out.println("ENTER getAllSentMails() ");
		List<Mail> mails = new ArrayList<Mail>();
		PreparedStatement ps = con.prepareStatement(getMails);
		ps.setString(1, fromMail);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Mail mail = new Mail(String.valueOf(rs.getInt("mail_unique_id")), rs.getString("to_mail"),
					rs.getString("message"), rs.getString("mailed_date_time"), rs.getString("subject"),rs.getString("file_name"));
			
			/*Mail mail = new Mail(String.valueOf(res.getInt("mail_unique_id")),
					res.getString("mail_from_id"),
					res.getString("to_mail"),
					res.getString("message"),
					res.getString("subject"),
					res.getString("mailed_date_time"),
					res.getString("user_id"),
					res.getString("deleted_date_time"),
					res.getString("file_name"),
					res.getString("file_src"));
*/
			System.out.println("SentMails : " + mail);
			mails.add(mail);

		}
		System.out.println("EXIT getAllSentMails() " + mails.size());
		return mails;
	}

	public static List<Mail> getIncomingMails(String currentUserId) throws SQLException {
		System.out.println("ENTER getIncomingMails() ");
		List<Mail> mails = new ArrayList<Mail>();
		PreparedStatement ps = con.prepareStatement(getIncomingMails);
		ps.setString(1, currentUserId);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Mail mail = new Mail(String.valueOf(rs.getInt("mail_unique_id")), rs.getString("from_mail"),
					rs.getString("message"), rs.getString("mailed_date_time"), rs.getString("subject"),rs.getString("file_name"));
			/*
			Mail mail=new Mail(String.valueOf(res.getInt("mail_uniq_id")), res.getString("mail_from_id"), res.getString("to_mail"),
					res.getString("message"), res.getString("subject"),res.getString("mailed_date_time") ,res.getString("user_id"),
					res.getString("deleted_date_time"), res.getString("file_name"), res.getString("file_src"));
				*/
			
			System.out.println("IncomingMails : " + mail);
			mails.add(mail);

		}
		System.out.println("EXIT getIncomingMails() " + mails.size());
		return mails;
	}
   // To delete the mail 
	public static boolean deleteThisMail(String mailUniqueID,String currentUserId) throws SQLException {
		System.out.println("ENTER deleteThisMail() "+mailUniqueID);
		System.out.println("current User ID : "+currentUserId);
		Connection conn = getConnection();
		PreparedStatement psgetMailByUniqID =conn.prepareStatement(getAmailByUniqID);
		psgetMailByUniqID.setInt(1,Integer.parseInt(mailUniqueID));
		
		ResultSet rs =  psgetMailByUniqID.executeQuery();
		while (rs.next()) {		
			
			PreparedStatement pstoCopyOnTrashTable =conn.prepareStatement(trashsendMessageSql);
			pstoCopyOnTrashTable.setInt(1,rs.getInt("mail_unique_id"));
			pstoCopyOnTrashTable.setString(2, rs.getString("from_mail"));
			pstoCopyOnTrashTable.setString(3, rs.getString("to_mail"));
			pstoCopyOnTrashTable.setString(4, rs.getString("message"));
			pstoCopyOnTrashTable.setString(5, rs.getString("mailed_date_time"));
			pstoCopyOnTrashTable.setString(6, rs.getString("subject"));
			pstoCopyOnTrashTable.setString(7, currentUserId);
			pstoCopyOnTrashTable.setString(8, new Date().toString());
			pstoCopyOnTrashTable.setString(9, rs.getString("file_name"));
			
			int  rowscopiedOnTrash = pstoCopyOnTrashTable.executeUpdate();
			
			System.out.println("Mail Copied on Trash : "+(rowscopiedOnTrash ==1?" : yes Copied on Trash" : "Problem in copying on trash>>>>>>>" ));

		}
		
		PreparedStatement ps =conn.prepareStatement(deleteMail);
		ps.setInt(1, Integer.parseInt(mailUniqueID));
		System.out.println("trimmed id : "+mailUniqueID);
		int rowsDeleted = ps.executeUpdate();
		System.out.println("ENTER deleteThisMail() "+rowsDeleted);
		return rowsDeleted >0 ? true : false;
	}

	// To get the deleted mails in trash box
	public static List<Mail> getDeletedMail(String currentUserID)throws SQLException {		
		System.out.println("ENTER getDeletedMail()");
		PreparedStatement ps = con.prepareStatement(getDeletedMail);
		List<Mail> maillist = new ArrayList();
		ps.setString(1, currentUserID);
		
		ResultSet res = ps.executeQuery();

		while (res.next()) {
			System.out.println("while loop in --getDeletedMail()--");

			Mail mail = new Mail(String.valueOf(res.getInt("mail_uniq_id")),
					res.getString("from_mail_id"), res.getString("to_mail"),
					 res.getString("message"),res.getString("subject"),res.getString("file_name"));

		/*	Mail mail = new Mail(String.valueOf(res.getInt("mail_uniq_id")),
					res.getString("mail_from_id"), 
					res.getString("to_mail"),
					res.getString("message"),
					res.getString("subject"),
					res.getString("mailed_date_time"),
					res.getString("user_id"),
					res.getString("deleted_date_time"),
					res.getString("file_name"), 
					res.getString("file_src"));*/

			maillist.add(mail);
			System.out.println("get the deleted mail to trash");
			System.out.println("deleted mail size is " + maillist.size());

		}
		System.out.println("EXIT getDeletedMail()");
		return maillist;

	}

	public static int storeloginDetailsToDB(String email,Object date) throws SQLException {
		
		
		 PreparedStatement logdetails=con.prepareStatement(logindetailshistory);
		 
	 
		// Date date1=  new Date();
		 logdetails.setString(1, email);
		 logdetails.setString(2,  new Date().toString());
		 
		 int result=logdetails.executeUpdate();
		 
		 if(result>0){
			 System.out.println("history are updated to the table user is ::"+email);
		 }
		 else
		 {
			 System.out.println("history are not updated to the table! ");
		 }
		
		return result;
	}
}
