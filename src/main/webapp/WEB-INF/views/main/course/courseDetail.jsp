<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
/* Hover state of the stars */
#stars > li.star.hover {
  color:#FFb606;
}

/* Selected state of the stars */
#stars > li.star.selected {
  color:#F6a405;
}
</style>
<div id="mainBanner" style="background-image:url('<%=ctx%>/img/top-banner.jpg')" class="bg-cover mb-4 w-full">
	<div class="container my-0 mx-auto">
		<h1 class="border-l-4 border-brand-600 text-5xl text-white roboto-slab font-bold">&nbsp;&nbsp;COURSES</h1>
	</div>
</div>
<div id="stickyNav" class="course-tab-nav w-full fixed bg-white border-t border-gray">
	<div class="w-full max-w-screen-xl my-0 mx-auto px-8 xl:px-0 flex justify-between">
		<ul class="flex items-center block w-1/2">
			<li class="tab-item w-1/3 text-center mx-4 border-t-4 active" data-nav-idx="1">
				<a href="#course_detail" class="inline-block px-4">강좌소개 및 커리큘럼</a>
			</li>
			<li class="tab-item w-1/3 text-center mx-4 border-t-4" data-nav-idx="2">
				<a href="#instructor" class="inline-block px-4">강사소개</a>
			</li>
			<li class="tab-item w-1/3 text-center mx-4 border-t-4" data-nav-idx="3">
				<a href="#comments" class="inline-block px-4">수강후기</a>
			</li>
		</ul>
		<div class="flex items-center">
			<p class="font-bold text-xl text-danger-500 mr-8"><span>${vo.course_price_format}</span>원</p>
			<a href="#donate" class="btn-donate bg-brand-500 hover:bg-brand-600 text-white py-2 px-4 rounded inline-block text-lg text-center font-bold">수강신청</a>
			<a href="#" class="add-wishlist relative ml-2 bg-black border border-gray-700 text-brand-500 w-12 rounded inline-block text-2xl text-center"><span class="wishlist-ico align-middle"></span></a>
		</div>
	</div>
