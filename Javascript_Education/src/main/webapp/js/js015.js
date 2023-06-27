/**
 * 
 */
 
function openWindow(){
	// 윈도우 객체	
	// window.open(url, title, 속성);
	var url = "./js_015_open_childHTML.html";
	var title = "자식창";
	var prop = "top=100px, left=100px, width=500px, height=500px";
	window.open(url, title, prop); 
}

function registForm(){
	document.getElementById("registForm").style.display = "block";
	document.body.style.backgroundColor = "#000";
	var btns = document.getElementsByName("btn");
	for(let i in btns){
		btns[i].disabled = "none";
	}
}

function cancel(){
	document.getElementById("registForm").style.display = "none";
	document.body.style.backgroundColor = "#fff";
	var btns = document.getElementsByName("btn");
	for(let i in btns){
		btns[i].disabled = "";
	}
}

function idChk(){
	var id = document.getElementsByName("id")[0].value;
	if(id==""){
		alert("중복 쳌 ㄱㄱ");
		return;
	}
	console.log("함수의 마지막 기능");
}

function idCheck(){
	open("./js_015_아이디중복검사.html", "", "width=400px, height=400px");
}