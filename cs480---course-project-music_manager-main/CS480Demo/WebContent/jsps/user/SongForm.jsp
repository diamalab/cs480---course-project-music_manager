<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Song Management Application</title>
</head>
<body>
    <center>
        <h1>Songs Management</h1>
        <h2>
            <a href="/new">Add New Song</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Songs</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${song != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${song == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${song != null}">
                        Edit song
                    </c:if>
                    <c:if test="${book == null}">
                        Add New Song
                    </c:if>
                </h2>
            </caption>
                <c:if test="${song != null}">
                    <input type="hidden" name="id" value="<c:out value='${song.id}' />" />
                </c:if>           
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${song.name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Artist: </th>
                <td>
                    <input type="text" name="artist" size="45"
                            value="<c:out value='${song.artist}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>ID: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${song.id}' />"
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

<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/UserServerSongManagement'/>" method="post">
	<input type="submit" value="Song Management"/>
</form>
  </body>
</html>