<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Song_CRUD</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <center>
        <h1>Song Management</h1>
        <h2>
            <a href="/new">Add New Song</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Songs</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Songs</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Artist_ID</th>
            </tr>
            <c:forEach var="song" items="${listSong}">
                <tr>
                    <td><c:out value="${Song.Song_ID}" /></td>
                    <td><c:out value="${Song.Song_Name}" /></td>
                    <td><c:out value="${Song.Song_Artist}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${Song.Song_ID}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${Song.Song_ID}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/UserServerSongManagement'/>" method="post">
	<input type="submit" value="Song Management"/>
</form>
  </body>
</html>
