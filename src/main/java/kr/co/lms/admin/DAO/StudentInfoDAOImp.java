package kr.co.lms.admin.DAO;

import java.util.List;

import kr.co.lms.admin.VO.AdminStudentPagingVO;
import kr.co.lms.admin.VO.StudentAttendanceVO;
import kr.co.lms.admin.VO.StudentClassInfoVO;
import kr.co.lms.admin.VO.StudentCounselingVO;
import kr.co.lms.admin.VO.StudentInfoVO;
import kr.co.lms.admin.VO.StudentPaymentInfoVO;

public interface StudentInfoDAOImp {
	//�л� ��ü ����Ʈ
	public List<StudentInfoVO> studentSelectAll(AdminStudentPagingVO PageVO);
	//�л� ��ü ��
	public int getStudentSelectAll(AdminStudentPagingVO PageVO);
	//�л� ���
	public int memberInsert(StudentInfoVO vo);
	//�л� ������
	public StudentInfoVO studentSelectDetail(int student_no);
	//�л� ������ ����
	public int studentInfoUpdate(StudentInfoVO vo);
	//�л� ������Ȳ
	public List<StudentPaymentInfoVO> studentPaymentInfo(int student_no);
	//�л� ��� ����Ʈ
	public List<StudentCounselingVO> studentCounselingList(int student_no);
	//�л� ��� ���� �߰�
	public int studentCounselingInsert(StudentCounselingVO vo);
	//�л� ��� ���� ����
	public int studentCounselingDelete(int student_no, int counseling_no);
	//�л� ��� ���� ����
	public int studentCounselingUpdate(StudentCounselingVO vo);
	//�л� ����
	public int memberDel(int student_no);
	//�ݹ��� ��Ȳ ����Ʈ
	public List<StudentClassInfoVO> studentClassInfoSelect(int student_no);
	//�ݹ��� ����
	public int studentClassMove(StudentClassInfoVO vo);
	//�޿� ��� ����
	public int studentClosedOutEditOk(StudentClassInfoVO vo);
	//�޿� ��� ����
	public int closedOutOk(StudentClassInfoVO vo);
	//�л� ��� ���
	public List<StudentAttendanceVO> studentAttendace(int student_no);
	//�л� ��� ����Ʈ
	public List<StudentAttendanceVO> studentAttendaceList(int payment_no);
	//�л� Ŭ���� ����
	public int classRecordDel(int payment_no, int student_no);
}
