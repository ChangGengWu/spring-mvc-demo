<!DOCTYPE html>

<html>
<body>

	<h2>Spring MVC demo</h2>

	<a href="hello/showForm">Hello World form</a>

	<br>
	<br>

	<a href="student/showForm">Student form</a>

	<br>
	<br>

	<a href="customer/showForm">Customer form</a>

	<a href="customer/showForm"
		onclick="if (!confirm('Continue?')) { return false; }">Customer</a>

	<form action="savefile" method="POST" enctype="multipart/form-data">
		Select File: <input type="file" name="file" /> <input type="submit"
			value="Upload File" />
	</form>
	<!-- <img src="${pageContext.request.contextPath}/resources/images/p6.png"> -->
</body>

</html>