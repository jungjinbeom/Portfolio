package kr.co.lms.contact;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.lms.main.DAO.ContactDAOImp;
import kr.co.lms.main.VO.ContactVO;

import kr.co.lms.VerifyRecaptcha;

@Controller
public class ContactController {
	SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/contact");
		return mav;
	}
	
	@Inject
	JavaMailSender mailSender;
	
	@RequestMapping(value = "/sendContactForm", method = RequestMethod.POST)
	@ResponseBody
	public int sendContactForm(ContactVO vo, HttpServletRequest req) {
		String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
		System.out.println(req.getParameter("g-recaptcha-response"));
		ContactDAOImp dao = sqlSession.getMapper(ContactDAOImp.class);
		int cnt;
		int res;
		try {
			//����ĸ������
			if(VerifyRecaptcha.verify(gRecaptchaResponse)) {
				MimeMessage msg = mailSender.createMimeMessage(); //�̸��ϰ�ü
				MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
				String contactContent = "����: " + vo.getContact_name() + "\r\n"
						+ "�̸���: " + vo.getContact_email() + "\r\n"
						+ "����ó: " + vo.getContact_tel() + "\r\n"
						+ "���ǳ���: " + vo.getContact_content();
				//������
				helper.setTo(new InternetAddress("fezze779@gmail.com"));
				//�߽���(�̸����ּ�+�̸�)
				helper.setFrom(new InternetAddress("fezze779@gmail.com", "Educamp"));
				
				//�̸��� ����
				helper.setSubject(vo.getContact_name()+"�����κ��� ���ο� ���ǰ� ���ŵǾ����ϴ�.");
				//�̸��� ����
				helper.setText(contactContent);
				
				mailSender.send(msg); //���Ϻ�����
				cnt = dao.insertContact(vo); //�����ͺ��̽� ó��
				System.out.println(cnt);
				if(cnt>0) {
					res = 1;
				}
				else {
					res = 0;
				}
			}
			else {
				res = -1; //ĸ������ �ȵ�
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			res = 0;
		}
		
		return res;
	}
}
