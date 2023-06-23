/**
 *  화면에 DOM 탐색을 한 후 결과
 	1) ""
 	2) null : 화면에 없는 element를 호출
 	
 */
 
 function variable_scope(){
	var empty = document.getElementById("empty");
	console.log(empty); // 탐색 결과가 없으면 null
	/*console.log(empty.value);*/ // null에 기능(function)을 동작시키면 오류 발생
	var uninital;
	console.log(uninital); // undefined, 화면이 아니라 javascript에서 선언만 되어 있는 변수를 호출 했을 때
	console.log(typeof uninital); // undefined는 타입임
	
	var initial_Value = 10; // number
	initial_Value = 'rainbow'; // string
	var initial_Value = true; // boolean
	console.log(typeof initial_Value);
	
	/**
		javascript는 같은 변수에 다른 타입의 값을 대입할 수 있음
		같은 이름의 변수를 계속해서 선언할 수 있음
		scope는 var로 선언된 변수에서 사용가능 (변수 선언의 종류 : var, let, const)
	 */
	 
	 console.log("a="+a);
	 var a=10;
	 var date = new Date();
	 
	 if(1){ 
		// 객체가 null/undifined가 아니면 true
		// 1은 true, 0은 false
		// 논리연산자의 판단 : 객체가 있으면, true, 1이면 무조건 실행
		/*console.log(a);*/
		
		var b = 100;
		var b = 200;
		b = 300;
		
		for(var c=0; c<5; c++){
			console.log("c="+c);
		}
		console.log("c="+c);
		
	} // if
	
	console.log("b="+b);
	
	// ES6문법 var의 scope가 너무 사용하기 어렵기 때문에 선언을 구분
	// 지역 변수 : let
	// 상수 : const
	
	/*console.log("i", i);*/ //let는 선언된 변수 다음에만 사용 가능
	let i = 1;
	
	for(let j = 0; j<3; j++)
	console.log(j);
	/*console.log(j);*/ // 괄호가 없다면 바로 밑에 있는 애 1개만 실행
	
	/*console.log(j);*/ // let는 로컬변수여서 scope의 범위가 한정되어 있음
	
	/*const PI;*/ // const variables must have an initializer , 선언과 입력이 반드시 동시에
}

// 전역 변수
// 상위에 선언된 변수를 javascript에서 모두 사용할 수 있다.
console.log("global_variable", variable);
var variable = 100; // var없으면 문제가 발생(선언이 아님)
function global_variable(){
	console.log("global_variable", variable);
	variable = variable+10;
	document.getElementById("v1").textContent = variable;
	document.querySelector("input").value = variable;
	document.getElementsByTagName("input")[0].value = variable;
}

function local_Scope(){
	console.log("local_Scope");
	// 69번째 줄에 variable의 변수명으로 전역 변수가 선언되어 있다.
	// 그런데 만약에 함수 내에서 variable 변수를 재정의 하면 => 지역 변수로 변경
	alert(variable);
	var variable = variable+99; // 지역 scope로 변경이 됨
	document.getElementById("v2").textContent = variable;
}

function local_Variable(){
	// let를 통한 변수의 선언은 상위 변수의 이름을 사용할 수 없음
	let variable1 = variable + 99;
	document.getElementById("v2").innerHTML = "<b>"+variable1+"</b>";
}

function variableType(){
	
}