</div>
<div class="w-full max-w-screen-xl my-0 mx-auto px-8 xl:px-0"><!-- 상세페이지 -->
	<span class="text-gray-500"><a href="<%=ctx%>/">Home</a>&nbsp;&nbsp;<i class="xi-angle-right"></i>&nbsp;&nbsp;Courses</span>
	<div id="hr" class="my-4 border-t border-solid"></div>
	<div class="w-full flex mb-4 pt-4"><!-- 상단 -->
		<div class="course-img w-2/5 pr-12">
			<div class="border border-gray">
				<img class="object-cover" src="<%=ctx %>/img/${vo.course_img}">
			</div>
		</div>
		<div class="w-3/5">
			<h1 class="mb-4 text-3xl font-bold">${vo.course_name}</h1>
			<p class="mb-8 text-gray-dark">${vo.course_overview}</p>
			<div class="course-meta flex items-center text-sm">
				<div class="border-r border-gray pr-4 py-1">
					<p class="text-gray-500">모집기간<span class="font-bold text-gray-700 ml-2 text-xs">${vo.course_reception_start} ~ ${vo.course_reception_end}</span></p>
				</div>
				<div class="border-r border-gray px-4 py-1">
					<p class="text-gray-500">개강일<span class="font-bold text-gray-700 ml-2 text-xs">${vo.course_start_date}</span></p>
				</div>
				<div class="border-r border-gray px-4 py-1">
					<p class="text-gray-500">수강기간<span class="font-bold text-gray-700 ml-2 text-xs">${vo.course_start_date} ~ ${vo.course_end_date}</span></p>
				</div>
				<div class="pl-4 py-1">
					<p class="text-gray-500">장소<span class="font-bold text-gray-700 ml-2 text-xs">${vo.course_stage}</span></p>
				</div>
			</div>
			<!--버튼-->
			<div class="mt-8 mb-4 flex justify-end items-center">
				<p class="font-bold text-3xl text-danger-500 mr-8"><span>${vo.course_price_format}</span>원</p>
				<a href="#donate" class="btn-donate bg-brand-500 hover:bg-brand-600 text-white py-2 px-4 rounded inline-block text-lg text-center font-bold">수강신청</a>
				<a href="#" class="add-wishlist relative ml-2 bg-black border border-gray-700 text-brand-500 w-12 rounded inline-block text-2xl text-center"><span class="wishlist-ico align-middle"></span></a>
			</div>
		</div>
	</div><!-- 상단 -->
	<div id="courseContent" class="w-full flex items-start content-start"><!-- 본문 -->
		<div class="w-full bg-white mt-4 border border-gray pb-16 mb-16">
			<div class="course-tab-nav w-full bg-white flex items-center justify-center">
				<ul class="w-full flex items-center justify-center block py-8 font-bold px-6">
					<li class="tab-item w-1/3 text-center mx-4 border-b-4 active" data-nav-idx="1">
						<a href="#course_detail" class="inline-block py-4 px-4">
							<span class="ico mr-2"><i class="xi-bookmark"></i></span>강좌소개 및 커리큘럼
						</a>
					</li>
					<li class="tab-item w-1/3 text-center mx-4 border-b-4" data-nav-idx="2">
						<a href="#instructor" class="inline-block py-4 px-4">
							<span class="ico mr-2"><i class="xi-user"></i></span>강사소개
						</a>
					</li>
					<li class="tab-item w-1/3 text-center mx-4 border-b-4" data-nav-idx="3">
						<a href="#comments" class="inline-block py-4 px-4">
							<span class="ico mr-2"><i class="xi-speech"></i></span>수강후기 <span class="text-brand-500">5</span>
						</a>
					</li>
				</ul>
				<a href="#donate" class="sticky-btn-donate inline-block bg-brand hover:bg-brand-dark text-white py-2 px-4 rounded inline-block text-lg text-center ml-4">후원하기</a>
			</div>
			<div class="course-tab-content px-10"><!--스토리-->
				<div id="course_detail" class="tab-content-item active">
					<div class="story-content">${vo.course_content}</div>
				</div><!--스토리-->
				<div id="instructor" class="tab-content-item"><!--강사소개-->
					<div class="border p-8">
						<div class="flex items-center">
							<div class="w-24 h-24 mr-8 rounded-full overflow-hidden">
								<img src="<%=ctx %>/img/user-avatar.png">
							</div>
							<div class="instructor-name font-bold mr-8">${vo.employee_name}</div>
							<div class="instructor-desc text-gray-700">
								강사소개강사소개강사소개강사소개강사소개강사소개강사소개강사소개강사소개강사소개강사소개강사소개강사소개강사소개강사소개
							</div>
						</div>
					</div>
				</div><!--강사소개-->
				<div id="comments" class="tab-content-item"><!--응원글-->
					<h1 class="my-4 font-bold">수강후기</h1>
					<div class="mb-8">
						<form method="POST" action="/reviewOk" enctype="multipart/form-data" onsubmit="return basicFormValidate(this)" class="course-comment-form">
							<div class="mb-4">
								<p class="mb-2">평점을 남겨주세요</p>
								<ul id="stars" class="text-lg text-gray-500">
									<li class="star inline-block" data-value="1"><i class="xi-star"></i></li>
									<li class="star inline-block" data-value="2"><i class="xi-star"></i></li>
									<li class="star inline-block" data-value="3"><i class="xi-star"></i></li>
									<li class="star inline-block" data-value="4"><i class="xi-star"></i></li>
									<li class="star inline-block" data-value="5"><i class="xi-star"></i></li>
								</ul>
								<input type="hidden" name="rate" id="rate" value="">
							</div>
							<textarea name="course_comment" id="course_comment" placeholder="여기에 수강후기를 남겨주세요." class="appearance-none border border-gray-500 w-full py-2 px-3 leading-tight focus:outline-none focus:border-brand-500 h-24"></textarea>
							<div class="text-right">
								<input type="submit" value="등록" class="bg-brand-500 hover:bg-brand-600 font-bold py-2 px-4 rounded"/>
							</div>
						</form>
					</div>
					<div class="course-total-rate flex items-center py-4 w-2/3 mb-8">
						<div class="w-56 h-56 text-center border p-6 mr-8">
							<h1 class="roboto-slab text-brand-500 font-bold text-6xl">5.0</h1>
							<p class="text-brand-500 font-normal mb-2">
								<i class="xi-star"></i><i class="xi-star"></i><i class="xi-star"></i><i class="xi-star"></i><i class="xi-star"></i>
							</p>
							<p>2개의 수강평</p>
						</div>
						<div class="flex-grow h-56 border px-6 py-10">
							<div class="stars flex items-center">
								<div class="key pr-8">5</div>
								<div class="bar w-full">
									<div class="fullbar bg-gray-300 relative h-2 w-full"><div class="bg-brand-500 absolute left-0 top-0 h-2" style="width:100%"></div></div>
								</div>
								<span class="w-16 text-right">100%</span>
							</div>
							<div class="stars flex items-center">
								<div class="key pr-8">4</div>
								<div class="bar w-full">
									<div class="fullbar bg-gray-300 relative h-2 w-full"><div class="bg-brand-500 absolute left-0 top-0 h-2" style="width:0%"></div></div>
								</div>
								<span class="w-16 text-right">0%</span>
							</div>
							<div class="stars flex items-center">
								<div class="key pr-8">3</div>
								<div class="bar w-full">
									<div class="fullbar bg-gray-300 relative h-2 w-full"><div class="bg-brand-500 absolute left-0 top-0 h-2" style="width:0%"></div></div>
								</div>
								<span class="w-16 text-right">0%</span>
							</div>
							<div class="stars flex items-center">
								<div class="key pr-8">2</div>
								<div class="bar w-full">
									<div class="fullbar bg-gray-300 relative h-2 w-full"><div class="bg-brand-500 absolute left-0 top-0 h-2" style="width:0%"></div></div>
								</div>
								<span class="w-16 text-right">0%</span>
							</div>
							<div class="stars flex items-center">
								<div class="key pr-8">1</div>
								<div class="bar w-full">
									<div class="fullbar bg-gray-300 relative h-2 w-full"><div class="bg-brand-500 absolute left-0 top-0 h-2" style="width:0%"></div></div>
								</div>
								<span class="w-16 text-right">0%</span>
							</div>
						</div>
					</div>
					<ul class="course-comment-list">
						<li class="py-8 px-4 border-t">
							<div class="comment-container">
								<p class="comment-author font-bold mb-2">
									홍길동
									<span class="text-brand-500 text-sm font-normal ml-4">
										<i class="xi-star"></i><i class="xi-star"></i><i class="xi-star"></i><i class="xi-star"></i><i class="xi-star"></i>
									</span>
									<span class="text-gray-700 text-sm font-normal ml-4">2020-04-27</span>
								</p>
								<div class="comment-text text-gray-900">수강후기입니다.</div>
							</div>
						</li>
						<li class="py-8 px-4 border-t">
							<div class="comment-container">
								<p class="comment-author font-bold mb-2">
									홍길동
									<span class="text-brand-500 text-sm font-normal ml-4">
										<i class="xi-star"></i><i class="xi-star"></i><i class="xi-star"></i><i class="xi-star"></i><i class="xi-star"></i>
									</span>
									<span class="text-gray-700 text-sm font-normal ml-4">2020-04-27</span>
								</p>
								<div class="comment-text text-gray-900">수강후기입니다.~~</div>
							</div>
						</li>
					</ul>
					<ul class="pagenation flex items-center justify-center my-4">
						<li class="page-item disabled"><a class="page-link block py-1 px-2 hover:text-brand pointer-events-none" href="#"><i class="xi-angle-left-min"></i></a></li>
						<li class="page-item acitve"><a class="page-link block py-1 px-2 hover:text-brand text-brand" href="#">1</a></li>
						<li class="page-item"><a class="page-link block py-1 px-2 hover:text-brand" href="#">2</a></li>
						<li class="page-item"><a class="page-link block py-1 px-2 hover:text-brand" href="#">3</a></li>
						<li class="page-item"><a class="page-link block py-1 px-2 hover:text-brand" href="#">4</a></li>
						<li class="page-item"><a class="page-link block py-1 px-2 hover:text-brand" href="#">5</a></li>
						<li class="page-item"><a class="page-link block py-1 px-2 hover:text-brand" href="#"><i class="xi-angle-right-min"></i></a></li>
					</ul>
				</div><!--응원글-->
			</div>
		</div>
	</div><!-- 본문 -->
