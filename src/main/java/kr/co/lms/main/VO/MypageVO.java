package kr.co.lms.main.VO;

public class MypageVO {
	private String Student_no;//��ϵ��л���ȣ 
	private String employee_name;//�����
	private String course_name;//���¸�
	private String course_start_date;//������
	private String course_end_date;//������
	private String passingGrade;//�ۼ�Ʈ��
	private String grade;//����
	private String rank;//����
	private String state;//�������
	
	
	public String getStudent_no() {
		return Student_no;
	}
	public void setStudent_no(String student_no) {
		Student_no = student_no;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	
	public String getCourse_start_date() {
		return course_start_date;
	}
	public void setCourse_start_date(String course_start_date) {
		this.course_start_date = course_start_date;
	}
	
	public String getCourse_end_date() {
		return course_end_date;
	}
	public void setCourse_end_date(String course_end_date) {
		this.course_end_date = course_end_date;
	}
	public String getPassingGrade() {
		return passingGrade;
	}
	public void setPassingGrade(String passingGrade) {
		this.passingGrade = passingGrade;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

	
	
	
	
	
}
