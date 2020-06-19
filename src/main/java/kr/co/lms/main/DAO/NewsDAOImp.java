package kr.co.lms.main.DAO;

import java.util.List;

import kr.co.lms.main.VO.NewsVO;

public interface NewsDAOImp {
	//�������� �Խ��� ����Ʈ ��������
	public List<NewsVO> newsAllSelectRecord(NewsVO vo);
	//�������� �� ��������
	public NewsVO newsSelectRecord(int no);
	//�̺�Ʈ �Խ��� ����Ʈ �������� 
	public List<NewsVO> eventsAllSelectRecord(NewsVO vo);
	//�̺�Ʈ �� �������� 
	public NewsVO eventsSelectRecord(int no);
	//����¡ �����������̺� �ִ� �Խù� ���� �������� 
	public int getTotalRecord();

}
