/**
 * 
 */
// 명시적 함수 : 명시적으로 이름을 선언해서 사용
function func01(){
    console.log("명시적 함수 : function 함수명(){}");
}
// 익명적 함수 : 함수인데 이름을 가지고 있지 않고 변수의 값으로 담겨 있음
var func02 = function(){
    console.log("익명적 함수 : var 변수명 = function(){}");
}

// 함수 리터럴 : 함수(function)가 변수의 값이 되어 사용되어짐
//              arguments/parameter도 변수 => 함수가 다른 함수를 arguments로 받을 수 있다.
function func03(){
    literalFn(function(msg){alert(msg)});
}

function literalFn(literal){
    literal("안녕하세요 함수입니다.")
}

function valuesArguments(a,b,c,d){ // arguments가 없어도 문제 없음
    console.log(arguments[0])
    console.log(arguments[1])
    console.log(arguments[2])
    console.log(arguments[3])
    console.log(arguments[4]) // undefined

    try{
        console.log(a,b,c,d,e); // e는 선언되지 않았으므로 error
    } catch(e){
        console.log(e);
    }
    console.log("Arguments");

    // index for
    // enhanced for : in, of 연산자
    //                  in은 array의 index
    //                  of는 array의 객체
}

// setInterval(실행함수, 반복시간)
// var demo = document.getElementById("demo")
// var start = setInterval(function(){demo.innerHTML+='hello'},1000);

// function stopInterval(){
//     clearInterval(start);
// }

// HTML을 DOM탐색을 하면 결과는 작성된 방식, 포함된 node에 따라 결과가 다름
function pPrint(){
    var p = document.getElementsByTagName("p");
    console.log(p.length);
    console.log(p);
    // index방식으로 in을 사용하면 web에서의 DOM탐색 결과는 다를 수 있음
    // for(let i in p){
    //     console.log(p[i].tagName, p[i].textContent);
    //     // in 함수을 사용하면 객체가 가지고 있는 함수들도 같이 호출
    // }
    // 아래와 같이 length로 범위를 잡아주면 괜찮
    for(let i=0; i<p.length; i++){
        console.log(p[i].tagName, p[i].textContent);
    }

    for(let i of p){
        console.log(i, i.textContent);
    }
}

function closureTest(){
    closureFn("JS")("KOR");
}

function closureFn(val){
    function addVal(msg){
        alert(val+":"+msg);
    }
    return addVal;
}

// var amEdu = function(val){
//     console.log(val);
// }

// var amEdu = closureFn(v); // amEdu is not a function

var amEdu = closureFn("HTML");

console.log(amEdu);