<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/tailwind.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile.css" type="text/css">
<script src="<%=request.getContextPath()%>/js/profile.js"></script>
</head>
<body>
	<div id="mainBanner" style="background-size:cover;background-image:url('<%=request.getContextPath()%>/img/top-banner.jpg')" class="mb-4  w-full ">
		<div id="bannerText">
			<h1 class="border-l-4 border-brand-600 text-5xl text-white roboto-slab font-bold">&nbsp;&nbsp;PROFILE</h1>
		</div>
	</div>
	<div id="profileMenu" class="my-0 mx-auto w-full max-w-screen-xl">
		<span class="text-gray-500"><a href="<%=request.getContextPath()%>/">Home</a>&nbsp;&nbsp;＞&nbsp;&nbsp;Profile</span>
		<div id="hr" class="my-4 border-t border-solid"></div>
		<div class="flex mt-12">
			<div>
				<img src="<%=request.getContextPath()%>/img/user-avatar.png">
				<div id="hr" class="my-8 border-t border-solid"></div>
				<h1 class="text-4xl font-bold roboto-slab text-center">Hong Gil Dong</h1>
				<div id="hr" class="m-0 m-auto border-black my-4 bg-black border-t border-solid w-4 border-2"></div>
				<h4 class="text-gray-500 text-center  mb-4">I have basics skills in leadership!</h4>
			</div>
			<div class="w-full mt-4 ml-8">
				<ul class="flex roboto-slab">
					  <li class="-mb-px mr-1">
					    <a class="bg-white hover:border-brand-500 border-b border-l border-t border-r  py-3 px-4 text-gray-900  hover:text-brand-500 font-semibold" href="<%=request.getContextPath()%>/courseOfStudy">Course</a>
					  </li> 
					  <li class="mr-1">
					    <a class="bg-white border-brand-500  border-b border-l border-t-4 border-r py-3 px-4  text-brand-500  font-semibold" href="<%=request.getContextPath()%>/completionCourse">Completion Course</a>
					  </li>
					  <li class="mr-1">
					   	 <a class="bg-white hover:border-brand-500 border-b border-l border-t border-r py-3 px-4 text-gray-900 hover:text-brand-500 font-semibold" href="<%=request.getContextPath()%>/inCompletionCourse">Incomplete Course</a>
					  </li>
					  <li class="mr-1">
					    <a class="bg-white hover:border-brand-500 border-b border-l border-t border-r py-3 px-4 text-gray-900 hover:text-brand-500 font-semibold" href="<%=request.getContextPath()%>/schedule">Schedule</a>
					  </li>
					  <li class="mr-1">
					    <a class="bg-white hover:border-brand-500 border-b border-l border-t border-r py-3 px-4 text-gray-900 hover:text-brand-500 font-semibold" href="<%=request.getContextPath()%>/profile">Profile</a>
					  </li>
					   <li class="mr-1">
					    <a class="  bg-white hover:border-brand-500 border-b border-l border-t border-r py-3 px-4 text-gray-900 hover:text-brand-500 font-semibold" href="<%=request.getContextPath()%>/wishList">WishList</a>
					  </li>
					</ul>
					
					<ul class="flex roboto-slab mt-16">
					  <li id="CompletionCourse" class="-mb-px mr-1">
					    <a class="bg-white border-b border-l border-t-4 border-r py-2 px-3 font-semibold border-brand-500 text-brand-500 " href="#">CompletionCourse</a>
					  </li> 
					  <li id="FinalGrade" class="mr-1">
					    <a class="bg-white border-b border-l border-t border-r py-2 px-3 font-semibold text-gray-900 hover:text-brand-500 " href="#">Final grade</a>
					  </li>
					</ul>
					
					
					<div id="CompletionCourseList" style="display:block">
					<ul class="flex mt-8 roboto-slab bg-cta-400">
						<li class="ml-2 h-8 text-xl text-white w-1/6">Instructor</li>
						<li class="text-white text-xl w-1/3">Course</li>
						<li class="text-white text-xl w-1/5">CompletionStatus</li>
						<li class="text-white text-xl w-1/6">End date</li>
						<li class="text-white text-xl mr-2">PassingGrade</li>
					</ul>
					<ul class="flex my-4 roboto-slab ">
						<li class="ml-2 h-8 text-xl text-black w-1/6">김길동</li>
						<li class="text-black text-xl w-1/3">Framework 전문 개발자 양성과정</li>
						<li class="text-black text-xl  w-1/5">YES</li>
						<li class="text-black text-xl w-1/6">2020-02-10</li>
						<li class="text-black text-xl  text-center ">80%</li>
					</ul>
					<div id="hr" class="my-4 border-cta-500 border-t border-solid"></div>
				</div>
				<div id="FinalGradeList" style="display:none">
					<ul class="flex mt-8 roboto-slab bg-cta-400">
						<li class="ml-2 h-8 text-xl text-white w-1/6">Instructor</li>
						<li class="text-white text-xl w-1/3">Course</li>
						<li class="text-white text-xl w-1/6">FinalGrade</li>
						<li class="text-white text-xl w-1/6">Rating</li>
						<li class="text-white text-xl">Test date</li>
					</ul>
					<ul class="flex my-4 roboto-slab ">
						<li class="ml-2 h-8 text-xl text-black w-1/6"><a href="#" class="hover:text-cta-500">김길동</a></li>
						<li class="text-black text-xl w-1/3"><a href="#" class="hover:text-cta-500">Framework 전문 개발자 양성과정</a></li>
						<li class="text-black text-xl w-1/6">A등급</li>
						<li class="text-black text-xl w-1/6">1등급</li>
						<li class="text-black text-xl ">2020-06-10</li>
					</ul>
					<div id="hr" class="my-4 border-cta-500 border-t border-solid"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>