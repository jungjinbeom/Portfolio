package kr.co.lms.main.VO;

public class NewsVO {
	private int admin_notice_no;
	private int employee_no;
	private int admin_category;
	private String admin_notice_title;
	private String admin_notice_img;
	
	public int getAdmin_notice_no() {
		return admin_notice_no;
	}
	public void setAdmin_notice_no(int admin_notice_no) {
		this.admin_notice_no = admin_notice_no;
	}
	public int getEmployee_no() {
		return employee_no;
	}
	public void setEmployee_no(int employee_no) {
		this.employee_no = employee_no;
	}
	public int getAdmin_category() {
		return admin_category;
	}
	public void setAdmin_category(int admin_category) {
		this.admin_category = admin_category;
	}
	public String getAdmin_notice_title() {
		return admin_notice_title;
	}
	public void setAdmin_notice_title(String admin_notice_title) {
		this.admin_notice_title = admin_notice_title;
	}
	public String getAdmin_notice_img() {
		return admin_notice_img;
	}
	public void setAdmin_notice_img(String admin_notice_img) {
		this.admin_notice_img = admin_notice_img;
	}
}
