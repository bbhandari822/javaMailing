<%--
  Created by IntelliJ IDEA.
  User: binodbhandari
  Date: 8/6/17
  Time: 6:08 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Java Mailing WebApplication</title>
</head>

<body>
<form action="EmailSendingServlet" method="post">
    <table border="0" width="35%" align="center">
        <caption><h2>Send New E-mail</h2></caption>
        <tr>
            <td width="50%">Recipient address </td>
            <td><input type="text" name="Email Recepient" size="50"/></td>
        </tr>
        <tr>
            <td>Email Subject </td>
            <td><input type="text" name="Email Subject" size="50"/></td>
        </tr>
        <tr>
            <td>Email Content </td>
            <td><textarea rows="10" cols="39" name="Email Content"></textarea> </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="Submit" value="Send"/></td>
        </tr>
    </table>

</form>
</body>
</html>
