package mango.academy_keyword.db;

public class AcademyKeywordBean {

	 // 학원지정번호 
   private int acaMainNum;

   // 키워드(교통이 편리한) 
   private String acakeyword;

   /*
    
    traffic - 교통이 편리한
    stdRoom - 스터디룸이 있는
    room - 기숙사가 있는
    audit - 청강신청이 가능한
    clean - 시설이 개끗한
    restaurant - 식당가 인근
    long - 중장기
    car - 차량운행이 있는
    level - 레벨테스트가 있는
    sat - 수능대비강의가 있는

    */
	public int getAcaMainNum() {
	return acaMainNum;
	}
	
	public void setAcaMainNum(int acaMainNum) {
		this.acaMainNum = acaMainNum;
	}

	public String getAcakeyword() {
		return acakeyword;
	}

	public void setAcakeyword(String acakeyword) {
		this.acakeyword = acakeyword;
	}

	@Override
	public String toString() {
		return "AcademyKeywordBean [acaMainNum=" + acaMainNum + ", acakeyword=" + acakeyword + "]";
	}

	
}
