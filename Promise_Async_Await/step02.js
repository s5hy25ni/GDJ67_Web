/*
    요청된 주소의 상태에 따라서
    요청/대시/에러를 나타낼 시간을 갖게 된다.
    이러한 문제점을 처리하기 위해 Promise 객체를 만들어 사용하게 된다.
*/

var req = fetch("https://cat-fact.herokuapp.com/facts");
console.log(req);