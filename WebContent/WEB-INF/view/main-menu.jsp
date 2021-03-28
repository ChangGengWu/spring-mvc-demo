<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
		Select File: <input type="file" name="file" id="file"  onchange="ValidateSize(this)" /> <input
			type="submit" value="Upload File" />
	</form>


	<form:form action="login" method="POST" modelAttribute="user">
		<form:input type="text" path="id" />
		<input type="submit" value="登入" />
	</form:form>
	<a href="logout">Log out</a>
	<br> name: ${sessionScope.user.id} status: ${sessionScope.user.id}
	${message}
	<!-- <img src="${pageContext.request.contextPath}/resources/images/p6.png"> -->
	
	
	<form action="redirectTest" mothod="POST">
	<input type="submit">
	</form>
	
	<input type="hidden" name="theReturn" id="theReturn" value="${theReturn}" />
</body>
<script type="text/javascript">
function ValidateSize(file) {
		console.log(file.files[0].size);
        var FileSize = file.files[0].size / 1024 / 1024; // in MiB
        console.log(FileSize);
        if (FileSize > 2) {
            alert('File size exceeds 2 MiB');
            document.getElementById("file").value = "";
        } else {

        }
    }
</script>
<script charset = "UTF-8">
$(document).ready(function(){
	  var modelAttr = $("#theReturn").val();
	  if(modelAttr == "1"){
		  alert("delete");
	  }
	  else if(modelAttr == "2"){
		  alert("update");
	  }
	})
</script>
    
</html>