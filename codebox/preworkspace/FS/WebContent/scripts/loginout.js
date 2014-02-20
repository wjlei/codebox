function doTheAjaxThing() {
	var PAGE_SUCCESS = 200;
	if (document.login.Mes.value.length > 0) {

		var param = "name=" + document.login.Mes.value;
		param = param + "&pw=" + document.login.Password1.value;
		var requestObject = xmlHttpRequestHandler.createXmlHttpRequest();
		requestObject.open("Get", "gocheck?" + param, false);
		requestObject.send(null);
		if (requestObject.status == PAGE_SUCCESS) {
			if (requestObject.responseText != "-1") {
				var temp = requestObject.responseText;
				SetCookie("usrid", temp.split(",")[0]);
				SetCookie("user", temp.split(",")[1]);
				SetCookie("locationx", temp.split(",")[2]);
				SetCookie("locationy", temp.split(",")[3]);
				SetCookie("maxid", 0);
				window.location.href = "welcome.html";
			} else
				alert("usrname or password error!");
		} else {
			alert("Request failed");
		}

	} else
		alert("Please Enter Something!");
}
function demo1() {
	var PAGE_SUCCESS = 200;


		var param = "name=Tim";
		param = param + "&pw=123";
		var requestObject = xmlHttpRequestHandler.createXmlHttpRequest();
		requestObject.open("Get", "gocheck?" + param, false);
		requestObject.send(null);
		if (requestObject.status == PAGE_SUCCESS) {
			if (requestObject.responseText != "-1") {
				var temp = requestObject.responseText;
				SetCookie("usrid", temp.split(",")[0]);
				SetCookie("user", temp.split(",")[1]);
				SetCookie("locationx", temp.split(",")[2]);
				SetCookie("locationy", temp.split(",")[3]);
				SetCookie("maxid", 0);
				SetCookie("mapnum", "map.jpg");
			//	SetCookie("loffset", "0");
				window.location.href = "welcome.html";
			} else
				alert("usrname or password error!");
		} else {
			alert("Request failed");
		}

}
function demo2() {
	var PAGE_SUCCESS = 200;


		var param = "name=Aimee";
		param = param + "&pw=123";
		var requestObject = xmlHttpRequestHandler.createXmlHttpRequest();
		requestObject.open("Get", "gocheck?" + param, false);
		requestObject.send(null);
		if (requestObject.status == PAGE_SUCCESS) {
			if (requestObject.responseText != "-1") {
				var temp = requestObject.responseText;
				SetCookie("usrid", temp.split(",")[0]);
				SetCookie("user", temp.split(",")[1]);
				SetCookie("locationx", temp.split(",")[2]);
				SetCookie("locationy", temp.split(",")[3]);
				SetCookie("maxid", 0);
				SetCookie("mapnum", "map2.jpg");
			//	SetCookie("loffset", "1000");
				window.location.href = "welcome.html";
			} else
				alert("usrname or password error!");
		} else {
			alert("Request failed");
		}


}
function demo3() {
	var PAGE_SUCCESS = 200;


		var param = "name=Payen";
		param = param + "&pw=123";
		var requestObject = xmlHttpRequestHandler.createXmlHttpRequest();
		requestObject.open("Get", "gocheck?" + param, false);
		requestObject.send(null);
		if (requestObject.status == PAGE_SUCCESS) {
			if (requestObject.responseText != "-1") {
				var temp = requestObject.responseText;
				SetCookie("usrid", temp.split(",")[0]);
				SetCookie("user", temp.split(",")[1]);
				SetCookie("locationx", temp.split(",")[2]);
				SetCookie("locationy", temp.split(",")[3]);
				SetCookie("maxid", 0);
				SetCookie("mapnum", "map3.jpg");
			//	SetCookie("loffset", "2000");
				window.location.href = "welcome.html";
			} else
				alert("usrname or password error!");
		} else {
			alert("Request failed");
		}


}
function makelogin() {

	var div_handle = document.getElementById("login");
	// check if DIV element is found
	if (div_handle) {
		div_handle.innerHTML = "<input type='text' id='Mes' name='Mes' /> <span class='style1'>username</span>		<input id='Password1' type='password' />password <input id='Submit1'	type='button' value='Login' onclick='doTheAjaxThing();'/>";
	}
}
function makelogout() {
	SetCookie("usrid", "");
	SetCookie("user", "");
	SetCookie("locationx", "");
	SetCookie("locationy", "");
	window.location.href = "login.html";
}
function makelogbar() {
	var iusr = GetCookie("user");
	var iusrid = GetCookie("usrid");
	var locationx = GetCookie("locationx");
	var locationy = GetCookie("locationy");
	if (iusrid == "" || iusr == "") {
		window.location.href = "login.html";
		return;
	}
	var div_handle = document.getElementById("form1");
	if (div_handle) {
		div_handle.innerHTML = " <a class=\"link\" id=\"username\"  href=\"myhome.html?user="
				+ iusr
				+ "&id="
				+ iusrid
				+ "\">"
				+ iusr
				+ "</a> <a href=\"welcome.html\"><span>欢迎!</span></a> <a id=\"locations\" href=\"overviewmap.html\" locations=\""
				+ locationx
				+ ","
				+ locationy
				+ "\">"
				+ "<img src=\"./img/mark.gif\" alt=\"mark\"/>"
				+ "</a> <input id=\"Submit1\"	type=\"button\" value=\"退出\" style=\"float:right\" onclick=\"makelogout();\" />";
	}
}