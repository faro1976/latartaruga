<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/favicon.ico">

    <title>CRUD Sensory Turtles</title>

	<!-- JTable include -->
    <link href="../widget/jtable.2.4.0/themes/redmond/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css" />
	<link href="../widget/jtable.2.4.0/scripts/jtable/themes/lightcolor/orange/jtable.css" rel="stylesheet" type="text/css" />
	<!--  JQuery include - embedded version for JTable -->
	<script src="../widget/jtable.2.4.0/scripts/jquery-1.6.4.min.js" type="text/javascript"></script>
    <script src="../widget/jtable.2.4.0/scripts/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
    <script src="../widget/jtable.2.4.0/scripts/jtable/jquery.jtable.js" type="text/javascript"></script>
    
</head>
<body>
	<div id="DeviceRelayTableContainer" style="width: 600px;"></div>	
	<div id="RoomTableContainer" style="width: 600px;"></div>	
	
<script type="text/javascript">
    $(document).ready(function () {
        $('#DeviceRelayTableContainer').jtable({
            title: 'Table DEVICE_RELAY',
            actions: {
                listAction: '../../SensoryTurtlesServices/rest/Configuration/Room/1/Relays',
                createAction: '../rest/CRUDResource/CreateDeviceRelay',
                updateAction: '../rest/CRUDResource/UpdateDeviceRelay',
                deleteAction: '../rest/CRUDResource/DeleteDeviceRelay'
            },
            fields: {
                code: {
                	key: true,
                    title: 'code',
                    width: '10%',
					create: true,
					edit: true,
					list: true
					//type: 'date'
                },
                description: {
                    title: 'description',
                    width: '60%'
                },
                idZWave: {
                    title: 'idRaspBerry',
                    width: '10%'
                },
                className: {
                    title: 'className',
                    width: '10%'
                }
                
            }
        });
        
		$('#DeviceRelayTableContainer').jtable('load');
		
		
		
        $('#RoomTableContainer').jtable({
            title: 'Table ROOM',
            actions: {
                listAction: '../../SensoryTurtlesServices/rest/Configuration/CRUDRooms',
                createAction: '../../rest/Configuration/CreateDeviceRelay',
                updateAction: '../rest/Configuration/UpdateDeviceRelay',
                deleteAction: '../rest/Configuration/DeleteDeviceRelay'
            },
            fields: {
                idRoom: {
                	key: true,
                    title: 'code',
                    width: '10%',
					create: true,
					edit: true,
					list: true
                },
                code: {
                    title: 'idRaspBerry',
                    width: '20%'
                },                
                description: {
                    title: 'descr',
                    width: '60%'
                },
                className: {
                    title: 'className',
                    width: '10%'
                }
                
            }
        });
        
		$('#RoomTableContainer').jtable('load');		
    });
</script>	
</body>
</html>