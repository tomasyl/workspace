<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="../inc/header.jsp"%>
<html>
    <head>
        <title>列表</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <a href="<c:url value='/message/add'/>">新增</a><br/>
    <table border="1">
        <tr>
                        <th>编号</th>
                        <th>title</th>
                        <th>body</th>
                        <th>author</th>
                      
                        <th>操作</th>
        </tr>
        <c:forEach items="${page.items}" var="t" varStatus="status">
        <tr>
                        <td>${ t.id }</td>
                        <td>${ t.title }</td>
                        <td>${ t.body }</td>
                        <td>${ t.author }</td>
                        
                        <td><a href="<c:url value='/message/${t.id}/delete'/>">删除</a>|<a href="<c:url value='/message/${t.id}/update'/>">修改</a></td>
        </tr>
        </c:forEach>
    </table>
    <common:pageV2 url="/message" optimize="true"/>
    </body>
</html>
