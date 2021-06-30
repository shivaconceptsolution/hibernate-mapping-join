<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="org.hibernate.cfg.*"%>
<%@page import="org.hibernate.*"%>
<%@page import="java.util.*" %>
<%@page import="dal.*" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml"); 

SessionFactory factory = cfg.buildSessionFactory();
Session sess = factory.openSession();		

Query qry= sess.createQuery("select v.vendorid,v.vendorname,c.custid, c.custname from Vendor v Inner Join v.chidren c");

List l = qry.list();
Iterator it=l.iterator();

while(it.hasNext())
{
	Object rows[] = (Object[])it.next();
	out.println(rows[0]+ " -- " +rows[1] + rows[2] + "....."+rows[3]+"<br>");
}
sess.close();
factory.close();

%>
</body>
</html>