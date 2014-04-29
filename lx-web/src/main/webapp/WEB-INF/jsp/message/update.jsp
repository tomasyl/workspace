<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="../inc/header.jsp"%>
<html>
    <head>
        <title>修改</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
    </head>
    <body>
            修改<br/>
            =============<br/>
            <form:form method="PUT">
                <form:errors path="*"/><br/>

                <label for="title" class="label">title:</label>
                <form:input path="title"/><br/>

                <label for="body" class="label">title:</label>
                <form:input path="title"/><br/>

                <label for="author" class="label">author:</label>
                <form:input path="author"/><br/>


                <label class="label"/><input type="submit" value="提交"/>&nbsp;<a href="<c:url value="/message"/>">取消</a><br/>
            </form:form>
            =============<br/>
    </body>
</html>
