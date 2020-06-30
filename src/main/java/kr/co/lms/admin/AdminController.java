package kr.co.lms.admin;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

import kr.co.lms.admin.DAO.AdminRegiInterface;
import kr.co.lms.admin.VO.AdminCourseVO;
import kr.co.lms.admin.VO.AdminManageInfoVO;
import kr.co.lms.admin.VO.AdminNoticeVO;
import kr.co.lms.admin.VO.AdminRegiVO;
import kr.co.lms.admin.VO.AdminStudentPagingVO;
import kr.co.lms.admin.VO.AdminTeacherVO;

@Controller
public class AdminController {

//-------------------------------------------------------------
	SqlSession sqlSession;
	

	public SqlSession getSqlSession() {
		return sqlSession;
	}
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
//-------------------------------------------------------------
	//�α���â
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin() {
		
		return "adminStart/adminLogin";
	}
	//������ �� ���� �α���
	@RequestMapping(value="/adminStart/adminLoginOk", method=RequestMethod.POST)
	public ModelAndView adminLoginOk(AdminRegiVO vo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);	
		AdminRegiVO resultVo = adminRegiInter.selectAdminId(vo); 
		
		if(resultVo != null) {  
			HttpSession sess = request.getSession();
			
			sess.setAttribute("employee_name", resultVo.getEmployee_name());
			sess.setAttribute("admin_id", resultVo.getAdmin_id());	
		 
			mav.setViewName("redirect:/admin/adminMain"); 
		}else {
			mav.setViewName("redirect:/admin");  
		} 
		
		return mav;
	}
	//ȸ������â
	@RequestMapping(value="/adminStart/adminJoin", method=RequestMethod.GET)
	public String adminJoin() {
		return "adminStart/adminJoin";
	}
	 //������ �� ���� ȸ������.
	@RequestMapping(value="/adminStart/adminJoinOk", method=RequestMethod.POST)
	public ModelAndView adminJoinOk(AdminRegiVO vo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		//���̵� �ߺ� üũ
		AdminRegiInterface checkId = sqlSession.getMapper(AdminRegiInterface.class);
		
		AdminRegiVO resultVo = checkId.selectAdminIdCheck(vo);
		 
		if(resultVo == null) { 
			//���̵� ���
			AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
			int insertResult = adminRegiInter.insertAdminID(vo);
			
			if(insertResult > 0) {
				mav.addObject("overlap", "N");
				mav.setViewName("redirect:/admin");
			}else {
				mav.setViewName("redirect:adminStart/adminJoin");
			}
		}else {
			String str = "Y";
			System.out.println("1�� : �ߺ�����");
			mav.addObject("overlap", str);   
			mav.setViewName("/adminStart/adminJoin");
		}
		return mav;
	}
	//�α׾ƿ�
	@RequestMapping(value="/adminStart/adminLogout", method=RequestMethod.GET)
	public String adminLogout(HttpServletRequest request) {
		
		HttpSession sess = request.getSession();
		
		sess.invalidate();
		
		return "adminStart/adminLogin";
	}
