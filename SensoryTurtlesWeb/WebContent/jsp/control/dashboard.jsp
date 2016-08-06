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

    <title>Dashboard for LaTartarugaOnlus</title>

    <!-- Bootstrap core CSS -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

    <!-- Boostrap dashboard -->
    <link href="../../css/dashboard.css" rel="stylesheet">

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<script src="../../js/jquery-3.1.0.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    
    <!-- color picker -->
	<script type="text/javascript" src="../../js/jquery.wheelcolorpicker-2.5.1.min.js"></script>
	<link type="text/css" rel="stylesheet" href="../../css/wheelcolorpicker.css" />
    
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

		<div class="row placeholders">
			<div class="col-xs-6 col-sm-3 placeholder">
				<input type="text" name="color" id="ColorInput-1" value="#ff0000" data-wheelcolorpicker data-wcp-layout="popup"  />
				<input type="text" name="color" id="ColorInput-2" value="#ff0000" data-wheelcolorpicker data-wcp-layout="block"  />
              	<h4>Label</h4>
              	<span class="text-muted">Something else</span>
            </div>
		</div>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
				<input id="toggle-event-1"  type="checkbox" checked data-toggle="toggle" data-size="large" data-on="switch #1 On" data-off="switch #1 Off" data-onstyle="success" data-offstyle="danger">
            </div>
		  </div>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
				<input type="checkbox" checked data-toggle="toggle" data-size="large">
				<input type="checkbox" checked data-toggle="toggle" data-size="normal">
				<input type="checkbox" checked data-toggle="toggle" data-size="small">
				<input type="checkbox" checked data-toggle="toggle" data-size="mini">		  
				<input type="checkbox" checked data-toggle="toggle" data-onstyle="success" data-offstyle="danger">
				<input type="checkbox" checked data-toggle="toggle" data-on="<i class='fa fa-play'></i> Play" data-off="<i class='fa fa-pause'></i> Pause">
            </div>
		  </div>

		  
          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
          </div>

          <h2 class="sub-header">Section title</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>
                  <td>Lorem</td>
                  <td>ipsum</td>
                  <td>dolor</td>
                  <td>sit</td>
                </tr>
                <tr>
                  <td>1,002</td>
                  <td>amet</td>
                  <td>consectetur</td>
                  <td>adipiscing</td>
                  <td>elit</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

	<script>
		$(function() {
			$('#ColorInput-1').change(function() {
				alert('Color: ' + $(this).prop('value'));
			});
			$('#toggle-event-1').change(function() {
				alert('Toggle: ' + $(this).prop('checked'));
			});				
		})
		

		var jsonData = $.ajax({
			url: '/SensoryTurtlesWeb/rest/ZWaveDeviceResource/readList',
			    dataType: 'json',
			}).done(function (data) {
			for (var key in data) {
				var val = data[key];
				alert (val['idZWave']);
				}
				$('#dataTable tbody').html(contentString);				
				$( "#progressbar" ).hide();
			});		
	</script>				  
    
  </body>
</html>
