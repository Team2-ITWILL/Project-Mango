package mango.academy.db;

import java.util.List;

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
	public AcademyBean getAcademyContent(AcademyBean ab);
	
	/*//학원을 등록하는 메서드
	public void InsertAcademy(AcademyBean ab);
	*/
	//학원 삭제
	public void DeleteAcademy(AcademyBean ab);
	
	

}
