<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="aducci.core.UserCore" %>



<html>
	<body>
		<table>
			<tr>
				<th>Authorized users</th>
			</tr>
			<%
				List<String> emails = UserCore.GetAuthorizedEmails();
				
				for(int i=0; i<emails.size(); i++)
				{
			%>
			
			<tr>
				<td><%= emails.get(i) %></td>				
			</tr>
			
			<%					
				}
			%>
			<tr>
				<td>
					<form action="/admin/add" method="get">
						<input type="text" name="email">
						<input type="submit" value="add">
					</form>
				</td>
			</tr>
		</table>		
	</body>
</html>