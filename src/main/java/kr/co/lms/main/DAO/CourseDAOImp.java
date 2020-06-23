package kr.co.lms.main.DAO;

import java.util.List;

import kr.co.lms.main.VO.CourseReviewVO;
import kr.co.lms.main.VO.CourseVO;
import kr.co.lms.main.VO.PagingVO;

public interface CourseDAOImp {
	//���¸���Ʈ
	public List<CourseVO> courseList(PagingVO pvo);
	//���¼���
	public CourseVO selectCourse(int course_no);
	//���°���
	public int getTotalCoureses(String search_text);
	//���Ź�ȣ ����
	public int selectPaymentNo(int course_no, int student_no);
	//�����ı� ����Ʈ
	public List<CourseReviewVO> reviewList(PagingVO rpvo);
	//�����ı� ����
	public int getTotalReviews(int course_no);
	//�����ı� ���
	public int insertReview(CourseReviewVO vo);
	//�����ı� ����
	public int updateReview(CourseReviewVO vo);
	//�����ı� ����
	public int deleteReview(int review_no);
	//���ø���Ʈ �߰�
	public int insertWish();
	//���ø���Ʈ ����
	public int deleteWish();
	
}
