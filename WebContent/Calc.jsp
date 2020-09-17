<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script 
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/Style.css">

</head>
<body>
	<div class="container">

		<jsp:useBean id="calc" class="atj.Calculator" scope="session"></jsp:useBean>

		<form method="post">
			<table>
				<tr>
					<td colspan="4" class="display">${calc.result}</td>
				</tr>
				<tr>
					<td><input type="submit" name="btn" value="C" class="btn btn-danger button"></td>
					<td><input type="submit" name="action" value="/" class="btn btn-info button"
						${ hide ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="action" value="*" class="btn btn-info button"
						${ hide ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="action" value="sqrt" class="btn btn-info button"
						${ hide ? 'disabled="disabled"' : ''}></td>
				</tr>
				<tr>
					<td><input type="submit" name="btn" value="7" class="btn btn-light button"
						${ hide ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="btn" value="8" class="btn btn-light button"
						${ hide ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="btn" value="9" class="btn btn-light button"
						${ hide ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="action" value="-" class="btn btn-info button"
						${ hide ? 'disabled="disabled"' : ''}></td>
				</tr>
				<tr>
					<td><input type="submit" name="btn" value="4" class="btn btn-light button"
						${ hide ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="btn" value="5" class="btn btn-light button"
						${ hide ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="btn" value="6" class="btn btn-light button"
						${ hide ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="action" value="+" class="btn btn-info button"
						${ hide ? 'disabled="disabled"' : ''}></td>
				</tr>
				<tr>
					<td><input type="submit" name="btn" value="1" class="btn btn-light button"
						${ hide ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="btn" value="2" class="btn btn-light button"
						${ hide ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="btn" value="3" class="btn btn-light button"
						${ hide ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="action" value="%" class="btn btn-info button"
						${ hide ? 'disabled="disabled"' : ''}></td>
				</tr>
				<tr>
					<td><input type="submit" name="action" value="+/-" class="btn btn-light button"
						${ hide ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="btn" value="0" class="btn btn-light button"
						${ hide ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="btn" value="." class="btn btn-light button"
						${ hideComma ? 'disabled="disabled"' : ''}></td>
					<td><input type="submit" name="equals" value="=" class="btn btn-success button"
						${ hide ? 'disabled="disabled"' : ''}></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>