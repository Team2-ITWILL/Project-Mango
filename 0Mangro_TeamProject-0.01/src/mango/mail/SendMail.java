package mango.mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/SendMail")
public class SendMail extends HttpServlet{

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		 
		PrintWriter out = response.getWriter();



		String name = request.getParameter("counter_name"); 		
		String tel = request.getParameter("counter_tel");	 		
		String select = request.getParameter("counter_select");				
		String content = request.getParameter("counter_content");	
		String to = "mango.project0324@gmail.com";
		
		// 정보를 담음
		Properties p = new Properties(); 
		 
		// SMTP 서버에 접속하기 위한 정보
		p.put("mail.smtp.host", "smtp.gmail.com");	
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		 
		
		
		try{
			
			MailAuth auth = new MailAuth();
		    Session ses = Session.getInstance(p, auth);
		     
		    ses.setDebug(true);
		     
		    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		    msg.setSubject(name + "님이 등록 상담을 문의하셨습니다."); // 제목
		     
		     
		    Address toAddr = new InternetAddress(to);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
		    
		    // 보내는 사람의 정보를 버퍼에 저장
		    StringBuffer buffer = new StringBuffer();
		    buffer.append("이름: ");
		    buffer.append(name + "<br>");
		    buffer.append("연락처: ");
		    buffer.append(tel + "<br>");
		    buffer.append("신청인: ");
		    buffer.append(select + "<br>");
		    buffer.append("내용: ");
		    buffer.append(content + "<br>");
		
		    // 버퍼에 담은 내용을 내용으로 전달함
		    msg.setContent(buffer.toString(), "text/html;charset=UTF-8"); // 내용과 인코딩
		    Transport.send(msg); // 전송
		    
		    
		} catch(Exception e){
			
		    e.printStackTrace();
		    // 오류 발생시 뒷 페이지로 이동
		    out.println("<script>alert('메일 보내기에 실패하였습니다.');history.back();</script>");
		    return;
		}
		 
		// 성공 시
		out.println("<script>alert('메일을 성공적으로 전송하였습니다.');location.href='./4index.jsp';</script>");
	}
	
	
	

}
