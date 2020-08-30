package mango.academy.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mango.connection.db.DBconnection;

public class AcademyDAO extends DBconnection implements IAcademy{

	@Override
	public List<AcademyBean> AllAcademyList(int StartRow, int pageSize) {
		List<AcademyBean> list = new ArrayList<AcademyBean>();
		try {
			getConnection();
			AcademyBean bean;
			String sql = "select * from academy limit ?, ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, StartRow);
			pstmt.setInt(2, pageSize);			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bean = new AcademyBean(
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), 
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)
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
	
	
	
	
}
