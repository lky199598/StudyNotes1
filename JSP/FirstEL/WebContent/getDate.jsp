<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>



<%-- <jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd  HH:mm:ss" var="today"/>
<fmt:formatDate value="${date}" type="both" dateStyle="long" pattern="yyyy-MM-dd  HH:mm:ss" var="date"/>
 --%>
${today }
${date }
${ date > today }

</body>
</html>