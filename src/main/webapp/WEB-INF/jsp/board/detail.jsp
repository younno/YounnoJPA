<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.1.3/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$( document ).ready(function() {

		_EventListener();
		
	});
	
	function _EventListener(){
		$("#btnReset").click(function(e){
			alert($(this).val());			
		});
		
		$("#btnSearch").click(function(e){
			alert($(this).val());			
		});
	}

</script>
</head>
<body>

■ 상세정보

<br/><br/>

<table style="border-style: groove;">
	<thead>
		<tr style="border-color: black;border-style: groove;background-color: antiquewhite;">	
			<th style="width:50px;">순번</th>
			<th style="width:150px;">제목</th>
			<th style="width:200px;">내용</th>
			<th style="width:100px;">등록일자</th>
			<th style="width:100px;">등록자</th>
			<th style="width:100px;">수정일자</th>
			<th style="width:100px;">수정자</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><c:out value="${item.id }"/></td>
			<td><c:out value="${item.title }"/></td>
			<td><c:out value="${item.content }"/></td>
			<td><fmt:formatDate value="${item.regDate }" pattern="yyyy.MM.dd"/></td>
			<td><c:out value="${item.writer }"/></td>
			<td><fmt:formatDate value="${item.modDate }" pattern="yyyy.MM.dd"/></td>
			<td></td>
		</tr>
	</tbody>
</table>

</body>
</html>