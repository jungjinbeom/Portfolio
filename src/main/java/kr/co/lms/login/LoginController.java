package kr.co.lms.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import kr.co.lms.main.DAO.MemberDAOImp;
import kr.co.lms.main.VO.MemberVO;

@Controller
public class LoginController {
	SqlSession sqlsession;

	public SqlSession getSqlsession() {
		return sqlsession;
	}
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	@Autowired
	PasswordEncoder pwEncoder;
	
	@RequestMapping(value="/loginOk",method=RequestMethod.POST)
	public ModelAndView login(MemberVO vo , HttpServletRequest req) {
		MemberDAOImp dao = sqlsession.getMapper(MemberDAOImp.class);
		MemberVO loginVO = dao.memberLogin(vo);
		//�н����� ��
		boolean pwMatch = pwEncoder.matches(vo.getStudent_pw(), loginVO.getStudent_pw());
		ModelAndView mav = new ModelAndView();
		if(loginVO!=null && pwMatch == true) {
			HttpSession s = req.getSession();
			s.setAttribute("username", loginVO.getStudent_name_ko());
			s.setAttribute("student_no", loginVO.getStudent_no());
			s.setAttribute("student_id", loginVO.getStudent_id());
			s.setAttribute("logStatus","Y");
			mav.addObject("response", "�α��� �Ǿ����ϴ�. ȯ���մϴ�!");
		}else {
			mav.addObject("response", "���̵� �Ǵ� �н����尡 �ùٸ��� �ʽ��ϴ�.");
		}
		mav.setViewName("main/login/loginRedirect");
		return mav;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) {
		new SecurityContextLogoutHandler().logout(req, res, null);
		ModelAndView mav = new ModelAndView();
		mav.addObject("response", "�α׾ƿ� �Ǿ����ϴ�.");
		
		mav.setViewName("main/login/loginRedirect");
		return mav;
	}
	
}
