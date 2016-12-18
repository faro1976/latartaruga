<%@page import="it.latartaruga.sensoryturtles.util.PropertiesHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/favicon.ico">

    <title>Dashboard Sensory Turtles</title>

	<!-- sensory turtles js -->
	<script src="../js/sensoryturtles.js"></script>	

	<!-- JQuery -->
	<script src="../js/jquery-3.1.0.min.js"></script>
	<!-- JQuery UI -->
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>	

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.css" rel="stylesheet">

	<!-- Bootstrap core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>
        
    <!-- Boostrap player buttons -->
    <link href="../css/font-awesome.min.css" rel="stylesheet">
	<script src="../js/d3.min.js"></script>    
	<!-- media player buttons -->
	<style type="text/css">
		.player{
  			margin: 50px 0;
		}
	</style>	

	<!-- toogle buttons -->
	<link href="../css/bootstrap-toggle.min.css" rel="stylesheet">
	<script src="../js/bootstrap-toggle.min.js"></script>
		

  </head>

  <body>
	<div class="container-fluid">
	  	<jsp:include page="header.jsp"></jsp:include>
	  
		<div class="panel panel-primary">
			<div class=panel-heading> <h3 class=panel-title>multimedia player</h3></div>
			<div class=panel-body>
			<div class="media-list-group">			
				<a class="list-group-item active"><%=PropertiesHelper.CFG_PATH + PropertiesHelper.getInstance().getP().getProperty("sensoryturtles.multimedia.dir") %></a>			
			</div>
			
			<div >
	  			<label for="usr">Selected file:</label>
	  			<input type="text" class="form-control" id="filefullpath" >
			</div>
	  		<div >  		  			
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

						<button type="button" class="btn btn-default btn-sm" onclick='buttonVolumeDownPress()'>
						  <span class="glyphicon glyphicon-volume-down"></span>
						</button>					    
						<button type="button" class="btn btn-default btn-sm" onclick='buttonVolumeUpPress()'>
						  <span class="glyphicon glyphicon-volume-up"></span>
						</button>					    
			</div>	
			</div>				
		</div>

		<div class="panel panel-success">
			<div class=panel-heading> <h3 class=panel-title>Switches on/off</h3></div>
			<div class=panel-body>

			<div class="col-xs-12 col-sm-6 col-md-8" >
				<!-- <div id="switchesDiv" ></div> -->  
				<table id="switchesTable" class="table switchesTable"></table>
			</div>
			 
		</div>
	
		<div class="panel panel-info">
			<div class=panel-heading> <h3 class=panel-title>RGB controllers</h3></div>
			<div class=panel-body>

			<div class="col-xs-12 col-sm-6 col-md-8">
				<!-- <div id="rgbControllersDiv" ></div>  -->  
				<table id="rgbCircleTable" class="table rgbCircleTable"></table>
			</div>
			
			<div class="col-xs-12 col-sm-6 col-md-8">
				<!-- <div id="rgbControllersDiv" ></div>  -->  
				<table id="rgbPaletteTable" class="table rgbPaletteTable"></table>				
			</div>
			
			</div>
		</div>
	</div>
	</div>
	<script>		
		var jsonData = $.ajax({
			url: '/SensoryTurtlesWeb/rest/ZWaveDeviceResource/readList',
			dataType: 'json',
			success: function (data) {	
				var rgbPaletteRow = $("<tr>");
				var rgbCircleRow = $("<tr>");
				var switchesRow = $("<tr>");
				for (var key in data) {
					var val = data[key];
					console.log(val['description']);					
			              	
					if (val['className']=='it.latartaruga.sensoryturtles.vo.ControllerRGBVO') {
						var rgbPageUrl = "colorPicker.jsp?idZWave=zwave-"+val['idZWave']+"&code="+val['code']+"&description="+val['description'];
	/*					var rgbContentString = '<input id=\"zwave-'+val['idZWave']+'\" type=\"text\" data-wheelcolorpicker data-wcp-layout=\"popup\" />'	
					          	+ '<h4>'+val['description']+'</h4>'
				              	+ '<span class=\"text-muted\">'+val['code']+'#'+val['idZWave']+'</span>'
				              	+ '<img id="'+$(this).prop("id")+'-color" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">'
						$('#rgbControllersDiv').append(rgbContentString);*/
				              	
/*						var iframe = document.createElement('iframe');				        					
						iframe.setAttribute("src", rgbPageUrl);
						iframe.setAttribute("width", 350);
						iframe.setAttribute("height", 310);
						iframe.setAttribute("border", 0);*/
						var iframe = "<iframe src="+rgbPageUrl+"' width=350 height=310 border=0 ></iframe>";   
						//document.getElementById("rgbControllersDiv").appendChild(iframe);
						var circleCols ="<td>"+iframe+"</td>";						
						rgbCircleRow.append(circleCols);
						
						var tableDiv = document.createElement('div');
						tableDiv.innerHTML='<table border="2" style="width:80%;height=40%;"><tr><td style="cursor:pointer;background-color:#FFFFFF" onclick="clickColor('+val['idZWave']+',&quot;#FFFFFF&quot;)">&nbsp;</td><td style="cursor:pointer;background-color:#000000" onclick="clickColor('+val['idZWave']+',&quot;#000000&quot;)">&nbsp;</td><td style="cursor:pointer;background-color:#009F6B" onclick="clickColor('+val['idZWave']+',&quot;#009F6B&quot;)">&nbsp;</td></tr><tr><td style="cursor:pointer;background-color:#C40233" onclick="clickColor('+val['idZWave']+',&quot;#C40233&quot;)">&nbsp;</td><td style="cursor:pointer;background-color:#FFD300" onclick="clickColor('+val['idZWave']+',&quot;#FFD300&quot;)">&nbsp<bsp;/td><td style="cursor:pointer;background-color:#0087BD" onclick="clickColor('+val['idZWave']+',&quot;#0087BD&quot;)">&nbsp;</td></tr></table>';
//						document.getElementById("rgbControllersDiv").appendChild(tableDiv);						
						var paletteCols ="<td>"+tableDiv.innerHTML+"</td>";
			            rgbPaletteRow.append(paletteCols);
						
						
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
						var switchesContentString = '<div style:"display:inline-block;"><input id=\"'+val['code']+'\"  type=\"checkbox\" checked data-toggle=\"toggle\" data-size=\"large\" data-on=\"'+val['description']+' On\" data-off=\"'+val['description']+' Off\" data-onstyle=\"success\" data-offstyle=\"danger\">'
				          	+ '<p><b>'+val['description']+'</b>'
			              	+ '<code style="color:red">'+val['code']+'#'+val['idZWave']+'</code></p></div>';
						
			            //$('#switchesDiv').append(switchesContentString);			            			            
			            var cols ="<td>"+switchesContentString+"</td>";
			            switchesRow.append(cols);
			              	
						$('#'+val['code']).change(function() {
							console.log('Switch of ZWave id '+$(this).prop('id')+': ' + $(this).prop('checked'));
							
							$.ajax({
								  url: "/SensoryTurtlesWeb/rest/ZWaveDeviceResource/invoke",
								  data: { 
									'devId': $(this).prop("id"),
									'type': "SWITCH",
									'cmd': $(this).prop('checked') ? "on" : "off"
								   },
								   success: function(data) {
									console.log(data);
								   },
								   error: function (request, error) {
									showError("lettura dispositvi ZWave non effettuata: " + error);
								   } 
							});
						});
					};
		            $("[data-toggle='toggle']").bootstrapToggle('destroy')                 
		            $("[data-toggle='toggle']").bootstrapToggle();		            		            		            
		            showSuccess("lettura dispositvi ZWave effettuata con successo");
				}
	            $("table.rgbPaletteTable").append(rgbPaletteRow);
	            $("table.rgbCircleTable").append(rgbCircleRow);	            
	            $("table.switchesTable").append(switchesRow);
		    },
		    error: function (request, error) {
		    	showError("lettura dispositvi ZWave non effettuata: " + error);
		    }
		    		    
		});		
		
		//load multimedia file path
		var jsonData = $.ajax({
			url: '/SensoryTurtlesWeb/rest/MediaFileResource/readList',
			dataType: 'json',
			success: function (data) {
				for (var idx in data) {
					console.log(data[idx]);
					$(".media-list-group" ).append("<a href=javascript:setFileName('"+encodeURIComponent(data[idx])+"') class=\"list-group-item \">"+data[idx]+"</a>");
					//<a href=javascript:setFileName('aa') class="list-group-item  ">CP 6 Ottobre.pdf</a>
					if (idx==0) {
						$("#filefullpath").val(data[idx]);
					}
				}
				showSuccess("lettura dei file multimediali effettuata con successo");
		    },
		    error: function (request, error) {
		    	showError("lettura file multimediali non effettuata: " + error);
		    }
		});		
			
		
		
		//media player buttons
		function startMPlayer(file){
			$.ajax({
				url: "/SensoryTurtlesWeb/rest/MPlayerResource/start",
				data: {  
					'file': file,
					'idTherapist': $("#idTherapist").val(),
					'idMember': $("#idMember").val()
				},
				success: function (data) {
				  	console.log(data);
			    },
	            error: function(jqXHR, textStatus, errorThrown) {
	                var errMsg = 'status code: '+jqXHR.status+'; errorThrown: ' + errorThrown + '; jqXHR.responseText: '+jqXHR.responseText;
			    	showError("errore in fase di avvio player multimediale per file "+file+"; errore: " + errMsg);
			    }
			});		 						
		}
		
		function invokeMPlayer(cmd){
			$.ajax({
				  url: "/SensoryTurtlesWeb/rest/MPlayerResource/invoke",
				  data: {  
					'cmd': cmd,
					'idTherapist': $("#idTherapist").val(),
					'idMember': $("#idMember").val()					
				   },
				success: function (data) {
				  	console.log(data);
			    },
	            error: function(jqXHR, textStatus, errorThrown) {
	            	showError("errore in fase di esecuzione comando "+cmd+" player multimediale; errore: " + error);	            	
	            }
			});		
		}
		
		function setFileName(fileName){
			$("#filefullpath").val(fileName);
		}

		
		//media player script
		var state = 'stop';
		
		function buttonBackPress() {
		    console.log("button back invoked.");
		    invokeMPlayer("BACK");
		}
		
		function buttonForwardPress() {
		    console.log("button forward invoked.");
		    invokeMPlayer("FW");		    
		}
		
		function buttonRewindPress() {
		    console.log("button rewind invoked.");
		    invokeMPlayer("REWIND");		    
		}
		
		function buttonFastforwardPress() {
		    console.log("button fast forward invoked.");
		    invokeMPlayer("FF");		    
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
		
		function buttonVolueDownPress() {
		    console.log("button volume down invoked.");
		    invokeMPlayer("VOLDOWN");		    
		}
		function buttonVolueUpPress() {
		    console.log("button volume up invoked.");
		    invokeMPlayer("VOLUP");		    
		}
		
		
		//set hue color
		function clickColor(devId, hexColor){
			var rgbColor =hexToRGB(hexColor, false); 
			console.log(rgbColor);		
			$.ajax({
				  url: "/SensoryTurtlesWeb/rest/ZWaveDeviceResource/invoke",
				  data: { 
					'devId': devId, 
					'type': "RGB",
					'cmd': rgbColor,	
					'idTherapist': $("#idTherapist").val(),
					'idMember': $("#idMember").val()					
				   },
				   success: function(data) {
				  	console.log(data);				  
				   }, 
				   error: function (request, error) {
					showError("impostazione colore "+hexColor+" su dispositivo "+devId+" non riuscito; errore: " + error);
				   } 				  
			});											
		}		
		
		
		function showError(err){
			$("div.bsalert").html("<div class=\"alert alert-danger\" role=\"alert\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\">&times;</a>"+new Date()+"<strong> Errore! </strong>"+err+"</div>");
		}
		
		function showSuccess(msg){
			$("div.bsalert").html("<div class=\"alert alert-success\" role=\"alert\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\">&times;</a>"+new Date()+"<strong> Ben fatto! </strong>"+msg+"</div>");			
		}
		
		function invokeOpSysCmd(cmd){
			$.ajax({
				  url: "/SensoryTurtlesWeb/rest/OpSysResource/invoke",
				  data: { 
					'cmd': cmd					
				   },
				   success: function(data) {
				  	console.log(data);				  
				   } 				  
			});					
		}
	</script>
	
  </body>
</html>
