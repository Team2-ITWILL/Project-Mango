package mango.academy.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mango.connection.db.DBconnection;
import mango.member.db.MemberBean;

public class AcademyDAO extends DBconnection implements IAcademy{

	@Override
	public List<AcademyBean> AllAcademyList(int StartRow, int pageSize) {
		List<AcademyBean> list = new ArrayList<AcademyBean>();

		
		try {
			getConnection();
			AcademyBean bean;  
			String sql =" select a.* ,ifnull(r.avgscore,0) avgscore "
						 +" from academy a left join (select aca_main_num,avg(review_score) avgscore"
								 					+" from academy_review) r"
						 +" on a.aca_main_num=r.aca_main_num"  
 						 +" limit ?,?";
 
			 
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, StartRow);
			pstmt.setInt(2, pageSize);			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bean = new AcademyBean(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getString(10), rs.getString(11), //acaCategory
						rs.getString(12), rs.getString(13), rs.getString(14), //address
						rs.getString(15),	//mem_email						
						rs.getDouble(19),  //reviewScore
						rs.getInt(17),//누적 청강수
						rs.getString(20)//학원프로필사진
						);				
				
				list.add(bean);			
			
			}			
			
			
			
		} catch (Exception e) {
			System.out.println("AllAcademyList()에서 예외 발생");
			e.printStackTrace();
		} finally{
			resourceClose();
		}
		
		return list;
	}

	@Override
	public List<AcademyBean> getOnlySearch(AcademyBean search) {

		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("getOnlySearch()에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}
		
		return null;
	}

	@Override
	public List<AcademyBean> getAllSearch(AcademyBean search) {
		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("getAllSearch()에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}
		return null;
	}

	@Override
	public List<AcademyBean> getListSearch(AcademyBean address) {
		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("getListSearch()에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}
		
		return null;
	}
	
	// 학원 정보 출력
	@Override
	public AcademyBean getAcademyContent(int acaMainNum) {
		
		AcademyBean bean = null;
		
		try {
			getConnection();
			sql = "select * from academy where aca_main_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, acaMainNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				bean = new AcademyBean();
				bean.setAcaMainNum(rs.getInt(1));
				bean.setAcaNum(rs.getString(2));
				bean.setAcaCode(rs.getString(3));
				bean.setAcaAttr(rs.getString(7));
				bean.setAcaName(rs.getString(8));
				bean.setAcaStartDate(rs.getString(9));
				bean.setAcaCategory1(rs.getString(10));
				bean.setAcaCategory2(rs.getString(11));
				bean.setAcaAddrZip(rs.getString(12));
				bean.setAcaAddrDoro(rs.getString(13));
				bean.setAcaAddrDetailed(rs.getString(14));
				bean.setMem_email(rs.getString(15));
				
			}
		} catch (Exception e) {
			System.out.println("getAcademyContent()에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}
		
		return bean;
	}

	@Override
	public void DeleteAcademy(AcademyBean ab) {
		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("DeleteAcademy()에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}	
	}
	
	// 지역구 가져오는 메서드
	public JSONArray getListSearchOne(String address){
		
		JSONArray ja = new JSONArray();
		JSONObject jo;
		try {
			getConnection();
			sql = "select distinct(aca_search_addr2) from academy where aca_search_addr1 =?";
			
			
			pstmt =con.prepareStatement(sql);
			
			
			pstmt.setString(1,address);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				jo = new JSONObject();
				
				jo.put("search2", rs.getString(1));
			
				ja.add(jo);
			}
			
			
					
		}catch (Exception e) {
			System.out.println("getListSearchOne()에서 예외 발생"+e);
		}finally {
			resourceClose();
		}	
		
	
		
		return ja;
	}
	// 읍면동 가져오는 메서드
	public JSONArray getListSearchTwo(String address,String address2){
		
		JSONArray ja = new JSONArray();
		
		try {
			getConnection();
			sql = "select distinct(aca_search_addr3) from academy where aca_search_addr1 =? and aca_search_addr2 =?";
			
			
			pstmt =con.prepareStatement(sql);
			
			
			pstmt.setString(1,address);
			pstmt.setString(2,address2);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				JSONObject jo = new JSONObject();
				
				jo.put("search3", rs.getString(1));
				
				ja.add(jo);
			}
			
		}catch (Exception e) {
			System.out.println("getListSearchTwo()에서 예외 발생"+e);
		}finally {
			resourceClose();
		}	
		
		
		
		return ja;
	}

	public JSONArray getListSearchThr(String parameter, String parameter2, String parameter3) {
		
		JSONArray ja = new JSONArray();
		
		try {
			getConnection();
			sql = "select distinct(aca_category1) from academy where aca_search_addr1 =? and aca_search_addr2 =? and aca_search_addr3=?";
			
			
			pstmt =con.prepareStatement(sql);
			
			
			pstmt.setString(1,parameter);
			pstmt.setString(2,parameter2);
			pstmt.setString(3,parameter3);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				JSONObject jo = new JSONObject();
				
				jo.put("search4", rs.getString(1));
				
				
				ja.add(jo);
			}
			
		}catch (Exception e) {
			System.out.println("getListSearchThr()에서 예외 발생"+e);
		}finally {
			resourceClose();
		}	
		
		
		
		return ja;
	
	}

	//학원 수 count하는 메서드
	public int getAcademyCount() {
	
		try {
			getConnection();
			
			sql="select count(*) from academy";
			
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			
			if(rs.next()){
				
				return rs.getInt(1);
			}
			
			
		} catch (Exception e) {
			System.out.println("getListSearchThr()에서 예외 발생"+e);
		}finally {
			resourceClose();
		}	
		
		
		
		
		return 0;
	}
	
	
	public JSONArray getCategory(HashMap<String,Object> add){
	    JSONArray ja =new JSONArray();
		
	    
	    try {
			getConnection();
			
			
			if(add.get("One")!=null&&add.get("Two")==null){
				
				sql="select distinct(aca_category1) from academy where aca_search_addr1 =?";
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1,(String)add.get("One"));
				
			}else if(add.get("One")!=null&&add.get("Two")!=null){
				
				sql="select distinct(aca_category1) from academy where aca_search_addr1 =? and aca_search_addr2 =?";
				
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1,(String)add.get("One"));
				pstmt.setString(2,(String)add.get("Two"));
				
				
			}
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				JSONObject jo =new JSONObject();
				
				
				jo.put("search4", rs.getString(1));
				
				ja.add(jo);
				
			}
			
			
		} catch (Exception e) {
			System.out.println("getCategory()에서 예외 발생"+e);
		}finally {
			resourceClose();
		}	
		
		
		
	    
	   
	    
	    
	    
				
				
				
		return ja;
	}

	
	//검색어로 검색한 학원 갯수 갖고오기
	public int getAcademyCount(HashMap<String, Object> formsearch) {
		
		int count=0;
		
		
		try {
			getConnection();
		
			
			//검색창에만 입력했을시에
		if(formsearch.get("main")!=null&&formsearch.get("s1")==null&&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")==null ){
			
			
	
			sql="select count(*)"
			+" from academy "                           
			+" where aca_name like ? " 
			+" or aca_search_addr1 like ? " 
			+" or aca_search_addr2 like ? " 
			+" or aca_search_addr3 like ? "
			+" or aca_category1 like ? ";
			
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(3,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(4,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(5,'%'+(String)formsearch.get("main")+'%');
			
			
			rs=pstmt.executeQuery();
			
		
		}

//		//검색 창 입력 O , 광역시도 선택 O , 카테고리 선택 X
		else if(formsearch.get("main")!=null&&formsearch.get("s1")!=null&&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
		
			
			sql="select count(*)"
					+" from academy "                           
					+" where aca_name like ? " 
					+" and aca_search_addr1 = ? ";
					
					pstmt=con.prepareStatement(sql);
					
					pstmt.setString(1,'%'+(String)formsearch.get("main")+'%');
					pstmt.setString(2,(String)formsearch.get("s1"));
					
					
					rs=pstmt.executeQuery();	
			
		}
		//검색 창 입력 O , 광역시도 선택 O , 카테고리 선택 O
		else if(formsearch.get("main")!=null&&formsearch.get("s1")!=null&&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
			
			
			sql="select count(*)"
					+" from academy "                           
					+" where aca_name like ? " 
					+" and aca_search_addr1 = ? "
					+" and aca_category1 = ? ";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(2,(String)formsearch.get("s1"));
			pstmt.setString(3,(String)formsearch.get("s4"));
			
			
			rs=pstmt.executeQuery();	
			
		}
//		//검색 창 입력 X , 광역시도 선택 O , 카테고리 선택 O
		else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
			
			
			sql="select count(*)"
					+" from academy "                            
					+" where aca_search_addr1 = ? "
					+" and aca_category1 = ? ";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("s1"));
			pstmt.setString(2,(String)formsearch.get("s4"));
			
			
			rs=pstmt.executeQuery();	
			
		}
//		//검색 창 입력 X , 광역시도 선택 O , 카테고리 선택 X
		else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
			
			sql="select count(*)"
				+" from academy "                           
				+" where aca_search_addr1 = ? ";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("s1"));
			
			
			rs=pstmt.executeQuery();	
			
		}//여기까지 광역시도 처리
