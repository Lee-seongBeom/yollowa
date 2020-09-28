<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/head.jspf" %>
<style rel="stylesheet" type="text/css">
	/* category start */
	.page-header{
		border-bottom: 1px solid lightgray;
		padding-top: 15px;
		padding-bottom: 25px;
	}
	.page-header>p{
		margin-top: 10px;
		margin-bottom:2px;
	}
	#category{
		border-right: 1px solid lightgray;
	}
	#category>div:first-child{
		margin-top: 30px;
	}
	#category>div{
		margin-bottom: 25px;
		padding-right:15px;
		font-size: 16px;
	}
	.smallList>p:hover {
		background-color: #EEEEED;
		cursor: pointer;
	}
	h2{
		margin-top: 50px;
		margin-left: 20px;
	}
	.bigList>p{
		font-size: 18px;
		margin-bottom:5px;
	}
	.smallList{
		margin-left: 15px;
		margin-bottom: 5px;
	}
	.smallList>p {
		margin-bottom:8px;
	}
	.smallList>p>a{
		font-size:15px;
		text-decoration: none;
		display: block;
	}
	/* category end */
		
	/* content start */
	.table{
		margin-top: 30px;
	    border-top: 2px solid #D0A9F5;
	}
	.table tr{
		text-align: center;
	}
	
	tbody td:nth-child(2) {
		text-align: left;
	}
	#search {
		float: right;
	}
	.form-group * {
	    margin: 5px auto 5px auto;
	    height: 33px;
	    padding-top: 1px;
	    padding-bottom: 1px;
	}
	.pagingBox{
		display: flex;
		position: relative;
	}
	.pagination {
		margin: 10px 205px auto 350px;
	}
	#btn-long {
	    margin: 5px auto 5px auto;
	    width: 120%;
	    height: 33px;
	    padding-top: 1px;
	    padding-bottom: 1px;
	}
	/* content end */
		
</style>
<script type="text/javascript">
</script>
</head>
<body>
<%@ include file="../template/header.jspf" %>
<%@ include file="../template/menu.jspf" %>
<div class="container">
	<div class="page-header">
		<p> <a href="../">메인 페이지</a> > 고객센터 > 공지사항 </p>
		<h1>공지사항 <small>욜로와에서 알려드립니다.</small></h1>
	</div>
	<div class="row">
		<div id="category" class="col-md-2">
				<div class="bigList">
					<p>고객센터</p>
					<div class="smallList">
						<p><a href="${pageContext.request.contextPath }/cs-center/notice/">공지사항</a></p>
					</div>
					<div class="smallList">
						<p><a href="${pageContext.request.contextPath }/cs-center/faq/">FAQ</a></p>
					</div>
					<div class="smallList">
						<p><a href="${pageContext.request.contextPath }/cs-center/qna/">Q&amp;A</a></p>
					</div>
				</div>
		</div>
		<div class="col-md-10">
			<form id="search" action="" class="form-inline">
				<div class="form-group">
				    <select name="searchType" class="custom-select">
				      	<option value="subject">제목</option>
						<option value="content">내용</option>
						<option value="all">제목+내용</option>
						<option value="user_name">작성자</option>
				    </select>
				  	<input type="text" class="form-control" placeholder="검색어를 입력하세요" id="inputDefault">
					<input type="button" id="btn-normal" value="검색하기" class="btn btn-primary" />
				</div>
			</form>
			<table class="table">
			  <thead class="thead-light">
			    <tr>
			      <th>글번호</th>
			      <th>제목</th>
			      <th>작성자</th>
			      <th>작성일</th>
			      <th>조회수</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${list }" var="notice">
			    <tr>
			      <td><a href="./detail/${notice.noticeno }">${notice.noticeno }</a></td>
			      <td><a href="./detail/${notice.noticeno }">${notice.title }</a></td>
			      <td><a href="./detail/${notice.noticeno }">${notice.writer }</a></td>
			      <td><a href="./detail/${notice.noticeno }">${notice.writeddate }</a></td>
			      <td><a href="./detail/${notice.noticeno }">${notice.cnt }</a></td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			<div class="pagingBox">
				<div class="paging">
					<ul class="pagination pagination">
					  <li class="page-item"><a class="page-link" href="#">이전</a></li>
					  <li class="page-item"><a class="page-link" href="#">1</a></li>
					  <li class="page-item"><a class="page-link" href="#">2</a></li>
					  <li class="page-item"><a class="page-link" href="#">3</a></li>
					  <li class="page-item"><a class="page-link" href="#">4</a></li>
					  <li class="page-item"><a class="page-link" href="#">5</a></li>
					  <li class="page-item"><a class="page-link" href="#">다음</a></li>
					</ul>
				</div>
				<div class="btnGroup">
				<input type="button" id="btn-long" value="글쓰기" class="btn btn-primary" onClick="location.href='./write'" />
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../template/footer.jspf" %>
</body>
</html>