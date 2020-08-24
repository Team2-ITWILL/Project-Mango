package mango.academy_review.db;

import java.util.List;

//import mango.academy.db.AcademyBean;
import mango.member.db.MemberBean; 

public interface IAcademyReview {
	

   
	//학원 후기내용을 갖고오는 메서드
	public AcademyReviewBean getAcademyReview(AcademyReviewBean ab);

	//후기리스트 갖고오는 
	public List<AcademyReviewBean> getAcademyReviewList(AcademyReviewBean ab);
 
	//학원 후기 등록
	public int InsertAcademyReview(AcademyReviewBean ab);
	
	//학원 후기 삭제
	public int DeleteAcademyReview(AcademyReviewBean ab);
	
	//학원 후기 수정
	public int UpdateAcademyReview(AcademyReviewBean ab);

	
	

}
