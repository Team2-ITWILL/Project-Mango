package mango.payment.db;

import mango.connection.db.DBconnection;

public class PayMentDAO extends DBconnection implements IPayMent{

	
	
	
	
	
	@Override
	public int InsertPayment(PaymentBean pb ,int day) {
	
	 int num=0;
	 int check=0;
		
		try {
			getConnection();
			
			
			sql="select max(pm_use_num) from payment where mem_email = ?";
							
			pstmt=con.prepareStatement(sql);
			
			//멤버십에 가입됐는지 안됐는지 확인후
			pstmt.setString(1,pb.getMemEmail());
			
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
				//있으면 사용회차에 1 플러스
				num=rs.getInt(1)+1;
				
			}else{
				//없으면 사용회차에 1 초기화
				num=1;
				
			}
			
			sql="insert into payment "
					+ " values(?,?,?,now(),DATE_ADD(NOW(), INTERVAL ? DAY),?)";
			
			pstmt=con.prepareStatement(sql);
			
			
			pstmt.setString(1,pb.getMemEmail());
			pstmt.setInt(2,num);//사용회차
			pstmt.setString(3,pb.getPmName());//사용권 이름
			pstmt.setInt(4,day);// 결제 날짜에 더할 날짜
			pstmt.setString(5,pb.getPmCheck());
			
			check=pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
		
			System.out.println("InsertPayment()메소드에서 오류발생"+e);
			
		}	
		return check;
	
	}

	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
