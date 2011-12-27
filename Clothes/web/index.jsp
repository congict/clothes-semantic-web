<%-- 
    Document   : index
    Created on : Dec 11, 2011, 9:02:37 PM
    Author     : psychok7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World2!</h1>
        
        <form id="login-form" action="/Clothes/servlet/servlets.AuthenticationServlet" method="post">
                        <input type="hidden" id="hidMethod" name="hidMethod" value="login"/>
                        <fieldset>
                            <label>Email</label>
                            <div class="clear"></div>
                            <input class="auth" type="text" id="e-mail" name="e-mail"/>
                            <div class="clear"></div>
                            <label>Password</label>
                            <div class="clear"></div>
                            <input class="auth" type="password" id="password" name="password"/>
                            <div class="clear"></div>
                            <input type="submit" class="button" name="commit" value="Login"/>	
                            <div class="clear"></div>
                        </fieldset>
        </form>
        
        
        
    </body>
</html>
