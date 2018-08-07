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
			frm.find("input[name=title]").val($("input[name=txTitle]").val()); 
			frm.find("input[name=content]").val($("input[name=txContent]").val()); 
			frm.find("input[name=writer]").val($("input[name=txWriter]").val()); 
			frm.find("input[name=regdate1]").val($("input[name=txRegDate1]").val());
			frm.find("input[name=regdate2]").val($("input[name=txRegDate2]").val());
			frm.attr("action", "findMulti");
			frm.submit();	
		});
		
		$("#btnSearchTitle").click(function(e){
			var frm = $("#frm");
			frm.find("input[name=title]").val($("input[name=txTitle]").val()); 
			frm.attr("action", "findTitle");
			frm.submit();	
		});
		
		$("#btnSearchContent").click(function(e){
			var frm = $("#frm");
			frm.find("input[name=content]").val($("input[name=txContent]").val()); 
			frm.attr("action", "findContent");
			frm.submit();	
		});
		
		$("#btnSearchWriter").click(function(e){
			var frm = $("#frm");
			frm.find("input[name=writer]").val($("input[name=txWriter]").val()); 
			frm.attr("action", "findWriter");
			frm.submit();	
		});
		
		$("#btnSearchRegdate").click(function(e){
			var frm = $("#frm");
			frm.find("input[name=regdate1]").val($("input[name=txRegDate1]").val());
			frm.find("input[name=regdate2]").val($("input[name=txRegDate2]").val());
			frm.attr("action", "findRegdate");
			frm.submit();	
		});
		
		$("tbody a").click(function(e){
			var frm = $("#frm");
			frm.find("input[name=id]").val($(this).find("input[name=id]").val());
			frm.submit();
		});
		
		$("#btnNew").click(function(e){
			var frm = $("#frm");
			frm.attr("action", "new");
			frm.submit();
		});
		
		$("input[type=text]").keypress(function(e){
			if(e.which == 13){ 
				$("#btnSearch").trigger("click");
			}
		});
		
	}
	
	function page(n){
		var frm = $("#frm");
		frm.find("input[name=page]").val(n);
		frm.attr("action", "list");
		frm.submit();
	}

</script>
</head>
<body>

■ 검색조건 : <br/><br/>
제목 : <input type="text" name="txTitle"/> &nbsp; <input type="button" id="btnSearchTitle" value="제목검색"/>  <br/> 
내용 : <input type="text" name="txContent"/> &nbsp; <input type="button" id="btnSearchContent" value="내용검색"/>  <br/>
작성자 : <input type="text" name="txWriter"/> &nbsp; <input type="button" id="btnSearchWriter" value="작성자검색"/>  <br/>
등록일 : <input type="text" name="txRegDate1"/> ~ <input type="text" name="txRegDate2"/> &nbsp; <input type="button" id="btnSearchRegdate" value="작성일검색"/>  <br/>

<br/><br/>

<input type="button" id="btnNew" value="새로작성"/>  &nbsp;&nbsp;
<input type="button" id="btnReset" value="초기화"/> &nbsp;&nbsp;
<input type="button" id="btnSearch" value="전체검색"/>  
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
			<td><a href="#"><c:out value="${item.id }"/><input type="hidden" name="id" value="${item.id }"/></a></td>
			<td><c:out value="${item.title }"/></td>
			<td><c:out value="${item.content }"/></td>
			<td><fmt:formatDate value="${item.regDate }" pattern="yyyy.MM.dd"/></td>
			<td><c:out value="${item.writer }"/></td>
			<td><fmt:formatDate value="${item.modDate }" pattern="yyyy.MM.dd"/></td>
			<td>N/A</td>
		</tr>
		</c:forEach> 
	</tbody>
</table>
<br/>

Paging : 
<c:forEach var="item" begin="0" end="${list.totalPages-1 }" step="1" varStatus="n">
	<a href="javascript:page(${n.index })"><c:out value="${n.count }"/></a>
</c:forEach>
<br/><br/><br/>

<form id="frm" name="frm" action="detail">
<input type="hidden" name="id"/>
<input type="hidden" name="title"/>
<input type="hidden" name="content"/>
<input type="hidden" name="writer"/>
<input type="hidden" name="regdate"/>

<input type="hidden" name="page"/>

<input type="hidden" name="regdate1"/>
<input type="hidden" name="regdate2"/>
</form>
</body>
</html>