function resizePanels(){
	jQuery(".panel").height(jQuery(window).height()-jQuery("#header").height()-15);
	var activePanels = 4 - jQuery(".hidden").length;
	jQuery(".panel").width((jQuery(window).width() / activePanels) - 15);
}

function updateOutput(){
	jQuery("#output-panel").contents().find("html").html("<html><head><style type='text/css'>"
	+jQuery("#css-panel").val()
	+"</style></head><body>"
	+jQuery("#html-panel").val()
	+"</body></html>");
	
	document.getElementById("output-panel").contentWindow.eval(jQuery("#js-panel").val());
}

resizePanels();
updateOutput();

jQuery(".toggle-btn").hover(
	function(){
		jQuery(this).addClass("hightlighted-btn");
	},function(){
		jQuery(this).removeClass("hightlighted-btn");
	});

jQuery(".toggle-btn").click(function(){
	//jQuery(".active").removeClass("active");
	jQuery(this).toggleClass("active");
	jQuery(this).removeClass("hightlighted-btn");
	
	var panelId = jQuery(this).attr("id")+"-panel";
	jQuery("#"+panelId).toggleClass("hidden");
	resizePanels();
});

jQuery("textarea").on("change keyup paste", function(){
	updateOutput();
});
