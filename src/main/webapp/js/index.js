$(function(){
	$('#logo').mouseenter(function(){
		$(this).attr("src","img/logo-colorido.png");
	}).mouseout(function(){
		$(this).attr("src","img/logo-dark.png");
	});
});