<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Register</title>
        </head>
        <body>
        	<center>  
			  <br /> <br /> <br /> <b>Spring MVC Login | Registration Form </b> <br />  
			  <br />  
		  	</center>
            <form:form id="registerForm" modelAttribute="register" action="register.htm" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="username">Username: </form:label>
                        </td>
                        <td>
                            <form:input path="username" name="username" id="username" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password:</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                    </tr>
                     <tr>
                        <td>
                            <form:label path="firstName">First Name:</form:label>
                        </td>
                        <td>
                            <form:input path="firstName" name="firstName" id="firstName" />
                        </td>
                    </tr>
                     <tr>
                        <td>
                            <form:label path="lastName">Last Name:</form:label>
                        </td>
                        <td>
                            <form:input path="lastName" name="lastName" id="lastName" />
                        </td>
                    </tr>
                     <tr>
                        <td>
                            <form:label path="email">Email id:</form:label>
                        </td>
                        <td>
                            <form:input path="email" name="email" id="email" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="location">Location:</form:label>
                        </td>
                        <td>
                            <form:input path="location" name="location" id="location" />
                        </td>
                    </tr>
                     <tr>
                        <td>
                            <form:label path="phone">Phone:</form:label>
                        </td>
                        <td>
                            <form:input path="phone" name="phone" id="phone" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="left">
                            <form:button id="save" name="save">Save</form:button>
                        </td>
                        <td align="left">
                            <a href="login.htm">Login</a>
                        </td>
                    </tr>
                </table>
            </form:form>
            
            <table align="center">
                <tr>
                    <td style="font-style: italic; color: Green;">${status}</td>
                </tr>
            </table>
        </body>
        </html>
 
