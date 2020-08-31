package mango.academy_review.db;

import java.util.List;

//import mango.academy.db.AcademyBean;
import mango.member.db.MemberBean; 

public interface IAcademyReview {
	

   
	//학원 후기숫자을 갖고오는 메서드
	public int getAcademyReviewCount(int acaNum);

	//후기리스트 갖고오는 
	public List<AcademyReviewBean> getAcademyReviewList(int acaNum,int startRow,int pageSize);
 
	//학원 후기 등록
	public void InsertAcademyReview(AcademyReviewBean ab);
	
	//학원 후기 삭제
	public int DeleteAcademyReview(int reviewNum);
	
	//학원 후기 수정
	public void UpdateAcademyReview(AcademyReviewBean ab);

	
	

}
