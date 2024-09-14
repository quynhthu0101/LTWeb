<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/BTLR/login" method="post">
		<h2>Tạo tài khoản mới</h2>
		<c:if test="${alert !=null}">
			<h3 class="alert alertdanger">${alert}</h3>
		</c:if>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fauser"></i></span> <input
						type="text" placeholder="Tài khoản" name="username"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fauser"></i></span> <input
						type="text" placeholder="Mật khẩu" name="password"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fauser"></i></span> <input
						type="checkbox" name="remember" value = "Nhớ tôi"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fauser"></i></span> <input
						type="submit" value="Login"
						class="form-control">
				</div>
			</label>
		</section>
		</form>
</body>
</html>