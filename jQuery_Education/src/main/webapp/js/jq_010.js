$(document).ready(function(){
	console.log($("div>div").length);
	$("div:eq(3)").css("background","yellow");
	
	var div = document.getElementsByTagName("div");
	console.log(div.length);
	
//	$("div").find("b").css({"fontSize":"20px","color":"tomato"});
	
	console.log($("div").children().length);
//	$("div:eq(0)").children().css("color","blue");
//	$("div:eq(1)").children().css("color","green");
//	$("div:eq(2)").children().css("color","blue");
//	$("div:eq(3)").children().css("color","blue");
//	$("div:eq(4)").children().css("color","blue");
	$("div:eq(5)").children().css("color","red");

	$("div").children("#id").text("2번 child 선택");
	
	//parent: 바로 상위 element
	//parent(선택자): 상위의 선택자 element
//	$("div>b").parent().css("background","lime"); // 탐색 엘리먼트의 첫번째 부모를 찾음
	
	$("div>div").eq(2).next().next().css("background","blue");
});