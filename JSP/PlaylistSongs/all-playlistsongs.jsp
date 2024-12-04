<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>All PlaylistsSongs</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

  </head>
  
  <body>
    <br>
    <form action="<c:url value='/findAll'/>" method="post">
    	<input type="hidden" name="playlist_songs_id"   value=${sessionScope.session_user.playlist_songs_id }/>
    	<input type="submit" value="List All PlaylistSongs"/>
    </form>
  </body>
</html>