package kr.co.lms.main.DAO;

import java.util.List;
import kr.co.lms.main.VO.MypageVO;

public interface MypageDAOImp {
	//�������� ���� ��� ��������
	public List<MypageVO> courseRecord();
	//������ ���� ��� ��������
	public List<MypageVO> completionCourseRecord();
	//�̼����� ���� ��� �������� 
	public List<MypageVO> inCompleteCourseRecord();
	
}
