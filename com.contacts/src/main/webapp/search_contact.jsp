<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Contact</title>
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
</head>
<body>
<form>
 <fieldset>
  <legend>Search Page</legend>
  <div id="content">
  Contact Name: <input type="text" name="username" id="username" /><br> OR <br>
  Email id: <input type="text" name="emailid" id="emailid" /><br> OR <br>
  Phone No: <input type="text" name="phone" id="phone" /><br>
  
  <div id="btn-grp">
  <input type="submit"  value="Search" />
      </div>
</div>
 </fieldset>
</form>
</body>
</html>