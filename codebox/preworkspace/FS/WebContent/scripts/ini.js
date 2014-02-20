var xmlHttpRequestHandler = new Object();
xmlHttpRequestHandler.createXmlHttpRequest = function() {
	var XmlHttpRequestObject;
	if (typeof XMLHttpRequest != "undefined") {
		XmlHttpRequestObject = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		// look up the highest possible MSXML version
		var tryPossibleVersions = [ "MSXML2.XMLHttp.5.0", "MSXML2.XMLHttp.4.0",
				"MSXML2.XMLHttp.3.0", "MSXML2.XMLHttp", "Microsoft.XMLHttp" ];
		for (var i = 0; i < tryPossibleVersions.length; i++) {
			try {
				XmlHttpRequestObject = new ActiveXObject(tryPossibleVersions[i]);
				break;
			} catch (xmlHttpRequestObjectError) {
				// ignore
			}
		}
	}
	return XmlHttpRequestObject;
}