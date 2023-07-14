/**
 * thead에 있는 checkbox를 클릭 했을 경우 다른 (name="ch") checkbox를 true/false로 변경
 */
 
function checkAll(bool){
	console.log("checkAll " , bool);
	var chs = document.getElementsByName("ch");
	for(let i=0; i<chs.length; i++){
		chs[i].checked = bool;
	}
}

/**
	jQuery 방식을 통한 체크
 */
 
/*$(document).ready(function(){ // window.onload
	console.log("jQuery 동작 체크")
	$("#allCheck").click(function(){
		$(".ch").attr("checked", this.checked) // var chs = document.getElementsByName("ch"); 후 for문까지
	});
}); */

/**
	ch의 checked의 갯수를 확인하는 함수
 */
 
function chsConfirm(){
	var chs = document.getElementsByName("ch");
	var cnt = 0;
	for(let i =0; i<chs.length; i++){
		if(chs[i].checked){
			cnt++;
		}
	}
	return cnt;
}

/**
	ch가 모두 체크된다면 allCheck가 체크
	ch가 1개라도 체크가 해제된다면 allCheck가 해제
 */
window.onload=function(){
	var chs = document.getElementsByName("ch");
	var all = document.getElementById("allCheck");
	
	for(let i=0; i<chs.length; i++){
		chs[i].onclick=function(){
			if(chs.length==chsConfirm()){
				all.checked = true;
			} else {
				all.checked = false;
			}
		}
	}
}

/*
	submit 제어
	실행 이벤트를 button의 onclick로 작업
	실행 이벤트를 submit으로 작성해서 submit제어
*/

// 일반적인 방법의 submit 제어
/*function chkSubmit(){
	var chsCnt = chsConfirm();
	if(!chsCnt>0){
		alert("한 개 이상의 글을 체크하세요.")
		return false;
	} else {
		
	}
}*/

// sweet alert 1.1.3 버전 => callback : 함수
// sweet alert 2.x 버전 => promise 객체 : then ~~

function chkSubmit(){
	if(chsConfirm()>0){
		swal({
		    title: "다중 삭제?",
		    text: "삭제를 진행하시겠습니까?",
		    type: "warning",
		    showCancelButton: true,
		    /*confirmButtonColor: '#DD6B55',*/
		    confirmButtonClass: 'btn-danger',
		    confirmButtonText: '예',
		    cancelButtonText: "아니요",
		    closeOnConfirm: true,
		    closeOnCancel: true
		},
		function(resp) {
		    console.log(resp)
		    if (resp) {
		        swal("삭제!", "삭제를 실행 하겠습니다.", "success");
		        submitForm();
		    } else {
		        swal("취소!", "삭제를 취소 하겠습니다.", "error");
		    }
		});
	} else {
		swal("한 개 이상의 글을 선택해주세요.");
	}
	return false;
}

function submitForm(){
	document.forms[0].submit();
}

function del(val){
	console.log("삭제", val);
	var con = confirm("선택된 글이 DB에서 삭제됩니다.");
	if(con){
		location.href="./boardDelete.do?seq="+val;
	} else {
		alert("삭제가 취소 되었습니다.");
	}
}

function modify(val){	
	console.log("수정", val);
	location.href="./boardModify.do?seq="+val;
}

function reply(val){
	console.log("답글", val);
	location.href="./boardReply.do?seq="+val;
}

function contentCheck(){
	var obj1 = document.getElementById("hiddenContent").value;
	var obj2 = document.getElementById("txtArea").value;
	
	console.log("obj1", obj1);
	console.log("obj2", obj2);
	
	var obj3 = obj2.replace("원본글>","");
	
	if(obj1==obj3){
		document.getElementById("txtArea").value="";
		document.getElementById("contxt").innerHTML="내용<br>(작성중)";
		document.getElementById("chkContent").value="N";
	}
}

function resetValue(event){
	/*event.preventDefault();*/
	
	document.getElementById("contxt").innerHTML="내용<br>(원본)";
	document.getElementById("txtArea").value="Y";
	
}

function checkContxt(){
	var check=document.getElementById("chkContent");
	if(check=='Y'){
		alert("답글 내용을 입력해주세요");
		return false;
	}
}