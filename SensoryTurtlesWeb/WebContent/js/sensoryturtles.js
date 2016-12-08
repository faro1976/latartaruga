	function hexToRGB(hex,alphaYes){
		var h = "0123456789abcdef";
		var r = h.indexOf(hex[1])*16+h.indexOf(hex[2]);
		var g = h.indexOf(hex[3])*16+h.indexOf(hex[4]);
		var b = h.indexOf(hex[5])*16+h.indexOf(hex[6]);
		if(alphaYes) return "rgba("+r+","+g+","+b+",1)";
//		else return "rgb("+r+","+g+","+b+")";
		else return "red="+r+"&green="+g+"&blue="+b;
	}	

	
	function rgbToRGB(total) {
	    var total = total.toString().split(',');
	    var r = total[0].substring(4);
	    var g = total[1].substring(1);
	    var b = total[2].substring(1,total[2].length-1);
	    return "red="+r+"&green="+g+"&blue="+b;
	}
