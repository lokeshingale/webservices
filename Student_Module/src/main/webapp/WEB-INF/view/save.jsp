<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register</title>
<style>
div{
width:500px;;
height:400px;
border:2px;
background-color:blur blue;
margin-left:350px;
 }
h3{
margin-left:150px;
color:orange;
}
div form{
align:center;
}
.input1{
width:300px;
height:20px;

}
input{
width:150px;
height:30px;
}
h4{
text-align:center;
}
</style>
</head>
<body>
<div>
<h3>Student Registration</h3>
<form action="saveForm" method="post">
<table>
<tr><td>Enter Name:</td><td><input class="input1" type="text" name="name" placeholder="Enter name"></td></tr>
<tr><td>Date of Birth:</td><td><input class="input1" type="date" name="dob" ></td></tr>
<tr><td>Date of joining:</td><td><input class="input1" type="date" name="doj" ></td></tr>
<tr><td></td><td><input type="submit" value="register" ></td></tr>
</table>
</form>

</div>
<h4>${message}</h4>
</body>
</html>