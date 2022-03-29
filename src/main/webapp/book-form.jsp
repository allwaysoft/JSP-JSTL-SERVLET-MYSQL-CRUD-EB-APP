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
        <c:if test="${book != null}">
            <form action="?action=update" method="post">
            </c:if>
            <c:if test="${book == null}">
                <form action="?action=insert" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${book != null}">
                                Edit Book
                            </c:if>
                            <c:if test="${book == null}">
                                Add New Book
                            </c:if>
                        </h2>
                    </caption>
                    <tr>
                        <th>Book ID: </th>
                        <td>
                            <input type="text" name="bid" size="45"
                                   value="<c:out value='${book.bid}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Book Author: </th>
                        <td>
                            <input type="text" name="author" size="45"
                                   value="<c:out value='${book.author}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Book Status: </th>
                        <td>
                            <input type="text" name="status" size="45"
                                   value="<c:out value='${book.status}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Book Title: </th>
                        <td>
                            <input type="text" name="title" size="15"
                                   value="<c:out value='${book.title}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
            </form>
    </div>
</body>
</html>
