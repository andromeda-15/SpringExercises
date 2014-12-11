<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The View of Product Specification</title>
</head>
<body>
<form:form modelAttribute="product" action="insertDetail" method="post">
    <table>
        <form:input type="hidden" path="pNo" />
        <tr>
             <td>*Product Name</td>
             <td><form:input type="text" path="name"/></td>
        </tr>
        <tr>
             <td>*Description</td>
             <td><form:input type="text" path="description"/></td>
        </tr>
        <tr>
             <td>Category</td>
             <td><form:select items="${categoryList}" path="category"/></td>
        </tr>
    </table>    
    <button type="submit" formaction="${pageContext.request.contextPath}/hello" formmethod="post" onclick="return doConfirm()">存檔</button>
	<button	type="button" onclick="goBack()">回上一頁</button>
</form:form>
</body>
	<script>	
		function doConfirm() {
			return confirm("確定存檔嗎 ?");
		}
		function goBack() {
		    window.history.back()
		}
	</script>
</html>