/**
 * 
 */
 
 function jsSubmit(){
	// form을 찾는 방법
	
	// 1) dom
		var form01 = document.getElementById("was");
	
	// 2) tag
		var form02 = document.forms[0];
	
	// 3) name
		var form03 = document.frm;
		
	// ## 유효값 검사
		var queryText = document.getElementByName("query")[0].value;
		
		if(queryText != ""){
			form03.submit();	
		} else {
			alert("안대 돌아가ㅎ");
		}
		
}

window.onload = function(){
	
	var newDate = new Date();
	var year = newDate.getFullYear();
	var month = newDate.getMonth()+1;
	var date = newDate.getDate();
	
	/*console.log(year);
	console.log(month);
	console.log(date);*/
	
	var resultDate = year + "-" + twoWord(month) + "-" + twoWord(date);
	
	console.log(resultDate);
	
	document.getElementById("date").value = resultDate;
}

function twoWord(v){
	// 숫자를 문자로, 한 자리를 두 자리로
	console.log(typeof v);
	var m = v+"";
	if(m.length<2){
		m = "0"+m
	}
	return m;
}

function textAreaCheck(){
	/*
		markup으로 되어 있는 tag는 모두 화면에 출력되어 text로 되어 있음
		string인 글만 가지고 온다
		
		하위에 있는 HTML을 가져오기 위해서는 innerHTML을 사용해야 한다.
		textarea는 문자로 작성되어지는 공간
		따라서 HTML 및 자바스크립트가 동작되지 않음
		
		textarea의 줄바꿈은 (\n\r)로 되어있음 => DB => HTML 출력 => 줄바꿈/tab 등과 같은 동작이 표현되지 않음
		/n/r을 HTML tab인 <br>로 변경해줘야함
		
		textarea에 의도적으로 javascript를 작성하면 => DB => HTML로 출력 기능을 동작
			javascript 혹은 tag를 제거하는 방법
			var newTxt = original.replace(//(<(^>)+>)igm, "")
	*/
	var txt = document.getElementById("txt");
	console.log("value", txt.value);
	console.log("textContent", txt.textContent);
	console.log("innerHTML", txt.innerHTML);
	/*txt.value="반갑습니다.";*/
	/*txt.innerHTML="<b>HTML작성</b>"; // tag 안먹힘*/
	/*txt.textContent="textContent";*/
}