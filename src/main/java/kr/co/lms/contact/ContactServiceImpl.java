package kr.co.lms.contact;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import kr.co.lms.main.VO.ContactVO;

@Service
public class ContactServiceImpl implements ContactEmailService {
	
	@Inject
	JavaMailSender mailSender;
	
	@Override
	public void sendContactMail(ContactVO vo) {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
