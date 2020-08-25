
package mango.payment.db;

import org.json.simple.JSONArray;

public interface IPayMent {

	
											//몇일인지
	public int InsertPayment(PaymentBean pb,int Day);
	
	// 가장 최근 사용 이용권을 오는 메서드
	public PaymentBean getNewPayment(PaymentBean pb); 

	
	//자신의 사용권리스트를 갖고오는
	public JSONArray getListMyPayMent(PaymentBean mypay);
}

