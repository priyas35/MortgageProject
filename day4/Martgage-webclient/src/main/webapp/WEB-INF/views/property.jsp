<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div align="center">
        <h1>New Applicant</h1>
        <form:form action="propertyform" method="post" modelAttribute="property">
        <table>
            
                
                <form:hidden path="id" />
            
        
            <tr>
                <td>Property Type</td>
                <td><form:input path="propertytype" /></td>
            </tr> 
            <tr>
                <td>Property Worth:</td>
                <td><form:input path="propertyworth" /></td>
            </tr>
            <tr>
                <td>Loan Amount:</td>
                <td> <form:input path="loanamount" />
                </td>
            </tr>
            <tr>
                <td>Property Weight:</td>
                <td><form:input path="propertyweight" /></td>
            </tr>
            <tr>
                <td>No of Year:</td>
                <td><form:input path="lyear" /></td>
            </tr> 
            
          
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>

</body>
</html>