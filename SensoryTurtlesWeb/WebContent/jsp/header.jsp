<%@page import="it.latartaruga.sensoryturtles.util.PropertiesHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
@font-face { font-family: HelveticaRoundedLTStd-BdCn; src: url('../fonts/Helvetica_rounded/HelveticaRoundedLTStd-BdCn.otf'); } 
</style>
<div class="main-container container">        
	<div class="row">
		<div class="col-xs-4 col-md-1">
			<img class="img-rounded img-responsive" src="../img/tartarugacarrozzellatrasparentevuotalight.jpg" />
		</div>
		<div class="col-xs-8 col-md-3"><img class="img-rounded img-responsive" src="../img/scritta.001light.jpg" alt="La Tartaruga ONLUS"><br/><span style="font-family:HelveticaRoundedLTStd-Bd;font-size:x-small;color:orange;">Centro Ludico/Ricreativo, Ambiente Multisensoriale Vasca Riscaldata per Disabili, anche gravi</span></div>
		<div class="col-xs-12 col-md-3 text-center">
			<p class="lead" style="margin-bottom: 0px;">
				<span style="font-family:HelveticaRoundedLTStd-BdCn;">Chi va piano va... e lontano</span>
				<h1 class="page-header"><span style="font-family:HelveticaRoundedLTStd-BdCn;">Sensory Turtles Dashboard</span></h1>
			</p>
		</div>
		<div class="col-xs-3 col-md-1" style="padding:0;"><a href="https://www.facebook.com/la.tartarugaonlus" class="thumbnail"><img src="../img/facebook.jpg" alt="facebook"></a></div>
		<div class="col-xs-3 col-md-1" style="padding:0;"><a href="https://www.youtube.com/channel/UC7X0uaat3F5Y-F3TlHE-sIQ" class="thumbnail"><img src="../img/youtube.jpg" alt="youtube"></a></div>
		<div class="col-xs-3 col-md-1" style="padding:0;"><a href="https://twitter.com/tartaruga_onlus" class="thumbnail"><img src="../img/twitter.jpg" alt="twitter"></a></div>
		<div class="col-xs-3 col-md-1" style="padding:0;"><a href="https://www.linkedin.com/company/la-tartaruga-onlus" class="thumbnail"><img src="../img/linkedin.jpg" alt="linkedin"></a></div>
		<div class="hidden-xs col-md-1">
			<img class="img-rounded img-responsive" src="../img/facciaasinistratartarugatrasparentelight.jpg"/>
		</div>
	</div>		
	<div class="row">		
		<div class="col-xs-12 col-md-3 text-center">
				<div class="form-group">
				<span style="font-family:HelveticaRoundedLTStd-BdCn;">
				  <label for="idTherapist">terapista:</label>
  				  <input type="text" class="form-control" id="idTherapist" value="idTherapist1">
				  <label for="idMember">socio tarta:</label>
  				  <input type="text" class="form-control" id="idMember" value="idMember1">  				  
  				 </span>
				</div>  				 			
		</div>
		<div class="bsalert col-xs-12 col-md-6"></div>		
	  	<div class="col-xs-12 col-md-3 text-center">
	  		<button type="button" class="btn btn-warning" aria-label="Left Align" onclick="invokeOpSysCmd('ls')">
  				<span class="glyphicon glyphicon-step-backward" aria-hidden="true">Riavvia</span>
			</button>	  					
	  		<button type="button" class="btn btn-danger" aria-label="Left Align" onclick="invokeOpSysCmd('du')">
  				<span class="glyphicon glyphicon-off" aria-hidden="true">Spegni</span>
			</button>			
	  	</div>	  	
	</div>
</div>
