/**
 * 
 */
 
alert("링크 방식 : 실행 3");

window.onload = function(){
	alert("링크의 window onload");
	document.getElementById("div_click").onclick = function(){
		alert("javascript에서 동작 실행");
	};
};