//		//검색 창 입력 O , 광역시도 선택 O,지역구 O , 카테고리 선택 O
		else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
			
			sql="select count(*)"
					+" from academy "                           
					+" where aca_name like ? " 
					+" and aca_search_addr1 =? " 
					+" and aca_search_addr2 =? " 
					+" and aca_category1 =? ";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(2,(String)formsearch.get("s1"));
			pstmt.setString(3,(String)formsearch.get("s2"));
			pstmt.setString(4,(String)formsearch.get("s4"));
			
			
			rs=pstmt.executeQuery();	
			
		}//
//		//검색 창 입력 X , 광역시도 선택 O,지역구 O , 카테고리 선택 O	
		else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
			
			sql="select count(*)"
					+" from academy "                           
					+" where aca_search_addr1 =? " 
					+" and aca_search_addr2 =? " 
					+" and aca_category1 =? ";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("s1"));
			pstmt.setString(2,(String)formsearch.get("s2"));
			pstmt.setString(3,(String)formsearch.get("s4"));
			
			
			rs=pstmt.executeQuery();	
			
		}//
//		//검색 창 입력 X , 광역시도 선택 O,지역구 O , 카테고리 선택 X	
	else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
			
			sql="select count(*)"
					+" from academy "                           
					+" where aca_search_addr1 =? " 
					+" and aca_search_addr2 =? "; 
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("s1"));
			pstmt.setString(2,(String)formsearch.get("s2"));
			
			
			rs=pstmt.executeQuery();	
			
		}//
