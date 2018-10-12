<html>
<body>
<h2>Hello World! Customermgr</h2>
<%@page import="com.test.architecture1.customermgr.Customer1" %>
<%
	System.out.println("Now in customermgr c1.jsp");
	new Customer1().c1();
%>
</body>
</html>
