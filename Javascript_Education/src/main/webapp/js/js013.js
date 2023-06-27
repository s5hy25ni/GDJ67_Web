/**
 * 
 */

// let number = [1, 2, 3, 4, 5];
// console.log(typeof number, number, number.length);

// for(let i = 0; i < number.length; i++){
//     console.log("idx : " + number[i]);
// }

// for(let i in number){
//     console.log("in : " + number[i]);
// }

// for(let i of number){
//     console.log("of : " + i);
// }

// number.forEach(function(x){
//                    console.log("forEach : "+x);
//                 });

// 1. 배열의 선언
var arrayObj = new Array(); // Array의 객체 생성 방법
var arrayLiteral = ["a1", "a2", 3, 4]; // type의 구분이 없음
// console.log(typeof arrayObj);
// console.log(typeof arrayLiteral);

// 2. 배열의 선언 방식 종류
var arrayObj02 = new Array(); // 선언
var arrayObj03 = new Array(5); // 크기
var arrayObj04 = new Array(1,2,3,4); // 1,2,3,4가 들어있는 array


arrayObj02[0]=10;
arrayObj02[2]=20;

// 객체가 있을 때 index를 지정하여 입력하면 자동으로 해당 인덱스가 생성되고 값이 입력됨
// 만약 index가 생성되진 index보다 크다면 하위에 index에 객체가 생성되고 값은 undefined
// console.log(arrayObj02[0], arrayObj02[1], arrayObj02[2]);
// console.log(arrayObj02);
// console.log(arrayObj02[-1]);
// console.log(arrayObj02.length);

// 하나의index에는 
// console.log(arrayObj03); // empty
// console.log(arrayObj03[0]) // undefined
// console.log(arrayObj03[6]);
// console.log(arrayObj.length);

// console.log(arrayObj04);
arrayObj04[5] = 10;
// console.log(arrayObj04[5]);
// console.log(arrayObj04.length);


function multiArray(){
    var len = 3;
    var arr = new Array(len);
    for(let i=0; i<len; i++){
        arr[i] = new Array(len);
    }

    arr[0][0] = "apple";
    arr[0][1] = "banana";
    arr[0][2] = "tomato";

    arr[1][0] = 1;
    arr[1][1] = 2;
    arr[1][2] = 3;

    arr[2][0] = ["java", "javasscript"];
    arr[2][1] = ["jsp", "servlet"];
    arr[2][2] = ["oracle", "mysql"];

    console.log(arr[2][1][1]);
}

function joinFn(){
    var array01 = ["apple", "banana", "lemon", 3];
    var array02 = [1, 2];
    var array03 = [3, 4];

    // join array의 각 요소를 하나의 문자열로 생성 conjunction을 통해서 붙여줌
    var joinArray = array01.join("-");
    console.log(typeof joinArray, joinArray);

    var arraySum = array02.join(array03);
    console.log(typeof arraySum, arraySum);

    var  arrayConcat = array02.concat(array03);
    console.log(typeof arrayConcat, arrayConcat);
}

function sortStringFn(){
    // 문자만 혹은 숫자만 있는 Array에서는 sorting의 문제가 발생하지 않음
    var arr = ['a', 'd', 'b', 'c'];
    var arrStr = ['1', '10', '4', '30'];
    var arrNum = [1, 4, 2, 6];
    // 숫자 문자 null
    var random = ['a', 1, null, 'b', 10];
    
    arr.sort();
    arrStr.sort();
    arrNum.sort();
    random.sort();

    console.log(arr);
    console.log(arrStr);
    console.log(arrNum);
    console.log(random);
}

function sortNumberFn(){
    var arr=['1', '10', '4', '30'];
    arr.sort(compare);
    console.log(typeof arr, arr);

    var arrNum=[1, 10, 5, 7];
    arrNum.sort(compare);
    arrNum.reverse();
    console.log(arrNum);
}

function compare(a,b){
    return a-b;
}

function sliceFn(){
    var array01 = [1,2,3,4,5];
    // slice는 잘라내는 index를 포함
    // java에서는 substring과 유사

    var array01New = array01.slice(1);

    console.log(typeof array01New, array01New);

    var array02 = new Array(4);
    array02[0] = new Array(1,2);
    array02[1] = new Array(3,4);
    array02[2] = new Array(5,6);
    array02[3] = new Array(7,8);

    console.log(array02);

    var array02_slice = array02.slice(1,3);
    console.log(array02_slice);
}

function saveArray(){
    var queue = new Array();
    console.log(typeof queue, queue);

    queue.push(1);
    queue.push("first");
    queue.push("second");
    queue.push("third");

    console.log(queue);

    // shift : Array 의 앞부터 잘라냄
    console.log(queue.length);
    var a0 = queue.shift();
    console.log(queue.length, a0);

    // pop : Array의 뒤부터 잘라냄
    var b0 = queue.pop();
    console.log(queue.length, b0);
}