package mango.liked_aca_review.db;


public class LikedAcaReviewBean {
	
	// 후기번호 
    private int reviewNum;

    // 이메일 
    private String memEmail;

    // 도움되었어요 일자 
    private String likedReviewDate;

    public int getReviewNum() {
        return reviewNum;
    }

    public void setReviewNum(int reviewNum) {
        this.reviewNum = reviewNum;
    }

    public String getMemEmail() {
        return memEmail; 
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    public String getLikedReviewDate() {
        return likedReviewDate;
    }

    public void setLikedReviewDate(String likedReviewDate) {
        this.likedReviewDate = likedReviewDate;
    }

}