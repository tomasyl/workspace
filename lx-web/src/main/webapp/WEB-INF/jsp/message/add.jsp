<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>新增</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
    </head>
    <body>
            新增<br/>
            =============<br/>
            <form:form method="POST" >
                <form:errors path="*" cssStyle="font-color:red"/><br/>

                <label for="title" class="label">title:</label>
                <form:input path="title"/><br/>

                <label for="body" class="label">body:</label>
                <form:input path="body"/><br/>

                <label for=author class="label">author:</label>
                <form:input path="author"/><br/>


                

               <label class="label"/><input type="submit" value="提交"/>&nbsp;<a href="<c:url value="/message"/>">取消</a><br/>
            </form:form>
            =============<br/>
    </body>
</html>
