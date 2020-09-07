package mango.anony_board.db;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mango.connection.db.DBconnection;



public class AnonyBoardDAO extends DBconnection {
	
	// 1-1.[랜덤 닉네임] :  AnoBoardWriteAction에서 호출
	public String getRandomNickname(){
		String nick = ""; 
		
		try {
			
			List<String> list1 = new ArrayList<String>();
			list1.add("행복한"); list1.add("좋은"); list1.add("멋진"); list1.add("감회가 새로운"); list1.add("기대되는"); list1.add("방황하는");
			list1.add("별난"); list1.add("종속적인"); list1.add("웃긴"); list1.add("뒤틀린"); list1.add("좋아하는"); list1.add("커밋을 깜빡한");
			list1.add("행복한"); list1.add("좋은"); list1.add("감기에 걸린"); list1.add("아이스크림이 먹고싶은"); list1.add("질색하는"); list1.add("고뇌하는");
			list1.add("귀여운"); list1.add("예쁜 마음의"); list1.add("잠을 못 잔"); list1.add("지겨운"); list1.add("이상적인"); list1.add("강한");
			
			List<String> list2 = new ArrayList<String>();
			list2.add("사자"); list2.add("노자"); list2.add("노스트라다무스"); list2.add("오라클"); list2.add("돼지"); list2.add("뉴런");
			list2.add("우산"); list2.add("가우시안"); list2.add("빅터"); list2.add("띵문"); list2.add("개발자"); list2.add("주머니"); list2.add("모나미볼펜");
			list2.add("아메리카노"); list2.add("무말랭이"); list2.add("우주의 먼지"); list2.add("표준편차"); list2.add("닭발"); list2.add("토끼");
			list2.add("빗자루"); list2.add("부지깽이"); list2.add("카오스를 겪는 선생님"); list2.add("전생"); list2.add("날씨"); list2.add("약쟁이");
			
			
			for( int i = 0; i < list1.size(); i++){
				Collections.shuffle(list1);
				Collections.shuffle(list2);
				
				nick = list1.get(i) +" "+ list2.get(i);
				
			}
		
			
		} catch (Exception e) {
			System.out.println("AnonyBoardDAO의 getRandomNickname()메소드에서 예외 발생");
			e.printStackTrace();
		} finally { resourceClose();}
		
		return nick;
		
		
	}// getRandomNickname()	

	
	
	// 1-2. [INSERT 게시판 글 저장 메소드] : AnoBoardInsertAction에서 호출
	public void insertANBoard(AnonyBoardBean anb){
		
		
		int num = 0;
		
		try {
			getConnection();
			// insert 되는 글의 글번호 증가 작업
			sql = "SELECT max(ano_board_num) FROM anony_board";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){ num = rs.getInt(1)+1; } else { num = 1;}
			
			
		}catch(SQLException se){
			System.out.println("InsertANBoard메소드에서 첫번째 SQL 예외 발생 : "+ se);				
			
		}catch(Exception e){
			System.out.println("InsertANBoard메소드 첫번째 쿼리에서 예외 발생 : "+ e);				
			
		}
		
		
		try{
			sql = "INSERT INTO anony_board "
				 + "(ano_board_num, "
				 + "mem_email, "
				 + "ano_board_title, " 
				 + "ano_board_content, "
				 + "ano_board_read, "
				 + "ano_board_date, "
				 + "ano_board_ip, "
				 + "ano_board_nick, "
				 + "ano_board_file) "
				 + "VALUES(?,?,?,?,0,?,?,?,?) "; 
			
			
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, num);
		pstmt.setString(2, anb.getMem_email());
		pstmt.setString(3, anb.getAno_board_title());
		pstmt.setString(4, anb.getAno_board_content());
		pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
		pstmt.setString(6, anb.getAno_board_ip() );
		pstmt.setString(7, anb.getAno_board_nick());
		pstmt.setString(8, anb.getAno_board_file());
		
		System.out.println(anb.getMem_email());
		
