package mango.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;

import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MemberMailAction implements Action{

   @Override
   public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
     
	   request.setCharacterEncoding("UTF-8");

      // 보내는 사람(망고)
      String smtpServer = "smtp.naver.com";
      final String sendId = "mango_academy"; // 아이디
      final String sendPass = "gkrdnjs0000"; // 비밀번호
      String sendEmailAddress = "mango_academy@naver.com"; // 보내는 사람

      int smtpPort = 465; // SMTP 포트번호

      // 받는 사람 (가입할 사람의 주소)
      System.out.println(request.getParameter("email"));
      String recieveEamilAddress = request.getParameter("email");

      
      // 인증번호 4개를 랜덤으로 뽑아줌.
      int[] num_arr = new int[4];
      for (int i = 0; i < 4; i++) {
         num_arr[i] = (int) (Math.random() * 10);

      }
      
      // 인증 번호를 암호화 하기 위한 암호코드.
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

      // 인증 번호를 받을 때마다 인증 코드를 랜덤하게 섞어주는 코드 
      for (int i = 0; i < Str_arr.length; i++) {
         String S;
         S = Str_arr[i];
         int K;
         K = (int) (Math.random() * Str_arr.length);
         Str_arr[i] = Str_arr[K];
         Str_arr[K] = S;
      }
      
      // 섞인 코드를 확인한다
      for (int i = 0; i < Str_arr.length; i++) {
         System.out.print(Str_arr[i]);
      }
      
      String subject = "Mango(망고) 회원가입 인증 메일입니다"; // 메일 제목
      String checknum = "" + num_arr[0] + num_arr[1] + num_arr[2] + num_arr[3];
      String checkStr = Str_arr[num_arr[0]] + Str_arr[num_arr[0] + num_arr[1]]
			          + Str_arr[num_arr[0] + num_arr[1] + num_arr[2]]
			          + Str_arr[num_arr[0] + num_arr[1] + num_arr[2] + num_arr[3]];
      String content = "안녕하세요. Mango(망고) 회원 가입 인증 메일입니다."
      				 + "\n인증 번호는 " + num_arr[0] + num_arr[1] + num_arr[2] + num_arr[3] + "입니다."; // 메일 내용
      
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
         
         PrintWriter out = response.getWriter();

//         out.println("인증번호 : <input type='text' id=checknum1>");
//                 out.println("<input type='button' value='인증' onclick='check();'>");
                 

         out.println("<script type='text/javascript' src='http://code.jquery.com/jquery-3.2.0.min.js' ></script>");
         out.println("<link rel='stylesheet' type='text/css' href='styles/bootstrap4/bootstrap.min.css'>");
         out.println("<link rel='stylesheet' type='text/css' href='styles/form_basic_page.css'>");
         
         // <-------------- <style> -------------->
         out.println("<style type='text/css'>");
         out.println("input {height: 50px;}");
         out.println(".btn-primary {color:#fff !important;background-color: #000 !important;border-color: #000 !important;cursor: pointer !important;}");
         out.println(".btn-primary:hover {background-color: #6610f2 !important;}");
         out.println("#rememberCheck {margin-left: -25px; z-index: 1 ; opacity: 1;}");
         out.println(".authBtn {float:right; width:100px;} .authSpan{color: #000; font-size: 1.1em;}");
         out.println("</style> ");
         // <-------------- </style> -------------->
         
         
         // <-------------- <div> -------------->
         out.println("<div class='js-form-message form-group' id='startAuth'>");
		 	
         	out.println("<label class='form-label' for='id_password1'>");
		 		out.println("<span class='d-flex justify-content-between align-items-center authSpan'>인증번호</span>");
		 	out.println("</label>");
       
		 out.println("<input type='text' class='form-control' name='' id='checknum1' placeholder='인증번호 입력'");
		 out.println("aria-label='인증번호 입력' required >");
		 
		 out.println("<input type='button' class='btn btn-primary right-btn authBtn' value='인증' onclick='check();'> </div>");
		// <-------------- </div> -------------->
		 
		 
		// <-------------- <script> -------------->
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
        
         // 인증 코드를 비교하기 위해 저장 
         	out.println("var lastAns1='" + checkStr + "';");
         	
         
         // 입력한 번호를 코드화하여 , 인증 코드와 같은 지 비교.
         	out.println("if(lastAns1 == lastAns){");
         	
         	out.println("alert('이메일 인증이 완료되었습니다.');");
         // 이메일 인증 완료 후 인증버튼 숨기기 + 인증번호 입력창 readonly 전환
         	out.println("$('.authBtn').attr('style','display:none;');");
         	out.println("$('#checknum1').attr('readonly','readonly');");

     	 // 부모창인 member_sign_up.jsp의 flag역할 <input>태그에 성공값 주기(check()함수 에서 검증)
         	out.println("$(top.document).find('#fromIframe').val('success');");
         	out.println("document.join.mailDupId.value='"+recieveEamilAddress+"';");

	        out.println("}else{");
         
         // 이메일 인증에 실패하면 다시 이메일 인증을 받아야 하며,
         // 암호화 코드가 변함으로써 인증 코드를 예측 할 수 없게 한다. 
		        out.println("alert('이메일 인증에 실패하였습니다.');");
		        out.println("alert('다시 시도해 주십시오.');");
//		        out.println("window.close();");
         
		    out.println("}"); // else끝
         
	     out.println("}"); // function check() 끝 
        
	     out.println("</script>");

	  // <-------------- </script> -------------->
	     

      } catch (Exception e) {
    	  System.out.println("MemberMailAction : " + e);
         e.printStackTrace();
        
         response.setContentType("text/html; charset=UTF-8");
         
         PrintWriter out = response.getWriter();
         out.println("<script>");
         out.println("alert('이메일 인증에 실패하였습니다.');");
         out.println("alert('다시 시도해 주십시오.');");
//       out.println("window.close();");
         out.println("</script>");

	      }
	     return null;
   	  }
	
}