<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
alert('${msg}');
location.href='<c:out value="${pageContext.request.contextPath}"/>${url}?course_no=${course_no}${hash}';
</script>
