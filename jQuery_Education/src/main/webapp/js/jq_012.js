$(function(){
	$(".menu>div").css("display","none");
	$(".menu").hover(function(){
		$(this).children("div").stop().slideToggle(1000);
	});
	
//	$(".menu").hover(function(){
//		$(this).children("div").slideDown();
//	},
//	function(){
//		$(this).children("div").slideUp();
//	});
});