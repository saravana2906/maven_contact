<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>
body {
    width: 100%;
}
fieldset {
position: block ;
  height: 50%;
  width: 50%;
  background: #ffffff;
  margin-top: 100px;
  margin-right: 100px;
  margin-bottom: 100px;
  margin-left: 300px;
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
  margin-top: 75px;
  } 
  #btn-grp
  {
  text-align: center;
  margin: 10px 10px 10px 50px;
  }
</style>
</head>
<s:head/>
<body>
<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
  <s:form action="login_action">
<s:textfield name="login.emailid"  label ="Email id"/> 
<s:password name="login.password"  label ="Password"/> 
 <s:submit value="Sign In" />
 </s:form>
  <a href="signup.jsp">Sign Up</a>
</body>
</html>