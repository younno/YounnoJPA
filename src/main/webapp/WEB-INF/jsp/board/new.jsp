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
			frm.attr("action", "save");
			frm.submit();	
		});
		
	}

</script>
</head>
<body>
<form id="frm" name="frm" action="detail">

■ 신규생성 : <br/><br/>
ID : <input type="text" name="id"/>  
제목 : <input type="text" name="title"/>  
내용 : <input type="text" name="content"/> 
작성자 : <input type="text" name="writer"/> 
등록일 : <input type="text" name="regDate1"/> &nbsp; <input type="button" id="btnSave" value="save"/>  <br/>
<br/><br/>

</form>
</body>
</html>