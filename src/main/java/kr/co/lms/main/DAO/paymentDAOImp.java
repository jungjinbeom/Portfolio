package kr.co.lms.main.DAO;

import kr.co.lms.main.VO.paymentVO;

public interface paymentDAOImp {
	//�������� ��� 
	public void paymentInfoInsert(paymentVO vo);
	//������ȣ �������� 
	public int paymentNumberRecord(paymentVO vo);
	//�������� ���� �������� 
	public paymentVO paymentInfoRecord(paymentVO vo);
}