//		//전체 검색 창 입력 O , 광역시도 선택 O,지역구 O ,읍면동 O , 카테고리 선택 O	
	else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")!=null){
		
		sql="select count(*) "
				+" from academy "                           
				+" where aca_name like ? " 
				+" and aca_search_addr1 = ? " 
				+" and aca_search_addr2 = ? " 
				+" and aca_search_addr3 = ? " 
				+" and aca_category1 = ? ";
		pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1,'%'+(String)formsearch.get("main")+'%');
		pstmt.setString(2,(String)formsearch.get("s1"));
		pstmt.setString(3,(String)formsearch.get("s2"));
		pstmt.setString(4,(String)formsearch.get("s3"));
		pstmt.setString(5,(String)formsearch.get("s4"));
		
		System.out.println("확인");
		rs=pstmt.executeQuery();	
		
	}//
     // 검색 창 입력 X , 광역시도 선택 O,지역구 O ,읍면동O , 카테고리 선택 O			
	else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")!=null){
		
		sql="select count(*)"
				+" from academy "                           
				+" where aca_search_addr1 =? " 
				+" and aca_search_addr2 =? " 
				+" and aca_search_addr3 =? " 
				+" and aca_category1 =? ";
		pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1,(String)formsearch.get("s1"));
		pstmt.setString(2,(String)formsearch.get("s2"));
		pstmt.setString(3,(String)formsearch.get("s3"));
		pstmt.setString(4,(String)formsearch.get("s4"));
		
		
		rs=pstmt.executeQuery();	
		
	}//		
		// 검색 창 입력 X , 광역시도 선택 O,지역구 O ,읍면동O , 카테고리 선택 X			
	else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")==null){
		
		sql="select count(*)"
				+" from academy "                           
				+" where aca_search_addr1 =? " 
				+" and aca_search_addr2 =? " 
				+" and aca_search_addr3 =? "; 
		pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1,(String)formsearch.get("s1"));
		pstmt.setString(2,(String)formsearch.get("s2"));
		pstmt.setString(3,(String)formsearch.get("s3"));
		
		
		rs=pstmt.executeQuery();	
		
	}		
		// 검색 창 입력 X , 광역시도 선택 O,지역구 O ,읍면동O , 카테고리 선택 X			
	else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")==null){
		
		sql="select count(*)"
				+" from academy where aca_name like ? "                           
				+" and aca_search_addr1 =? " 
				+" and aca_search_addr2 =? " 
				+" and aca_search_addr3 =? "; 
		pstmt=con.prepareStatement(sql);
		

		pstmt.setString(1,'%'+(String)formsearch.get("main")+'%');
		pstmt.setString(2,(String)formsearch.get("s1"));
		pstmt.setString(3,(String)formsearch.get("s2"));
		pstmt.setString(4,(String)formsearch.get("s3"));
		
		
		rs=pstmt.executeQuery();	
		
	}		
	else{//그냥 검색하기 만 눌렀을 경우
		
		sql="select count(*)"
				+" from academy ";                           
				 
		pstmt=con.prepareStatement(sql);
		
		
		rs=pstmt.executeQuery();	
		
		
	}
		
			
			
		
		
		
		
		if(rs.next()){//카운트 갖고오기
			
			count=rs.getInt(1);
			
			return count;
		}
		
			
	
		
		}catch (Exception e) {
			System.out.println("getAcademyCount(HashMap)에서 예외 발생"+e);
		}finally {
			resourceClose();
		}	
		
		
		
		
		
		
		
	 return count;
		
		
	}//getAcademyCount
	
	
	
	//검색 이용시 검색결과에 따라 학원 목록을 갖고오는 메서드
	public List<AcademyBean> getSearchListAcademy(HashMap<String,Object> formsearch ,int StartRow, int pageSize){
		
		List<AcademyBean> list = new ArrayList();
			try {
				
				getConnection();
				
				
				String like="select a.* ,ifnull(r.avgscore,0) avgscore , ifnull(m.mem_profileImg,'images/etc/default_mango.png') profileimg  ,ifnull(k.acalike , 0) acalike "
						+" from academy a left join (select aca_main_num,avg(review_score) avgscore "
						+" from academy_review "
						+ " group by aca_main_num ) r"
									+" on a.aca_main_num=r.aca_main_num left join (select aca_main_num , count(*) acalike "
																				+ 	" from liked_academy "
												+ 		" group by aca_main_num ) k on a.aca_main_num = k.aca_main_num "                      
															+" left join (select mem_email,mem_profileImg "
															+ " from member "
															+ " group by mem_email) m on a.mem_email = m.mem_email ";
				
				String review ="select a.* ,ifnull(r.avgscore,0) avgscore,ifnull(m.mem_profileImg,'images/etc/default_mango.png') profileimg ,ifnull(r.count,0) count "
						+" from academy a left join (select aca_main_num, count(*) count,avg(review_score) avgscore "
						+" from academy_review"
						+ " group by aca_main_num) r"
						+" on a.aca_main_num=r.aca_main_num "
						+" left join (select mem_email,mem_profileImg "
						+ " from member "
						+ " group by mem_email) m on a.mem_email = m.mem_email ";
				
				String rating="select a.* ,ifnull(r.avgscore,0) avgscore,ifnull(m.mem_profileImg,'images/etc/default_mango.png') profileimg "
						+" from academy a left join (select aca_main_num,avg(review_score) avgscore"
						  +" from academy_review"
						  + " group by aca_main_num ) r" 
						  +" on a.aca_main_num=r.aca_main_num "
						  +" left join (select mem_email,mem_profileImg "
						  + " from member "
						  + " group by mem_email) m on a.mem_email = m.mem_email ";	
				
				String basic="select a.* ,ifnull(r.avgscore,0) avgscore ,ifnull(m.mem_profileImg,'images/etc/default_mango.png') profileimg"
						 +" from academy a left join (select aca_main_num,avg(review_score) avgscore "
		 					+" from academy_review "
		 					+ " group by aca_main_num ) r "
		 					+" on a.aca_main_num=r.aca_main_num "   
							+" left join (select mem_email,mem_profileImg "
							+ " from member "
							+ " group by mem_email) m on a.mem_email = m.mem_email ";
				
				String where="";
				
				
				String s5= (String)formsearch.get("s5");
				
				//검색창에만 입력했을시에
			if(formsearch.get("main")!=null&&formsearch.get("s1")==null&&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")==null ){
				
				
				
				where=" where a.aca_name like ? " 
						+" or a.aca_search_addr1 like ? " 
						+" or a.aca_search_addr2 like ? " 
						+" or a.aca_search_addr3 like ? "
						+" or a.aca_category1 like ? ";
				
				if(s5.equals("like")){//좋아요 많은순
					
					
					sql=like+where	
							+ " order by acalike desc "
							+ " limit ? , ?";
					
				}else if(s5.equals("review")){//리뷰 후기 많은순
					
					sql=review
							+ where	
							+ " order by count desc "
							+ " limit ? , ?";
					
					
				}else if(s5.equals("rating")){//평점 높은순 
					
					
					sql=rating								
							+where
							+ " order by  avgscore desc "
							+ " limit ? , ? ";
					
				}else if(s5.equals("basic")){//기본
					sql=basic
					+ where
					+ " limit ? , ? ";
				}
				
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1,'%'+(String)formsearch.get("main")+'%');
				pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
				pstmt.setString(3,'%'+(String)formsearch.get("main")+'%');
				pstmt.setString(4,'%'+(String)formsearch.get("main")+'%');
				pstmt.setString(5,'%'+(String)formsearch.get("main")+'%');
				pstmt.setInt(6,StartRow);
				pstmt.setInt(7,pageSize);
				
				
				rs=pstmt.executeQuery();
				
			
			}
	
	//		//검색 창 입력 O , 광역시도 선택 O , 카테고리 선택 X
			else if(formsearch.get("main")!=null&&formsearch.get("s1")!=null&&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
			
				
				where=" where a.aca_name like ? " 
						+" and a.aca_search_addr1 = ? ";
				
				if(s5.equals("like")){//좋아요 많은순
							
							
							sql=like
									+where
									+ " order by acalike desc,a.aca_main_num asc "
									+ " limit ? , ?";
							
							
							
							
						}else if(s5.equals("review")){//리뷰 후기 많은순
							
							
							
							sql=review
									+where
									+ " order by count desc,a.aca_main_num asc "
									+ " limit ? , ?";
							
							
						}else if(s5.equals("rating")){//평점 높은순 
							
							
							sql=rating
									+where
									+ " order by  avgscore desc,a.aca_main_num asc "
									+ " limit ? , ? ";
							
						}else if(s5.equals("basic")){//기본
				
							sql=basic
									+where
									+ " limit ? , ?";
						}
				
						pstmt=con.prepareStatement(sql);
						
						pstmt.setString(1,'%'+(String)formsearch.get("main")+'%');
						pstmt.setString(2,(String)formsearch.get("s1"));
						pstmt.setInt(3,StartRow);
						pstmt.setInt(4,pageSize);
						
						
						rs=pstmt.executeQuery();	
				
			}
			//검색 창 입력 O , 광역시도 선택 O , 카테고리 선택 O
			else if(formsearch.get("main")!=null&&formsearch.get("s1")!=null&&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
				
				
				where=" where a.aca_name like ? " 
						+" and a.aca_search_addr1 = ? "
						+" and a.aca_category1 = ? ";
				
					if(s5.equals("like")){//좋아요 많은순
							
							
							sql=like+where
									+ " order by acalike desc,a.aca_main_num asc "
									+ " limit ? , ?";
							
							
							
							
						}else if(s5.equals("review")){//리뷰 후기 많은순
							
							
							
							sql=review
									+where
									+ " order by count desc,a.aca_main_num asc "
									+ " limit ? , ?";
							
							
						}else if(s5.equals("rating")){//평점 높은순 
							
							
							sql=rating
									+where
									+ " order by  avgscore desc,a.aca_main_num asc "
									+ " limit ? , ? ";
							
						}else if(s5.equals("basic")){//기본
							
							
							sql=basic
									+where
									 + " limit ? , ?";
							
			
						}
				

				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1,'%'+(String)formsearch.get("main")+'%');
				pstmt.setString(2,(String)formsearch.get("s1"));
				pstmt.setString(3,(String)formsearch.get("s4"));
				pstmt.setInt(4,StartRow);
				pstmt.setInt(5,pageSize);
				
				rs=pstmt.executeQuery();	
				
			}
	//		//검색 창 입력 X , 광역시도 선택 O , 카테고리 선택 O
			else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
				
				
				where=" where a.aca_search_addr1 = ? "
						+" and a.aca_category1 = ? ";
				
				if(s5.equals("like")){//좋아요 많은순
					
					
					sql=like
						+where
							+ " order by acalike desc,a.aca_main_num asc "
							+ " limit ? , ?";
					
					
					
					
				}else if(s5.equals("review")){//리뷰 후기 많은순
					
					
					
					sql=review
							+where
							+ " order by count desc,a.aca_main_num asc "
							+ " limit ? , ?";
					
					
				}else if(s5.equals("rating")){//평점 높은순 
					
					
					sql=rating
							+where
							+ " order by  avgscore desc,a.aca_main_num asc "
							+ " limit ? , ? ";
					
				}else if(s5.equals("basic")){//기본
					
					
					sql=basic 					
							+where
							 + " limit ? , ?";
					
	
				}
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1,(String)formsearch.get("s1"));
				pstmt.setString(2,(String)formsearch.get("s4"));
				pstmt.setInt(3,StartRow);
				pstmt.setInt(4,pageSize);
				
				rs=pstmt.executeQuery();	
				
			}
	//		//검색 창 입력 X , 광역시도 선택 O , 카테고리 선택 X
			else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
				
				
				
				where=" where a.aca_search_addr1 = ? ";
				
				
				
				if(s5.equals("like")){//좋아요 많은순
					
					
					sql=like                     
							+where
							+ " order by acalike desc,a.aca_main_num asc "
							+ " limit ? , ?";
					
					
					
					
				}else if(s5.equals("review")){//리뷰 후기 많은순
					
					
					
					sql=review             
							+where
							+ " order by count desc,a.aca_main_num asc "
							+ " limit ? , ?";
					
					
				}else if(s5.equals("rating")){//평점 높은순 
					
					
					sql=rating                     
							+where
							+ " order by  avgscore desc,a.aca_main_num asc "
							+ " limit ? , ? ";
					
				}else if(s5.equals("basic")){//기본
					sql=basic            
							+where
							 + " limit ? , ?";
				}
				
				
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1,(String)formsearch.get("s1"));
				pstmt.setInt(2,StartRow);
				pstmt.setInt(3,pageSize);
				
				rs=pstmt.executeQuery();	
				
			}//여기까지 광역시도 처리
	//		//검색 창 입력 O , 광역시도 선택 O,지역구 O , 카테고리 선택 O
			else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
				
				
				where=" where a.aca_name like ? " 
						+" and a.aca_search_addr1 =? " 
						+" and a.aca_search_addr2 =? " 
						+" and a.aca_category1 =? ";
				
			if(s5.equals("like")){//좋아요 많은순
				
				
				sql=like                   
						+where
						+ " order by acalike desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
				
				
			}else if(s5.equals("review")){//리뷰 후기 많은순
				
				
				
				sql=review                  
						+where
						+ " order by count desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
			}else if(s5.equals("rating")){//평점 높은순 
				
				
				sql=rating                 
						+where
						+ " order by  avgscore desc,a.aca_main_num asc "
						+ " limit ? , ? ";
				
			}else if(s5.equals("basic")){//기본
				
				
				sql=basic                 
						+where
						 + " limit ? , ?";
				

			}
			
				
				
				
				
				
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1,'%'+(String)formsearch.get("main")+'%');
				pstmt.setString(2,(String)formsearch.get("s1"));
				pstmt.setString(3,(String)formsearch.get("s2"));
				pstmt.setString(4,(String)formsearch.get("s4"));
				pstmt.setInt(5,StartRow);
				pstmt.setInt(6,pageSize);
				    
				rs=pstmt.executeQuery();	
				
			}//
	//		//검색 창 입력 X , 광역시도 선택 O,지역구 O , 카테고리 선택 O	
			else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
				
				
				
				where=" where a.aca_search_addr1 =? " 
						+" and a.aca_search_addr2 =? " 
						+" and a.aca_category1 =? ";
				
				
				if(s5.equals("like")){//좋아요 많은순
				
				
				sql=like                    
						+where
						+ " order by acalike desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
				
				
			}else if(s5.equals("review")){//리뷰 후기 많은순
				
				
				
				sql=review                 
						+where
						+ " order by count desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
			}else if(s5.equals("rating")){//평점 높은순 
				
				
				sql=rating                    
						+where
						+ " order by  avgscore desc,a.aca_main_num asc "
						+ " limit ? , ? ";
				
			}else if(s5.equals("basic")){//기본
				
				
				sql=basic                
						+where
						 + " limit ? , ?";
				

			}
			
				
				
				
				
				
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1,(String)formsearch.get("s1"));
				pstmt.setString(2,(String)formsearch.get("s2"));
				pstmt.setString(3,(String)formsearch.get("s4"));
				pstmt.setInt(4,StartRow);
				pstmt.setInt(5,pageSize);
				
				rs=pstmt.executeQuery();	
				
			}//
	//		//검색 창 입력 X , 광역시도 선택 O,지역구 O , 카테고리 선택 X	
		else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
				
			where=" where a.aca_search_addr1 =? " 
					+" and a.aca_search_addr2 =? ";
				if(s5.equals("like")){//좋아요 많은순
					
					
				sql=like                    
						+where
						+ " order by acalike desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
				
				
			}else if(s5.equals("review")){//리뷰 후기 많은순
				
				
				
				sql=review                    
						+where
						+ " order by count desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
			}else if(s5.equals("rating")){//평점 높은순 
				
				
				sql=rating                    
						+where
						+ " order by  avgscore desc,a.aca_main_num asc "
						+ " limit ? , ? ";
				
				}else if(s5.equals("basic")){//기본
				
				
				sql=basic                    
						+where
						 + " limit ? , ?";
				
	
				}
				
				
			
					pstmt=con.prepareStatement(sql);
					
					pstmt.setString(1,(String)formsearch.get("s1"));
					pstmt.setString(2,(String)formsearch.get("s2"));
					pstmt.setInt(3,StartRow);
					pstmt.setInt(4,pageSize);
					
				rs=pstmt.executeQuery();	
				
			}//
		//검색 창 입력 O , 광역시도 선택 O,지역구 O , 카테고리 선택 X	
		else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
			
			where=" where a.aca_name like ?"
					+ "and a.aca_search_addr1 =? " 
					+" and a.aca_search_addr2 =? ";
			if(s5.equals("like")){//좋아요 많은순
				
				
				sql=like                    
						+where
						+ " order by acalike desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
				
				
			}else if(s5.equals("review")){//리뷰 후기 많은순
				
				
				
				sql=review                    
						+where
						+ " order by count desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
			}else if(s5.equals("rating")){//평점 높은순 
				
				
				sql=rating                    
						+where
						+ " order by  avgscore desc,a.aca_main_num asc "
						+ " limit ? , ? ";
				
			}else if(s5.equals("basic")){//기본
				
				
				sql=basic                    
						+where
						+ " limit ? , ?";
				
				
			}
			
			
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(2,(String)formsearch.get("s1"));
			pstmt.setString(3,(String)formsearch.get("s2"));
			pstmt.setInt(4,StartRow);
			pstmt.setInt(5,pageSize);
			
			rs=pstmt.executeQuery();	
			
		}//
	//		//전체 검색 창 입력 O , 광역시도 선택 O,지역구 O ,읍면동 O , 카테고리 선택 O	
		else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")!=null){
			
			
			where=" where a.aca_name like ? " 
					+" and a.aca_search_addr1 = ? " 
					+" and a.aca_search_addr2 = ? " 
					+" and a.aca_search_addr3 = ? " 
					+" and a.aca_category1 = ? ";
			
			
			if(s5.equals("like")){//좋아요 많은순
				
				
				sql=like                    
						+where
						+ " order by acalike desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
				
				
			}else if(s5.equals("review")){//리뷰 후기 많은순
				
				
				
				sql=review                    
						+where
						+ " order by count desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
			}else if(s5.equals("rating")){//평점 높은순 
				
				
				sql=rating                     
						+where
						+ " order by  avgscore desc,a.aca_main_num asc "
						+ " limit ? , ? ";
				
				}else if(s5.equals("basic")){//기본
				
				
				sql=basic	 					
						+where
						 + " limit ? , ?";
				
	
				}
			
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(2,(String)formsearch.get("s1"));
			pstmt.setString(3,(String)formsearch.get("s2"));
			pstmt.setString(4,(String)formsearch.get("s3"));
			pstmt.setString(5,(String)formsearch.get("s4"));
			pstmt.setInt(6,StartRow);
			pstmt.setInt(7,pageSize);
			
			System.out.println("확인");
			rs=pstmt.executeQuery();	
			
		}//
	     // 검색 창 입력 X , 광역시도 선택 O,지역구 O ,읍면동O , 카테고리 선택 O			
		else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")!=null){
			
			
			where=" where a.aca_search_addr1 =? " 
					+" and a.aca_search_addr2 =? " 
					+" and a.aca_search_addr3 =? "     
					+" and a.aca_category1 =? ";
			
			if(s5.equals("like")){//좋아요 많은순
				
				
				sql=like                      
						+where
						+ " order by acalike desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
				
				
			}else if(s5.equals("review")){//리뷰 후기 많은순
				
				
				
				sql=review                    
						+where
						+ " order by count desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
			}else if(s5.equals("rating")){//평점 높은순 
				
				
				sql=rating                    
						+where
						+ " order by  avgscore desc,a.aca_main_num asc "
						+ " limit ? , ? ";
				
				}else if(s5.equals("basic")){//기본
				
				
				sql=basic  
						+where
						 + " limit ? , ?";
				
	
				}
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("s1"));
			pstmt.setString(2,(String)formsearch.get("s2"));
			pstmt.setString(3,(String)formsearch.get("s3"));
			pstmt.setString(4,(String)formsearch.get("s4"));
			pstmt.setInt(5,StartRow);
			pstmt.setInt(6,pageSize);
			
			rs=pstmt.executeQuery();	
			
		}//		
			// 검색 창 입력 X , 광역시도 선택 O,지역구 O ,읍면동O , 카테고리 선택 X			
		else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")==null){
			
			where=" where a.aca_search_addr1 =? " 
					+" and a.aca_search_addr2 =? " 
					+" and a.aca_search_addr3 =? ";
			
				if(s5.equals("like")){//좋아요 많은순
				
				
				sql=like                   
						+where
						+ " order by acalike desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
			}else if(s5.equals("review")){//리뷰 후기 많은순
				
				
				
				sql=review                 
						+where
						+ " order by count desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
			}else if(s5.equals("rating")){//평점 높은순 
				
				
				sql=rating                    
						+where
						+ " order by  avgscore desc,a.aca_main_num asc "
						+ " limit ? , ? ";
				
				}else if(s5.equals("basic")){//기본
				
				
				sql=basic 
						+where
						 + " limit ? , ?";
				
	
				}
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("s1"));
			pstmt.setString(2,(String)formsearch.get("s2"));
			pstmt.setString(3,(String)formsearch.get("s3"));
			pstmt.setInt(4,StartRow);
			pstmt.setInt(5,pageSize);
			
			rs=pstmt.executeQuery();	
			
		}		// 검색 창 입력 O, 광역시도 선택 O,지역구 O ,읍면동O , 카테고리 선택 X	
		else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")==null){
			
			
			
			where=" where aca_name like ? "
					+" and a.aca_search_addr1 =? " 
					+" and a.aca_search_addr2 =? " 
					+" and a.aca_search_addr3 =? ";
			if(s5.equals("like")){//좋아요 많은순
				
				
				sql=like                    
						+where
						+ " order by acalike desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
				
				
			}else if(s5.equals("review")){//리뷰 후기 많은순
				
				
				
				sql=review                      
						+where
						+ " order by count desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
			}else if(s5.equals("rating")){//평점 높은순 
				
				
				sql=rating                    
						+where
						+ " order by  avgscore desc,a.aca_main_num asc "
						+ " limit ? , ? ";
				
			}else if(s5.equals("basic")){//기본
				
				
				sql=basic   
						+where
						+ " limit ? , ?";
				
				
			}
				
			
			pstmt=con.prepareStatement(sql);

			pstmt.setString(1,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(2,(String)formsearch.get("s1"));
			pstmt.setString(3,(String)formsearch.get("s2"));
			pstmt.setString(4,(String)formsearch.get("s3"));
			pstmt.setInt(5,StartRow);
			pstmt.setInt(6,pageSize);
			
			rs=pstmt.executeQuery();	
			
		}		
		else{//그냥 검색하기 만 눌렀을 경우
			
			
			if(s5.equals("like")){//좋아요 많은순
				
				
				sql=like                      
						+ " order by acalike desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
				
				
			}else if(s5.equals("review")){//리뷰 후기 많은순
				
				
				
				sql=review              
						+ " order by count desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
			}else if(s5.equals("rating")){//평점 높은순 
				
				
				sql=rating                		
						+ " order by  avgscore desc,a.aca_main_num asc "
						+ " limit ? , ? ";
				
				}else if(s5.equals("basic")){//기본
				
				
				sql=basic
						 + " limit ? , ?";
				
	
				}
					 
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,StartRow);
			pstmt.setInt(2,pageSize);
			
			
			rs=pstmt.executeQuery();	
			
			
		}
			
			while(rs.next()){
				AcademyBean bean = new AcademyBean(	
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getString(10), rs.getString(11), //acaCategory
						rs.getString(12), rs.getString(13), rs.getString(14), //address
						rs.getString(15),	//mem_email						
						rs.getDouble(19),   //reviewScore
						rs.getInt(17),rs.getString(20)
						);			
				
				list.add(bean);				
			}			
		
			
			
			
		}catch (Exception e) {
			System.out.println("getSearchListAcademy(HashMap)에서 예외 발생"+e);
		
		}finally {
			resourceClose();
		}	
		
		
		
		
		return list;
	} // getSearchListAcademy() 끝

	
	//학원관리자 회원정보 변경
	@Override
	public int reviseAcademyInfo(AcademyBean vo) {
		int result = 0;
		try {
			getConnection();
			
			String query = "update academy set "					
					+ " aca_name = ?, "
					+ " aca_start_date = ?, " 
					+ " aca_category1 = ?, " 
					+ " aca_category2 = ?, " 
					+ " aca_addr_zip = ?, " 
					+ " aca_addr_doro = ? "			
					+ " where mem_email=?";			
			
			pstmt = con.prepareStatement(query);			
			
			pstmt.setString(1, vo.getAcaName());
			pstmt.setString(2, vo.getAcaStartDate());
			pstmt.setString(3, vo.getAcaCategory1());
			pstmt.setString(4, vo.getAcaCategory2());
			pstmt.setString(5, vo.getAcaAddrZip());
			pstmt.setString(6, vo.getAcaAddrDoro());
			pstmt.setString(7, vo.getMem_email());
			
			System.out.println(vo.toString());
	
			
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) { 
			System.out.println("reviseAcademyInfo()에서 예외 발생");
			e.printStackTrace();
		} finally{
			resourceClose();
		}
		
		return result;
	}

	//getAcademyContent() 오버로딩(매개변수 이메일 기준으로 변경)
	@Override
	public AcademyBean getAcademyContent(String email) {
		AcademyBean bean = null;
		
		try {
			getConnection();
			sql = "select * from academy where mem_email=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				bean = new AcademyBean();
				bean.setAcaMainNum(rs.getInt(1));
				bean.setAcaNum(rs.getString(2));
				bean.setAcaCode(rs.getString(3));
				bean.setAcaAttr(rs.getString(7));
				bean.setAcaName(rs.getString(8));
				bean.setAcaStartDate(rs.getString(9));
				bean.setAcaCategory1(rs.getString(10));
				bean.setAcaCategory2(rs.getString(11));
				bean.setAcaAddrZip(rs.getString(12));
				bean.setAcaAddrDoro(rs.getString(13));
				bean.setAcaAddrDetailed(rs.getString(14));
				bean.setMem_email(rs.getString(15));
				
				//System.out.println(bean.toString());
			}
		} catch (Exception e) {
			System.out.println("getAcademyContent(String email)에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}
		
		return bean;
	}

	@Override
	public List<AcademyBean> getAcademyInfoBySearchToList(String acaName) {
		List<AcademyBean> list = new ArrayList<AcademyBean>();
		
		try {
			getConnection();
			sql = "select * from academy "
					+ "where aca_name like ? ";
			
			pstmt = con.prepareStatement(sql);
			
			//쿼리가 아니라 여기서 ?값에 "%"를 붙여줘야 함
			pstmt.setString(1, "%" + acaName + "%");
			
			rs = pstmt.executeQuery();
			
			//여러 개의 학원이 검색될 수 있으므로 LIST로 반환
			while(rs.next()){
				AcademyBean bean = new AcademyBean();
				bean.setAcaMainNum(rs.getInt(1));
				bean.setAcaNum(rs.getString(2));
				bean.setAcaCode(rs.getString(3));
				bean.setAcaAttr(rs.getString(7));
				bean.setAcaName(rs.getString(8));
				bean.setAcaStartDate(rs.getString(9));
				bean.setAcaCategory1(rs.getString(10));
				bean.setAcaCategory2(rs.getString(11));
				bean.setAcaAddrZip(rs.getString(12));
				bean.setAcaAddrDoro(rs.getString(13));
				bean.setAcaAddrDetailed(rs.getString(14));
				bean.setMem_email(rs.getString(15));
				
				list.add(bean);
				
			}
		} catch (Exception e) {
			System.out.println("getAcademyInfoBySearchToList에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}
		
		return list;
	}	
	
	@Override
	public JSONArray getAcademyInfoBySearchToJSON(String acaName) {
		JSONArray arr = new JSONArray();
		
		try {
			getConnection();
			sql = "select * from academy "
					+ "where aca_name like ? ";
			
			pstmt = con.prepareStatement(sql);
			
			//쿼리가 아니라 여기서 ?값에 "%"를 붙여줘야 함
			pstmt.setString(1, "%" + acaName + "%");
			
			rs = pstmt.executeQuery();
			
			//여러 개의 학원이 검색될 수 있으므로 array로 반환
			while(rs.next()){
				JSONObject obj = new JSONObject();
			
				obj.put("aca_addr_zip", rs.getString("aca_addr_zip"));
				obj.put("aca_addr_doro", rs.getString("aca_addr_doro"));
				obj.put("aca_name", rs.getString("aca_name"));			
				
				arr.add(obj);
				
			}
		} catch (Exception e) {
			System.out.println("getAcademyInfoBySearchToJSON에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}
		
		return arr;
	}

	//학원관리자 등록 시 mem_email 컬럼 값에 매칭시키는 메서드
	@Override
	public int changeAcademyEmail(AcademyBean vo, int flag) {
		int result = 0;
		try {
			getConnection();
			
			//관리자 등급으로 변경 승인
			if(flag == 1){
				sql = "update academy set "					
						+ " mem_email = ? "					
						+ " where aca_name=?";			
				
				pstmt = con.prepareStatement(sql);			
				
				pstmt.setString(1, vo.getMem_email());	
				pstmt.setString(2, vo.getAcaName());
			
			//flag == 0이면 관리자 등급으로 변경 승인 취소
			}else if(flag == 0){
				sql = "update academy set "					
						+ " mem_email = null "					
						+ " where aca_name=?";			
				
				pstmt = con.prepareStatement(sql);					
				
				pstmt.setString(1, vo.getAcaName());				
					
			//flag == -1이면 관리자 등급으로 변경 승인 취소
			}else if(flag == -1){
				sql = "update academy set "					
						+ " mem_email = null "					
						+ " where aca_name=?";						
				pstmt = con.prepareStatement(sql);					
				pstmt.setString(1, vo.getAcaName());	
				
			}else{
				System.out.println("changeAcademyEmail() : 잘못된 flag 값 -> error");
				return 0;
			}
			
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			System.out.println("changeAcademyEmail()에서 예외 발생");
			e.printStackTrace();
		} finally{
			resourceClose();
		}		
		return result;
	}	
	
	//학원 이름 찾아오는 메서드
	public String getAcaName(String email){		
		String acaName = null;
		try {
			getConnection();
			
			String sql = "select * from academy "
					+ "where mem_email = ? ";
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);				
			rs = pstmt.executeQuery();
			
			if(rs.next())
				acaName = rs.getString("aca_name");				
			
		} catch (Exception e) {
			System.out.println("getAcaName()에서 예외 발생");
			e.printStackTrace();
		}finally{
			resourceClose();
		}		
		return acaName;
	}

	@Override
	public int getAcademyNumByAcaName(String acaName) {
		int acaMainNum = 0;
		try {
			getConnection();
			
			String sql = "select * from academy "
					+ "where aca_name = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, acaName);				
			rs = pstmt.executeQuery();
			
			if(rs.next())
				acaMainNum = rs.getInt("aca_main_num");				
			
		} catch (Exception e) {
			System.out.println("getAcademyNumByAcaName()에서 예외 발생");
			e.printStackTrace();
		}finally{
			resourceClose();
		}		
		return acaMainNum;
	}
	
	
	
	
	
	
	

	//키워드로 검색한 학원 갯수 갖고오기
	public int getAcademyKeywordCount(HashMap<String, Object> formsearch) {
		
		int count=0;
		
		
		
		try {
			getConnection();
		
			String where="select count(*) "
					+ "   from academy a join ( select aca_main_num , aca_keyword "
 												 +"					from academy_keyword "
                                                 +                  "  where aca_keyword =? "
                                                 + " group by aca_main_num)k "
					+ " on a.aca_main_num = k.aca_main_num " ;
			
			
			//검색창에만 입력했을시에
		if(formsearch.get("main")!=null&&formsearch.get("s1")==null&&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
			
			sql = where	
					+" where a.aca_name like ? " 
					+" or a.aca_search_addr1 like ? " 
					+" or a.aca_search_addr2 like ? " 
					+" or a.aca_search_addr3 like ? "
					+" or a.aca_category1 like ? ";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("key"));
			pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(3,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(4,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(5,'%'+(String)formsearch.get("main")+'%');
			
			
			rs=pstmt.executeQuery();
			
		
		}

//		//검색 창 입력 O , 광역시도 선택 O , 카테고리 선택 X
		else if(formsearch.get("main")!=null&&formsearch.get("s1")!=null&&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
		
			
			sql=   where                     
					+" where aca_name like ? " 
					+" and aca_search_addr1 = ? ";
					
					pstmt=con.prepareStatement(sql);
					
					pstmt.setString(1,(String)formsearch.get("key"));
					pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
					pstmt.setString(3,(String)formsearch.get("s1"));
					
					
					rs=pstmt.executeQuery();	
			
		}
		//검색 창 입력 O , 광역시도 선택 O , 카테고리 선택 O
		else if(formsearch.get("main")!=null&&formsearch.get("s1")!=null&&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
			
			
			sql=where                           
					+" where aca_name like ? " 
					+" and aca_search_addr1 = ? "
					+" and aca_category1 = ? ";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("key"));
			pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(3,(String)formsearch.get("s1"));
			pstmt.setString(4,(String)formsearch.get("s4"));
			
			
			rs=pstmt.executeQuery();	
			
		}
//		//검색 창 입력 X , 광역시도 선택 O , 카테고리 선택 O
		else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
			
			
			sql=where
					+ "where aca_search_addr1 = ? "
					+" and aca_category1 = ? ";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("key"));
			pstmt.setString(2,(String)formsearch.get("s1"));
			pstmt.setString(3,(String)formsearch.get("s4"));
			
			
			rs=pstmt.executeQuery();	
			
		}
//		//검색 창 입력 X , 광역시도 선택 O , 카테고리 선택 X
		else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
			
			sql=where
					+" where aca_search_addr1 = ? ";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("key"));
			pstmt.setString(2,(String)formsearch.get("s1"));
			
			
			rs=pstmt.executeQuery();	
			
		}//여기까지 광역시도 처리
//		//검색 창 입력 O , 광역시도 선택 O,지역구 O , 카테고리 선택 O
		else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
			
			sql=where                           
					+" where aca_name like ? " 
					+" and aca_search_addr1 =? " 
					+" and aca_search_addr2 =? " 
					+" and aca_category1 =? ";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("key"));
			pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(3,(String)formsearch.get("s1"));
			pstmt.setString(4,(String)formsearch.get("s2"));
			pstmt.setString(5,(String)formsearch.get("s4"));
			
			
			rs=pstmt.executeQuery();	
			
		}//
