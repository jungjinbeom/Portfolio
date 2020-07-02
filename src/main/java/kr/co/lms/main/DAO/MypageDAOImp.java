package kr.co.lms.main.DAO;

import java.util.List;
import kr.co.lms.main.VO.MypageVO;
import kr.co.lms.main.VO.WishListVO;

public interface MypageDAOImp {
	//�������� ���� ��� ��������
	public List<MypageVO> courseRecord(int no);
	//������ ���� ��� ��������
	public List<MypageVO> completionCourseRecord(int no);
	//�̼����� ���� ��� �������� 
	public List<MypageVO> inCompleteCourseRecord(int no);
	//���������������� �л������� ���� ���� ��������
	public MypageVO memberMypageDetailInfo(int no);
	//���ø���Ʈ ���� ��������
	public List<WishListVO> wishListRecord(WishListVO wVO);
	//��ϳ�¥ ����
	public void updateSysdate();
	//��¥���� 
	public MypageVO courseProgess(int no);
}
