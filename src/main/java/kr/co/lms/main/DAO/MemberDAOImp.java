package kr.co.lms.main.DAO;

import kr.co.lms.main.VO.MemberVO;

public interface MemberDAOImp {
	//ȸ������
	public int memberRegister(MemberVO vo);
	//���̵� �ߺ�üũ
	public int idCheck(String userid);
	//�α���
	public MemberVO memberLogin(MemberVO vo);
	//���� ���̵� ã��
	public String memberIdFind(MemberVO vo);
	//���� ��й�ȣ ã��
	public String memberPwFind(MemberVO vo);
	//���� ���� ����
	public int memberDataUpdate(MemberVO vo);
	//���������� ���� �������� 
	public MemberVO memberPaymentRecord(MemberVO vo2);
	//�������� �� �̸��� �ڱ�Ұ�
	public MemberVO  memberDataSelect(MemberVO vo);
	//������ �̹��� ������Ʈ
	public int memberImgDataSelect(MemberVO vo); 
	//������ ��й�ȣ ����
	public int memberPasswordDataSelect(MemberVO vo);
	//�̸��� �ߺ�üũ
	public int emailCheck(String student_email);
}
