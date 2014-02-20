function catchhtml(url) {
	var PAGE_SUCCESS = 200;
	var requestObject = xmlHttpRequestHandler.createXmlHttpRequest();
	requestObject.open("Get", url, false);
	requestObject.send(null);
	if (requestObject.status == PAGE_SUCCESS) {
			var div_handle = document.getElementById("htmlcontent");
			//check if DIV element is found 
			if (div_handle) {
				div_handle.innerHTML =requestObject.responseText;
		}
	} else {
		alert("Request failed");
	}

}