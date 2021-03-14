<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title> Student Confirmation</title>
</head>

<body>
	
	The student is confirm: ${student.firstName} ${student.lastName}
	
	<br><br>
	
	Country: ${student.country}
	
	<br><br>
	
	Language: ${student.favoriteLanguage}
	
	<br><br>
	
	Operating Systems: 
	
	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}">
			<li> ${temp} </li>
		</c:forEach>
	</ul>
	
	
	
	
	${student.favoriteLanguage}
</body>

</html>