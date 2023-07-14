// 쿼리스트링을 만들어주는 함수
// ?키=값&키=값
// $("셀렉터표현식") => document.getElement[s]XXXXX
function getParameterValue(){
	var name="name="+$("#name").val();
	var kor="kor="+$("#kor").val();
	var eng="eng="+$("#eng").val();
	var math="math="+$("#math").val();
	
	console.log(name+"&"+kor+"&"+eng+"&"+math);
	return (name+"&"+kor+"&"+eng+"&"+math);
}

// $(document).ready(function({}));
$(function(){
	// Ajax GET 방식으로 실행
	$("#process").click(function(event){ // event를 넣을 수 있다.
		ajaxLoad()
	});
	
	// Ajax POST 방식으로 실행
	$("#process2").click(function(){
		ajaxLoad2()
	});
});

/**
	XMLHttpRequest : javascript에서 Object를 통한 HTTP 데이터를 송수신이 가능하도록 만들어 주는 객체
		주요 용어
			state(작동 진행)
			status(작동 후 상태)
			
	onreadystatechange : state의 상태 정보
	-- readyState의 상태
	0 uninitalized : 실행(로딩)이 되어 있지 않음
	1 loading : 로드 진행
	2 loaded : 로드 완료
	3 interactive : 통신
	4 complete : 완료
	
	각각의 state에서 callback을 통해 상태를 반환
	-- status code
	200 : 성공
	403 : 인증되지 않음(로그인X || 키X)
	404 : 요청 페이지가 없음
	405 : 요청 프로토콜이 없음
	500 : 서버 문제(서버에서 값을 받지 못함)
*/
 
// XMLHttpRequest 객체 선언
var httpRequest = null;
function ajaxLoad(){
	// 요청 -> 송수신 객체 생성 -> callback(값 처리) 함수를 state에 넣어줌 -> 연결 -> 보내줌
   var url = "./ScoreCal.do?"+getParameterValue();
   console.log(url);
   httpRequest = new XMLHttpRequest();//서버와 송수신을 위한 통신 객체 생성
   console.log(httpRequest)
   httpRequest.onreadystatechange =callback;//각 state에 처리된 callback 함수 생성
   httpRequest.open("GET",url,true);//"GET방식"으로 해당 "URL"에 "비동기식"으로 연결하겠다
   httpRequest.send();//연결(호출)하겠다
	
}

// state에 따라서 callback함수가 실행
function callback(){
	/*alert("httpRequest.readyState : "+httpRequest.readyState);*/
	console.log(httpRequest.readyState);
	alert("서버에서 처리된 결과 코드 : "+httpRequest.status);
	
	if(httpRequest.readyState == 4){
		alert("통신이 완료되었습니다.")
		if(httpRequest.status == 200){
			alert(httpRequest.responseText);
			var obj = JSON.parse(httpRequest.responseText);
			$("#result").html(obj.name+" 총점 : "+obj.sum+"평균 : "+obj.avg);
		} else {
			alert("데이터를 수신할 수 없습니다.");
		}
	}
}

// POST 프로토콜의 처리 방식은 화면의 HTML을 보낸다.
function ajaxLoad2(){
   var url = "./ScoreCal.do"; // 요청할 서버의 주소
   httpRequest = new XMLHttpRequest();//서버와 송수신을 위한 통신 객체 생성
   httpRequest.onreadystatechange =callback2;//각 state에 처리된 callback 함수 생성
   alert(httpRequest.onreadystatechange);
   httpRequest.open("POST",url,true);//"GET방식"으로 해당 "URL"에 "비동기식"으로 연결하겠다\
   httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
   httpRequest.send(getParameterValue());//연결(호출)하겠다
}

function callback2(){
	if(httpRequest.readyState == 4){
		if(httpRequest.status == 200){
			var obj = JSON.parse(httpRequest.responseText);
			$("#result").html(obj.name+" 총점 : "+obj.sum+"평균 : "+obj.avg);
		} else {
			alert("데이터를 수신할 수 없습니다.");
		}
	}
}