function btn01(){
	var obj = $("input:text").val();
	console.log(obj);
}

function btn02(){
	var obj = $("input:radio").eq(1).val();
	console.log(obj);
	
	var obj2 = $("input[type=text][value=아이디]");
	
//	var obj3 = $("input:radio");
	var obj3 = document.getElementsByClassName("rdo");
	console.log(obj3.length);
	for(let i=0; i<obj3.length; i++){
		console.log(obj3[i].value, obj3.eq(i).val());
	}
	
	$("input:radio").each(function(index, item){
		console.log(item.value);
	});
}

function btn03(){
	var obj = $("input[type=checkbox]").val();
	console.log(obj);
}

$(function(){
	//jQuery이벤트는 on으로 시작하지 않음
	// ~~.addEventListener("click",function(){})
	$("select").change(function(event){
		console.log(event);
		alert($("select option:selected").val());
	});
	
	var selEle = document.getElementsByTagName("select")[0];
	selEle.onchange = function(){
		alert(selEle.options[selEle.selectedIndex].value);
	}
});

function btn04(){
	//전체 개수
	var len = $("input:checkbox[name=isChk]").length;
	console.log(len);
	
	//선택 개수
	var chLen = $("input:checkbox[name=isChk]:checked").length;
	console.log(chLen);
	
	//1)전체 체크
//	$("input:checkbox[name=isChk]").prop("checked",true);
	
	//2-1)전체 체크
//	$("input:checkbox[name=isChk]").each(function(){
//		this.checked = true;
//	});
	
	//2-2)
//	$("input:checkbox[name=isChk]").each(function(index, item){
//		console.log(index, item.checked);
//	});
	
	//3) is문
	if($("input:checkbox[name=isChk]").is(":checked") == true){
		console.log(this);
	}
}



