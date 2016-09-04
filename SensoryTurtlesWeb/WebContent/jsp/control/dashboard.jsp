<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../img/favicon.ico">

    <title>Dashboard for LaTartarugaOnlus</title>

    <!-- Bootstrap core CSS -->
    <link href="../../css/bootstrap.css" rel="stylesheet">

    <!-- Boostrap dashboard -->
    <link href="../../css/dashboard.css" rel="stylesheet">

	<!-- JQuery -->
	<script src="../../js/jquery-3.1.0.min.js"></script>	

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<script type="text/javascript" src="../../js/jquery-ui.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
        
	<!-- toogle -->
	<link href="../../css/bootstrap-toggle.min.css" rel="stylesheet">
	<script src="../../js/bootstrap-toggle.min.js"></script>	

  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>


    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Cruscotto <span class="sr-only">(current)</span></a></li>
            <li><a href="#">Illuminazione</a></li>            
            <li><a href="#">Prese</a></li>
            <li><a href="#">Multimedia</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item</a></li>
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
            <li><a href="">More navigation</a></li>
          </ul>
        </div>
        
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Dashboard</h1>

		<div class="row">
			<div class="col-xs-10 col-sm-2 ">
				<div id="rgbControllersDiv" />											
            </div>
			<div class="col-xs-10 col-sm-2 ">
				<div id="switchesDiv" />							
            </div>
            
		</div>



	<script>

		var jsonData = $.ajax({
			url: '/SensoryTurtlesWeb/rest/ZWaveDeviceResource/readList',
			    dataType: 'json',
			}).done(function (data) {
				
			
			for (var key in data) {
				var val = data[key];
				console.log(val['description']);
				
		              	
				if (val['className']=='it.latartaruga.sensoryturtles.vo.ControllerRGBVO') {
/*					var rgbContentString = '<input id=\"zwave-'+val['idZWave']+'\" type=\"text\" data-wheelcolorpicker data-wcp-layout=\"popup\" />'	
				          	+ '<h4>'+val['description']+'</h4>'
			              	+ '<span class=\"text-muted\">'+val['code']+'#'+val['idZWave']+'</span>'
			              	+ '<img id="'+$(this).prop("id")+'-color" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">'
					$('#rgbControllersDiv').append(rgbContentString);*/
					var iframe = document.createElement('iframe');
			        var rgbPageUrl = "colorPicker.jsp?idZWave=zwave-"+val['idZWave']+"&code="+val['code']+"&description="+val['description'];					
					iframe.setAttribute("src", rgbPageUrl);
					iframe.setAttribute("width", 500);
					iframe.setAttribute("height", 230);
					iframe.setAttribute("border", 0);					
					document.getElementById("rgbControllersDiv").appendChild(iframe);
					
/*					$('#zwave-'+val['idZWave']).on('slidermove', function() {
						console.log('Color of ZWave id '+$(this).prop('id')+': ' + $(this).prop('value'));
						$($(this).prop("id")+'-colordiv').css('background-color','red');
						
						$.ajax({
							  url: "../../rest/ZWaveDeviceResource/invoke",
							  data: { 
								'devId': $(this).prop("id"), 
								'cmd': $(this).prop('value')
							   },
							}).done(function(data) {
							  console.log(data);
						});						
					});*/
				} else if (val['className']=='it.latartaruga.sensoryturtles.vo.RelayVO') {
					var switchesContentString = '<input id=\"zwave-'+val['idZWave']+'\"  type=\"checkbox\" checked data-toggle=\"toggle\" data-size=\"large\" data-on=\"'+val['description']+' On\" data-off=\"'+val['description']+' Off\" data-onstyle=\"success\" data-offstyle=\"danger\">'
			          	+ '<b>'+val['description']+'</b>'
		              	+ '<code style="color:red">'+val['code']+'#'+val['idZWave']+'</code>';		              	
					
					$('#switchesDiv').append(switchesContentString);  	
		              	
					$('#zwave-'+val['idZWave']).change(function() {
						console.log('Switch of ZWave id '+$(this).prop('id')+': ' + $(this).prop('checked'));
						
						$.ajax({
							  url: "/SensoryTurtlesWeb/rest/ZWaveDeviceResource/invoke",
							  data: { 
								'devId': $(this).prop("id"), 
								'cmd': $(this).prop('checked')
							   },
							}).done(function(data) {
							  console.log(data);
						}); 					
						
					});						
				}
			}
				
		});		
	</script>				  
	
  </body>
</html>
