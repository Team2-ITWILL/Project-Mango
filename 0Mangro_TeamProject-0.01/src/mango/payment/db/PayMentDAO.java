package mango.payment.db;

import mango.connection.db.DBconnection;

public class PayMentDAO extends DBconnection implements IPayMent{

	
	
	
	
	
	@Override
	public int InsertPayment(PaymentBean pb) {
	
	 int num=0;
	 int check=0;
		
		try {
			getConnection();
			
			
			sql="select pm_use_num from payment where mem_email = ?";
							
			pstmt=con.prepareStatement(sql);
			
			
			pstmt.setString(1,pb.getMemEmail());
			
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
				num=rs.getInt(1)+1;
				
			}else{
				
				num=1;
				
			}
			
			sql="insert into payment "
					+ " values(?,?,?,now(),DATE_ADD(NOW(), INTERVAL ? DAY)";
			
			pstmt=con.prepareStatement(sql);
			
			
			pstmt.setString(1,pb.getMemEmail());
			pstmt.setInt(2,num);
			pstmt.setString(3,pb.getPmName());
			
			check=pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
		
			System.out.println("InsertPayment()메소드에서 오류발생"+e);
			
		}
		
		
		
		
		return 0;
	}

	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
