function doTheAjaxThing() {
	var PAGE_SUCCESS = 200;
	if (document.form1.Mes.value.length > 0) {

		var param = "name=" + document.form1.Mes.value;
		param = param + "&pw=" + document.form1.Password1.value;
		var requestObject = xmlHttpRequestHandler.createXmlHttpRequest();
		requestObject.open("Get", "gocheck?" + param, false);
		requestObject.send(null);
		if (requestObject.status == PAGE_SUCCESS) {
			if (requestObject.responseText != "-1") {
				SetCookie("user", document.form1.Mes.value);
				SetCookie("usrid", requestObject.responseText);
				//	window.location.href="welcome.html?user="+document.form1.Mes.value+"&id="+requestObject.responseText;
				window.location.href = "welcome.html";
			} else
				alert("usrname or password error!");
		} else {
			alert("Request failed");
		}

	} else
		alert("Please Enter Something!");
}
function makelogin() {

	var div_handle = document.getElementById("form1");
	//check if DIV element is found 
	if (div_handle) {
		div_handle.innerHTML = "<input type='text' id='Mes' name='Mes' /> <span class='style1'>username</span>		<input id='Password1' type='password' />password <input id='Submit1'	type='button' value='Login' onclick='doTheAjaxThing();'/>";
	}
}
function makelogout() {
	window.location.href = "login.html";
}