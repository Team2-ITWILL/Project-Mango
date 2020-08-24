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

// 이메일 인증 번호를 발송하는 기능의 액션클래스
public class MemberMailAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
	
		request.setCharacterEncoding("UTF-8");
		
		// 인증메일을 보내는 사람(망고)
		String host = "smtp.gmail.com";
		final String user = "gyrud6744"; // 자신의 네이버 계정
		final String password = "busy1260@";// 자신의 네이버 패스워드
		String sendEmailAddress = "gyrud6744@gmail.com";

		// 인증메일을 받는 사람
		System.out.println(request.getParameter("id_email"));
		String to_email = request.getParameter("id_email");
		
		// 랜덤으로 인증번호 4자리를 뽑아준다.
		int[] num_arr = new int[4];
		for (int i = 0; i < 4; i++) {
			num_arr[i] = (int) (Math.random() * 10);
		}

		// 인증번호를 암호화 하기 위한 암호코드.
        String[] Str_arr = new String[] {"─","│",
							             "├","┬","┤","┴",
							             "┼","━","┃",
							             "┣","┳","┫",
							             "┻","╋","┠","┯","┨",
							             "┷","┿","┝","┰","┥",
							             "┸","╂",
							             "┞","┟ ","┡","┢","┦",
							             "┧","┪","┭","┮","┱",
							             "┲","┵","┶","┹","┺",
							             "┽","┾","╀","╁","╃",
							             "╄","╅","╆","╇","╈",
							             "╉","╊","l","ㅣ","I"};
		
	    // 인증 번호를 받을 때마다 인증암호 코드가 랜덤하게 섞어주는 코드 
	    for (int i = 0; i < Str_arr.length; i++) {
		       String S;
		       S = Str_arr[i];
		       int K;
		       K = (int) (Math.random() * Str_arr.length);
		       Str_arr[i] = Str_arr[K];
		       Str_arr[K] = S;
	    }
        
	    // 섞인 코드를 확인한다. 
	    for (int i = 0; i < Str_arr.length; i++) {
	         System.out.print(Str_arr[i]);
	    }
	    
		String subject = "Mango(망고) 회원가입 인증메일입니다."; // ---제목
	    String checknum = "" + num_arr[0] + num_arr[1] + num_arr[2] + num_arr[3];
	    String checkStr = Str_arr[num_arr[0]] + Str_arr[num_arr[0] + num_arr[1]]
	            + Str_arr[num_arr[0] + num_arr[1] + num_arr[2]]
	            + Str_arr[num_arr[0] + num_arr[1] + num_arr[2] + num_arr[3]];
	    String content = "안녕하세요. 가입 인증 메일입니다.\n인증번호는 " + num_arr[0] + num_arr[1] + num_arr[2] + num_arr[3] + "입니다."; // ---내용
		
		// SMTP 서버 정보를 설정한다.
		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", host); 
			props.put("mail.smtp.port", 465);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.trust", host);
			
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			
			// 메일 내용
			session.setDebug(true); // for debug
	        Message mimeMessage = new MimeMessage(session);
	        mimeMessage.setFrom(new InternetAddress(sendEmailAddress));
	        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
	        mimeMessage.setSubject(subject);
	        mimeMessage.setText(content);
	        Transport.send(mimeMessage);
	        response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("인증번호 : <input type='text' id=checknum1>");
	        out.println("<input type='button' value='인증' onclick='check();'>");
	        out.println("<script type='text/javascript' src='http://code.jquery.com/jquery-3.2.0.min.js' ></script>");
	        out.println("<script type='text/javascript'>");
	        out.println("function check(){");
	        out.println("var str=$('#checknum1').val();");
	        out.println("var ansArr1='';");
	        
	        for (int i = 0; i < Str_arr.length; i++) {
	           out.println("ansArr1=ansArr1+'" + Str_arr[i] + "';");
            }
	        
	        // 입력한 인증번호를 암호화 
	        out.println(
	              "var lastAns= (ansArr1.charAt(str.charAt(0)*1)+ansArr1.charAt(str.charAt(0)*1+str.charAt(1)*1)+ansArr1.charAt(str.charAt(0)*1+str.charAt(1)*1+str.charAt(2)*1)+ansArr1.charAt(str.charAt(0)*1+str.charAt(1)*1+str.charAt(2)*1+str.charAt(3)*1));");
	        
	        //인증 코드를 비교하기 위해 저장 
	        out.println("var lastAns1='" + checkStr + "';");
	        
	        // 입력한 번호를 코드화하여 , 인증 코드와 같은 지 비교.
	        out.println("if(lastAns1==lastAns){");
	        
	        out.println("alert('이메일 인증이 성공 하였습니다.');");
	        
	        out.println("opener.document.join.mailDup.value='mailCheck';");
	        out.println("opener.document.join.mailDupId.value='"+to_email+"';");
	         
	        out.println("window.close();");

	        out.println("}else{");
	  
	        //이메일 인증에 실패하면 다시 이메일 인증을 받아야 되고, 암호화 코드도 변함으로써 인증코드 예측을 더 어렵게 만듬. 
	        out.println("alert('이메일 인증이 실패 하였습니다.');");
	        out.println("alert('다시 시도해 주십시오.');");
	        out.println("window.close();");
	        out.println("}");
	        out.println("}");
	        out.println("</script>");
	        
		}catch(Exception e){
			e.printStackTrace();
	        response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>");
	        out.println("alert('이메일 인증이 실패 하였습니다.');");
            out.println("alert('다시 시도해 주십시오.');");
	        out.println("window.close();");
	        out.println("</script>");
		}
		
		return null;
	} // excute() 끝

}