package mango.academy_register.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.academy.db.AcademyBean;
import mango.academy.db.AcademyDAO;
import mango.academy_keyword.db.AcademyKeywordBean;
import mango.academy_keyword.db.AcademyKeywordDAO;
import mango.academy_register.db.AcademyRegisterDAO;
import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberDAO;

public class AcademyRegisterApproveAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		//email : 사이트 관리자 계정 이메일
		//String email = (String)request.getSession().getAttribute("id_email");
		
		//regEmail : 학원관리자 등록을 요청한 사용자의 이메일
		String regEmail = request.getParameter("regEmail");
		
		//학원이름
		String acaName = request.getParameter("acaName");
		
		//키워드
		String aca_keyword = request.getParameter("aca_keyword");
		
		//confirm_date 값 변경 기준 flag
		int flag = Integer.parseInt(request.getParameter("flag"));	
		int result = 0;
		
		System.out.println(regEmail);
		System.out.println(flag);
		
		//==========1. academy_register에서 승인(confirm_date 변경)/취소/삭제
		AcademyRegisterDAO arDAO = new AcademyRegisterDAO();
		result = 0;
		result = arDAO.changeConfirmDate(regEmail, flag);
		if(result == 0){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('failed changeConfirmDate');");
			//out.println("history.back();");
			out.println("location.href='./registerGetList.areg';");
			out.println("</script>");
			out.close();
			return null;
		}	
				
		//==========2. member 테이블 mem_admin 컬럼 값 변경=============================
		MemberDAO memDAO = new MemberDAO();		
		result = 0;
		result = memDAO.changeAdmin(regEmail, flag);
		if(result == 0){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('failed changeAdmin');");
			//out.println("history.back();");
			out.println("location.href='./registerGetList.areg';");
			out.println("</script>");
			out.close();
			return null;
		}			
		
		
		//=============3. academy 테이블 mem_email 컬럼 값 변경=================	
		AcademyDAO acaDAO = new AcademyDAO();
		int acaMainNum = acaDAO.getAcademyNumByAcaName(acaName);	
		
		AcademyBean acaVO = new AcademyBean();
		acaVO.setMem_email(regEmail);
		acaVO.setAcaName(acaName);		
		
		result = 0;
		result = acaDAO.changeAcademyEmail(acaVO, flag);
		if(result == 0){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('changeAcaEmail failed');");
			//out.println("history.back();");
			out.println("location.href='./registerGetList.areg';");
			out.println("</script>");
			out.close();
			return null;
		}	
	
		
		//===================4.academy_keyword에 키워드값 넣기============================	
		
		AcademyKeywordDAO akDAO = new AcademyKeywordDAO();
		AcademyKeywordBean akVO = new AcademyKeywordBean();
		akVO.setAcaMainNum(acaMainNum);
		akVO.setAcakeyword(aca_keyword);
		
		System.out.println(akVO.toString());		
		
		//키워드 값이 존재할 경우에만 DB에 insert
		if(!(aca_keyword == null || aca_keyword.equals(""))){	
			
			//-------------------------키워드 추가------------------------
			// 승인이 되어있는 상태에서 승인버튼을 다시 누르면 키워드 중복 insert 에러 발생
			// =>
			// 1. 이미 키워드가 등록되어있으면 중복오류가 발생하므로 테이블에 행이 존재하는지 확인(중복검사)
			// 2. 중복이 아니면 insert
			if(flag == 1){			
				result = akDAO.insertAcademyKeyword(akVO);
				if(result == 0){
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('Insert Keyword failed');");
					//out.println("history.back();");
					out.println("location.href='./registerGetList.areg';");
					out.println("</script>");
					out.close();
					return null;
				}else{
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('승인이 완료되었습니다.');");
					//out.println("alert('approve register & insert keyword success');");
					//out.println("location.href = './4index.jsp?center=O_admin/register_reqManagement.jsp';");
					out.println("location.href='./registerGetList.areg';");
					out.println("</script>");
					out.close();
					return null;
				}
				
			//flag == 0 || flag == -1
			}else{
				//-----------------------키워드 삭제------------------------------
				// 취소 / 삭제 요청일 경우 keyword 테이블에서 삭제
				result = akDAO.deleteAcademyKeyword(acaMainNum, flag);	
				
				// 1. 이미 키워드 삭제 처리된 상태에서 삭제요청을 추가적으로 할 경우
				// 레코드에서 더 이상 삭제할 executeUpdate()의 결과가 0이 반환됨				
				if(result == 0){
					System.out.println("삭제 요청 반복! 더 이상 제거할 키워드 데이터가 없음");
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('승인되지 않았거나 이미 취소 처리가 된 상태입니다. ');");
					out.println("location.href='./registerGetList.areg';");
					out.println("</script>");
					out.close();
					return null;
					
				// 2. 취소처리(키워드 테이블 데이터 삭제) 후 삭제 요청
				// -> 이미 키워드테이블 데이터가 없어서 삭제할 행이 없으므로 0이 반환됨	
				// -> 예외적이므로 이 경우 DAO 메서드에서 -1을 반환하도록 하였음
				}else if(result == -1){
					System.out.println("aca_register 삭제 완료 & aca_keyword는 등록된 데이터가 없거나 이미 삭제처리가 되어 있는 상태");
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('Delete register & Delete keyword success');");
					out.println("location.href='./registerGetList.areg';");
					out.println("</script>");
					out.close();
					return null;	
					
				
				//삭제처리가 수행되어 executeUpdate()의 리턴값이 1 이상이라면(삭제된 행 개수만큼 반환)
				}else{
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('reject register & delete keyword success');");
					//out.println("location.href = './4index.jsp?center=O_admin/register_reqManagement.jsp';");
					out.println("location.href='./registerGetList.areg';");
					out.println("</script>");
					out.close();
					return null;
				}				
			}					
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('fail! 키워드가 존재하지 않습니다');");
			//out.println("location.href = './4index.jsp?center=O_admin/register_reqManagement.jsp';");
			out.println("location.href='./registerGetList.areg';");
			out.println("</script>");
			out.close();
			return null;
		}
		
		
		//return null;
				
	}//excute()

}//AcademyRegisterApproveAction
