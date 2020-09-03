package mango.academy_files.db;

import java.util.ArrayList;
import java.util.List;

import mango.academy.db.AcademyBean;
import mango.connection.db.DBconnection;

public class AcademyFilesDAO extends DBconnection{
	
	public int UploadToDB(AcademyFilesBean bean){
			
		int result = 0;
		try {
			getConnection();
			
			String sql = "insert into academy_files "
					+ "values(null,?,?,?,?,curdate(),?)";
			pstmt = con.prepareStatement(sql);
			
			System.out.println(bean.toString());			
			
			//file_no : auto-increment
			pstmt.setInt(1, bean.getAca_main_num());
			pstmt.setString(2, bean.getOrg_file_name());
			pstmt.setString(3, bean.getStored_file_name());
			pstmt.setInt(4, bean.getFile_size());
			
			//등록날짜 : curdate()
			//pstmt.setDate(5, java.sql.Date.valueOf(bean.getRegdate()));
			
			pstmt.setInt(5, bean.getDel_diff());		
			
			result = pstmt.executeUpdate();		
			
		} catch (Exception e) {
			System.out.println("UploadToDB()에서 예외 발생");
			e.printStackTrace();
		}finally{
			resourceClose();
		}		
		return result;
	}
	
	// 학원별 등록된 파일리스트 가져오기	
	public List<AcademyFilesBean> getFilesByAcanum(int acaMainNum) {
		
		List<AcademyFilesBean> list = new ArrayList<AcademyFilesBean>();
			
		try {
			getConnection();
			sql = "select * from academy_files where aca_main_num=?";			
			pstmt = con.prepareStatement(sql);			
			pstmt.setInt(1, acaMainNum);			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				AcademyFilesBean bean = new AcademyFilesBean
					(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),							
						rs.getDate(6).toLocalDate(),
						rs.getInt(7)					
					);		
				
				list.add(bean);				
			}
		} catch (Exception e) {
			System.out.println("getFilesByAcanum()에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}
		
		return list;
	}

}
