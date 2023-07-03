/**
 * 실질적인 데이터를 사용하여 처리
 * axios를 사용하여 ajax 통신을 진행
 * axios를 설치
 * npm i axios
 */

/**
 * ajax -> 서버 -> response -> 값(data) (SPA, Single Page Application) : jQuery, fetch || axios(promise의 값과 성공 여부 : Promise 객체)
 * html.jsp -> 서버 -> request -> JSP, HTML (MPA, Multi Page Application)
 */
const axios = require("axios");
// const data = axios.get("https://cat-fact.herokuapp.com/facts");
const data = axios.get("https://www.google.com"); // promise 객체에 직접적으로 담김
console.log(data);

data
    .then((res)=>{
        console.log(res.data);
    })
    .catch((err)=>{
        console.log(err);
    })
    .finally(()=>{
        console.log("Promise 객체 설명중");
    })