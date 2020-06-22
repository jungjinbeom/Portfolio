package kr.co.lms.news;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.lms.main.DAO.NewsDAOImp;
import kr.co.lms.main.VO.CourseVO;
import kr.co.lms.main.VO.NewsVO;
import kr.co.lms.main.VO.PagingVO;

@Controller
public class NewsController {
	SqlSession sqlSession;
	
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@RequestMapping(value="/event", method=RequestMethod.GET)
	public ModelAndView event(NewsVO vo ,HttpServletRequest req){//�̺�Ʈ �Խù�
		PagingVO pvo = new PagingVO();
		//���������� ������ �Խù� ���� ����
		pvo.setOnePageRecord(5);
		//��ü������ �� ���ϱ� 
		
		ModelAndView mav = new ModelAndView();
		NewsDAOImp dao = sqlSession.getMapper(NewsDAOImp.class);
		pvo.setTotalRecord(dao.getTotalRecord());
		String str = req.getParameter("pageNum");
		if(str != null) {
			pvo.setPageNum(Integer.parseInt(str));
		}else {
			pvo.setPageNum(1);
		}
		System.out.println("=============================");
		System.out.println("�̺�Ʈ ������ �۾�");
		System.out.println("�������� �����ֱ�"+pvo.getOnePageRecord());
		System.out.println("���� ������"+pvo.getPageNum());
		System.out.println("�� ������"+pvo.getTotalPage());
		System.out.println("�� ���ڵ�"+pvo.getTotalRecord());
		System.out.println("������ ������ ��ȣ"+pvo.getLastPageRecord());
		System.out.println("=============================");
		
		//��Ʈ ������ �۾�.
		pvo.setTotalRecord(dao.getTotalRecord());
		
		if((pvo.getPageNum() < pvo.getTotalPage())) { //���� ��������ȣ�� ������������ ��ȣ���� ���� ��
			pvo.setLastPageRecord(pvo.getOnePageRecord());
		} 
		List<NewsVO> eventsList = dao.eventsAllSelectRecord(pvo);
		mav.addObject("pvo",pvo);
		mav.addObject("event_list",eventsList);
		mav.setViewName("main/news/event");
		return mav;
	}
	
	@RequestMapping(value="/news", method=RequestMethod.GET)
	public ModelAndView news(NewsVO vo ,HttpServletRequest req){//�������� �Խù�
		ModelAndView mav = new ModelAndView();
		PagingVO pvo = new PagingVO();
		//���������� ������ �Խù��� ���� ����
		pvo.setOnePageRecord(5);
		//��ü �������� ���� ���ϰ�
		NewsDAOImp dao = sqlSession.getMapper(NewsDAOImp.class);
		pvo.setTotalRecord(dao.getTotalRecord());
		
		String str = req.getParameter("pageNum");
		 
		if(str != null) {
			pvo.setPageNum(Integer.parseInt(str));
		}else {
			pvo.setPageNum(1);
		}
 
		System.out.println("=============================");
		System.out.println("���� ������ �۾�");
		System.out.println("�������� �����ֱ�"+pvo.getOnePageRecord());
		System.out.println("���� ������"+pvo.getPageNum());
		System.out.println("�� ������"+pvo.getTotalPage());
		System.out.println("�� ���ڵ�"+pvo.getTotalRecord());
		System.out.println("������ ������ ��ȣ"+pvo.getLastPageRecord());
		System.out.println("=============================");
		
		//��Ʈ ������ �۾�.
		pvo.setTotalRecord(dao.getTotalRecord());
		
		if((pvo.getPageNum() < pvo.getTotalPage())) { //���� ��������ȣ�� ������������ ��ȣ���� ���� ��
			pvo.setLastPageRecord(pvo.getOnePageRecord());
		} 
		
		List<NewsVO> newsList = dao.newsAllSelectRecord(pvo);
		mav.addObject("pvo",pvo);
		mav.addObject("notice_list", newsList); 
		mav.setViewName("main/news/news");
		return mav;
	}
	
	@RequestMapping(value="/noticeForm", method=RequestMethod.GET)
	public ModelAndView noticeForm(int no ,HttpServletRequest req){//�������� �Խù� ����
		ModelAndView mav = new ModelAndView();
		NewsDAOImp dao = sqlSession.getMapper(NewsDAOImp.class);
		mav.addObject("vo",dao.newsSelectRecord(no));
		mav.setViewName("main/news/noticeForm");
		return mav;
	}
	
	@RequestMapping(value="/eventForm", method=RequestMethod.GET)
	public ModelAndView eventForm(int no ,HttpServletRequest req){//�̺�Ʈ �Խù� ����
		ModelAndView mav = new ModelAndView();
		NewsDAOImp dao = sqlSession.getMapper(NewsDAOImp.class);
		mav.addObject("vo",dao.eventsSelectRecord(no));
		mav.setViewName("main/news/eventForm");
		return mav;
	}
}