package kr.co.lms.main.DAO;

import java.util.List;

import kr.co.lms.main.VO.CourseVO;
import kr.co.lms.main.VO.MypageVO;

public interface MypageDAOImp {
	//�������� ���� ��� ��������
	public List<MypageVO> courseRecord(int no);
	//������ ���� ��� ��������
	public List<MypageVO> completionCourseRecord(int no);
	//�̼����� ���� ��� �������� 
	public List<MypageVO> inCompleteCourseRecord(int no);
	//�ð�ǥ
	public List<CourseVO> selectTimeTable(int student_no);
}
