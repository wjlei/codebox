function checkfriend(usrid) {
	var PAGE_SUCCESS = 200;
	var param = "req=check";
	var suser = GetCookie("usrid");
	param += "&suser=" + suser;
	param += "&tuser=" + usrid;
	var requestObject = xmlHttpRequestHandler.createXmlHttpRequest();
	requestObject.open("Get", "gofriendcheck?" + param, false);
	requestObject.send(null);
	if (requestObject.status == PAGE_SUCCESS) {
		if (requestObject.responseText != "1") {
			var div_handle = document.getElementById("friends");
			//check if DIV element is found 
			if (div_handle) {
				div_handle.innerHTML = "<input id='addfriend'	type='button' value='关注' onclick='makefriend(usrid);'/>";
			}
		}
	} else {
		alert("Request failed");
	}

}
function makefriend(usrid) {
	var PAGE_SUCCESS = 200;
	var param = "req=add";
	var suser = GetCookie("usrid");
	param += "&suser=" + suser;
	param += "&tuser=" + usrid;
	var requestObject = xmlHttpRequestHandler.createXmlHttpRequest();
	requestObject.open("Get", "gofriendcheck?" + param, false);
	requestObject.send(null);
	if (requestObject.status == PAGE_SUCCESS) {
		if (requestObject.responseText == "1") {
			var div_handle = document.getElementById("friends");
			//check if DIV element is found 
			if (div_handle) {
				div_handle.innerHTML = "";
			}
			
		}
	} else {
		alert("Request failed");
	}

}
function checkpicfriend(picid) {
	var PAGE_SUCCESS = 200;
	var param = "req=piccheck";
	var suser = GetCookie("usrid");
	param += "&suser=" + suser;
	param += "&picid=" + picid;
	var requestObject = xmlHttpRequestHandler.createXmlHttpRequest();
	requestObject.open("Get", "gofriendcheck?" + param, false);
	requestObject.send(null);
	if (requestObject.status == PAGE_SUCCESS) {
		if (requestObject.responseText != "1") {
			var div_handle = document.getElementById("friends");
			//check if DIV element is found 
			if (div_handle) {
				div_handle.innerHTML = "<input id='addfriend'	type='button' value='关注' onclick='makepicfriend(picid);'/>";
			}
		}
	} else {
		alert("Request failed");
	}

}
function makepicfriend(picid) {
	var PAGE_SUCCESS = 200;
	var param = "req=picadd";
	var suser = GetCookie("usrid");
	param += "&suser=" + suser;
	param += "&picid=" + picid;
	var requestObject = xmlHttpRequestHandler.createXmlHttpRequest();
	requestObject.open("Get", "gofriendcheck?" + param, false);
	requestObject.send(null);
	if (requestObject.status == PAGE_SUCCESS) {
		if (requestObject.responseText == "1") {
			var div_handle = document.getElementById("friends");
			//check if DIV element is found 
			if (div_handle) {
				div_handle.innerHTML = "";
			}
			
		}
	} else {
		alert("Request failed");
	}

}