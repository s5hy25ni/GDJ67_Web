$(function(){
	$("input[type=button]").eq(0).on("click", function(){
		$(location).attr("href","./detail.do?seq=1&page=1");
	});
	$("input[type=button]").eq(1).on("click", function(){
		$(location).attr("href","./insert.do");
	});
	
});