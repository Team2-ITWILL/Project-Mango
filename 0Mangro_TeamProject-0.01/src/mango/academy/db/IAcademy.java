package mango.academy.db;

import java.util.List;

import org.json.simple.JSONArray;

import mango.member.db.MemberBean;

public interface IAcademy {
	
	
	
	//전체 학원 목록
	public List<AcademyBean> AllAcademyList(int StartRow,int pageSize);
	
	//검색바로만 이용시 학원 이름과 지역 검색
	public List<AcademyBean> getOnlySearch(AcademyBean search);
	
	//학원 검색바와 목록을 한꺼번에 검색할 경우			
	public List<AcademyBean> getAllSearch(AcademyBean search);
							
	/*											
	 												학원 명    			지역 			학원과목
	 	public List<AcademyBean> getAllSearch(String title,String address,String sub);
	
	*/
	//목록으로만 검색 할 경우
	public List<AcademyBean> getListSearch(AcademyBean address);
	
	//학원에 대한정보를 갖고오는 메서드
	public AcademyBean getAcademyContent(int acaNum);
	
	/*//학원을 등록하는 메서드
	public void InsertAcademy(AcademyBean ab);
	*/
	//학원 삭제
	public void DeleteAcademy(AcademyBean ab);
	
	//학원수 체크
	public int getAcademyCount();
	
	//지역구
	public JSONArray getListSearchOne(String address);

	//읍면동
	public JSONArray getListSearchTwo(String address,String address2);
	
	//카테고리
	public JSONArray getListSearchThr(String parameter, String parameter2, String parameter3);
	
	
	//학원관리자 회원정보 변경
	public int reviseAcademyInfo(AcademyBean bean);
	
	//학원관리자 회원정보 가져오기(오버로딩)
	public AcademyBean getAcademyContent(String email);
	
	//학원에 대한정보를 갖고오는 메서드(이름으로 검색) -> List
	public List<AcademyBean> getAcademyInfoBySearchToList(String acaName);
	//학원에 대한정보를 갖고오는 메서드(이름으로 검색) -> JSON Array
	public JSONArray getAcademyInfoBySearchToJSON(String acaName);
	
	//학원관리자 등록 시 mem_email 컬럼 값에 매칭시키는 메서드
	public int changeAcademyEmail(AcademyBean vo, int flag);
	
	//학원 이름 찾아오는 메서드
	public String getAcaName(String email);	

	//학원번호 가져오는 메서드
	public int getAcademyNumByAcaName(String acaName);
	
	//등록된 학원 수
	public int getRegisteredAcademyCount();
	

}