//		//검색 창 입력 X , 광역시도 선택 O,지역구 O , 카테고리 선택 O	
		else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
			
			sql=where                           
					+"  where aca_search_addr1 =? " 
					+" and aca_search_addr2 =? " 
					+" and aca_category1 =? ";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("key"));
			pstmt.setString(2,(String)formsearch.get("s1"));
			pstmt.setString(3,(String)formsearch.get("s2"));
			pstmt.setString(4,(String)formsearch.get("s4"));
			
			
			rs=pstmt.executeQuery();	
			
		}//
//		//검색 창 입력 X , 광역시도 선택 O,지역구 O , 카테고리 선택 X	
	else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
			
			sql=where                          
					+" where aca_search_addr1 =? " 
					+" and aca_search_addr2 =? "; 
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("key"));
			pstmt.setString(2,(String)formsearch.get("s1"));
			pstmt.setString(3,(String)formsearch.get("s2"));
			
			
			rs=pstmt.executeQuery();	
			
		}//
//		//전체 검색 창 입력 O , 광역시도 선택 O,지역구 O ,읍면동 O , 카테고리 선택 O	
	else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")!=null){
		
		sql=where	+" where aca_name like ? " 
				+" and aca_search_addr1 = ? " 
				+" and aca_search_addr2 = ? " 
				+" and aca_search_addr3 = ? " 
				+" and aca_category1 = ? ";
		pstmt=con.prepareStatement(sql);
		
		
		pstmt.setString(1,(String)formsearch.get("key"));
		pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
		pstmt.setString(3,(String)formsearch.get("s1"));
		pstmt.setString(4,(String)formsearch.get("s2"));
		pstmt.setString(5,(String)formsearch.get("s3"));
		pstmt.setString(6,(String)formsearch.get("s4"));
		
		System.out.println("확인");
		rs=pstmt.executeQuery();	
		
	}//
     // 검색 창 입력 X , 광역시도 선택 O,지역구 O ,읍면동O , 카테고리 선택 O			
	else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")!=null){
		
		sql=where			
				+" where aca_search_addr1 =? " 
				+" and aca_search_addr2 =? " 
				+" and aca_search_addr3 =? " 
				+" and aca_category1 =? ";
		pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1,(String)formsearch.get("key"));
		pstmt.setString(2,(String)formsearch.get("s1"));
		pstmt.setString(3,(String)formsearch.get("s2"));
		pstmt.setString(4,(String)formsearch.get("s3"));
		pstmt.setString(5,(String)formsearch.get("s4"));
		
		
		rs=pstmt.executeQuery();	
		
	}//		
		// 검색 창 입력 X , 광역시도 선택 O,지역구 O ,읍면동O , 카테고리 선택 X			
	else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")==null){
		
		sql=where                         
				+" where aca_search_addr1 =? " 
				+" and aca_search_addr2 =? " 
				+" and aca_search_addr3 =? "; 
		pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1,(String)formsearch.get("key"));
		pstmt.setString(2,(String)formsearch.get("s1"));
		pstmt.setString(3,(String)formsearch.get("s2"));
		pstmt.setString(4,(String)formsearch.get("s3"));
		
		
		rs=pstmt.executeQuery();	
		
	}		
		// 검색 창 입력 X , 광역시도 선택 O,지역구 O ,읍면동O , 카테고리 선택 X			
	else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")==null){
		
		sql=where
				+ " where aca_name like ? "                           
				+" and aca_search_addr1 =? " 
				+" and aca_search_addr2 =? " 
				+" and aca_search_addr3 =? "; 
		pstmt=con.prepareStatement(sql);
		

		pstmt.setString(1,(String)formsearch.get("key"));
		pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
		pstmt.setString(3,(String)formsearch.get("s1"));
		pstmt.setString(4,(String)formsearch.get("s2"));
		pstmt.setString(5,(String)formsearch.get("s3"));
		
		
		rs=pstmt.executeQuery();	
		
	}		
	else{//그냥 키워드만 눌렀을 경우
		
		sql+=where ;                          
				 
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,(String)formsearch.get("key"));
		
		
		rs=pstmt.executeQuery();	
		
		
	}
		
			
			
		
		
		
		
		if(rs.next()){//카운트 갖고오기
			
			count=rs.getInt(1);
			
			return count;
		}
		
			
	
		
		}catch (Exception e) {
			System.out.println("getAcademyKeywordCount(HashMap)에서 예외 발생"+e);
		}finally {
			resourceClose();
		}	
		
		
		
		
		
		
		
	 return count;
		
		
	}//getAcademyCount

	public List<AcademyBean> getSearchKeywordListAcademy(HashMap<String, Object> formsearch, int StartRow, int pageSize) {
	
		
		List<AcademyBean> list = new ArrayList();
		try {
			
			getConnection();
			
			
			String like="select a.* ,ifnull(r.avgscore,0) avgscore , ifnull(m.mem_profileImg,'images/etc/default_mango.png') profileimg  ,ifnull(k.acalike , 0) acalike "
					+" from academy a left join (select aca_main_num,avg(review_score) avgscore "
					+" from academy_review "
					+ " group by aca_main_num ) r"
								+" on a.aca_main_num=r.aca_main_num left join (select aca_main_num , count(*) acalike "
																			+ 	" from liked_academy "
											+ 		" group by aca_main_num ) k on a.aca_main_num = k.aca_main_num "                      
														+" left join (select mem_email,mem_profileImg "
														+ " from member "
														+ " group by mem_email) m on a.mem_email = m.mem_email join ( select aca_main_num , aca_keyword "
 												 +"	from academy_keyword "
                                                 +   "  where aca_keyword =? "
                                                 + " group by aca_main_num)w "
					+ " on a.aca_main_num = w.aca_main_num " ;
			
			String review ="select a.* ,ifnull(r.avgscore,0) avgscore,ifnull(m.mem_profileImg,'images/etc/default_mango.png') profileimg ,ifnull(r.count,0) count "
					+" from academy a left join (select aca_main_num, count(*) count,avg(review_score) avgscore "
					+" from academy_review"
					+ " group by aca_main_num) r"
					+" on a.aca_main_num=r.aca_main_num "
					+" left join (select mem_email,mem_profileImg "
					+ " from member "
					+ " group by mem_email) m on a.mem_email = m.mem_email join ( select aca_main_num , aca_keyword "
 												 +"	from academy_keyword "
                                                 +   "  where aca_keyword =? "
                                                 + " group by aca_main_num)w "
					+ " on a.aca_main_num = w.aca_main_num " ;
			
			String rating="select a.* ,ifnull(r.avgscore,0) avgscore,ifnull(m.mem_profileImg,'images/etc/default_mango.png') profileimg "
					+" from academy a left join (select aca_main_num,avg(review_score) avgscore"
					  +" from academy_review"
					  + " group by aca_main_num ) r" 
					  +" on a.aca_main_num=r.aca_main_num "
					  +" left join (select mem_email,mem_profileImg "
					  + " from member "
					  + " group by mem_email) m on a.mem_email = m.mem_email join ( select aca_main_num , aca_keyword "
 												 +"	from academy_keyword "
                                                 +   "  where aca_keyword =? "
                                                 + " group by aca_main_num)w "
					+ " on a.aca_main_num = w.aca_main_num " ;	
			
			String basic="select a.* ,ifnull(r.avgscore,0) avgscore ,ifnull(m.mem_profileImg,'images/etc/default_mango.png') profileimg"
					 +" from academy a left join (select aca_main_num,avg(review_score) avgscore "
	 					+" from academy_review "
	 					+ " group by aca_main_num ) r "
	 					+" on a.aca_main_num=r.aca_main_num "   
						+" left join (select mem_email,mem_profileImg "
						+ " from member "
						+ " group by mem_email) m on a.mem_email = m.mem_email join ( select aca_main_num , aca_keyword "
 												 +"	from academy_keyword "
                                                 +   "  where aca_keyword =? "
                                                 + " group by aca_main_num)w "
					+ " on a.aca_main_num = w.aca_main_num " ;
			
			String where="";
			
			
			String s5= (String)formsearch.get("s5");
			
			//검색창에만 입력했을시에
		if(formsearch.get("main")!=null&&formsearch.get("s1")==null&&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")==null ){
			
			
			
			where=" where a.aca_name like ? " 
					+" or a.aca_search_addr1 like ? " 
					+" or a.aca_search_addr2 like ? " 
					+" or a.aca_search_addr3 like ? "
					+" or a.aca_category1 like ? ";
			
			if(s5.equals("like")){//좋아요 많은순
				
				
				sql=like+where	
						+ " order by acalike desc "
						+ " limit ? , ?";
				
			}else if(s5.equals("review")){//리뷰 후기 많은순
				
				sql=review
						+ where	
						+ " order by count desc "
						+ " limit ? , ?";
				
				
			}else if(s5.equals("rating")){//평점 높은순 
				
				
				sql=rating								
						+where
						+ " order by  avgscore desc "
						+ " limit ? , ? ";
				
			}else if(s5.equals("basic")){//기본
				sql=basic
				+ where
				+ " limit ? , ? ";
			}
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("key"));
			pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(3,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(4,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(5,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(6,'%'+(String)formsearch.get("main")+'%');
			pstmt.setInt(7,StartRow);
			pstmt.setInt(8,pageSize);
			
			
			rs=pstmt.executeQuery();
			
		
		}

//		//검색 창 입력 O , 광역시도 선택 O , 카테고리 선택 X
		else if(formsearch.get("main")!=null&&formsearch.get("s1")!=null&&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
		
			
			where=" where a.aca_name like ? " 
					+" and a.aca_search_addr1 = ? ";
			
			if(s5.equals("like")){//좋아요 많은순
						
						
						sql=like
								+where
								+ " order by acalike desc,a.aca_main_num asc "
								+ " limit ? , ?";
						
						
						
						
					}else if(s5.equals("review")){//리뷰 후기 많은순
						
						
						
						sql=review
								+where
								+ " order by count desc,a.aca_main_num asc "
								+ " limit ? , ?";
						
						
					}else if(s5.equals("rating")){//평점 높은순 
						
						
						sql=rating
								+where
								+ " order by  avgscore desc,a.aca_main_num asc "
								+ " limit ? , ? ";
						
					}else if(s5.equals("basic")){//기본
			
						sql=basic
								+where
								+ " limit ? , ?";
					}
			
					pstmt=con.prepareStatement(sql);
					
					
					pstmt.setString(1,(String)formsearch.get("key"));
					pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
					pstmt.setString(3,(String)formsearch.get("s1"));
					pstmt.setInt(4,StartRow);
					pstmt.setInt(5,pageSize);
					
					
					rs=pstmt.executeQuery();	
			
		}
		//검색 창 입력 O , 광역시도 선택 O , 카테고리 선택 O
		else if(formsearch.get("main")!=null&&formsearch.get("s1")!=null&&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
			
			
			where=" where a.aca_name like ? " 
					+" and a.aca_search_addr1 = ? "
					+" and a.aca_category1 = ? ";
			
				if(s5.equals("like")){//좋아요 많은순
						
						
						sql=like+where
								+ " order by acalike desc,a.aca_main_num asc "
								+ " limit ? , ?";
						
						
						
						
					}else if(s5.equals("review")){//리뷰 후기 많은순
						
						
						
						sql=review
								+where
								+ " order by count desc,a.aca_main_num asc "
								+ " limit ? , ?";
						
						
					}else if(s5.equals("rating")){//평점 높은순 
						
						
						sql=rating
								+where
								+ " order by  avgscore desc,a.aca_main_num asc "
								+ " limit ? , ? ";
						
					}else if(s5.equals("basic")){//기본
						
						
						sql=basic
								+where
								 + " limit ? , ?";
						
		
					}
			

			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("key"));
			pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(3,(String)formsearch.get("s1"));
			pstmt.setString(4,(String)formsearch.get("s4"));
			pstmt.setInt(5,StartRow);
			pstmt.setInt(6,pageSize);
			
			rs=pstmt.executeQuery();	
			
		}
//		//검색 창 입력 X , 광역시도 선택 O , 카테고리 선택 O
		else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
			
			
			where=" where a.aca_search_addr1 = ? "
					+" and a.aca_category1 = ? ";
			
			if(s5.equals("like")){//좋아요 많은순
				
				
				sql=like
					+where
						+ " order by acalike desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
				
				
			}else if(s5.equals("review")){//리뷰 후기 많은순
				
				
				
				sql=review
						+where
						+ " order by count desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
			}else if(s5.equals("rating")){//평점 높은순 
				
				
				sql=rating
						+where
						+ " order by  avgscore desc,a.aca_main_num asc "
						+ " limit ? , ? ";
				
			}else if(s5.equals("basic")){//기본
				
				
				sql=basic 					
						+where
						 + " limit ? , ?";
				

			}
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("key"));
			pstmt.setString(2,(String)formsearch.get("s1"));
			pstmt.setString(3,(String)formsearch.get("s4"));
			pstmt.setInt(4,StartRow);
			pstmt.setInt(5,pageSize);
			
			rs=pstmt.executeQuery();	
			
		}
//		//검색 창 입력 X , 광역시도 선택 O , 카테고리 선택 X
		else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")==null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
			
			
			
			where=" where a.aca_search_addr1 = ? ";
			
			
			
			if(s5.equals("like")){//좋아요 많은순
				
				
				sql=like                     
						+where
						+ " order by acalike desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
				
				
			}else if(s5.equals("review")){//리뷰 후기 많은순
				
				
				
				sql=review             
						+where
						+ " order by count desc,a.aca_main_num asc "
						+ " limit ? , ?";
				
				
			}else if(s5.equals("rating")){//평점 높은순 
				
				
				sql=rating                     
						+where
						+ " order by  avgscore desc,a.aca_main_num asc "
						+ " limit ? , ? ";
				
			}else if(s5.equals("basic")){//기본
				sql=basic            
						+where
						 + " limit ? , ?";
			}
			
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("key"));
			pstmt.setString(2,(String)formsearch.get("s1"));
			pstmt.setInt(3,StartRow);
			pstmt.setInt(4,pageSize);
			
			rs=pstmt.executeQuery();	
			
		}//여기까지 광역시도 처리
