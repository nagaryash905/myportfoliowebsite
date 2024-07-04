<% 
	String message = (String)session.getAttribute("msg");
	if(message!=null)
	{
		if(message.contains("Successfully"))
		{
%>
	<span style="color: #5600E8"><%=message %></span>
	
<%
		}
		else
		{
			%>
			<span style="color: red"><%=message %></span>
			<%
			}
		%>
<% 		
		}
	session.removeAttribute("msg");
%>	