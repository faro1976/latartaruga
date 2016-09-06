<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
	<!-- JQuery -->
	<script src="../../js/jquery-3.1.0.min.js"></script>	
    <!-- color picker -->
	<script type="text/javascript" src="../../js/jquery.wheelcolorpicker-2.5.1.min.js"></script>
	<link type="text/css" rel="stylesheet" href="../../css/wheelcolorpicker.css" />
	<style>
		.circle {
			width:1%;
			padding:10px 11px;
			margin:0 auto;
			border:2px solid #a1a1a1;
			border-radius:50%;		
		}	
	</style>
</head>

<body>
	<div id="snippet-block">
		<input id="<%=request.getParameter("idZWave") %>" type="text" data-wheelcolorpicker data-wcp-layout="block" />	
		<b><%=request.getParameter("description") %></b>
		<code style="color:red"><%=request.getParameter("code") %>#<%=request.getParameter("idZWave") %></code>
		<div id='<%=request.getParameter("idZWave") %>-colordiv' class="circle" style="display:inline"/>				
	</div>

<script>
	$('#<%=request.getParameter("idZWave")%>').on('slidermove', function() {
		var hexColor = $(this).prop('value');
		console.log('Color of ZWave id <%=request.getParameter("idZWave") %>: ' + hexColor);
		$('#<%=request.getParameter("idZWave") %>-colordiv').css('background-color', '#'+hexColor);
		
		$.ajax({
			  url: "/SensoryTurtlesWeb/rest/ZWaveDeviceResource/invoke",
			  data: { 
				'devId': '<%=request.getParameter("idZWave") %>', 
				'cmd': $(this).prop('value')
			   },
			}).done(function(data) {
			  console.log(data);
		});						
	});
</script>	
	
</body>

</html>
