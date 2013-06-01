<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="aducci.business.user.Authentication" %>
<%@ page import="aducci.business.user.LoginState" %>

<html>
	<body>
		<%
			LoginState state = Authentication.GetLoginState();			
			
			if(state == LoginState.notLoggedIn) {	
				out.println("<a href=\"" + UserServiceFactory.getUserService().createLoginURL("/") + "\">Login</a>");
			}
			else {	
				out.println("<a href=\"" + UserServiceFactory.getUserService().createLogoutURL("/") + "\">Logout</a>");				
			}
		%>
		
		<br/>
		
		
		<form name="gameForm" action="/game" method="get" >    	
			<input type="text" name="gameid" >
    		<input type="submit" >
		</form>
		
		<form name="gameForm" action="/game/create" method="post" >    	
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="gameid" ></td>
				</tr>
				<tr>
					<td>Player1</td>
					<td><input type="text" name="player1" ></td>
				</tr>
				<tr>
					<td>Player2</td>
					<td><input type="text" name="player2" ></td>
				</tr>
    			<tr>					
					<td colspan="2"><input type="submit" ></td>
				</tr>
    		</table>
		</form>
	</body>
</html>