//		//검색 창 입력 O , 광역시도 선택 O,지역구 O , 카테고리 선택 O
		else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
			
			
			where=" where a.aca_name like ? " 
					+" and a.aca_search_addr1 =? " 
					+" and a.aca_search_addr2 =? " 
					+" and a.aca_category1 =? ";
			
		if(s5.equals("like")){//좋아요 많은순
			
			
			sql=like                   
					+where
					+ " order by acalike desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
			
			
		}else if(s5.equals("review")){//리뷰 후기 많은순
			
			
			
			sql=review                  
					+where
					+ " order by count desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
		}else if(s5.equals("rating")){//평점 높은순 
			
			
			sql=rating                 
					+where
					+ " order by  avgscore desc,a.aca_main_num asc "
					+ " limit ? , ? ";
			
		}else if(s5.equals("basic")){//기본
			
			
			sql=basic                 
					+where
					 + " limit ? , ?";
			

		}
		
			
			
			
			
			
			pstmt=con.prepareStatement(sql);
			
			
			pstmt.setString(1,(String)formsearch.get("key"));
			pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
			pstmt.setString(3,(String)formsearch.get("s1"));
			pstmt.setString(4,(String)formsearch.get("s2"));
			pstmt.setString(5,(String)formsearch.get("s4"));
			pstmt.setInt(6,StartRow);
			pstmt.setInt(7,pageSize);
			    
			rs=pstmt.executeQuery();	
			
		}//
