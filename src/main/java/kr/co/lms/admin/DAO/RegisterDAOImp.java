package kr.co.lms.admin.DAO;

import java.util.List;

import kr.co.lms.admin.VO.AdminStudentPagingVO;
import kr.co.lms.admin.VO.RegisterVO;
import kr.co.lms.admin.VO.StudentByCourseVO;

public interface RegisterDAOImp {
	//������Ȳ ����Ʈ
	public List<RegisterVO> selectAll(AdminStudentPagingVO PageVO);
	//������Ȳ ����Ʈ ����
	public int getSelectAll(AdminStudentPagingVO PageVO);
}
