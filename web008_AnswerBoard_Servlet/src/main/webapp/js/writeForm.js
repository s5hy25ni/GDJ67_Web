document.onkeydown=function(event){
	/*console.log(event);*/
	//if(event.ctrlKey==true && (event.keyCode==78 || event.keyCode==82) || event.keyCode==116){
		/**
			event.ctrlKey : 컨트롤키가 눌러져 있을 때
			event.keyCode==78 : N 새창열기
			event.keyCode==82 : R 새로고침
			event.keyCode==116 : F5키
		 */
		
		/*event.keyCode == 0; 
		event.cancelBubble = true;
		event.returnValue = false;*/

		/*return false;*/
	//}
};

var isShow = true;
window.onbeforeunload=function(){
	if(isShow){
		return "화면을 벗어납니다";		
	}
}

function validationForm(){
	var frm = document.forms[0];
	var title = document.getElementById("title");
	var content = document.getElementById("content");
	
	console.log(title.value, content.value);
	if(title.value=="" || content.value==""){
		alert("필수값을 입력해주세요")
	} else {
/*		var str = content.value;
		str = str.replace(/\r\n|\r|\n|\n\r/gim,"<br>");
		str = str.replace(/>/gim,'&gt;');
		str = str.replace(/</gim,'&lt;');
		str = str.replace(/\"/gim,'&quot;');
		str = str.replace(/\'/gim,'&#39;');
		document.getElementById("convertView").innerHTML = str;*/
		isShow = false;
		frm.submit();
	}
};