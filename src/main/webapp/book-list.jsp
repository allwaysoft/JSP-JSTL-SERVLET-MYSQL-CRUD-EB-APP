<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Book Management Application</title>
    </head>
    <body>
    <center>
        <h1>Book Management</h1>
        <h2>
            <a href="?action=new">Add New Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="?action=list">List All Books</a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Author</th>
                <th>Status</th>
                <th>Title</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="book" items="${listBook}">
                <tr>
                    <td><c:out value="${book.bid}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.status}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td>
                        <a href="?action=edit&bid=<c:out value='${book.bid}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="?action=delete&bid=<c:out value='${book.bid}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
