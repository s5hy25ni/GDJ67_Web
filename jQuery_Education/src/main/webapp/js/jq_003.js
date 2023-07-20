function idSelector() {
	$("#selId").hide();
}

function classSelector() {
	$(".selClass").css("opacity", 0.3);
}
      
function changeImg() {
	$("td>img").attr("src", "./img/img02.png");
}

function propSelector() {
	// = 같다, *= 포함한다, |= 키워드 검색
	$("img[title*='02']").slideUp();
}