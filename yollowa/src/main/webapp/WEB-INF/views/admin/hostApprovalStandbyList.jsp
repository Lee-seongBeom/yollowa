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
		<p> <a href="../">메인 페이지</a> > 관리자 페이지 > 임시 </p>
		<h1>관리자 <small>임시페이지</small></h1>
	</div>
	<div class="row">
		<div id="category" class="col-md-2">
				<div class="bigList">
					<p>파트너 회원 관리</p>
					<div class="smallList">
						<p><a href="${pageContext.request.contextPath }/admin/hostApprovalStandbyList">사업자 승인</a></p>
					</div>
					<div class="smallList">
						<p><a href="${pageContext.request.contextPath }/admin/postApproval">POST  승인</a></p>
					</div>
					<p>자사 사원 관리</p>
					<div class="smallList">
						<p><a href="${pageContext.request.contextPath }/admin/adminList">관리자 관리</a></p>
					</div>
				</div>
		</div>
		<div class="col-md-10">
			<form id="search" action="" class="form-inline">
				<div class="form-group">
				    <select name="searchType" class="custom-select">
				      	<option value="subject">회원번호</option>
				      	<option value="subject">아이디</option>
						<option value="content">이름</option>
						<option value="all">전화번호</option>
						<option value="user_name">이메일</option>
				    </select>
				  	<input type="text" class="form-control" placeholder="검색어를 입력하세요" id="inputDefault">
					<input type="button" id="btn-normal" value="검색하기" class="btn btn-primary" />
				</div>
			</form>
			<table class="table">
			  <thead class="thead-light">
			    <tr>
			      <th>회원번호</th>
			      <th>아이디</th>
			      <th>이름</th>
			      <th>전화번호</th>
			      <th>이메일</th>
			      <th>사업자등록번호</th>
			      <th>상호</th>
			      <th>권한</th>
			      <th>승인</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${list }" var="user">
			    <tr>
			      <td>${user.user_number }</td>
			      <td>${user.user_id }</td>
			      <td>${user.user_name }</td>
			      <td>${user.user_phoneNumber }</td>
			      <td>${user.user_email }</td>
			      <td>${user.user_companyNumber }</td>
			      <td>${user.user_companyName }</td>
			      <td>${user.user_level }</td>
			      <td><a href="./hostApproval/${user.user_number }">승인하기</a></td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			<div class="pagingBox">
				<div class="paging">
					<ul class="pagination">
						<c:if test="${paging.prev }">
						 <li class="page-item"><a class="page-link" href="?page=${paging.startPage - 1 }">이전</a></li>
						</c:if>
						<c:forEach begin="${paging.startPage }" end="${paging.endPage }" varStatus="status">
							<li class="page-item"><a class="page-link" href="?page=${status.index }">${status.index }</a></li>
						</c:forEach>
						<c:if test="${paging.next && paging.endPage > 0 }">
							<li class="page-item"><a class="page-link" href="?page=${paging.endPage + 1 }">다음</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../template/footer.jspf" %>
</body>
</html>