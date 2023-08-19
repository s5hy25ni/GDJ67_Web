/*
	이벤트 전파 : 각 요소가 중첩(포함, 겹침)인 경우, 하나의 이벤트가 발생하면 중첩된 요소의 이벤트로 모두 차례대로 이벤트가 발생된다
	이벤트 전파막기 : stopPropagation() - 이벤트 요소를 막는다 // javascript 이벤트 onXXX
				 preventDefault() - 이벤트에 의한 기본 동작을 막는다 // html 기본 동작 막음
				 return false; - 위 두개를 다 막음
	기본의 Propagation 없이 진행되면 중첩되어 있기 때문에 a-> p -> div -> HTML href 동작
	하지만 중간에 p태그 이벤트 stopPropagation을 작성하면 a -> p -> HTML href 동작
*/

$(function(){
	$("a:eq(0)").click(function(e){ // click 이벤트를 담고 있는 객체를 e 변수로 받아줌
		alert("a 클릭!");
		console.log(e);
		e.preventDefault(); //href를 막는다
		e.stopPropagation();
//		return false;
	});
	
	$("p").click(function(){
		alert("p 클릭");
	});
	
	$("div").click(function(){
		alert("div 클릭");
	});
	
	// 이벤트 메소드 종류 : click(), change(), keyUp(), submit()...
	// 이벤트 핸들러(이벤트의 발생을 도와주는 것) : bind(), unbind(), live(), die() ...
	console.log($("a:eq(1)"));
	$("a:eq(1)").bind(
		{"mouseover":
		function(){
			$(this).css("background","blue")
		}
		,"mouseout":
		function(){
			$(this).css("background","white")
		}
		});
		
	// bind()를 통해 화면이 렌더링 될 때 없었던 이벤트를 생성할 수 있다
	// 생성된 이벤트를 제거하는 unbind()
	// var interval = setInterval("함수","시간")
	// clearInterval(interval)
	
	$("span").click(function(){
		$("a:eq(1)").unbind();
	});
	
	// 요소추가
	$("button").click(function(){
		$("body").append("<p>새로추가된 p태그</p>")
		// innerHTML 혹은 javascript의 setAttribute를 통해서 이벤트를 설정해줘야 함
		$("body").append("<p onclick='alert(100);'>새로추가된 p태그</p>")
	});
	
	// 51번째 줄에서 나중에 생성된 Element에 이벤트를 걸어 줌
	// 렌더링시 생성된 p태그가 아니기 때문에 이벤트 핸들러가 존재하지 않음
	// 이전에 생성된 tag가 아닌 추가된 p tag이기 때문에 event를 걸어 줄 수가 없다.
	// on을 통해서 처리해준다
	$("body").on("click","p",function(){
		alert("on으로 추가된 새로운 이벤트");
	});
});