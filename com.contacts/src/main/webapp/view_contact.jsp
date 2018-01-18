<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List" %>
     <%@ page import="java.util.HashMap" %>
    <%@ page import="com.contacts.beans.ContactPhone" %>
    <%@ page import="com.contacts.beans.Contact" %>
    <%@ page import="com.contacts.services.ContactService" %>
    
    <%@ taglib prefix="s" uri="/struts-tags" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Contacts</title>
<script>
function selectRow(x) {
	   // alert("Row index is: " + x.rowIndex);
	    var con=x.getElementsByTagName('input')[0];
	    console.log("Value of hidden :"+ con.getAttribute('value'));
	    
	    var con_id=document.getElementById('contactid');
	    con_id.setAttribute('value',con.getAttribute('value'));
	    console.log(con_id.getAttribute('value'));
	  //  document.getElementById("edit_contact").submit();
	}
	
	function submitAction( button) 
	{
		var txt=button.innerHTML;
		var form=document.getElementById("multiform");
		if(txt.indexOf("Update")>-1)
			{
			form.setAttribute('action','edit_contact');
			form.submit();
			}
		else if(txt.indexOf("Delete")>-1)
			{
			form.setAttribute('action','delete_contact');
			form.submit();
			}
		else
			{
			console.log("Not Valid input");
			}
		console.log(txt);
	
	}

</script>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 50%;
	
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}


#contents {
    text-align:center; // needed if you expect IE 5
	
}

.centered {
    margin:100px auto; // this sets left/right margin to auto and
                     // centers the element
}
a:hover
{
 text-decoration: underline;
font-color: blue;
}
</style>
</head>
<body>
<div id="contents">
<form  id="multiform">
<input type="hidden" name="contactid" id="contactid" value="">
</form>
<button type="button" onclick="submitAction(this)" value="update">Update</button>
<button type="button" onclick="submitAction(this)" value="delete">Delete</button>
<table class="centered">
<tr>
<th>contact name</th>
<th>Email Id</th>
<th>Phone Number</th>
</tr>
 <s:set var="conservice" value="conservice" /> 
 <jsp:useBean id="conservice" type="com.contacts.services.ContactService" /> 

  <%
List<Contact> contacts=conservice.getAllContacts(Long.parseLong((String)session.getAttribute("userid")));
  HashMap<Long,ContactPhone> phones=conservice.getAllPhones(Long.parseLong((String)session.getAttribute("userid")));
for(Contact contact : contacts)
{
	ContactPhone phone=phones.get(contact.getContactid());
%>
<tr onclick="selectRow(this)">
<input type="hidden" name="id" value=<%= contact.getContactid() %> />
<td rowspan=<%= phone.getPhoneid().size() %>><input type="hidden" name="contact_id" value=<%= contact.getContactid() %>/>  <%=contact.getName() %></td>
<td rowspan=<%= phone.getPhoneid().size() %>><%= contact.getEmailid() %></td>
<%

if(phone.getPhoneid().size()>0)
{
	List<Long> phid=phone.getPhoneid();
	List<String> ph=phone.getPhonenumber();
	
	for(int count=0;count<phone.getPhoneid().size();count++){
		if(count==0)
		{
		%>
		<td><%= ph.get(count)%></td>
		</tr>
		<%
		}
		else
		{
		%>
		<tr>
		<td><%= ph.get(count) %>
		</td>
		</tr>
		<%
		}
	}
}
%>

<%} %>

</table>

<a href="home">Back</a>
</div>
</body>
</html>