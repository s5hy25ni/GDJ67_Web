function childAppend(){
    //body에 존재하는 element를 탐색
    var fieldSet = document.getElementById("addElement");

    //생성하는 element
    var p = document.createElement("p");

    //fieldSet의 자식 tag 중 마지막에 붙여 넣음
    var txt = document.createTextNode("appedChild는 맨 뒤에 붙어요");
    // p.appendChild(txt); // <p>appedChild는 맨 뒤에 붙어요</p>
    p.textContent = "appedChild는 맨 뒤에 붙어요";
    // fieldSet.append(p); // 문자열HTML로 전달하면 문자열로 출력, 객체로 하면 appendChild
    // fieldSet.append("<p>안녕하세요</p>");
    // fieldSet.appendChild("<p>안녕하세요</p>"); // 문자열 HTML로 전달되지 않는다.
    fieldSet.appendChild(p); // element 객체만 입력 가능;
}

var cnt=1;
function beforAppend(){
    var newP = document.createElement("p");
    newP.textContent = "Element 앞에 붙여 준다."+(cnt++);

    var fieldSet = document.getElementById("addElement");

    // 붙여 넣을 곳
    var oldDiv = document.querySelector("fieldset>div");

    // insertBefore(추가할 Element 위치)
    fieldSet.insertBefore(newP, oldDiv);

    // 자식노드를 검색 :
    // 1) childNodes : 모든 node를 인식(textNode, tagElement)
    // 2) children : Element만 인식
    // ※ childNodes는 HTML에 작성되는 작성방식에 따라서 달라짐
    // <div><p></p><p></p></div> : 1개만 나옴
    /*
        <div>
            <p></p> : 공백, P
            <p></p> : 공백, P
                    : 공백 => 5개
        </div>
    */
}

function moveAppend(){
    /*
        document.getElementById : Node
        document.getElementsByTagName||Name||Class : NodeList[]

        // css 표현식
        document.querySelector : Node
        document.querySelectorAll : NodeList[]
    */
    var moveEle = document.querySelector("fieldset");
    
    console.log(moveEle);
    console.log(moveEle.tagName);
    console.log(moveEle.nodeName);

    /*
        Element의 복제가 아닌 객체의 위치 주소를 알려줌
        객체를 복사하기 위해서는 복사 함수(cloneNode())를 통해서 객체를 복사해야함
        만약에 자식노드(textNode, Element)를 모두 복사하기 위해서는 반드시 argument를 true로 입력

        ex) <div><p>컨텐츠</p></div>
            ☞ cloneNode() => <div></div>
            ☞ cloneNode(true) => <div><p>컨텐츠</p></div>
    */

    // body의 위치
    var addEle = document.body;
    // var copyEle = moveEle.cloneNode(true); // 하위 태그를 모두 복사
    // var copyEle = moveEle.cloneNode(); // 선택된 Element만 ㅂ고사
    // addEle.appendChild(copyEle);

    var pasteEle = document.querySelector("fieldset").children[1];
    addEle.appendChild(pasteEle); // 이동한다
}

function addTest(){
    var test01 = document.getElementById("test01");
    var div = document.createElement("div");
    var txt = document.createTextNode("DOM TEST");

    div.appendChild(txt);
    test01.appendChild(div);
}

function moveTest(){
    var test02 = document.getElementById("test02");
    var moveDiv = document.querySelector("#test01>div");
    test02.appendChild(moveDiv);
}