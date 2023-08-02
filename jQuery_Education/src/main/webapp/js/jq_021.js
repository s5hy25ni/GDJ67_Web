var intervalObj;

$(function(){
	$("button").click(function(){
		if($("button").text()=="START"){
				setInterval(
				function(){
					$("img:first").appendTo($("#menu"))
				}		
			,30);
			$(this).text("STOP");
		} else {
			clearInterval(intervalObj);
			$(this).text("START");
			var choice = $("img:eq(2)").attr("alt");
			alert("오늘의 회식 메뉴는?"+choice);
		}
		
	});
});