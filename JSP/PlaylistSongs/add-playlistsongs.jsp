<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Add PlaylistSongs</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
  </head>
  
  <body>
  <h1>Add PlaylistSongs</h1>
<p style="color: blue; font-weight: 900">${msg }</p>
<form action="<c:url value='/PlaylistSongsServletAdd'/>" method="post">
	<input type="hidden" name="method" value="add"/>
	<input type="hidden" name="playlist_songs_id" value=${sessionScope.session_user.playlist_songs_id }/>
	
	PlaylistSongs ID:    :<input type="text" name="user_id" value="${form.playlist_songs_id }"/> 
	<br/>
	Playlist Id    :<input type="text" name="symbol" value="${form.playlist_id }"/>
	<span style="color: red; font-weight: 900">${errors.playlist_name }</span>
	<br/>
	Song ID  :<input type="text" name="quantity" value="${form.song_id }"/>
	<span style="color: red; font-weight: 900">${errors.user_id }</span>
	<br/>
	<input type="submit" value="Add"/>
</form> 
  </body>
</html>