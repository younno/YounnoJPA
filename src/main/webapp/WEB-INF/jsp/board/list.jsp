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
		$("#btnReset").click(function(e){
			$("input[type=text]").val("");
			$("input[type=hidden]").val("");
			$("#frm").attr("action","list").submit();
		});
		
		$("#btnSearch").click(function(e){
			var frm = $("#frm");
			frm.find("input[name=title]").val($("input[name=txTitle]").val()); //frm.attr("action", "title");
			frm.find("input[name=content]").val($("input[name=txContent]").val()); //frm.attr("action", "content");
			
			//frm.attr("action", "titleContent");
			frm.attr("action", "sqlTitle");
			frm.submit();	
			
			console.log($("input[name=txTitle]").val());
		});
		
		$("tbody a").click(function(e){
			var frm = $("#frm");
			frm.find("input[name=id]").val($(this).find("input[name=id]").val());
			frm.submit();
		});
	}

</script>
</head>
<body>

■ 검색조건 : <br/><br/>
제목 : <input type="text" name="txTitle"/> <br/>
내용 : <input type="text" name="txContent"/> <br/>
작성자 : <input type="text" name="txWriter"/> <br/>
등록일 : <input type="text" name="txRegDate1"/> ~ <input type="text" name="txRegDate2"/> <br/><br/>

<input type="button" id="btnReset" value="초기화"/> &nbsp;&nbsp;
<input type="button" id="btnSearch" value="검색"/>  
<br/><br/>
 
■ 검색결과 : <c:out value="${list.size }"/> 건

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
		<c:forEach var="item" items="${list.content }" varStatus="n">
		<tr>
			<td><a href="#"><c:out value="${n.index }"/><input type="hidden" name="id" value="${item.id }"/></a></td>
			<td><c:out value="${item.title }"/></td>
			<td><c:out value="${item.content }"/></td>
			<td><fmt:formatDate value="${item.reg_date }" pattern="yyyy.MM.dd"/></td>
			<td><c:out value="${item.writer }"/></td>
			<td><fmt:formatDate value="${item.mod_date }" pattern="yyyy.MM.dd"/></td>
			<td>N/A</td>
		</tr>
		</c:forEach> 
	</tbody>
</table>

<form id="frm" name="frm" action="detail">
<input type="hidden" name="id"/>
<input type="hidden" name="title"/>
<input type="hidden" name="content"/>
</form>
</body>
</html>