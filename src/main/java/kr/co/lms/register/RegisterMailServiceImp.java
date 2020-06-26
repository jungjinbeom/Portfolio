package kr.co.lms.register;

import javax.inject.Inject;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service
public class RegisterMailServiceImp implements RegisterMailService {
	@Inject
	JavaMailSender mailSender;

	
	@Override
	public void sendRegisterMail(String usermail,String sesId) {
		
		try {
			
			MimeMessage msg = mailSender.createMimeMessage(); //�̸��ϰ�ü
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
			
			String contactContent = "EduCamp ȸ�����Կ� �ʿ��� �����ڵ� ���� �Դϴ�.\n";
				   contactContent+="�����ڵ�:"+sesId;
			helper.setTo(new InternetAddress(usermail));
			helper.setFrom(new InternetAddress("fezze779@gmail.com", "Educamp"));
			
			//�̸��� ����
			helper.setSubject("EduCamp ȸ�����Կ� �ʿ��� �����ڵ� ���� �Դϴ�.");
			//�̸��� ����
			helper.setText(contactContent);
			
			mailSender.send(msg); //���Ϻ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}