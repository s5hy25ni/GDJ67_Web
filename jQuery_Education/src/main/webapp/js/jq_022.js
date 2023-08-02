$(function(){
	$("button").eq(0).click(function(){
		$("#base").after("<div>새로운 Element After</div>");
	});
	$("button").eq(1).click(function(){
//		$("<div>").html("<b>새로운 element insertAfter</b>").insertAfter("#base");
		$("<div>새로운 elemnet insertAfter</div>").insertAfter("#base");
	});
	$("button").eq(2).click(function(){
		$("#base").before("<div>새로운 Element Before</div>");
	});
	$("button").eq(3).click(function(){
		$("<div>새로운 elemnet insertBefore</div>").insertBefore("#base");
	});
});