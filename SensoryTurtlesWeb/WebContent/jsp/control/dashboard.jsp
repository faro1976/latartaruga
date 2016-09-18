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
    
    <!-- Boostrap player buttons -->
    <link href="../../css/font-awesome.min.css" rel="stylesheet">
	<script src="../../js/d3.min.js"></script>    

	<!-- JQuery -->
	<script src="../../js/jquery-3.1.0.min.js"></script>	

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<script type="text/javascript" src="../../js/jquery-ui.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
        
	<!-- toogle -->
	<link href="../../css/bootstrap-toggle.min.css" rel="stylesheet">
	<script src="../../js/bootstrap-toggle.min.js"></script>
	
	
	<!-- media player buttons -->
	<style type="text/css">
		.player{
  			margin: 50px 0;
		}
	</style>	

  </head>

  <body>
	 <div class="container-fluid">
	     <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	       <h1 class="page-header">Sensory Turtles Dashboard</h1>
	     </div>
  
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-4">
	  			<label for="usr">File full path:</label>
	  			<input type="text" class="form-control" id="filefullpath" value="IMG_0022.MOV" >
			</div>
	  		<div class="col-xs-12 col-md-8">  		  			
					    <button type="button" id="button_fbw" class="btn" onclick='buttonRewindPress()'>
					      <i class="fa fa-fast-backward"></i>
					    </button>
					    
					    <button type="button" id="button_bw" class="btn" onclick='buttonBackPress()'>
					      <i class="fa fa-backward"></i>
					    </button>
					    
					    <button type="button" id="button_play" class="btn" onclick='buttonPlayPress()'>
					      <i class="fa fa-play"></i>
					    </button>
					    
					    <button type="button" id="button_stop" class="btn" onclick='buttonStopPress()'>
					      <i class="fa fa-stop"></i>
					    </button>
					    
					    <button type="button" id="button_fw" class="btn" onclick='buttonForwardPress()'>
					      <i class="fa fa-forward"></i>
					    </button>
					    
					    <button type="button" id="button_ffw" class="btn" onclick='buttonFastforwardPress()'>
					      <i class="fa fa-fast-forward"></i>
					    </button>    
			</div>		
		</div>

		<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-8">
				<div id="switchesDiv" />  
			</div>
		</div>
	
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-8">
				<div id="rgbControllersDiv" />  
			</div>
		</div>
	</div>

<div class="row">
  <div class="col-xs-12 col-sm-6 col-md-8">Example: Mobile, tablet, desktop<BR/>.col-xs-12 .col-sm-6 .col-md-8</div>
  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
</div>
<div class="row">
  <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
  <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
  <!-- Optional: clear the XS cols if their content doesn't match in height -->
  <div class="clearfix visible-xs-block"></div>
  <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
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
		              	+ '<code style="color:red">'+val['code']+'#'+val['description']+'</code>';		              	
					
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
		
		
		
		//media player buttons
		function startMPlayer(file){
			$.ajax({
				  url: "/SensoryTurtlesWeb/rest/MPlayerResource/start",
				  data: {  
					'file': file
				   },
				}).done(function(data) {
				  console.log(data);
			}); 						
		}
		
		function invokeMPlayer(cmd){
			$.ajax({
				  url: "/SensoryTurtlesWeb/rest/MPlayerResource/invoke",
				  data: {  
					'cmd': cmd
				   },
				}).done(function(data) {
				  console.log(data);
			}); 						
		}

		var state = 'stop';
		
		function buttonBackPress() {
		    console.log("button back invoked.");
		    invokeMPlayer("REWIND");
		}
		
		function buttonForwardPress() {
		    console.log("button forward invoked.");
		    invokeMPlayer("FF");		    
		}
		
		function buttonRewindPress() {
		    console.log("button rewind invoked.");
//		    invokeMPlayer("REWIND");		    
		}
		
		function buttonFastforwardPress() {
		    console.log("button fast forward invoked.");
//		    invokeMPlayer("FF");		    
		}
		
		function buttonPlayPress() {
		    if(state=='stop'){
		      state='play';
		      var button = d3.select("#button_play").classed('btn-success', true); 
		      button.select("i").attr('class', "fa fa-pause");
			  startMPlayer($("#filefullpath").val());
		    }
		    else if(state=='play' || state=='resume'){
		      state = 'pause';
		      d3.select("#button_play i").attr('class', "fa fa-play");
			  invokeMPlayer("PR");		      
		    }
		    else if(state=='pause'){
		      state = 'resume';
		      d3.select("#button_play i").attr('class', "fa fa-pause");
			  invokeMPlayer("PR");		      
		    }
		    console.log("button play pressed, play was "+state);		    
		}
		
		function buttonStopPress(){
		    state = 'stop';
		    var button = d3.select("#button_play").classed('btn-success', false);
		    button.select("i").attr('class', "fa fa-play");
		    console.log("button stop invoked.");    
		    invokeMPlayer("EXIT");		    		    
		}
	</script>				  
	
  </body>
</html>
