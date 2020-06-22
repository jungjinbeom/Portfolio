//=======================================================유효성 검사 및 정규식 START===========================================================================
//로그인 유효성 검사 및 정규식 
$(function(){
	$("#loginBtn").on('click',function(){
		/*아이디 유효성 검사*/
		if($("#grid-id").val()==""){
			alert("아이디를 입력해주세요.");
			return false;
		}
		/*아이디 정규식 */
		var reg = /^[a-zA-Z]{1}\w{7,20}$/;
		if(!reg.test($("#grid-id").val())){
			alert("잘못된 아이디 입니다. 다시 입력해 주세요");
			return false;
		}
		/*비밀번호 유효성 검사*/
		if($("#grid-password").val()==""){
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		/*비밀번호 정규식 */
		var reg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
		if(!reg.test($("#grid-password").val())){
			alert("잘못된 비밀번호 입니다. 다시 입력해주세요.");
			return false;
		}
	});
});

/*회원가입 유효성 검사 및 정규식  */
$(function(){
	$("#registerBtn").on('click',function(){
		/*이름유효성검사 */
		if($("#username").val()==""){
			alert("이름을 입력해주세요.");
				return false;
		}
		/*이름 정규식*/
		var reg = /^[가-힣]{2,7}$/;
		if(!reg.test($("#username").val())){
			alert("이름은 최소 2글자부터 7글자 까지입니다.");
				return false;
		}
		/*아이디 유효성검사 */
		if($("#userId").val()==""){
			alert("아이디를 입력해주세요.");
				return false;
		}
		/*아이디 정규식*/
		var reg = /^[a-zA-Z]{1}\w{7,20}$/;
		if(!reg.test($("#userId").val())){
			alert("아이디는 영어만 입력가능하며 \n 최소 2글자부터 최대 20글자 까지입니다 .");
				return false;
		}
		/*비밀번호 유효성 검사*/
		if($("#userPw").val()==""){
			alert("비밀번호를 입력해주세요.");
				return false;
		}
		/*비밀번호 정규식*/
		var reg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
		if(!reg.test($("#userPw").val())){
			alert("비밀번호는 특수문자,영문,숫자를 포함한 8글자 이상 입력하셔야 합니다.");
				return false;
		}
		/*비밀번호 확인 유효성 검사*/
		if($("#userPwChk").val()==""){
			alert("비밀번호를 입력해주세요.");
				return false;
		}
		/*비밀번호 확인 정규식*/
		var reg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
		if(!reg.test($("#userPwChk").val())){
			alert("비밀번호는 특수문자,영문,숫자를 포함한 8글자 이상 입력하셔야 합니다.");
			return false;
		}
		/*비밀번호 비밀번호 확인 유효성검사*/
		if($("#userPwChk").val() != $("#userPwChk").val()){
			alert("비밀번호 서로 같지 않습니다. 다시 입력해 주세요.");
				return false;
		}
		/*전화번호 유효성 검사*/
		if($("#userTel").val()==""){
			alert("전화번호를 입력해주세요.");
				return false;
		}
		/*전화번호 정규식  */
		var reg = /^(010){0,2}[0-9][0-9]{3,10}$/;
		if(!reg.test($("#userTel").val())){
			alert("잘못된 전화번호 입니다. 다시 입력해주세요.");
			return false;
		}
		/*이메일 유효성 검사*/
		if($("#userEmail").val()==""){
			alert("이메일을 입력해주세요.");
				return false;
		}
		/*이메일 정규식 */
		var reg = /^\w{2,20}[@][a-zA-Z]{2,10}[.][a-zA-Z]{2,3}([.][a-zA-Z]{2,3})?$/;
		if(!reg.test($("#userEmail").val())){
			alert("잘못된 이메일 입니다 다시 입력해 주세요.");
				return false;
		}
	});
});
/*아이디 및 비밀번호 찾기 유효성검사 및 정규식*/
$(function(){
	/*이름 유효성 검사*/
	$("#idFindBtn").on('click',function(){
		if($("#userName").val()==""){
			alert("이름을 입력해주세요.");
			return false;
		}
		/*이름 정규식*/
		var reg = /^[가-힣]{2,7}$/;
		if(!reg.test($("#userName").val())){
			alert("이름은 2~7글자까지 입력 가능합니다.");
			return false;
		}
		/*이름 유효성 검사*/
		if($("#userEmail").val()==""){
			alert("이메일을 입력해주세요.");
			return false;
		}
		/*이름 정규식*/
		var reg = /^\w{2,20}[@][a-zA-Z]{2,10}[.][a-zA-Z]{2,3}([.][a-zA-Z]{2,3})?$/;
		if(!reg.test($("#userEmail").val())){
			alert("잘못된 이메일 입니다. 다시 입력해주세요..");
			return false;
		}
	});
	/*비밀번호 찾기*/
	$("#pwFindBtn").on('click',function(){
		/*이름 유효성 검사*/
		if($("#username").val()==""){
			alert("이름을 입력해주세요.");
			return false;
		}
		/*이름 정규식*/
		var  reg = /^[가-힣]{2,7}$/;
		if(!reg.test($("#username").val())){
			alert("이름을 입력해주세요.");
			return false;
		}
		/*아이디 유효성 검사*/
		if($("#userid").val()==""){
			alert("아이디를 입력해주세요.");
			return false;
		}
		/*아이디 정규식*/
		var reg = /^[a-zA-Z]{1}\w{7,20}$/;
		if(!reg.test($("#userid").val())){
			alert("아이디는 영어만 입력가능하며 \n최소 2글자부터 최대 20글자 까지입니다 .");
				return false;
		}
		/*이메일 유효성 검사*/
		if($("#useremail").val()==""){
			alert("이메일을 입력해주세요.");
			return false;
		}
		/*이메일 정규식*/
		var reg = /^\w{2,20}[@][a-zA-Z]{2,10}[.][a-zA-Z]{2,3}([.][a-zA-Z]{2,3})?$/;
		if(!reg.test($("#useremail").val())){
			alert("잘못된 이메일 입니다. 다시 입력해 주세요.");
			return false;
		}
	});
});

/*마이페이지(이름 및 자기소개 수정,비밀번호수정)유효성 검사 및 정규식 */
$(function(){
	$("#generalBtn").on('click',function(){
		/*성 유효성 검사 */
		if($("#firstName").val()==""){
			alert("성을 입력해주세요.")
			 return false;
		}
		/*이름 유효성 검사 */
		if($("#lastName").val()==""){
			alert("이름을 입력해주세요.")
			return false;
		}
	});
	$("#pwUpdateBtn").on('click',function(){
		/*현재 비밀번호 유효성 검사*/	
		if($("#oldPwd").val()==""){
			alert("현재비밀번호를 입력해주세요");
			return false;
		}
		/*현재 비밀번호 정규식*/
		var reg =/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
		if(!reg.test($("#oldPwd").val())){
			alert("사용 중 이신 비밀번호가 일치하지 않습니다 \n 다시 입력해 주세요.");
			return false;
		}
		/*변경 비밀번호 유효성 검사*/	
		if($("#newPwd").val()==""){
			alert("변경하실 비밀번호를 입력해주세요");
			return false;
			
		}
		/*변경 비밀번호 정규식*/
		var reg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
		if(!reg.test($("#newPwd").val())){
			alert("변경하실 비밀번호를 조건에 맞춰서 다시 입력해 주세요.");
			return false;
		}
		/*변경 비밀번호 확인 유효성 검사*/	
		if($("#newPwdChk").val()==""){
			alert("변경할 비밀번호와 일치하지 않습니다. \n 다시 입력해 주세요.");
			return false;
		}
		/*변경 비밀번호 확인 정규식*/
		var reg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
		if(!reg.test($("#newPwdChk").val())){
			alert("변경하실 비밀번호를 조건에 맞춰서 다시 입력해 주세요.");
			return false;
		}
		/*변경 비밀번호 및 변경 비밀번호 확인  유효성 검사*/	
		if($("#newPwdChk").val()!=$("#newPwd").val()){
			alert("변경할 비밀번호가 서로 일치하지 않습니다. \n 다시 입력해 주세요.");
			return false;
		}
	});
});
/*결제창 유효성 검사 및 정규식 검사*/
//=======================================================유효성 검사 및 정규식 END===========================================================================

/*마이페이지 위시리스트 이미지 슬라이드 */
$(function(){
    $("#wishListCourseCarousel").slick({
    	slidesToShow: 3,
		prevArrow: ".best-section .arrow-prev",
		nextArrow: ".best-section .arrow-next",
	});
});

/* 메뉴 모달 검색창 */
$(function(){
	$('.login-ico').on('click', function(e){
		console.log("123213213213")
	    e.preventDefault();
	    $($(this).data('target')).fadeIn(function(){
	        $('.loginModal').removeClass('hidden');
	        
	    });
	});
	$('.xi-close').on('click', function(){
	    $(".xi-close").parents('.loginModal').fadeOut(function(){
	        $(".xi-close").parents('.loginModal').addClass('hidden');
	    });
	});
});

/* 마이페이지 탭메뉴*/
$(function(){
	$("#grade").click(function(){
		
		$("#course>a").addClass("text-gray-900").addClass("hover:text-brand-500").addClass("border-t");
		$("#course>a").removeClass("border-brand-500").removeClass("text-brand-500").removeClass("border-t-4");
		
		$("#grade>a").addClass("border-brand-500").addClass("text-brand-500").addClass("border-t-4");
		$("#grade>a").removeClass("text-gray-900").removeClass("hover:text-brand-500").removeClass("border-t");
		
		$("#courseList").css("display","none");
		$("#gradeList").css("display","block");
	});
	
	$("#course").click(function(){
		
		$("#course>a").addClass("border-brand-500").addClass("text-brand-500").addClass("border-t-4");
		$("#course>a").removeClass("text-gray-900").removeClass("hover:text-brand-500").removeClass("border-t");
		
		$("#grade>a").addClass("text-gray-900").addClass("hover:text-brand-500").addClass("border-t");
		$("#grade>a").removeClass("border-brand-500").removeClass("text-brand-500").removeClass("border-t-4");
		
		$("#courseList").css("display","block");
		$("#gradeList").css("display","none");
		
		
	});
	
	$("#FinalGrade").click(function(){
		
		$("#CompletionCourse>a").addClass("text-gray-900").addClass("hover:text-brand-500").addClass("border-t");
		$("#CompletionCourse>a").removeClass("border-brand-500").removeClass("text-brand-500").removeClass("border-t-4");
		
		$("#FinalGrade>a").addClass("border-brand-500").addClass("text-brand-500").addClass("border-t-4");
		$("#FinalGrade>a").removeClass("text-gray-900").removeClass("hover:text-brand-500").removeClass("border-t");
		
		$("#CompletionCourseList").css("display","none");
		$("#FinalGradeList").css("display","block");
	});
	
	$("#CompletionCourse").click(function(){
		
		$("#CompletionCourse>a").addClass("border-brand-500").addClass("text-brand-500").addClass("border-t-4");
		$("#CompletionCourse>a").removeClass("text-gray-900").removeClass("hover:text-brand-500").removeClass("border-t");
		
		$("#FinalGrade>a").addClass("text-gray-900").addClass("hover:text-brand-500").addClass("border-t");
		$("#FinalGrade>a").removeClass("border-brand-500").removeClass("text-brand-500").removeClass("border-t-4");
		
		$("#CompletionCourseList").css("display","block");
		$("#FinalGradeList").css("display","none");
	});
	
	$("#avatar").click(function(){
		
		$("#imgUpload").css("display","block");
		$("#passwordUpdate").css("display","none");
		$("#profileUpdate").css("display","none");
		
		$("#avatar>a").addClass("border-brand-500").addClass("text-brand-500").addClass("border-t-4");
		$("#avatar>a").removeClass("text-gray-900").removeClass("hover:text-brand-500").removeClass("border-t");
		$("#general>a").addClass("text-gray-900").addClass("hover:text-brand-500").addClass("border-t");
		$("#general>a").removeClass("border-brand-500").removeClass("text-brand-500").removeClass("border-t-4");
		$("#password>a").addClass("text-gray-900").addClass("hover:text-brand-500").addClass("border-t");
		$("#password>a").removeClass("border-brand-500").removeClass("text-brand-500").removeClass("border-t-4");
		
	});
	
	$("#password").click(function(){
	
		$("#passwordUpdate").css("display","block");
		$("#imgUpload").css("display","none");
		$("#profileUpdate").css("display","none");
		
		$("#password>a").addClass("border-brand-500").addClass("text-brand-500").addClass("border-t-4");
		$("#avatar>a").addClass("text-gray-900").addClass("hover:text-brand-500").addClass("border-t");
		$("#general>a").addClass("text-gray-900").addClass("hover:text-brand-500").addClass("border-t");
		
		$("#password>a").removeClass("text-gray-900").removeClass("hover:text-brand-500").removeClass("border-t");
		$("#avatar>a").removeClass("border-brand-500").removeClass("text-brand-500").removeClass("border-t-4");
		$("#general>a").removeClass("border-brand-500").removeClass("text-brand-500").removeClass("border-t-4");
		
		
	});
	
	$("#general").click(function(){
		
		$("#profileUpdate").css("display","block");
		$("#imgUpload").css("display","none");
		$("#passwordUpdate").css("display","none");
		
		$("#general>a").addClass("border-brand-500").addClass("text-brand-500").addClass("border-t-4");
		$("#avatar>a").addClass("text-gray-900").addClass("hover:text-brand-500").addClass("border-t");
		$("#password>a").addClass("text-gray-900").addClass("hover:text-brand-500").addClass("border-t");
		
		$("#general>a").removeClass("text-gray-900").removeClass("hover:text-brand-500").removeClass("border-t");
		$("#avatar>a").removeClass("border-brand-500").removeClass("text-brand-500").removeClass("border-t-4");
		$("#password>a").removeClass("border-brand-500").removeClass("text-brand-500").removeClass("border-t-4");
	});
});

$(function(){
	$("#emailCodeBtn").click(function(){
		/*이메일 유효성 검사 및 정규식*/
		var reg = /^\w{2,20}[@][a-zA-Z]{2,10}[.][a-zA-Z]{2,3}([.][a-zA-Z]{2,3})?$/;
		if($("#userEmail").val()=="" || !reg.test($("#userEmail").val())){
			alert("잘못된 이메일 입니다 다시 입력해 주세요.");
				return false;
		}else{
			$("#userEmailText").css("display","none");
			$("#userEmailCodeText").css("display","block");
		}
	});
});


