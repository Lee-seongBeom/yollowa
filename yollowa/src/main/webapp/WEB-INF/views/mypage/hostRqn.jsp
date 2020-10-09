<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YOLLOWA</title>
<%@ include file="../template/head.jspf"%>
<style type="text/css">
ul {
	list-style: none;
}

.mypageLink {
	color: black;
	text-decoration: none;
}

.mypageLink:hover {
	color: black;
	text-decoration: none;
}

.row {
	font-size: 1.000rem;
}

.card {
	border-radius: 5px;
}

.card-link {
	display: block;
	color: #433387;
}

.card-link:hover {
	color: #433387;
}
</style>
<script type="text/javascript">
	$(function() {
		$('.card-body p>a').on('mouseenter', function() {
			$(this).css('color', '#C6BFE7');
		}).on('mouseleave', function() {
			$(this).css('color', '#433387');
		});

	});
</script>
</head>
<body>
	<%@ include file="../template/header.jspf"%>
	<%@ include file="../template/menu.jspf"%>
	<div class="container">
		<div class="page-header">
			<p>메인 페이지 > 마이 페이지 > 사업자 등록</p>
			<h1>
				<a class="mypageLink"
					href="${pageContext.request.contextPath }/mypage/">사업자 등록</a> <small>
					욜로와가 여러분을 도와드리겠습니다</small>
			</h1>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="card border-primary mb-3" style="max-width: 20rem;">
					<div class="card-header bg-primary">
						<a class="card-link" style="color: white;"
							href="${pageContext.request.contextPath }/mypage/">> 마이페이지</a>
					</div>
					<div class="card-body">
						<p class="card-text">
							<a class="card-link"
								href="${pageContext.request.contextPath }/mypage/">예약 현황</a>
						</p>
						<p class="card-text">
							<a class="card-link"
								href="${pageContext.request.contextPath }/mypage/completed">이용
								내역</a>
						</p>
						<p class="card-text">
							<a class="card-link"
								href="${pageContext.request.contextPath }/mypage/cart">장바구니</a>
						</p>
						<p class="card-text">
							<a class="card-link"
								href="${pageContext.request.contextPath }/mypage/wishlist">찜
								목록</a>
						</p>
					</div>
				</div>
				<div class="card border-secondary mb-3" style="max-width: 20rem;">
					<div class="card-header bg-secondary" style="color: white;">>
						내가 쓴 글</div>
					<div class="card-body">
						<p class="card-text">
							<a class="card-link"
								href="${pageContext.request.contextPath }/mypage/myreview">내가
								쓴 리뷰</a>
						</p>
						<p class="card-text">
							<a class="card-link"
								href="${pageContext.request.contextPath }/mypage/qna">내가 쓴
								Q&A</a>
						</p>
						<p class="card-text">
							<a class="card-link"
								href="${pageContext.request.contextPath }/mypage/userinfo">내
								정보</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<c:if test="${bean.user_level eq 0}">
				<div class="jumbotron">
					<h3>사업자 여러분을 환영합니다!!</h3>
					<p class="lead">
					${bean.user_name } 씨 함께 할 수 있게 되어 기뻐요.<br/> 
					저희는 ${bean.user_name } 씨와 함께 할 수 있기를 기다리고 있었답니다.<br/>
					그럼 정식으로 파트너 사업주의 권한을 얻기 위해서 다음의 신청 절차를 진행해주세요.
					</p>
					<hr class="my-4">
					<p>
					<h4>신청 방법</h4>
					<p class="lead">
					신청 양식을 작성한 후 신청하기를 누르면 다음 페이지로 넘어갑니다.<br/>
					다음 페이지에서는 신청서 파일을 다운 받으실 수 있습니다.<br/>
					해당 신청서를 작성 후 이메일이나 Fax를 통해 보내주셔야 정식 접수가 됩니다.<br/>
					이메일 : partner@yollowa.com | Fax : 02-6007-0000<br/>
					<br/>
					신청 처리에는 1~3일이 소요됩니다. 파트너 센터: 02-3486-0000
					</p>
					<h4>신청서</h4>
					<form method="post" action="${pageContext.request.contextPath }/mypage/hostRqn/applyed">
						<div class="form-group">
						  <fieldset disabled="disabled">
						    <label class="control-label" for="disabledInput">신청자</label>
						    <input class="form-control" id="disabledInput" type="text" placeholder="신청인을 입력하세요" disabled="disabled" value="${bean.user_name }"/>
						  </fieldset>
						</div>
					 	<input type="hidden" name="user_number" value="${bean.user_number }" />
						<div class="form-group">
						  <label class="col-form-label" for="user_companyNumber">사업자 번호</label>
						  <input type="text" name="user_companyNumber" class="form-control" placeholder="사업자 번호를 입력하세요" id="user_companyNumber">
						</div>
						<div class="form-group">
						  <label class="col-form-label" for="user_companyName">업소명</label>
						  <input type="text" name="user_companyName" class="form-control" placeholder="영업소 이름을 입력하세요" id="user_companyName">
						</div>
						<button type="submit" class="btn btn-primary btn-lg">신청하기</button>
					
					</form>
				</div>
				</c:if>
				<c:if test="${user_level eq 9}">>
					<div class="jumbotron">
					<h3>신청이 완료되었습니다!!</h3>
					<p class="lead">
					@@@@@@
					</p>
					<hr class="my-4">
					<p>
					<h4>@@@@@@</h4>
					<p class="lead">
					<br/>
					신청 처리에는 1~3일이 소요됩니다. 파트너 센터: 02-3486-0000
					</p>
					<p class="lead">
						<a class="btn btn-primary btn-lg" href="#" role="button">Learn
							more</a>
					</p>
				</div>
				</c:if>
			</div>
		</div>

	</div>
	<%@ include file="../template/footer.jspf"%>
</body>
</html>