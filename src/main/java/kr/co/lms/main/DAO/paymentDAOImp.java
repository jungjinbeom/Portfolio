package kr.co.lms.main.DAO;

import java.util.List;

import kr.co.lms.main.VO.paymentVO;

public interface paymentDAOImp {
	//�������� ��� 
	public void paymentInfoInsert(paymentVO vo);
	//���ݰ��� ����
	public void paymentCashInsert(paymentVO vo);
	//������ȣ �������� 
	public Integer paymentNumberRecord(paymentVO vo);
	//�������� ���� �������� 
	public paymentVO paymentInfoRecord(paymentVO vo);
	//�������� �������� 
	public List<paymentVO> paymentHistoryRecord(paymentVO vo);
	//�������� �������� �������� 
	public paymentVO paymentDetailRecord(paymentVO vo);
}
