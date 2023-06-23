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
	var var02 = 5; // 정수
	var var03 = 3.14; // 실수
	console.log(typeof var02); // number
	console.log(typeof var03); // number

	var var04 = '문자';
	console.log(typeof var04); // string

	var var05 = [1, 3, 4, 7]; // array => object
	console.log(typeof var05);
	console.log(var05.length);
	console.log(var05[0]);
	for(let i=0; i<var05.length; i++){
		console.log(i, var05[i]);
	}

	for(let n in var05){ // index
		console.log(n);
	}

	for(let n of var05){ // value
		console.log(n);
	}

	var var06 = false; // 0(false) 1(true)
	console.log(typeof var06);

	var var07 = null; // null -> object
	console.log(typeof var07);
	console.log(var07+1); // 1
	console.log(var07+"kor"); // nullkor

	var undef;
	console.log(undef);
	console.log(undef+1); // undefined는 미지의 값이기 때문에 만약 숫자 연산을 처리하면 nan이 뜬다.(Not a Number)
	console.log(undef+"kor"); // undefinedkor

	// 변수에 함수를 값으로 가질 수 있다.
	// 변수에 함수를 값으로 갖고 있다면 함수는 이름이 없어진다.(익명함수)
	var var08 = function(id){
		alert("값="+id);
		return "값="+id;
	};

	/* 
		javascript의 function 은 parameter/argument가 선언되어 있어도 필수값이 아님
		선언만 되어 있는 변수가 되기 때문에 undefined가 된다.
	 */
	// console.log(var08); // 함수가 찍힌다.
	// console.log(var08()); // undefined
	console.log(var08("kor")); // undefine -> return이 없을 때
	console.log(typeof var08);

	// 객체 Node, Element
	// HTML은 tag로 되어 있음
	// HTML에 body tag를 탐색하면 Element를 가지고 옴 => 객체
	// HTML 내에 단독의 속성(ID)으로 탐색하면 하나의 Element
	// 			여러 개의 속성 tag, class, name 은 여러개 Elements => Array
	// Dom 탐색 후 id, class, name, tag 등이 없다면 null이 됨

	var var10 = document.getElementById("v1");
	console.log(typeof var10);
	console.log(var10);
	alert(var10);
}
