<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Page</title>
<style>
body {
    width: 100%;
}
fieldset {
position: block ;
  height: 50%;
  width: 50%;
  background: #ffffff;

  margin-left: 300px;
  margin-top: 100px;
  text-align: center;
}
fieldset input {
  text-align: center;
  margin: 10px 10px 10px 10px;
  }
   #content
  {
  position: block ;
  text-align: center;
  margin-top: 10px;
  } 
  #btn-grp
  {
  text-align: center;
  margin: 10px 10px 10px 50px;
  }
</style>
<s:head />
</head>
<body>
<s:form action="signup_action">
 
<h3>Sign Up Form</h3>
  <div id="content">
  <!-- User name: <input type="text" name="signup.username" id="username" /><br>
  Email id: <input type="text" name="signup.emailid" id="emailid" /><br>
  Phone No: <input type="text" name="signup.phoneno" id="phone" /><br>
  Password: <input type="password" name="signup.password" id="password" /><br>
  Confirm Password: <input type="password" name="signup.confirmpassword" id="confirmpassword" /><br> -->
  
  <s:textfield name="signup.username"  label ="User name"/> 
  <s:textfield name="signup.emailid"  label ="Email id"/> 
  <s:textfield name="signup.phoneno"  label ="Phone No"/> 
  <s:password name="signup.password"  label ="Password"/> 
  <s:password name="signup.confirmpassword"  label ="Confirm Password"/> 
  
  <div id="btn-grp">
<s:submit value="Sign Up" />
<!--    <input type="button" name="Sign Up" value="Sign up" /> -->
   </div>
</div>
 
</s:form>
</body>
</html>