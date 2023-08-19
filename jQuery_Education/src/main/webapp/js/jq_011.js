$(function(){
//	$("p:eq(0)").add("span").css("color","red"); //p,div
//	$("p:eq(0), span").css("color","lime"); //위랑 똑같은거
	
//	var doc =document.getElementsByTagName("div")[0];
//	var chd = doc.children;
//	for(let i in chd){
//		chd[i].onclick = function(){
//			if(this.tagName == "SPAN"){
//				console.log(this.textContent);
//			}
//		}
//	}

	/*
		문제
		div 태그의 자식들 중에서
		span은 폰트색을 orange로 바꾸고
		p는 배경색을 yellow로 변경
		단, 사용하는 문법은 is를 사용해 주세요
	*/
	$("div").children().click(function(){
		if($(this).prop("tagName")=="SPAN"){
			$(this).css("color","orange");
		}
		
		if($(this).is("P")){
			$(this).css("background","yellow");
		}
	});
});