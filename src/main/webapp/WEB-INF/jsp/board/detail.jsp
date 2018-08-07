<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.1.3/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$( document ).ready(function() {
	
		_EventListener();
		
	});
	
	function _EventListener(){
		
		$("#btnSave").click(function(e){
			var frm = $("#frm");
			frm.attr("action", "update");
			frm.submit();	
		});
		
		$("#btnDelete").click(function(e){
			var frm = $("#frm");
			frm.attr("action", "delete");
			frm.submit();	
		});
		
	}

</script>
</head>
<body>
<form id="frm" name="frm" >
<input type="hidden" name="regDate" value="<c:out value='${item.regDate }'/>"/>
<div>	
	<h3 class="h_tit">■ 상세정보 </h3>
	<ul>
		<li>ID : <input type="text" name="id" value="<c:out value='${item.id }'/>" readonly/></li>
	</ul>
	<ul>
		<li>제목 : <input type="text" name="title" value="<c:out value='${item.title }'/>"/></li>
	</ul>
	<ul>
		<li>내용 : <input type="text" name="content" value="<c:out value='${item.content }'/>"/></li>
	</ul>
	<ul>
		<li>작성자 : <input type="text" name="writer" value="<c:out value='${item.writer }'/>"/></li>
	</ul>  
</div>
<input type="button" id="btnSave" value="update"/>
<input type="button" id="btnDelete" value="delete"/>
</form>
</body>
</html>