package mango.qna_board.action;

import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mango.action.Action;
import mango.action.ActionForward;

public class QnaBoardFrontController extends HttpServlet{
  
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	  
		
    request.setCharacterEncoding("UTF-8");

    
    String RequestURI = request.getRequestURI();
    System.out.println(RequestURI);
    

    String contextPath = request.getContextPath();
    System.out.println(contextPath);

    
    System.out.println(contextPath.length());

    
    String command = RequestURI.substring(contextPath.length());
    System.out.println(command);

    
    ActionForward forward = null;

    
    Action action = null;

    if (command.equals("/QnaBoard.qna")){
    	
      action = new QnaBoardListAction();
      
      try {
    	  
    	  forward = action.excute(request, response);
    	  
      } catch (Exception e) {
        
    	  e.printStackTrace();
      }
      

    }
    else if (command.equals("/QnaBoardSearch.qna")) {
    	
      action = new QnaBoardListSearchAction();
      
      try{
    	  
        forward = action.excute(request, response);
      
      } catch (Exception e) {
      
    	  e.printStackTrace();
      
      }
    
    }
    else if (command.equals("/QnaBoardWrite.qna")){
    	
      forward = new ActionForward();
      forward.setRedirect(false);
      forward.setPath("./4index.jsp?center=O_qna/qna_write.jsp");
      
    } 
    else if (command.equals("/QnaBoardWriteAction.qna")) {
    	
      action = new QnaBoardWriteAction();
      
      try{
    	  
        forward = action.excute(request, response);
      
      } catch (Exception e) {
       
    	  e.printStackTrace();
      
      }
      
    }
    else if (command.equals("/QnaBoardContent.qna")){
    	
      action = new QnaBoardContentAction();
      
      try{
        forward = action.excute(request, response);
      } catch (Exception e) {
        e.printStackTrace();
      }

    }
    else if (command.equals("/QnaBoardUpdate.qna")){
    	
      action = new QnaBoardUpdate();
      
      try {
        forward = action.excute(request, response);
      } catch (Exception e) {
        e.printStackTrace();
      }

    }
    else if (command.equals("/QnaBoardUpdateAction.qna")){
    	
      action = new QnaBoardUpdateAction();
      
      try{
        forward = action.excute(request, response);
      } catch (Exception e) {
        e.printStackTrace();
      }
      
    }
    else if (command.equals("/QnaBoardDelete.qna")){
    	
      forward = new ActionForward();   
      forward.setRedirect(false);
      forward.setPath("./4index.jsp?center=O_qna/qna_delete.jsp");
      
    }
    else if (command.equals("/QnaBoardDeleteAction.qna")){
    	
      action = new QnaBoardDeleteAction();
      
      try{
        forward = action.excute(request, response);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    else if (command.equals("/QnaBoardReWrite.qna")){
    	
      forward = new ActionForward();
      forward.setRedirect(false);
      forward.setPath("./4index.jsp?center=O_qna/qna_rewrite.jsp");
      
    }
    else if (command.equals("/QnaBoardReWriteAction.qna")){
    	
      action = new QnaBoardReWriteAction();
      
      try{
        forward = action.excute(request, response);
      } catch (Exception e) {
        e.printStackTrace();
      }
 
    } 
    else if (command.equals("/QnaBoardSecret.qna")){
    	
      forward = new ActionForward();
      forward.setRedirect(false);
      forward.setPath("./4index.jsp?center=O_qna/qna_secret.jsp");
      
    }
    else if (command.equals("/QnaBoardSecretAction.qna")){
    	
      action = new QnaBoardSecretAction();
      
      try{
        forward = action.excute(request, response);
      } catch (Exception e) {
        e.printStackTrace();
      }
      
    } else if (command.equals("/QnaManagement.qna")){
    	
    	action = new QnaManagementListAction();
    	
        try {
      	  
      	  forward = action.excute(request, response);
      	  
        } catch (Exception e) {
          
      	  e.printStackTrace();
        }
        
        
    }  else if (command.equals("/MyQnaList.qna")){
    	
    	action = new MyQnaListAction();
    	
        try {
      	  
      	  forward = action.excute(request, response);
      	  
        } catch (Exception e) {
          
      	  e.printStackTrace();
        }
        

    } else if (command.equals("/QnaBoardDeleteAdmin.qna")){
    	
    	action = new QnaBoardDeleteAdminAction();
        
        try{
        	
          forward = action.excute(request, response);
          
        } catch (Exception e) {
        	
          e.printStackTrace();
          
        }
    	
    }
    

    
    
    if (forward != null){
    	
      if (forward.isRedirect()){
        response.sendRedirect(forward.getPath());
      }
      else{
        RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
        dispatcher.forward(request, response);
      }
      
    }
    
    
    
  }
	
	

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doProcess(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doProcess(request, response);
  }

}