//======================================================================================
	//�������� ��� ��Ʈ
	
		//�������� ����(����Ʈ)�� �̵�. 
	@RequestMapping(value="/admin/adminManagementInfo", method= {RequestMethod.GET,RequestMethod.POST}, produces = "application/text; charset=UTF-8")
	public ModelAndView adminManagementInfo(AdminManageInfoVO vo, AdminStudentPagingVO pVo, HttpServletRequest request) { 
		ModelAndView mav = new ModelAndView();
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		
		int 	selectNo 	  = 0;
		String  selectSubject = "::����::";
		int		selectOk 	  = vo.getAdmin_manageinfo_ok();
		  
		
		if(vo.getAdmin_manageinfo_subject() == null) { 
			selectSubject = "::����::";
			System.out.println(selectSubject + "::::selectSubject");
			pVo.setSearchKey_02(selectSubject);  
		} 
		if(vo.getEmployee_no() == -1) {
			selectNo = -1; 
			pVo.setSearchKey_01(selectNo);
		}
		 
		if(vo.getEmployee_no() != -1) { 
			selectNo = vo.getEmployee_no();
			pVo.setSearchKey_01(selectNo);
		}
			
		if(vo.getAdmin_manageinfo_subject() != null) {
			selectSubject =  vo.getAdmin_manageinfo_subject();	
			pVo.setSearchKey_02(selectSubject);  
		}
		
		pVo.setSearchKey_03(vo.getAdmin_manageinfo_ok());
		
		//������ ����.
		int result_totalPage = adminRegiInter.selectTotalRecordManageInfo();
		
		//���� �̸� ���� �̾ƿ���.
		List<AdminManageInfoVO> nameList = adminRegiInter.selectManageInfoName();
		
		//���������� ���̴� ���� Ȯ��.
		pVo.setOnePageRecord(5);
		//��Ż ���ڵ� Ȯ��.
		pVo.setTotalRecord(result_totalPage);
		
		List<AdminManageInfoVO> resultList = adminRegiInter.selectManageInfo(pVo);		
	 	
		mav.addObject("selectNo", selectNo);
		mav.addObject("selectOk", selectOk);
		mav.addObject("selectSubject", selectSubject);
	
		mav.addObject("nameList", nameList);
		mav.addObject("pageVo", pVo);
		mav.addObject("resultList", resultList);
		
		mav.setViewName("/admin/adminManagementInfo"); 
 
		return mav;
	}
		//�������� �������� ��.
	@RequestMapping("/admin/adminManageView")
	public ModelAndView adminManageView(AdminManageInfoVO vo) {
		ModelAndView mav = new ModelAndView();
		
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		AdminManageInfoVO result_Vo = adminRegiInter.selectOneRecord(vo.getAdmin_manageinfo_no()); 
		
		mav.addObject("result_Vo", result_Vo);
		mav.setViewName("/admin/adminManageView");  
		
		return mav;
	}
		//�������� ����ϴ� ������ �̵�.
	@RequestMapping("/admin/adminManageRegi")
	public String adminManageRegi(){
		
		return "admin/adminManageRegi";
	}

		//�������� ���OK
	@RequestMapping(value="/admin/adminMangeRegiOk", method=RequestMethod.POST)
	public ModelAndView adminManageRegiOk(AdminManageInfoVO vo, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		
		HttpSession sess = request.getSession();
		
		String admin_Id = (String)sess.getAttribute("admin_id");
		System.out.println("id" + admin_Id);
		
		AdminManageInfoVO tempVo = adminRegiInter.selectManageinfoNameAndNo(admin_Id);

		vo.setEmployee_no(tempVo.getEmployee_no());
		vo.setEmployee_name(tempVo.getEmployee_name());

		int result_Int = adminRegiInter.insertAdminManageInfo(vo);
		
		if(result_Int > 0) {
			System.out.println("�������� ��� ����");
			mav.setViewName("redirect:/admin/adminManagementInfo");
		}else {
			System.out.println("�������� ��� ����");
			mav.setViewName("/admin/adminManagementInfo"); 
		}
		return mav;
	}
	
	//����������, ������ �ҷ�����.
	@RequestMapping(value="/admin/adminManageEdit", method= {RequestMethod.GET ,RequestMethod.POST})
	public ModelAndView adminMangeEdit(AdminManageInfoVO vo, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		AdminRegiInterface  adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		
		AdminManageInfoVO result_Vo = adminRegiInter.selectOneRecord(vo.getAdmin_manageinfo_no()); 
		
		mav.addObject("result_Vo", result_Vo);
		mav.setViewName("/admin/adminManageEdit");   
	
		return mav;
	}
	//�������� ����ok
	@RequestMapping(value="/admin/adminManageEditOk", method= RequestMethod.POST)
	public ModelAndView adminMangeEditOk(AdminManageInfoVO vo, HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			AdminRegiInterface  adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
			
			int result_Int = adminRegiInter.updateAdminManageInfo(vo);
			
			if(result_Int > 0) {
				mav.setViewName("redirect:/admin/adminManagementInfo"); 
			}else {
				mav.setViewName("redirect:/admin/adminManageEdit"); 
			}
		return mav;
	} 
	//�������� ����
	@RequestMapping(value="/admin/adminManagementInfoOk", method=RequestMethod.POST)
	public ModelAndView adminManageInfoOk(AdminManageInfoVO vo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		int result_Int = adminRegiInter.updateAdminManageInfoOk(vo);
		
		if(result_Int > 0) {
			mav.setViewName("redirect:/admin/adminManagementInfo");  
		}else {
			mav.setViewName("redirect:/admin/adminManageView");  
		}
		return mav;
	}
	
