jQuery(document).ready(function(){
	jQuery("#mycarousel").carousel({interval: 2000});
	
	jQuery("#carouselButton").click(function(){
		if(jQuery("#carouselButton").children("span").hasClass("fa-pause")){
			//carousel is paused
			jQuery("#carouselButton").children("span").removeClass("fa-pause");
			jQuery("#carouselButton").children("span").addClass("fa-play");
			jQuery("#mycarousel").carousel("pause");
		}
		else{
			//carousel is in play mode
			jQuery("#carouselButton").children("span").removeClass("fa-play");
			jQuery("#carouselButton").children("span").addClass("fa-pause");
			jQuery("#mycarousel").carousel("cycle");
		}
	});
});

jQuery("#rsv-btn").click(function(){
	jQuery("#reserveModal").modal('toggle');
});

jQuery("#login").click(function(){
	jQuery("#loginModal").modal('toggle');
});