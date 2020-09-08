package mango.member.action;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberBean;
import mango.member.db.MemberDAO;
public class MemberFindPwAction implements Action{
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		/* 비밀번호 조회하기 */
		MemberDAO mdao = new MemberDAO();
		String email = (String)request.getParameter("id_email");
		MemberBean mb = mdao.findPw(email);
		
		if(mb != null){
			
			response.setContentType("text/html; charset=UTF-8"); 
			
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호를 전송했습니다.')");
			out.println("</script>");
			
			// 보내는 사람(망고)
			String smtpServer = "smtp.naver.com";
		    final String sendId = "mango_academy"; // 아이디
		    final String sendPass = "gkrdnjs0000"; // 비밀번호
		    String sendEmailAddress = "mango_academy@naver.com"; // 보내는 사람
		    int smtpPort = 465; // SMTP 포트번호
			
		    // 받는 사람 (가입할 사람의 주소)
		    System.out.println(request.getParameter("id_email"));
		    String recieveEamilAddress = request.getParameter("id_email");
			
		    String subject = "Mango(망고) 비밀번호 확인 메일입니다"; // 메일 제목
		    String content = "안녕하세요. Mango(망고) 비밀번호 확인 메일입니다."
		      				 + "\n비밀번호는 "+ mb.getMemPwd() + " 입니다.";
		    
			try {
				Properties props = System.getProperties();
			    props.put("mail.smtp.host", smtpServer);
			    props.put("mail.smtp.port", smtpPort);
			    props.put("mail.smtp.auth", "true");
			    props.put("mail.smtp.ssl.enable", "true");
			    props.put("mail.smtp.ssl.trust", smtpServer);
			    
			    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			       protected PasswordAuthentication getPasswordAuthentication() {
			          return new PasswordAuthentication(sendId, sendPass);
			       }
			       
			    });
			
			session.setDebug(true);
		         
	        Message mimeMessage = new MimeMessage(session);
	        mimeMessage.setFrom(new InternetAddress(sendEmailAddress));
	        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recieveEamilAddress));
	        mimeMessage.setSubject(subject);
	        mimeMessage.setText(content);
	        Transport.send(mimeMessage);
			
	        response.setContentType("text/html; charset=UTF-8");
	        out.println("<script>");
	        out.println("location.href='./MemberLogin.me'");
	        out.println("</script>");
	        
			} catch (Exception e) {
				e.printStackTrace();
		        System.out.println("MemberFindPwAction : " + e);
		        response.setContentType("text/html; charset=UTF-8");
		        out.println("<script>");
		        out.println("alert('이메일 인증에 실패하였습니다.');");
		        out.println("alert('다시 시도해 주십시오.');");
		        out.println("window.close();");
		        out.println("</script>");
			}
			return null;
		}else{
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('가입한 이메일이 없습니다.')");
			out.println("location.href='./MemberFindPw.me'");
			out.println("</script>");
		}
		
//		ActionForward forward = new ActionForward();
//		forward.setRedirect(false);
//		forward.setPath("./MemberFindPw.me");
		return null;
	}
	
}