//-------------------------------------------------------------		
	
	//������ �������� �̺�Ʈ ����Ʈ �̱�.
	@RequestMapping("/admin/adminNotice")
	public ModelAndView adminNotice(AdminNoticeVO vo, AdminStudentPagingVO pVo, HttpServletRequest request) { 
		ModelAndView mav = new ModelAndView();
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		
		System.out.println("adminNotice ����" + pVo.getSearchKey());
		
		int result_totalPage = adminRegiInter.selectNoticeTotalRecord();
		int searchKeyInt = -1;
		
		if(pVo.getSearchKey() != null) {
			searchKeyInt = Integer.parseInt(pVo.getSearchKey()); 
		}
		
		//���������� ���̴� ���� Ȯ��.
		pVo.setOnePageRecord(5);
		//��Ż ���ڵ� Ȯ��.
		pVo.setTotalRecord(result_totalPage);
		
		List<AdminNoticeVO> result_List = adminRegiInter.selectNoticeAll(pVo);
		
		if(result_List != null) {
			mav.addObject("list", result_List);
			mav.addObject("pageVo", pVo);
			mav.addObject("searchKey", searchKeyInt); 
			mav.setViewName("/admin/adminNotice");
		}else {
			mav.setViewName("/admin/adminNotice");
		}
		return mav; 
	}

	@RequestMapping("/admin/adminNoticeWrite")
	public String adminNoticeWrite() {
		return "admin/adminNoticeWrite";
	}
	
	//�������� ���.
	@RequestMapping(value="/admin/adminNoticeWriteOk", method=RequestMethod.POST)
	public ModelAndView adminNoticeWriteOk(AdminNoticeVO vo, HttpServletRequest request) {
	
		ModelAndView mav = new ModelAndView();
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		
		HttpSession sess = request.getSession();
		
		String admin_Id		 = (String)sess.getAttribute("admin_id");
		String employee_Name = (String)sess.getAttribute("employee_name");
		//���÷��� �ѹ� ���ϱ�.
		int adminNo = adminRegiInter.selectEmployeeNo(admin_Id);
		
		vo.setEmployee_no(adminNo);

		int result_Int = adminRegiInter.insertNotice(vo); 
		
		if(result_Int>0) {
			mav.setViewName("redirect:/admin/adminNotice");
		}else {
			mav.setViewName("redirect:/admin/adminNotice");
		}

		
		return mav;
	}
	
	//�系���� ����
	@RequestMapping("/admin/adminNoticeView")
	public ModelAndView adminNoticeView(@RequestParam("admin_notice_no") int admin_notice_no, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		AdminNoticeVO result_Vo = adminRegiInter.selectNoticeOne(admin_notice_no);
				
		if(result_Vo != null){
			mav.addObject("list", result_Vo);
			mav.setViewName("admin/adminNoticeView");
		}else {
			mav.setViewName("admin/adminNoticeView");
		}
		return mav;
	}
	//�系���� �������� �̵��ϱ�.
	@RequestMapping("/admin/adminNoticeEdit")
	public ModelAndView adminNoticeEdit(@RequestParam("admin_notice_no") int admin_notice_no, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		 
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		
		AdminNoticeVO result_Vo = adminRegiInter.selectNoticeOne(admin_notice_no);

		if(result_Vo != null){ 
			mav.addObject("list", result_Vo);
			mav.setViewName("admin/adminNoticeEdit");
		}
		return mav; 
	}
	//���� ����.
	@RequestMapping(value="/admin/adminNoticeEditOk", method=RequestMethod.POST)
	public ModelAndView adminNoticeEditOk(AdminNoticeVO vo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
	

		int result_Int = adminRegiInter.updateNotice(vo); 
		if(result_Int > 0) {
			mav.setViewName("redirect:/admin/adminNotice"); 
		}else {
			mav.setViewName("redirect:/admin/adminNoticeEdit");
		}
		return mav;
	}

	@RequestMapping("/admin/adminNoticeDel")
	public String adminNoticeDel() {
		return "admin/adminNotice";
	}