//		//검색 창 입력 X , 광역시도 선택 O,지역구 O , 카테고리 선택 O	
		else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")!=null){
			
			
			
			where=" where a.aca_search_addr1 =? " 
					+" and a.aca_search_addr2 =? " 
					+" and a.aca_category1 =? ";
			
			
			if(s5.equals("like")){//좋아요 많은순
			
			
			sql=like                    
					+where
					+ " order by acalike desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
			
			
		}else if(s5.equals("review")){//리뷰 후기 많은순
			
			
			
			sql=review                 
					+where
					+ " order by count desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
		}else if(s5.equals("rating")){//평점 높은순 
			
			
			sql=rating                    
					+where
					+ " order by  avgscore desc,a.aca_main_num asc "
					+ " limit ? , ? ";
			
		}else if(s5.equals("basic")){//기본
			
			
			sql=basic                
					+where
					 + " limit ? , ?";
			

		}
		
			
			
			
			
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,(String)formsearch.get("key"));
			pstmt.setString(2,(String)formsearch.get("s1"));
			pstmt.setString(3,(String)formsearch.get("s2"));
			pstmt.setString(4,(String)formsearch.get("s4"));
			pstmt.setInt(5,StartRow);
			pstmt.setInt(6,pageSize);
			
			rs=pstmt.executeQuery();	
			
		}//
