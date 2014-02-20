/*
 **	Anderson Ferminiano
 **	contato@andersonferminiano.com -- feel free to contact me for bugs or new implementations.
 **	jQuery ScrollPagination
 **	28th/March/2011
 **	http://andersonferminiano.com/jqueryscrollpagination/
 **	You may use this script for free, but keep my credits.
 **	Thank you.
 */

(function($) {

	$.fn.scrollPagination = function(options) {

		var opts = $.extend($.fn.scrollPagination.defaults, options);
		var target = opts.scrollTarget;
		if (target == null) {
			target = obj;
		}
		opts.scrollTarget = target;

		return this.each(function() {
			$.fn.scrollPagination.init($(this), opts);
		});

	};

	$.fn.stopScrollPagination = function() {
		return this.each(function() {
			$(this).attr('scrollPagination', 'disabled');
		});

	};

	$.fn.scrollPagination.loadContent = function(obj, opts) {
		var target = opts.scrollTarget;
		var mayLoadContent = $(target).scrollTop() + opts.heightOffset >= $(
				document).height()
				- $(target).height();
		if (mayLoadContent) {
			if (opts.beforeLoad != null) {
				opts.beforeLoad();
			}
			$(obj).children().attr('rel', 'loaded');
			var param = "name=" + document.getElementById("username").innerHTML;
			if(ismyroom==1){
			     param += "&usrid=" + usrid;
			}
			param += "&maxid=" + GetCookie("maxid");
			param += "&lx=" + GetCookie("locationx");
			param += "&ly=" + GetCookie("locationy");
			param += "&ismyroom=" + ismyroom;
			$.ajax({
				type : 'Get',
				url : "godatatouch",
				data : param,
				success : function(data) {
					var temp = data;
					var offset = temp.indexOf("^");
					var len = temp.length;
					var maxid=temp.substr(0, offset);
					SetCookie("maxid", maxid);
					temp=temp.substr(offset + 1, len);
					offset = temp.indexOf("^");
					len = temp.length;
					if (offset != -1) {
						var rt = temp.substr(offset + 1, len);
						$(obj).append(rt);
						rt = temp.substr(0, offset + 1);
						if(rt!="^")
						SetCookie("locations", rt);
					} else
						$(obj).append(temp);
					var objectsRendered = $(obj).children('[rel!=loaded]');
					if (opts.afterLoad != null) {
						opts.afterLoad(objectsRendered);
					}
				},
				dataType : 'html'
			});
		}

	};

	$.fn.scrollPagination.init = function(obj, opts) {
		var target = opts.scrollTarget;
		$(obj).attr('scrollPagination', 'enabled');

		$(target).scroll(function(event) {
			if ($(obj).attr('scrollPagination') == 'enabled') {
				$.fn.scrollPagination.loadContent(obj, opts);
			} else {
				event.stopPropagation();
			}
		});

		$.fn.scrollPagination.loadContent(obj, opts);

	};

	$.fn.scrollPagination.defaults = {
		'contentPage' : null,
		'contentData' : {},
		'beforeLoad' : null,
		'afterLoad' : null,
		'scrollTarget' : null,
		'heightOffset' : 0
	};
})(jQuery);