//-------------------------------------------------------------	
		//���� ����Ʈ �Ѹ���
	@RequestMapping(value="/admin/adminTeacherList", method= RequestMethod.GET)
	public ModelAndView adminTeacherList(HttpServletRequest request, AdminTeacherVO vo, AdminStudentPagingVO pVo) {
		ModelAndView mav = new ModelAndView();
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
	
		pVo.setOnePageRecord(5);
		
		if(vo.getEmployee_class() == null) {
			vo.setEmployee_class("::Class::");
		} 
		if(vo.getEmployee_rank() == null) {
			vo.setEmployee_rank("::����::");
		}
		int result_Total = adminRegiInter.selectTeacherTotal();
		
		pVo.setTotalRecord(result_Total);
		pVo.setSearchKey(vo.getEmployee_class());
		pVo.setSearchWord(vo.getEmployee_rank());
		pVo.setSearchKey_02(vo.getEmployee_name());
		
		List<AdminTeacherVO> resultList = adminRegiInter.selectAdminAllRecord(pVo);
		
		if(resultList != null) {
			System.out.println("����");
			mav.addObject("pageVo", pVo); 
			mav.addObject("list", resultList); 
			mav.addObject("employee_rank", vo.getEmployee_rank());
			mav.addObject("employee_class",vo.getEmployee_class());

			mav.setViewName("/admin/adminTeacherList");
		}else {
			System.out.println("����");
			mav.setViewName("redirect:/admin");
		}
		return mav;
	}
	//���� ���.
	@RequestMapping("/admin/adminTeacherRegi")
	public String adminTeacherRegi() {
		return "admin/adminTeacherRegi";
	}
	//���� ���ok.
	@RequestMapping(value="/admin/adminTeacherRegiOk", method= {RequestMethod.GET ,RequestMethod.POST})
	public ModelAndView adminTeacherRegiOk(AdminTeacherVO vo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		
		HttpSession  sess = request.getSession();
		String 		check = (String)sess.getAttribute("employee_name");
		
		
		if(check.equals("������")) { 
			int insertResult = adminRegiInter.insertAdminTeacher(vo);			 
			if(insertResult > 0) {
				 mav.setViewName("redirect:/admin/adminTeacherList");
			}else {
				mav.setViewName("/admin/adminTeacherRegi");
			}
		}else{
			mav.setViewName("redirect:/admin");
		}
		return mav;
	}
	//���� ���� ���� ��
	@RequestMapping(value="/admin/adminTeacherEdit", method= {RequestMethod.GET ,RequestMethod.POST})
	public ModelAndView adminTeacherEdit(HttpServletRequest request, AdminTeacherVO vo) {
								
		ModelAndView  mav = new ModelAndView();
	
		AdminRegiInterface  adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		//�����ؾ��ϴ� ����� ������  ������.
		
		AdminTeacherVO tempVo = adminRegiInter.selectTeacherOverView(vo);
		System.out.println("tempVo " + tempVo);
		System.out.println("tempVo.getEmployee_email() " + tempVo.getEmployee_email());
		 
		if(tempVo != null) { 
			vo.setEmployee_overview(tempVo.getEmployee_overview() ); 
			//������, ���̵� �и�.
			String email = tempVo.getEmployee_email(); 
			int      cut   = email.indexOf("@");
			String emailId = email.substring(0,cut); 
			String  domain = email.substring(cut+1); 
			
			//��ȭ��ȣ �и� 
			String tel = tempVo.getEmployee_tel();
			
			String[] telSplitData = tel.split("-");

			String telAndEmailList[]  = new String[4]; 
				   telAndEmailList[0] = emailId;
				   telAndEmailList[1] = domain;
				   telAndEmailList[2] = telSplitData[1];
				   telAndEmailList[3] = telSplitData[2]; 
			
			mav.addObject("data", telAndEmailList);
		
		}
	
		mav.addObject("vo", vo);
		mav.setViewName("/admin/adminTeacherEdit");  
		
		return mav;
	}
	
	//���� ���� ����OK
	@RequestMapping(value="/admin/adminTeacherEditOk", method={RequestMethod.POST, RequestMethod.GET}) 
	public ModelAndView adminTeacherEditOk(HttpServletRequest request, AdminTeacherVO vo) {
		ModelAndView mav = new ModelAndView();
		
		AdminRegiInterface adminRegiInter	= sqlSession.getMapper(AdminRegiInterface.class);
		
		int result_Int = adminRegiInter.updateAdminTeacherEdit(vo);
		
		if(result_Int > 0) {  
			mav.setViewName("redirect:/admin/adminTeacherList");	
		}else {
			mav.setViewName("redirect:/admin/adminTeacherEdit"); 
		}
		
		return mav;
	} 
	@RequestMapping("/admin/adminTeacherDel")
	public ModelAndView adminTeacherDel(HttpServletRequest request, AdminTeacherVO vo) {
		ModelAndView mav = new ModelAndView();
		AdminRegiInterface adminRegiInter	= sqlSession.getMapper(AdminRegiInterface.class);
		
	int result_Int = adminRegiInter.deleteTeacher(vo);
		
		if(result_Int > 0) {  
			mav.setViewName("redirect:/admin/adminTeacherList");	
		}else {
			mav.setViewName("redirect:/admin/adminTeacherEdit"); 
		} 
		 
		return mav;
	}  
