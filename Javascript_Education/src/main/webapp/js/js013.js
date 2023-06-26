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
console.log(typeof arrayObj);
console.log(typeof arrayLiteral);

// 2. 배열의 선언 방식 종류
var arrayObj02 = new Array(); // 선언
var arrayObj03 = new Array(5); // 크기
var arrayObj04 = new Array(1,2,3,4); // 1,2,3,4가 들어있는 array


arrayObj02[0]=10;
arrayObj02[2]=20;

// 객체가 있을 때 index를 지정하여 입력하면 자동으로 해당 인덱스가 생성되고 값이 입력됨
// 만약 index가 생성되진 index보다 크다면 하위에 index에 객체가 생성되고 값은 undefined
console.log(arrayObj02[0], arrayObj02[1], arrayObj02[2]);
console.log(arrayObj02);
console.log(arrayObj02[-1]);
console.log(arrayObj02.length);

// 하나의index에는 
console.log(arrayObj03); // empty
console.log(arrayObj03[0]) // undefined
console.log(arrayObj03[6]);
console.log(arrayObj.length);

console.log(arrayObj04);
arrayObj04[5] = 10;
console.log(arrayObj04[5]);
console.log(arrayObj04.length);