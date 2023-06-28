/**
 * 엘리먼트 생성하기 : createElement("태그명")
 * 속성 객체 생성하기 : createAttribute("속성명")
 * 콘텐츠 생성하기 : createTextNode("내용")
 * 속성 추가하기 : setAttributeNode("속성명") / setAttribute("속성명", "속성값")
 * 
 * var t = "<a href='http://www.naver.com'>이동합니다</a>";
 * 
 * ※ append
 */

function elementCreate(){
    // 1. HTML을 string으로 작성 후 : body에 div를 작성하고, 속성을 입력하고, 글을 입력하고, html에 있는 <p> 태그에 자식노드로 붙혀 넣음
    var tmp = "<div style='border:1px solid black;'>안녕하세요 동적 추가 입니다.</div>";
    // document.getElementById("loc").innerHTML = tmp;
    // document.getElementById("loc").append(tmp); // element가 아닌 text로 인식
    // document.getElementById("loc").appendChild(tmp); // 객체(createElement()로 생성)만 인식 = element

    // 2. Element 객체로 작성 후 : body에 div를 작성하고, 속성을 입력하고, 글을 입력하고, html에 있는 <p> 태그에 자식노드로 붙혀 넣음
    // $('div') : JQuery 객체
    var div = document.createElement('div'); // <div></div>
    var attr = document.createAttribute("style"); // style=""
    var txt = document.createTextNode("안녕하세요 동적 추가 입니다!!"); // 안녕하세요 동적 추가 입니다!!

    // 1) 속성 추가
    // attr.nodeValue = "border: 1px solid tomato"; // style="border: 1px solid tomato";
    // div.setAttributeNode(attr); // <div style="border: 1px solid tomato"></div>

    // 2) 속성 추가
    div.setAttribute("style", "border: 1px solid lime"); // <div style="border: 1px solid lime"></div>
    div.appendChild(txt);// <div style="border: 1px solid lime">안녕하세요 동적 추가 입니다!!</div>

    document.getElementById("loc").appendChild(div);
}