//		//검색 창 입력 X , 광역시도 선택 O,지역구 O , 카테고리 선택 X	
	else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
			
		where=" where a.aca_search_addr1 =? " 
				+" and a.aca_search_addr2 =? ";
			if(s5.equals("like")){//좋아요 많은순
				
				
			sql=like                    
					+where
					+ " order by acalike desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
			
			
		}else if(s5.equals("review")){//리뷰 후기 많은순
			
			
			
			sql=review                    
					+where
					+ " order by count desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
		}else if(s5.equals("rating")){//평점 높은순 
			
			
			sql=rating                    
					+where
					+ " order by  avgscore desc,a.aca_main_num asc "
					+ " limit ? , ? ";
			
			}else if(s5.equals("basic")){//기본
			
			
			sql=basic                    
					+where
					 + " limit ? , ?";
			

			}
			
			
		
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1,(String)formsearch.get("key"));
				pstmt.setString(2,(String)formsearch.get("s1"));
				pstmt.setString(3,(String)formsearch.get("s2"));
				pstmt.setInt(4,StartRow);
				pstmt.setInt(5,pageSize);
				
			rs=pstmt.executeQuery();	
			
		}//
	//검색 창 입력 O , 광역시도 선택 O,지역구 O , 카테고리 선택 X	
	else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")==null&&formsearch.get("s4")==null){
		
		where=" where a.aca_name like ?"
				+ "and a.aca_search_addr1 =? " 
				+" and a.aca_search_addr2 =? ";
		if(s5.equals("like")){//좋아요 많은순
			
			
			sql=like                    
					+where
					+ " order by acalike desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
			
			
		}else if(s5.equals("review")){//리뷰 후기 많은순
			
			
			
			sql=review                    
					+where
					+ " order by count desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
		}else if(s5.equals("rating")){//평점 높은순 
			
			
			sql=rating                    
					+where
					+ " order by  avgscore desc,a.aca_main_num asc "
					+ " limit ? , ? ";
			
		}else if(s5.equals("basic")){//기본
			
			
			sql=basic                    
					+where
					+ " limit ? , ?";
			
			
		}
		
		
		
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,(String)formsearch.get("key"));
		pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
		pstmt.setString(3,(String)formsearch.get("s1"));
		pstmt.setString(4,(String)formsearch.get("s2"));
		pstmt.setInt(5,StartRow);
		pstmt.setInt(6,pageSize);
		
		rs=pstmt.executeQuery();	
		
	}//
