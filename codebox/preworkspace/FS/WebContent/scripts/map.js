function showmap() {

	var div_handle = document.getElementById("getmap");
	//check if DIV element is found 
	if (div_handle) {
		var mapnum=GetCookie("mapnum");
		if(picid=="5")
		    mapnum="map10.jpg";
		var ss = "<div id=\"comb\"  style= \"height:500px; width :  400px; position:relative;  left:  0px;   top:   0px; \"><a><img   src= \"./img/"+mapnum+"\" alt=\"map\"   style= \"position:absolute;  left:   10px;   top:   10px;   z-index:1; \" onclick=\"closemap()\"/></a> ";
		var div_handle2=document.getElementById("location");
		var ls=div_handle2.getAttribute("locations");
		var lx=ls.split(",")[0];
		var ly=ls.split(",")[1];
		ss+="<div id=\"points\"><img   src= \"./img/mark.png\"  alt=\"p1\"  style= \"position:absolute;  left:   "+lx+"px;   top:   "+ly+"px;   z-index:2;height:16px; width :  16px; \"/></div></div>"; 
		div_handle.innerHTML =ss;
	}
}
function closemap() {

	var div_handle = document.getElementById("getmap");
	//check if DIV element is found 
	if (div_handle) {
		div_handle.innerHTML ="";
		}
	
}