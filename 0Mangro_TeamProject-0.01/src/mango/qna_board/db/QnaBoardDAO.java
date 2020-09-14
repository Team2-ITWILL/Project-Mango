package mango.qna_board.db;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mango.connection.db.DBconnection;

public class QnaBoardDAO extends DBconnection{
	
	
	
	
	
	
  public void insertQnaBoard(QnaBoardBean qbean){
	  
	  
    int num = 0;
    
    try{
    	
    	
      getConnection();

      sql = "select max(qna_board_num) from qna_board";
      pstmt = con.prepareStatement( sql);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        num = rs.getInt(1) + 1;
      }

      sql = "insert into qna_board(qna_board_num, mem_email, qna_board_pwd, qna_board_title, qna_board_content, qna_board_read, qna_board_date, qna_board_ip, qna_re_lev, qna_re_ref, qna_re_seq, qna_notice) values(?, ?, ?, ?, ?, ?,  now(), ?, ?, ?, ?, ?)";

      pstmt =  con.prepareStatement(sql);
      pstmt.setInt(1, num);
      pstmt.setString(2, qbean.getMem_email());
      pstmt.setString(3, qbean.getQna_board_pwd());
      pstmt.setString(4, qbean.getQna_board_title());
      pstmt.setString(5, qbean.getQna_board_content());
      pstmt.setInt(6, 0);
      pstmt.setString(7, qbean.getQna_board_ip());
      pstmt.setInt(8, 0);
      pstmt.setInt(9, num);
      pstmt.setInt(10, 0);
      pstmt.setString(11, qbean.getQna_notice());

      pstmt.executeUpdate();
      
    } catch (Exception e){
    	
      System.out.println("insertQnaBoard에서 오류 " + e);
      
    } finally{
    	
      resourceClose();
      
    }
   
    
  }	// insertQnaBoard 끝

  
  
  
  
  
  
  
  
  
  public int getQnaBoardCount(){
	  
	  
    int count = 0;
    
    
    try{
    	
      getConnection();

      sql = "select count(*) from qna_board";
      pstmt = con.prepareStatement( sql);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        count = rs.getInt(1);
      }
      

    }catch (Exception e){
    	
      System.out.println("getQnaBoardCount에서 오류" + e);
    
    } finally{
    	
      resourceClose();
      
    }

    return count;
    
  } // getQnaBoardCount 끝
  
 
  
  
  
  
  
  
  
  

  public int getSearchQnaBoardCount(String search_key, String search_word){
	  
	  
    int count = 0;
    
    
    try{
      
      getConnection();

      sql = ("select count(*) from qna_board where + " + search_key + " Like '%" + search_word + "%'");
      pstmt = con.prepareStatement(sql);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        count = rs.getInt(1);
      }

    } catch (Exception e) {
    	
      System.out.println("getSearchQnaBoardCount()에서 오류" + e);
    
    }finally{
    	
      resourceClose();
    
    }

    return count;
  
  
  } // getSearchQnaBoardCount() 끝
  
  
  
  
  
  

  
  
  
  
  
  
  public List<QnaBoardBean> getQnaBoardList(int startRow, int pageSize){
	  
    
	List<QnaBoardBean> qnaBoardList = new ArrayList();
    
	
    try{
    	
    	
      getConnection();
      
      
      
      sql = "select * from qna_board where qna_notice = 1 order by qna_notice desc, qna_re_ref desc, qna_re_seq asc";
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      
      
      while(rs.next()){
    	  
    	  QnaBoardBean qbean = new QnaBoardBean();

          qbean.setQna_board_num(rs.getInt("qna_board_num"));
          qbean.setMem_email(rs.getString("mem_email"));
          qbean.setQna_board_pwd(rs.getString("qna_board_pwd"));
          qbean.setQna_board_title(rs.getString("qna_board_title"));
          qbean.setQna_board_content(rs.getString("qna_board_content"));
          qbean.setQna_board_read(rs.getInt("qna_board_read"));
          qbean.setQna_board_date(rs.getTimestamp("qna_board_date"));
          qbean.setQna_board_ip(rs.getString("qna_board_ip"));
          qbean.setQna_re_lev(rs.getInt("qna_re_lev"));
          qbean.setQna_re_ref(rs.getInt("qna_re_ref"));
          qbean.setQna_re_seq(rs.getInt("qna_re_seq"));
          qbean.setQna_notice(rs.getString("qna_notice"));

          qnaBoardList.add(qbean);
      }
       

      
      sql = "select * from qna_board where qna_notice = 0 order by qna_notice desc, qna_re_ref desc, qna_re_seq asc limit ?, ?";
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, startRow-1);
      pstmt.setInt(2, pageSize);
      rs =  pstmt.executeQuery();

      while (rs.next()){
    	  
    	  
        QnaBoardBean qbean = new QnaBoardBean();

        qbean.setQna_board_num(rs.getInt("qna_board_num"));
        qbean.setMem_email(rs.getString("mem_email"));
        qbean.setQna_board_pwd(rs.getString("qna_board_pwd"));
        qbean.setQna_board_title(rs.getString("qna_board_title"));
        qbean.setQna_board_content(rs.getString("qna_board_content"));
        qbean.setQna_board_read(rs.getInt("qna_board_read"));
        qbean.setQna_board_date(rs.getTimestamp("qna_board_date"));
        qbean.setQna_board_ip(rs.getString("qna_board_ip"));
        qbean.setQna_re_lev(rs.getInt("qna_re_lev"));
        qbean.setQna_re_ref(rs.getInt("qna_re_ref"));
        qbean.setQna_re_seq(rs.getInt("qna_re_seq"));
        qbean.setQna_notice(rs.getString("qna_notice"));

        qnaBoardList.add(qbean);
        
      }

      
    } catch (Exception e) {
    	
      System.out.println("getQnaBoardList()에서 오류" + e);
      
    } finally{
    	
      resourceClose();
    
    }

    return qnaBoardList;
  
  } // getQnaBoardList 끝
  
  
  
  
  
  
  

  
  
  
  
  public List<QnaBoardBean> getSearchQnaBoardList(int startRow, int pageSize, String search_key, String search_word){
    
	  
	List<QnaBoardBean> qnaBoardList = new ArrayList();
	
	
    try {
      
    	
      getConnection();

      
      if ((search_key == null) || (search_word.equals(null) || (search_word.equals("") ))) {
    	  
         sql = "select * from qna_board order by qna_notice desc, qna_re_ref desc, qna_re_seq asc, qna_board_num desc limit ?, ?";
      
      }
      else{
    	  
         sql = "select * from qna_board where " + 
          search_key + " like '%" + search_word + "%' " + 
          " order by qna_notice desc, qna_re_ref desc, qna_re_seq asc, qna_board_num desc limit ?, ?";
      }

      
       pstmt = con.prepareStatement( sql);
       pstmt.setInt(1, startRow - 1);
       pstmt.setInt(2, pageSize);
       rs =  pstmt.executeQuery();

       
      while (rs.next()){
    	  
    	  
        QnaBoardBean qbean = new QnaBoardBean();

        qbean.setQna_board_num(rs.getInt("qna_board_num"));
        qbean.setMem_email(rs.getString("mem_email"));
        qbean.setQna_board_pwd(rs.getString("qna_board_pwd"));
        qbean.setQna_board_title(rs.getString("qna_board_title"));
        qbean.setQna_board_content(rs.getString("qna_board_content"));
        qbean.setQna_board_read(rs.getInt("qna_board_read"));
        qbean.setQna_board_date(rs.getTimestamp("qna_board_date"));
        qbean.setQna_board_ip(rs.getString("qna_board_ip"));
        qbean.setQna_re_lev(rs.getInt("qna_re_lev"));
        qbean.setQna_re_ref(rs.getInt("qna_re_ref"));
        qbean.setQna_re_seq(rs.getInt("qna_re_seq"));
        qbean.setQna_notice(rs.getString("qna_notice"));

        qnaBoardList.add(qbean);
        
      }

    } catch (Exception e){
    	
      System.out.println("getSearchQnaBoardList()에서 오류" + e);
    
    } finally{
    	
      resourceClose();
    
    }

    return qnaBoardList;
  
  } // getSearchQnaBoardList 끝

  
  
  
  
  
  
  
  
  
  public QnaBoardBean getQnaBoard(int num){
	  
    
	QnaBoardBean qbean = null;
    
    try{
    	
      getConnection();

      sql = "select * from qna_board where qna_board_num = ?";
      pstmt = con.prepareStatement( sql);
      pstmt.setInt(1, num);
      rs = pstmt.executeQuery();

      if(rs.next()){
    	  
    	  
        qbean = new QnaBoardBean();

        qbean.setQna_board_num(rs.getInt("qna_board_num"));
        qbean.setMem_email(rs.getString("mem_email"));
        qbean.setQna_board_pwd(rs.getString("qna_board_pwd"));
        qbean.setQna_board_title(rs.getString("qna_board_title"));
        qbean.setQna_board_content(rs.getString("qna_board_content"));
        qbean.setQna_board_read(rs.getInt("qna_board_read"));
        qbean.setQna_board_date(rs.getTimestamp("qna_board_date"));
        qbean.setQna_board_ip(rs.getString("qna_board_ip"));
        qbean.setQna_re_lev(rs.getInt("qna_re_lev"));
        qbean.setQna_re_ref(rs.getInt("qna_re_ref"));
        qbean.setQna_re_seq(rs.getInt("qna_re_seq"));
        qbean.setQna_notice(rs.getString("qna_notice"));
     
      }

    } catch (Exception e){
    	
      System.out.println("getQnaBoard()에서 오류" + e);
    
    } finally{
    	
      resourceClose();
    
    }

    return qbean;
    
  } // getQnaBoard 끝
  
  
  
  
  
  
  
  
  
  

  public void UpdateReadCount(int num){
	  
	  
    try{
      
       getConnection();

       sql = "update qna_board set qna_board_read = qna_board_read+1 where qna_board_num = ?";
       pstmt = con.prepareStatement( sql);
       pstmt.setInt(1, num);

       pstmt.executeUpdate();
       
    } catch (Exception e) {
    	
      System.out.println("UpdateReadCount()에서 오류" + e);
      
    } finally{
    	
      resourceClose();
    }
    
  } // UpdateReadCount 끝
  
  
  

  
  
  
  
  
  
  
  public int UpdateQnaBoard(QnaBoardBean qbean){
	  
	  
    int check = -1;
    
    try{
    	
    	
      getConnection();

       sql = "select qna_board_pwd from qna_board where qna_board_num = ?";
       pstmt = con.prepareStatement( sql);
       pstmt.setInt(1, qbean.getQna_board_num());
       rs =  pstmt.executeQuery();

      if (rs.next()){
        
    	if(qbean.getQna_board_pwd().equals( rs.getString("qna_board_pwd"))){
    		
          check = 1;

          sql = "update qna_board set qna_board_title = ?, qna_board_content = ?, qna_notice = ? where qna_board_num = ?";
          pstmt = con.prepareStatement( sql);
          pstmt.setString(1, qbean.getQna_board_title());
          pstmt.setString(2, qbean.getQna_board_content());
          pstmt.setString(3, qbean.getQna_notice());
          pstmt.setInt(4, qbean.getQna_board_num());

          pstmt.executeUpdate();
        
    	} else{
    		
          check = 0;
          
        }

      }

    } catch (Exception e) {
    	
      System.out.println("UpdateQnaBoard()에서 오류" + e);
    
    } finally{
    	
      resourceClose();
    }

    return check;
    
  } // UpdateQnaBoard 끝
  
  
  
  
  
  
  
  
  
  

  public int DeleteQnaBoard(int num, String pwd){
	  
	  
    int check = -1;

    try{
    	
    	
      getConnection();

       sql = "select qna_board_pwd from qna_board where qna_board_num = ?";
       pstmt = con.prepareStatement( sql);
       pstmt.setInt(1, num);
       rs = pstmt.executeQuery();

       
      if(rs.next()){
    	  
        if(pwd.equals(rs.getString("qna_board_pwd"))){
        	
          check = 1;

          sql = "delete from qna_board where qna_board_num = ?";
          pstmt =  con.prepareStatement( sql);
          pstmt.setInt(1, num);

          pstmt.executeUpdate();

        }
        
      }
      
      else{
    	  
    	  check = 0;
    	  
      }
      

    } catch (Exception e){
    	
      System.out.println("DeleteQnaBoard()에서 오류" + e);
    
    } finally {
    	
      resourceClose();
    
    }

    return check;
  
  } // DeleteQnaBoard 끝

  
  
  
  
  
  
  
  
  // 관리자용 계정을 위한 글 삭제 메서드
  public void DeleteQnaBoard_Admin(int num){
	  
      try {
    	  
		getConnection();
		

        sql = "delete from qna_board where qna_board_num = ?";  
        pstmt =  con.prepareStatement(sql);
        pstmt.setInt(1, num);

        pstmt.executeUpdate();

		
	} catch (Exception e) {
		
		
		e.printStackTrace();
		
	}

	  
	  
  }
  
  
  
  
  
  
  
  public void reInsertQnaBoard(QnaBoardBean qbean) {
	  
	  
    int num = 0;
    
    
    try {
      
    	
       getConnection();

       sql = "select max(qna_board_num) from qna_board";
       pstmt = con.prepareStatement( sql);
       rs = pstmt.executeQuery();

      if (rs.next()) {
        num =  rs.getInt(1) + 1;
      }

       sql = "update qna_board set qna_re_seq = qna_re_seq+1 where qna_re_ref = ? AND qna_re_seq > ?";
       pstmt =  con.prepareStatement( sql);
       pstmt.setInt(1, qbean.getQna_re_ref());
       pstmt.setInt(2, qbean.getQna_re_seq());
       pstmt.executeUpdate();

       sql = "insert into qna_board(qna_board_num, mem_email, qna_board_pwd, qna_board_title, qna_board_content, qna_board_read, qna_board_date, qna_board_ip, qna_re_lev, qna_re_ref, qna_re_seq, qna_notice)values(?, ?, ?, ?, ?, ?,  now(), ?, ?, ?, ?, ?)";

       pstmt =  con.prepareStatement( sql);
       pstmt.setInt(1, num);
       pstmt.setString(2, qbean.getMem_email());
       pstmt.setString(3, qbean.getQna_board_pwd());
       pstmt.setString(4, qbean.getQna_board_title());
       pstmt.setString(5, qbean.getQna_board_content());
       pstmt.setInt(6, 0);
       pstmt.setString(7, qbean.getQna_board_ip());
       pstmt.setInt(8, qbean.getQna_re_lev() + 1);
       pstmt.setInt(9, qbean.getQna_re_ref());
       pstmt.setInt(10, qbean.getQna_re_seq() + 1);
       pstmt.setString(11, qbean.getQna_notice());

       pstmt.executeUpdate();
       
    } catch (Exception e) {
    	
      System.out.println("reInsertQnaBoard()에서 오류" + e);
    
    } finally {
    	
      resourceClose();
      
    }
    
  } // reInsertQnaBoard 끝
  
  
  
  
  
  
  
  
  
  
  
  
  // 답변 목록을 출력할 때 사용
  public List<QnaBoardBean> SearchReWriteList(int num){
	  
	List<QnaBoardBean> qnaBoardList = new ArrayList();
	
    
    try{
    	
    	
      getConnection();
      
      sql = "select * from qna_board where qna_re_ref = ? AND qna_board_num not in(?) order by qna_re_ref desc, qna_re_seq desc";
      pstmt = con.prepareStatement( sql);
      pstmt.setInt(1, num);
      pstmt.setInt(2, num);
      rs =  pstmt.executeQuery();

      while (rs.next()){
    	  
    	  QnaBoardBean qbean = new QnaBoardBean();

          qbean.setQna_board_num(rs.getInt("qna_board_num"));
          qbean.setMem_email(rs.getString("mem_email"));
          qbean.setQna_board_pwd(rs.getString("qna_board_pwd"));
          qbean.setQna_board_title(rs.getString("qna_board_title"));
          qbean.setQna_board_content(rs.getString("qna_board_content"));
          qbean.setQna_board_read(rs.getInt("qna_board_read"));
          qbean.setQna_board_date(rs.getTimestamp("qna_board_date"));
          qbean.setQna_board_ip(rs.getString("qna_board_ip"));
          qbean.setQna_re_lev(rs.getInt("qna_re_lev"));
          qbean.setQna_re_ref(rs.getInt("qna_re_ref"));
          qbean.setQna_re_seq(rs.getInt("qna_re_seq"));
          qbean.setQna_notice(rs.getString("qna_notice"));

          qnaBoardList.add(qbean);
        
      }

    } catch (Exception e) {
    	
      System.out.println("SearchReWriteList()에서 오류" + e);
      
    } finally{
    	
      resourceClose();
    
    }

    return qnaBoardList;
  
  } // SearchReWriteList 끝
  
  
  
  
  
  
  
  // 비밀글으로 잠긴 글 패스워드
  public int SecretQnaBoard(int num, String pwd){
	  
	  
	    int check = -1;

	    try{
	    	
	    	
	      getConnection();

	       sql = "select qna_board_pwd from qna_board where qna_board_num = ?";
	       pstmt = con.prepareStatement( sql);
	       pstmt.setInt(1, num);
	       rs = pstmt.executeQuery();

	       
	      if(rs.next()){
	    	  
	        if(pwd.equals(rs.getString("qna_board_pwd"))){
	        	
	          check = 1;

	        }
	        
	      }
	      
	      else{
	    	  
	    	  check = 0;
	    	  
	      }
	      

	    } catch (Exception e){
	    	
	      System.out.println("DeleteQnaBoard()에서 오류" + e);
	    
	    } finally {
	    	
	      resourceClose();
	    
	    }

	    return check;
	  
	  } // DeleteQnaBoard 끝
  
  
  
  
  
  //////////////////////////// 관리자 메뉴의 문의 답변 관리를 위한 메서드들 ////////////////////////////////////////
  
  
  
  
  
  
  // 문의글의 개수를 출력하는 메서드
  public int getQnaManagementCount(){
	  
	  int count = 0;
	  
	  
	  
	  try{
		  
		  getConnection();
		  

		  sql = "select count(*) from qna_board where qna_notice = 0 And qna_re_lev = 0";
		  pstmt = con.prepareStatement(sql);
		  rs = pstmt.executeQuery();
		  
		  if(rs.next()){
			  count = rs.getInt(1);
		  }
		  
	  } catch(Exception e) {
		
		  System.out.println("getQnaManagementCount() 에서 오류 " + e);
	  
	  } finally {
		  
		resourceClose();

	  }
	    
	    
	  return count;
	  
	  
  } // getQnaManagementCount 끝
  
  
  

  
  
  
  
  // 관리자 페이지에서 현재 고객센터에 존재하는 문의글의 리스트를 출력하는 메서드
  public List<QnaBoardBean> getQnaManagementList(int startRow, int pageSize){
	  
    
	List<QnaBoardBean> qnaBoardList = new ArrayList();
    
	
    try{
    	
    	
      getConnection();
      
      sql = "select * from qna_board where qna_notice = 0 order by qna_re_ref desc, qna_re_seq asc limit ?, ?";
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, startRow);
      pstmt.setInt(2, pageSize);
      rs =  pstmt.executeQuery();
      

      while (rs.next()){
    	  
    	  
        QnaBoardBean qbean = new QnaBoardBean();

        qbean.setQna_board_num(rs.getInt("qna_board_num"));
        qbean.setMem_email(rs.getString("mem_email"));
        qbean.setQna_board_pwd(rs.getString("qna_board_pwd"));
        qbean.setQna_board_title(rs.getString("qna_board_title"));
        qbean.setQna_board_content(rs.getString("qna_board_content"));
        qbean.setQna_board_read(rs.getInt("qna_board_read"));
        qbean.setQna_board_date(rs.getTimestamp("qna_board_date"));
        qbean.setQna_board_ip(rs.getString("qna_board_ip"));
        qbean.setQna_re_lev(rs.getInt("qna_re_lev"));
        qbean.setQna_re_ref(rs.getInt("qna_re_ref"));
        qbean.setQna_re_seq(rs.getInt("qna_re_seq"));
        qbean.setQna_notice(rs.getString("qna_notice"));

        qnaBoardList.add(qbean);
        
      }

      
    } catch (Exception e) {
    	
      System.out.println("getQnaManagementList()에서 오류" + e);
      
    } finally{
    	
      resourceClose();
    
    }

    return qnaBoardList;
  
    
  } // getQnaManagementList 끝
  
  
  
  
  
  
  
  
  
  /////////////////////////////// MYPage에서 내가 쓴 목록 출력////////////////////////////////////////////// 
  // 내가 쓴 문의글의 개수 출력
  public int getMYQnaCount(String id_email){
	  
	  int count = 0;
	  
	  
	  
	  try{
		  
		  getConnection();
		  

		  sql = "select count(*) from qna_board where qna_notice = 0 And qna_re_lev = 0 And mem_email = ?";
		  pstmt = con.prepareStatement(sql);
		  pstmt.setString(1, id_email);
		  rs = pstmt.executeQuery();
		  
		  if(rs.next()){
			  count = rs.getInt(1);
		  }
		  
		  
	  } catch(Exception e) {
		
		  System.out.println("getMYQnaCount() 에서 오류 " + e);
	  
	  } finally {
		  
		resourceClose();

	  }
	    
	    
	  return count;
	  
	  
 } // getMYQnaCount 끝
  
  
  
  
  
  
  public List<QnaBoardBean> getMyQnaList(int startRow, int pageSize, String mem_email){
	  
	    
	List<QnaBoardBean> qnaBoardList = new ArrayList();
    
	
    try{
    	
    	
      getConnection();
      
      sql = "select * from qna_board where mem_email = ? AND qna_notice = 0  order by qna_re_ref desc, qna_re_seq asc limit ?, ?";
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, mem_email);
      pstmt.setInt(2, startRow);
      pstmt.setInt(3, pageSize);
      rs =  pstmt.executeQuery();
      

      while (rs.next()){
    	  
    	  
        QnaBoardBean qbean = new QnaBoardBean();

        qbean.setQna_board_num(rs.getInt("qna_board_num"));
        qbean.setMem_email(rs.getString("mem_email"));
        qbean.setQna_board_pwd(rs.getString("qna_board_pwd"));
        qbean.setQna_board_title(rs.getString("qna_board_title"));
        qbean.setQna_board_content(rs.getString("qna_board_content"));
        qbean.setQna_board_read(rs.getInt("qna_board_read"));
        qbean.setQna_board_date(rs.getTimestamp("qna_board_date"));
        qbean.setQna_board_ip(rs.getString("qna_board_ip"));
        qbean.setQna_re_lev(rs.getInt("qna_re_lev"));
        qbean.setQna_re_ref(rs.getInt("qna_re_ref"));
        qbean.setQna_re_seq(rs.getInt("qna_re_seq"));
        qbean.setQna_notice(rs.getString("qna_notice"));

        qnaBoardList.add(qbean);
        
      }

      
    } catch (Exception e) {
    	
      System.out.println("getMyQnaList()에서 오류" + e);
      
    } finally{
    	
      resourceClose();
    
    }

    return qnaBoardList;
  
    
  } // getMyQnaList 끝
  
  
  
  
  
  
  
  
  
  
}