package kr.co.lms.admin.DAO;

import java.util.List;

import kr.co.lms.admin.VO.AdminStudentPagingVO;
import kr.co.lms.admin.VO.LeaveOfAbsenceVO;

public interface LeaveOfAbsenceDAOImp {
	//���л� ����Ʈ
	public List<LeaveOfAbsenceVO> selectLeaveOfAbsence(AdminStudentPagingVO PageVO);
	//���л� ��ü ��
	public int getSelectLeaveOfAbsence(AdminStudentPagingVO PageVO);
}
