jQuery("#show-login-form").click(function(){
	jQuery("#login-form").show();
	jQuery("#signup-form").hide();
});

jQuery("#show-signup-form").click(function(){
	jQuery("#signup-form").show();
	jQuery("#login-form").hide();
});