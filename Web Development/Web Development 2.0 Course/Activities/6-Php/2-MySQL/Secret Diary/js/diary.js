/*
jQuery("#save-diary").click(function(){
	jQuery.ajax({
		method:"POST",
		url:"updateDatabase.php",
		data:{
			content: jQuery("#diary").val()
		}
	})
});
*/
$('#diary').bind('input propertychange', function() {
	jQuery.ajax({
		method:"POST",
		url:"updateDatabase.php",
		data:{
			content: jQuery("#diary").val()
		}
	})
});