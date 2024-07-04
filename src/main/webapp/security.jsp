<% 
String check = (String) session.getAttribute("admin"); 
if(check==null) 
{ 
response.sendRedirect("admin.jsp"); 
return; 
} 
%>