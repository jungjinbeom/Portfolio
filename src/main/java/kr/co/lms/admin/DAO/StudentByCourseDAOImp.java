package kr.co.lms.admin.DAO;

import java.util.List;

import kr.co.lms.admin.VO.AdminStudentPagingVO;
import kr.co.lms.admin.VO.StudentByCourseVO;

public interface StudentByCourseDAOImp {
	//���º� ������ ����Ʈ
	public List<StudentByCourseVO> selectStudentByCourse(AdminStudentPagingVO PageVO); 
	//���º� ������ ��
	public int getSelectStudentByCourse(AdminStudentPagingVO PageVO);
	//���� ����
	public StudentByCourseVO selectCourseInfo(int course_no);
	//���º� ���� �л�
	public List<StudentByCourseVO> selectCourseByStudent(int course_no);
	//������ �� �̵�
	public int studentClassUpdate(StudentByCourseVO vo);
	//���̵� �Ǵ� ����� ó���ϴ� �л��� �̸����ϱ�
	public StudentByCourseVO selectStudentName(int student_no);
	//����� ó��
	public int studentLeaveOutUpdate(StudentByCourseVO vo);
}
