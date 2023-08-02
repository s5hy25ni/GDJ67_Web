function imgSize(){
	//jQuery에서 속성을 입력할 때 여러 개의 값을 반복해서 작업해야 한다
	//JSON의 객체로 전달하면 여러 개의 속성을 적용할 수 있다
	//NodeList의 경우 for문을 하지 않아도 모두 적용, eq 단일 node를 선택할 수 있다
	$("img").css({"width":"300px","height":"300px"});
}

function idSelector(){
	//CSS는 같은 id가 있어도 적용이 됨
	//DOM을 탐색하게 되면 id는 반드시 첫번째 node만 선택됨
	$("#selId").hide();
}

function classSelector(){
	$(".selClass").css("opacity","0.3");
}

function changeImg(){
	
	$("td>img").attr("src", "./img/img02.png");
}

function propSelector(){
	// =같다, *=포함한다, |=키워드 검색
	$("img[title*=02]").slideUp(2000);
}