</div><!-- 상세페이지 -->
<script>
$(function(){
	function stickyTabNav() {
		if (scrollY < 500) {
			$("#stickyNav").removeClass('sticky-nav');
		}
		else {
			$("#stickyNav").addClass('sticky-nav');
		}
	}

	/*별점*/
	$('#stars li').on('mouseover', function(){
    	var onStar = parseInt($(this).data('value'), 10); // The star currently mouse on
   
    	// Now highlight all the stars that's not after the current hovered star
    	$(this).parent().children('li.star').each(function(e){
      		if (e < onStar) {
        		$(this).addClass('hover');
      		}
      		else {
        		$(this).removeClass('hover');
      		}
    	});
    
	}).on('mouseout', function(){
	    $(this).parent().children('li.star').each(function(e){
	    	$(this).removeClass('hover');
		});
	});
	
	/* 2. Action to perform on click */
	$('#stars li').on('click', function(){
	    var onStar = parseInt($(this).data('value'), 10); //현재 선택된 별점
	    $('#rate').val(onStar);
	    var stars = $(this).parent().children('li.star');
	    
	    for (i = 0; i < stars.length; i++) {
	      $(stars[i]).removeClass('selected');
	    }
	    
	    for (i = 0; i < onStar; i++) {
	      $(stars[i]).addClass('selected');
	    }
	});
	
	//위시리스트
	$('a.add-wishlist').on('click', function(e){
		e.preventDefault();
		$(this).toggleClass('added-this');
	});
	
	//탭
	$('.course-tab-nav .tab-item a').on('click', function(e){
		e.preventDefault();
        
        var tabIdx=$(this).parent().data('nav-idx');
        $('html,body').animate({
            scrollTop: $("#courseContent").offset().top-95
        });

        $('.course-tab-nav .tab-item').removeClass('active');
        $('.course-tab-content .tab-content-item').removeClass('active');

        $(this).parent().addClass('active');
        $('.course-tab-nav li[data-nav-idx='+tabIdx+']').addClass('active');
        $($(this).attr('href')).addClass('active');
    });
	
	$("html,body").on("mousewheel DOMMouseScroll'", stickyTabNav);
	stickyTabNav();
});
</script>