package kr.co.lms.admin.DAO;

import java.util.List;

import kr.co.lms.admin.VO.AdminStudentPagingVO;
import kr.co.lms.admin.VO.CancelRegisterVO;

public interface CancelRegisterDAOImp {
	//��ҿ�û ����Ʈ
	public List<CancelRegisterVO> cancelSelectAll(AdminStudentPagingVO PageVO);
	//��ҿ�û ����Ʈ ����
	public int getCancelSelectAll(AdminStudentPagingVO PageVO);
	//��� ��û �Ѱ� ����
	public CancelRegisterVO selectCancelRecord(int student_no, int payment_no);
	//��ȭ���� ����
	public CancelRegisterVO selectRefundRecord(int student_no, int payment_no);
	//��ȯ�����߰�
	public int CancelRecordInsert(CancelRegisterVO vo);
	//�������� ����
	public CancelRegisterVO selectPaymentRecord(int student_no, int payment_no);
	//�������� ������Ʈ
	public int updatePaymentRecord(CancelRegisterVO vo);
	//��ȯ���� ����
	public CancelRegisterVO selectReturnRecord(int student_no);
	//��ȯ���� ������Ʈ
	public int updateReturnRecord(int student_no);
	//�������� ����
	public int deleteReceiveRecord(int student_no, int payment_no);
	//��ȯ���� ����
	public int deleteReturnRecord(int student_no, int payment_no);
}
