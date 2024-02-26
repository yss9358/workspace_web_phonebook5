<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호부</h1>

	<h2>등록폼</h2>

	<p>
		전화번호를 등록하려면<br> 아래 항목을 기입하고 "등록" 버튼을 클릭하세요
	</p>

	<form action="/phonebook5/phone/write2" method="get">
		<div>
			<label>이름(name)</label> <input type="text" name="name" value="">
		</div>

		<div>
			<label>핸드폰(hp)</label> <input type="text" name="hp" value="">
		</div>

		<div>
			<label>회사(company)</label> <input type="text" name="company" value="">
		</div>

		<button type="submit">등록</button>

	</form>

	<br>
	<br>
	<a href="/phonebook5/phone/list">리스트페이지로 이동</a>

</body>
</html>