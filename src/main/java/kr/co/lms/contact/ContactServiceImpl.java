package kr.co.lms.contact;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kr.co.lms.main.DAO.ContactDAOImp;
import kr.co.lms.main.VO.ContactVO;

@Service
public class ContactServiceImpl implements ContactDAOImp {
	
	@Inject
	JavaMailSender mailSender;
	
	@Override
	public void sendContactMail(ContactVO vo) {
		try {
			MimeMessage msg = mailSender.createMimeMessage(); //�̸��ϰ�ü
			
			//������
			msg.addRecipient(RecipientType.TO, new InternetAddress());
			
			//�߽���(�̸����ּ�+�̸�)
			msg.addFrom(new InternetAddress[] {new InternetAddress()});
			
			//�̸��� ����
			msg.setSubject(vo.getContact_name()+"�����κ��� ���ο� ���ǰ� ���ŵǾ����ϴ�.", "utf-8");
			//�̸��� ����
			msg.setText(vo.getContact_content());
			mailSender.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