//-------------------------------------------------------------	
	 //���� ����Ʈ �Ѹ���
	@RequestMapping("/admin/adminCourseList")
	public ModelAndView adminCourseList(AdminStudentPagingVO pVo
										,AdminCourseVO vo
										,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);

		System.out.println("Ȯ�� : "+ pVo.getSearchKey_01());
		System.out.println("Ȯ�� : "+ pVo.getSearchKey_02());
		
		//���������� ������ ���ڵ� �� ����.
		pVo.setOnePageRecord(10);
				
		int 	searchKey_Year = -1;
		String  searchKey_State = "::����::";
	  	 
		if(pVo.getSearchKey_01() == 0) {
			pVo.setSearchKey_01(searchKey_Year); 
		}
		if(pVo.getSearchKey_02() == null) {
			pVo.setSearchKey_02(searchKey_State); 
		}
		 
		System.out.println("Ȯ�� �� : "+ pVo.getSearchKey_01());
		System.out.println("Ȯ��  ��: "+ pVo.getSearchKey_02());
		
		
		//��Ż ���ڵ�
		int result_Int = adminRegiInter.selectCourseTotal();
		//��Ż ���ڵ� ����.
		pVo.setTotalRecord(result_Int);
		
		
		searchKey_Year  = pVo.getSearchKey_01(); 
		searchKey_State = pVo.getSearchKey_02(); 
		
		pVo.setSearchKey_01(searchKey_Year);
		pVo.setSearchKey_02(searchKey_State);

		//����Ʈ ��� ����.
		List<AdminCourseVO> courseList = adminRegiInter.selectCourseAll(pVo);
		
		if(courseList != null) {
			mav.addObject("searchKey_Year", searchKey_Year);
			mav.addObject("searchKey_State", searchKey_State);
			mav.addObject("list", courseList);
			mav.addObject("pageVo", pVo);
			mav.setViewName("/admin/adminCourseList");
		}
		return mav;
	}
	 //���� ���� �� ����.	
	@RequestMapping("/admin/adminCourseEdit")
	public ModelAndView adminCourseEdit(AdminCourseVO vo, HttpServletRequest requet) {
		ModelAndView mav = new ModelAndView();
		
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		
		AdminCourseVO result_Vo = adminRegiInter.selectCourseOne(vo.getCourse_no());
		
		mav.addObject("vo", result_Vo);
		mav.setViewName("/admin/adminCourseEdit");
		
		return mav;  
	}
	
	@RequestMapping(value="/admin/adminCourseEditOk", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView adminCourseEditOk(AdminCourseVO vo, HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);

		int result_Int = adminRegiInter.updateCourse(vo);
		
		System.out.println("Ȯ�� : ��� : " + result_Int); 
		
		if(result_Int > 0) {
			mav.setViewName("redirect:/admin/adminCourseList");   
		}else { 
			mav.addObject("vo", vo);
			mav.setViewName("redirect:/admin/adminCourseEdit");
		}
		
		
		return mav;
	}
	
	
	@RequestMapping("/admin/adminCourseDel")
	public ModelAndView adminCourseDel(AdminCourseVO vo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		
		int result_Int = adminRegiInter.delRecord(vo);
		
		if(result_Int > 0) {
			mav.setViewName("redirect:/admin/adminCourseList");   
		}else { 
			mav.setViewName("redirect:/admin/adminCourseList"); 
		}
		
		return mav;
	}
	
	@RequestMapping("/admin/adminCourseRegi")
	public String adminCourseRegi() {
		return "admin/adminCourseRegi";
	}
	
	@RequestMapping(value="/admin/adminCourseRegiOk", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView adminCourseRegiOk(AdminCourseVO vo, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		AdminRegiInterface adminRegiInter = sqlSession.getMapper(AdminRegiInterface.class);
		
		//���̵� ���� �޾ƿ��� ���� ���� ����
		HttpSession sess = request.getSession();
		//���̵� , �̸�, ��ȣ
		String 	employee_Id = (String)sess.getAttribute("admin_id");
		String 	check_Name  = (String)sess.getAttribute("employee_name");
		int 	employee_No_Check =  adminRegiInter.checkTeacherId(employee_Id); 
		
		if(vo.getEmployee_name().equals(check_Name)) {
			
			vo.setEmployee_no(employee_No_Check); 
			vo.setEmployee_name(check_Name);
					
			String price = vo.getCourse_price();
			String priceUncomma = price.replaceAll(",", ""); 

			int result_price = Integer.parseInt(priceUncomma);
		
			vo.setCourse_price(priceUncomma);
			
			int result_Int = adminRegiInter.insertCourse(vo); 
			
			if(result_Int > 0) {
				mav.setViewName("redirect:/admin/adminCourseList");   
			}else { 
				mav.setViewName("redirect:/admin/adminCourseList"); 
			}	
		}
		

		return mav;
	}
//------------------------------------------------------------
 	
}//controller end