//		//전체 검색 창 입력 O , 광역시도 선택 O,지역구 O ,읍면동 O , 카테고리 선택 O	
	else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")!=null){
		
		
		where=" where a.aca_name like ? " 
				+" and a.aca_search_addr1 = ? " 
				+" and a.aca_search_addr2 = ? " 
				+" and a.aca_search_addr3 = ? " 
				+" and a.aca_category1 = ? ";
		
		
		if(s5.equals("like")){//좋아요 많은순
			
			
			sql=like                    
					+where
					+ " order by acalike desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
			
			
		}else if(s5.equals("review")){//리뷰 후기 많은순
			
			
			
			sql=review                    
					+where
					+ " order by count desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
		}else if(s5.equals("rating")){//평점 높은순 
			
			
			sql=rating                     
					+where
					+ " order by  avgscore desc,a.aca_main_num asc "
					+ " limit ? , ? ";
			
			}else if(s5.equals("basic")){//기본
			
			
			sql=basic	 					
					+where
					 + " limit ? , ?";
			

			}
		
		
		pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1,(String)formsearch.get("key"));
		pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
		pstmt.setString(3,(String)formsearch.get("s1"));
		pstmt.setString(4,(String)formsearch.get("s2"));
		pstmt.setString(5,(String)formsearch.get("s3"));
		pstmt.setString(6,(String)formsearch.get("s4"));
		pstmt.setInt(7,StartRow);
		pstmt.setInt(8,pageSize);
		
		System.out.println("확인");
		rs=pstmt.executeQuery();	
		
	}//
     // 검색 창 입력 X , 광역시도 선택 O,지역구 O ,읍면동O , 카테고리 선택 O			
	else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")!=null){
		
		
		where=" where a.aca_search_addr1 =? " 
				+" and a.aca_search_addr2 =? " 
				+" and a.aca_search_addr3 =? "     
				+" and a.aca_category1 =? ";
		
		if(s5.equals("like")){//좋아요 많은순
			
			
			sql=like                      
					+where
					+ " order by acalike desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
			
			
		}else if(s5.equals("review")){//리뷰 후기 많은순
			
			
			
			sql=review                    
					+where
					+ " order by count desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
		}else if(s5.equals("rating")){//평점 높은순 
			
			
			sql=rating                    
					+where
					+ " order by  avgscore desc,a.aca_main_num asc "
					+ " limit ? , ? ";
			
			}else if(s5.equals("basic")){//기본
			
			
			sql=basic  
					+where
					 + " limit ? , ?";
			

			}
		
		pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1,(String)formsearch.get("key"));
		pstmt.setString(2,(String)formsearch.get("s1"));
		pstmt.setString(3,(String)formsearch.get("s2"));
		pstmt.setString(4,(String)formsearch.get("s3"));
		pstmt.setString(5,(String)formsearch.get("s4"));
		pstmt.setInt(6,StartRow);
		pstmt.setInt(7,pageSize);
		
		rs=pstmt.executeQuery();	
		
	}//		
		// 검색 창 입력 X , 광역시도 선택 O,지역구 O ,읍면동O , 카테고리 선택 X			
	else if(formsearch.get("main")==null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")==null){
		
		where=" where a.aca_search_addr1 =? " 
				+" and a.aca_search_addr2 =? " 
				+" and a.aca_search_addr3 =? ";
		
			if(s5.equals("like")){//좋아요 많은순
			
			
			sql=like                   
					+where
					+ " order by acalike desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
		}else if(s5.equals("review")){//리뷰 후기 많은순
			
			
			
			sql=review                 
					+where
					+ " order by count desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
		}else if(s5.equals("rating")){//평점 높은순 
			
			
			sql=rating                    
					+where
					+ " order by  avgscore desc,a.aca_main_num asc "
					+ " limit ? , ? ";
			
			}else if(s5.equals("basic")){//기본
			
			
			sql=basic 
					+where
					 + " limit ? , ?";
			

			}
		
		pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1,(String)formsearch.get("key"));
		pstmt.setString(2,(String)formsearch.get("s1"));
		pstmt.setString(3,(String)formsearch.get("s2"));
		pstmt.setString(4,(String)formsearch.get("s3"));
		pstmt.setInt(5,StartRow);
		pstmt.setInt(6,pageSize);
		
		rs=pstmt.executeQuery();	
		
	}		// 검색 창 입력 O, 광역시도 선택 O,지역구 O ,읍면동O , 카테고리 선택 X	
	else if(formsearch.get("main")!=null &&formsearch.get("s1")!=null &&formsearch.get("s2")!=null&&formsearch.get("s3")!=null&&formsearch.get("s4")==null){
		
		
		
		where=" where aca_name like ? "
				+" and a.aca_search_addr1 =? " 
				+" and a.aca_search_addr2 =? " 
				+" and a.aca_search_addr3 =? ";
		if(s5.equals("like")){//좋아요 많은순
			
			
			sql=like                    
					+where
					+ " order by acalike desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
			
			
		}else if(s5.equals("review")){//리뷰 후기 많은순
			
			
			
			sql=review                      
					+where
					+ " order by count desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
		}else if(s5.equals("rating")){//평점 높은순 
			
			
			sql=rating                    
					+where
					+ " order by  avgscore desc,a.aca_main_num asc "
					+ " limit ? , ? ";
			
		}else if(s5.equals("basic")){//기본
			
			
			sql=basic   
					+where
					+ " limit ? , ?";
			
			
		}
			
		
		pstmt=con.prepareStatement(sql);

		pstmt.setString(1,(String)formsearch.get("key"));
		pstmt.setString(2,'%'+(String)formsearch.get("main")+'%');
		pstmt.setString(3,(String)formsearch.get("s1"));
		pstmt.setString(4,(String)formsearch.get("s2"));
		pstmt.setString(5,(String)formsearch.get("s3"));
		pstmt.setInt(6,StartRow);
		pstmt.setInt(7,pageSize);
		
		rs=pstmt.executeQuery();	
		
	}		
	else{//그냥 검색하기 만 눌렀을 경우
		
		
		if(s5.equals("like")){//좋아요 많은순
			
			
			sql=like                      
					+ " order by acalike desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
			
			
		}else if(s5.equals("review")){//리뷰 후기 많은순
			
			
			
			sql=review              
					+ " order by count desc,a.aca_main_num asc "
					+ " limit ? , ?";
			
			
		}else if(s5.equals("rating")){//평점 높은순 
			
			
			sql=rating                		
					+ " order by  avgscore desc,a.aca_main_num asc "
					+ " limit ? , ? ";
			
			}else if(s5.equals("basic")){//기본
			
			
			sql=basic
					 + " limit ? , ?";
			

			}
				 
		pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1,(String)formsearch.get("key"));
		pstmt.setInt(2,StartRow);
		pstmt.setInt(3,pageSize);
		
		
		rs=pstmt.executeQuery();	
		
		
	}
		
		while(rs.next()){
			AcademyBean bean = new AcademyBean(	
					rs.getInt(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getString(5), rs.getString(6),
					rs.getString(7), rs.getString(8), rs.getString(9), 
					rs.getString(10), rs.getString(11), //acaCategory
					rs.getString(12), rs.getString(13), rs.getString(14), //address
					rs.getString(15),	//mem_email						
					rs.getDouble(19),   //reviewScore
					rs.getInt(17),rs.getString(20)
					);			
			
			list.add(bean);				
		}			
	
		
		
		
	}catch (Exception e) {
		System.out.println("getSearchKeywordListAcademy(HashMap)에서 예외 발생"+e);
	
	}finally {
		resourceClose();
	}	
	
	
	
	
	return list;
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

	//등록된 학원 수
	@Override
	public int getRegisteredAcademyCount() {		
		try {
			getConnection();
			
			sql="select count(*) from academy where mem_email is not null";
			
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();			
			
			if(rs.next()){				
				return rs.getInt(1);
			}			
			
		} catch (Exception e) {
			System.out.println("getRegisteredAcademyCount()에서 예외 발생"+e);
		}finally {
			resourceClose();
		}					
		return 0;
	}
	
	
	
	
	
	
	
} // AcademyDAO 끝	
