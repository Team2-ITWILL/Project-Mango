
package mango.payment.db;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
			
		}finally {
			
			resourceClose();
			
		}
		
		return check;
	
	}
	
	
	
	//최근 이용권 정보를 갖고오는 메서드
	@Override
	public PaymentBean getNewPayment(PaymentBean pb) {
			
		try {
			getConnection();
			
			sql="select pm_name,max(pm_Use_Num) from payment where mem_email=?"
					+" and pm_Use_num=(select max(pm_Use_Num) " 
					+		"		 	from payment"
			         +      "  			where mem_email = ?) ";
			
					
					
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,pb.getMemEmail());
			pstmt.setString(2,pb.getMemEmail());
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
				pb.setPmName(rs.getString(1));
				pb.setPmUseNum(rs.getInt(2));
				return pb;
			
			}
			
			
			
		} catch (Exception e) {
		System.out.println("getNewPayment()메소드에서  오류발생"+e);
		}finally {
			
			resourceClose();
			
		}

		
		
		
		
		return pb;
	}

	
	//자신의 이용권 리스트를 갖고 오는 메서드
	public JSONArray getListMyPayMent(PaymentBean mypay){
		
		JSONArray ja =new JSONArray();
		
		
		try {
		
			getConnection();
	
			
			sql="select p.mem_email,p.pm_use_num,p.pm_name,date_format(p.pm_start_date, '%Y-%m-%d') "
			+ " pm_start_date ,date_format(p.pm_exp_date, '%Y-%m-%d') pm_exp_date, p.pm_check , m.maxnum, DATEDIFF( p.pm_exp_date,now() ) result "
			+" from payment p join (select mem_email, max(pm_use_num) maxnum "
			+					 " from payment"
			+ "						group by mem_email) m "
			+" on p.mem_email = m.mem_email "
			+" where p.mem_email=? "
			+ " order by p.pm_start_date desc ";     
			
			
			
			
			
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,mypay.getMemEmail());
			
			rs=pstmt.executeQuery();
			
			
			while(rs.next()){
				
			JSONObject jo = new JSONObject();
			
			jo.put("memEmail", rs.getString(1));
			jo.put("pmUseName", rs.getInt(2));
			jo.put("pmName", rs.getString(3));
			jo.put("pmStartDate", rs.getString(4));
			jo.put("pmExpDate", rs.getString(5));
			jo.put("pmCheck", rs.getString(6));
			jo.put("max", rs.getInt(7));
			jo.put("result", rs.getInt(8));
			
			ja.add(jo);
			
			}
			
			
			
		} catch (Exception e) {
		
			System.out.println("getListMyPayMent()메소드에서  오류발생"+e);
			
		}finally {
			
			resourceClose();
			
		}
		
		
		
		return ja;
	}
	
	
	
	public List<PaymentBean> getadminAllList(int startRow ,int pageSize){
		
		
		List<PaymentBean> pbList =new ArrayList<PaymentBean>();
		
		try {
			getConnection();
		
			
			sql="select mem_email, pm_use_num, pm_name ,date_format(pm_start_date, '%Y-%m-%d') "
			+ " pm_start_date ,date_format(pm_exp_date, '%Y-%m-%d') pm_exp_date, pm_check "
			+ " from payment "
			+ " limit ?,? ";
		
			pstmt=con.prepareStatement(sql);
		
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			
			rs=pstmt.executeQuery();
		
			
			while(rs.next()){
			
				PaymentBean pb =new PaymentBean(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getDate(4),rs.getDate(5),rs.getString(6));
				
	
				pbList.add(pb);
				
			}
				
			
			
			
		
		} catch (Exception e) {
		
			System.out.println("getPaymentCount()메소드에서  오류발생"+e);
			
		}finally {
			
			resourceClose();
			
		}
		
		
		
		
		
		
		
		
		
		return pbList;
	}


	// 멤버십 가입자 수
	public int getPaymentCount() {
		
		int count=0;
		
		try {
			getConnection();
		
			
			sql="select count(*) from payment";
		
			pstmt=con.prepareStatement(sql);
		
			rs=pstmt.executeQuery();
		
			
			if(rs.next()){
				
				
			count=rs.getInt(1);
				
			}
			
			
		
		} catch (Exception e) {
		
			System.out.println("getPaymentCount()메소드에서  오류발생"+e);
			
		}finally {
			
			resourceClose();
			
		}
		
		
		
		return count;
	}
	
	
	// 멤버십 만료 체크
	public String checkPayment(String mem_email){
		
		String check = "X";
		try {
			getConnection();
			sql = "select pm_check from payment where mem_email=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_email);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				check = rs.getString(1);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			resourceClose();
			
		}
		
		
		return check;
		
	}



	public int getMonthMoney() {
		int money=0;
		
		try {
			getConnection();
			
						sql= " select count(*)*7900 + e.pm2 "   
							+	" from payment i join (select count(*)*12900 pm2 " 
										+ " from payment "
										+ " where pm_name='무제한 이용권 (90일)' " 
										+" and pm_start_date BETWEEN  DATE_ADD(NOW(),INTERVAL -DATE_FORMAT(now(), '%d')- "
			+ "								date_format( (DATE_ADD(NOW(),INTERVAL - DATE_FORMAT(now(), '%d') day) ),'%d')+1 day) " 
														+	" AND DATE_ADD(NOW(),INTERVAL -DATE_FORMAT(now(), '%d') day) ) e  "  
			+" where i.pm_name='무제한 이용권 (30일)'"
			+" and i.pm_start_date between DATE_ADD( NOW(),INTERVAL -DATE_FORMAT(now(), '%d') - "
			+ "								date_format( (DATE_ADD(NOW(),INTERVAL - DATE_FORMAT(now(), '%d') day) ),'%d')+1 day) "
								+" and DATE_ADD(NOW(),INTERVAL -DATE_FORMAT(now(), '%d') day) ";
			
			
			pstmt=con.prepareStatement(sql);			
				
		rs=pstmt.executeQuery();
			
		if(rs.next()){
			
			money=rs.getInt(1);
			
		}
		
		} catch (Exception e) {
			System.out.println("getMonthMoney()메서드에서 오류 "+e);
		}finally {
			
			resourceClose();
			
		}
		
		
		
		return money;
	}

	
	
	
	
	
	
	
	
	
	
}
