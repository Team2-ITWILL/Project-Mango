package mango.academy_files.db;

import java.time.LocalDate;

public class AcademyFilesBean {
	
	// 파일 고유번호
	private int file_no;
	
	// 학원 지정번호
	private int aca_main_num;
	
	// 원본 파일이름
	private String org_file_name;
	
	// 서버에 저장된 파일이름
	private String stored_file_name;
	
	// 파일 크기
	private int file_size;
	
	// 업로드된 날짜
	private LocalDate regdate;
	
	// 삭제 구분(1,0)
	private int del_diff;
	
	
	//============Constructors====================
	public AcademyFilesBean(){ }
	public AcademyFilesBean(int file_no, int aca_main_num, String org_file_name, String stored_file_name, int file_size,
			LocalDate regdate, int del_diff) {
		super();
		this.file_no = file_no;
		this.aca_main_num = aca_main_num;
		this.org_file_name = org_file_name;
		this.stored_file_name = stored_file_name;
		this.file_size = file_size;
		this.regdate = regdate;
		this.del_diff = del_diff;
	}

	//==========GETTER/SETTER==========
	public int getFile_no() {
		return file_no;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	public int getAca_main_num() {
		return aca_main_num;
	}

	public void setAca_main_num(int aca_main_num) {
		this.aca_main_num = aca_main_num;
	}

	public String getOrg_file_name() {
		return org_file_name;
	}

	public void setOrg_file_name(String org_file_name) {
		this.org_file_name = org_file_name;
	}

	public String getStored_file_name() {
		return stored_file_name;
	}

	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}

	public int getFile_size() {
		return file_size;
	}

	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}

	public LocalDate getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDate regdate) {
		this.regdate = regdate;
	}

	public int getDel_diff() {
		return del_diff;
	}

	public void setDel_diff(int del_diff) {
		this.del_diff = del_diff;
	}

	@Override
	public String toString() {
		return "AcademyFilesBean [file_no=" + file_no + ", aca_main_num=" + aca_main_num + ", org_file_name="
				+ org_file_name + ", stored_file_name=" + stored_file_name + ", file_size=" + file_size + ", regdate="
				+ regdate + ", del_diff=" + del_diff + "]";
	}
	
	
	
	
}