		pstmt.executeUpdate();
		
		}catch(Exception e){
			System.out.println("InsertANBoard메소드 두번째 쿼리에서 예외 발생 : "+ e);				
			e.printStackTrace();
		}finally { resourceClose();}
	}

	
	
	
	// [2.조회수 증가메소드] : AnoBoardSingleAction에서 호출
	public void updateANBoardRead(int ano_board_num){
		try {
			getConnection();
			
			sql = "UPDATE anony_board "
					+ "SET ano_board_read=ano_board_read + 1 "
					+ "WHERE ano_board_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ano_board_num);
			
			pstmt.executeUpdate();
			
		}catch (SQLException se){
			System.out.println("updateANBoardRead메소드에서 SQL 예외 발생 : "+ se);				
			
		}catch (Exception e) {
			System.out.println("updateANBoardRead메소드 쿼리에서 예외 발생 : "+ e);				
			
		} finally { resourceClose(); }
		
		
	}//updateANBoardRead()
	
	
	
	// [3.게시판 글 삭제] : AnoBoardDeleteAction에서 호출
	public void deleteANBoard(int ano_board_num){
		
		try {
			
			getConnection();
			sql = "DELETE FROM anony_board "
					+ "WHERE ano_board_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ano_board_num);
			
			pstmt.executeUpdate();
			
			
		}catch (SQLException se){
			System.out.println("DeleteANBoard메소드에서 SQL 예외 발생 : "+ se);				
			
		}catch (Exception e) {
			System.out.println("DeleteANBoard메소드 쿼리에서 예외 발생 : "+ e);				
			
		} finally { resourceClose(); }
			
		
		
	};
	
	//------------------------게시글 불러오기---------------------------
	
	// [4.익명사담방 게시판 글 1개 불러오기] : AnoBoardSingleAction에서 호출
	public AnonyBoardBean getANBoard(int ano_board_num){
		
		AnonyBoardBean anb = null;
		
		try{
			getConnection();
			sql = "SELECT * FROM anony_board "
					+ "WHERE ano_board_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ano_board_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				anb = new AnonyBoardBean();
				
				anb.setAno_board_num(rs.getInt("ano_board_num"));
				anb.setMem_email(rs.getString("mem_email"));
				anb.setAno_board_title(rs.getString("ano_board_title"));
				anb.setAno_board_content(rs.getString("ano_board_content"));
				anb.setAno_board_read(rs.getInt("ano_board_read"));
				anb.setAno_board_date(rs.getTimestamp("ano_board_date"));
				anb.setAno_board_ip(rs.getString("ano_board_ip"));
				anb.setAno_board_nick(rs.getString("ano_board_nick"));
				anb.setAno_board_file(rs.getString("ano_board_file"));
				
			}// if
			
		}catch (Exception e) {
			System.out.println("getANBoard메소드 쿼리에서 예외 발생 : "+ e);				
			
		} finally { resourceClose(); }
		
		return anb;
		
	}// getANBoard() 메소드
	
	
	
	// [5.익명사담방 전체 글목록 불러오기 ] : AnonyBoardListAction에서 호출
	public List<AnonyBoardBean> getANBoardList(String searchKeyword){
		List<AnonyBoardBean> anbList = new ArrayList<AnonyBoardBean>();
		
		System.out.println("getANBoardList() 메소드 실행");
		try {
			getConnection();
			sql = "SELECT * FROM anony_board ";
			
			if(searchKeyword != "") {
				// 제목과, 내용, 닉네임, 첨부파일명 중 일치하는 검색키워드를 필터링 
				sql += "WHERE ano_board_title LIKE ? ";
				sql += "OR ano_board_content LIKE ? ";
				sql += "OR ano_board_nick LIKE ? ";
				sql += "OR ano_board_file LIKE ? ";
				sql += "ORDER BY ano_board_num DESC";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchKeyword+"%");
				pstmt.setString(2, "%"+searchKeyword+"%");
				pstmt.setString(3, "%"+searchKeyword+"%");
				pstmt.setString(4, "%"+searchKeyword+"%");
				
			}else {
				sql += "ORDER BY ano_board_num DESC";
				pstmt = con.prepareStatement(sql);
			}
			
			rs = pstmt.executeQuery();
			
			// (검색키워드에 해당하는)글이 있다면
			while(rs.next()){
				AnonyBoardBean anb = new AnonyBoardBean();
				anb.setAno_board_num(rs.getInt("ano_board_num"));
				anb.setMem_email(rs.getString("mem_email"));
				anb.setAno_board_title(rs.getString("ano_board_title"));
				anb.setAno_board_content(rs.getString("ano_board_content"));
				anb.setAno_board_read(rs.getInt("ano_board_read"));
				anb.setAno_board_ip(rs.getString("ano_board_ip"));
				anb.setAno_board_date(rs.getTimestamp("ano_board_date"));
				anb.setAno_board_nick(rs.getString("ano_board_nick"));
				anb.setAno_board_file(rs.getString("ano_board_file"));
				
				System.out.println("dao에서 보여지는 anb"+anb);
				anbList.add(anb);
			}//while 끝
			
			
		} catch (Exception e) {
			System.out.println("getANBoardList()메소드 쿼리에서 예외 발생 : "+ e);				
			e.printStackTrace();
		} finally { resourceClose(); }
			
		return anbList;
	}
	
	// [6.전체 글 개수 반환 메소드] : AnonyBoardListAction에서 호출
	public int getAnonyBoardCount(String searchKeyword){
		int count = 0;
		
		try {
			getConnection();
			sql = "SELECT count(*) FROM anony_board ";
			
			if(searchKeyword != "") {
				// 제목과, 내용, 닉네임, 첨부파일명 중 일치하는 검색키워드를 필터링 
				sql += "WHERE ano_board_title LIKE ? ";
				sql += "OR ano_board_content LIKE ? ";
				sql += "OR ano_board_nick LIKE ? ";
				sql += "OR ano_board_file LIKE ? ";
				sql += "ORDER BY ano_board_num DESC";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchKeyword+"%");
				pstmt.setString(2, "%"+searchKeyword+"%");
				pstmt.setString(3, "%"+searchKeyword+"%");
				pstmt.setString(4, "%"+searchKeyword+"%");
				
			}else {
				sql += "ORDER BY ano_board_num DESC";
				pstmt = con.prepareStatement(sql);
			}
			
			
			
			rs = pstmt.executeQuery();
			
			// 게시판에 글이 0개 이상이라면 
			if(rs.next()) {
				count = rs.getInt(1);
			}//if
			
			
		}catch(Exception e){
			System.out.println("getAnonyBoardCount()메소드 쿼리에서 예외 발생 : "+ e);				
			
		}finally {resourceClose();}
		
		return count;
		
	}//getAnonyBoardCount()
	
	
	// [7.글 수정 메소드] : AnoBoardUpdateAction에서 호출
	public int updateANBoard(AnonyBoardBean anbean){
		
		int check = 0;
		
		try {
			getConnection();
			
			sql = "UPDATE anony_board "
					+ "SET "
					+ "ano_board_title=?, "
					+ "ano_board_content=?, "
					+ "ano_board_file=? "
					+ "WHERE ano_board_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, anbean.getAno_board_title());
			pstmt.setString(2, anbean.getAno_board_content());
			pstmt.setString(3, anbean.getAno_board_file());
			pstmt.setInt(4, anbean.getAno_board_num());
			
			pstmt.executeUpdate();
			
			check = 1;
			
			System.out.println(check);
			
		}catch(SQLException se){
			System.out.println("updateANBoard메소드에서 SQL 예외 발생 : "+ se);				
			
		}catch(Exception e){
			System.out.println("updateANBoard메소드에서 예외 발생 : "+ e);				
		
		}finally { resourceClose();}
		
		System.out.println(check);
		return check;
		
		
		
	}//updateANBoard()


	
	
	// [8. 계정별 작성한 익명사담글을 반환하는 메소드 (마이페이지 내가 작성한 글 - 익명사담글)]
	// - getANBoardList 오버로딩(String을 사용할 수 없으므로 bean타입으로 매개변수 지정)
	
	public List<AnonyBoardBean> getANBoardList(AnonyBoardBean anbean){
		List<AnonyBoardBean> myAnonyList = new ArrayList<AnonyBoardBean>();
		
		System.out.println("getANBoardList() 메소드 실행");
		try {
			getConnection();
			sql = "SELECT * FROM anony_board "
				+ "WHERE mem_email = ?" 
				+ "ORDER BY ano_board_num DESC, ano_board_date DESC ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, anbean.getMem_email());
			
			rs = pstmt.executeQuery();
			
			// (해당 계정이 쓴)글이 있다면
			while(rs.next()){
				AnonyBoardBean anb = new AnonyBoardBean();
				anb.setAno_board_num(rs.getInt("ano_board_num"));
				anb.setMem_email(rs.getString("mem_email"));
				anb.setAno_board_title(rs.getString("ano_board_title"));
				anb.setAno_board_content(rs.getString("ano_board_content"));
				anb.setAno_board_read(rs.getInt("ano_board_read"));
				anb.setAno_board_ip(rs.getString("ano_board_ip"));
				anb.setAno_board_date(rs.getTimestamp("ano_board_date"));
				anb.setAno_board_nick(rs.getString("ano_board_nick"));
				anb.setAno_board_file(rs.getString("ano_board_file"));
				
				System.out.println("dao에서 보여지는 anb"+anb);
				myAnonyList.add(anb);
			}//while 끝
			
			System.out.println("DAO에서 보는 myAnonyList"+myAnonyList);
			
			
		} catch (Exception e) {
			System.out.println("getANBoardList(멤버계정)메소드 쿼리에서 예외 발생 : "+ e);				
			e.printStackTrace();
		} finally { resourceClose(); }
		return myAnonyList;
	}
	
	
	
		
}
