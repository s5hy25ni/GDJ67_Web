/**
 * DOM 탐색(Document Object Model) : node tree
 * 작성되어 있는 HTML을 (렌더링된 후) javascript를 통해서
 * Element의 위츠를 가져오는 것(object)
 * 
 * selector 방식 : CSS 선택자
 * 
 */

function searchQuerySelector(){
    var doc = document.querySelector("#query");
    // console.log(doc); // 객체를 가져옴
    // console.log(doc.textContent); // 텍스트만 가져옴(tab도 가져오기 때문에 trim() 필수
    // alert(doc.textContent.trim());
    // doc.textContent="<span>셀렉터표현식은 node(querySelector)이다. </span>";
    alert(doc);
    doc.innerHTML="<span>셀렉터표현식은 node(querySelector)이다. </span>";

    var doc1 = document.querySelectorAll("#query");
    alert(doc1[0]);
    // 셀렉터표현식은 NodeList(querySelectAll) 이다
}

function searchJQuery(){
    var doc = $("#query1");
    doc.html("<b>콘텐츠변경</b>")
    doc.css("color", "red");
    doc.hide(4000);
}

function searchId(){
    var doc = document.getElementById("testId"); // node
    doc.innerHTML = "<b>아이디로 탐색하기</b>";
    doc.style.color="skyblue";
    doc.style.backgroundColor="black";
    doc.title = "id로 검색됨";
}

function checkAll(bool){
    console.log(bool);
    var chk = document.getElementById("allCheck");
    console.log(chk.value); // checkbox는 value의 값이 변화 없이 on
    console.log(chk.checked); // checked를 통해서 결과를 받아옴

    var chk = document.getElementsByName("chk");
    for(let i=0; i<chk.length; i++){
        chk[i].checked = bool;
    }
}

function remove(){
    console.log("remove");

    var chk = document.getElementsByName("chk");
    for(let i=0; i<chk.length; i++){
       if(chk[i].checked){
        // chk[i].style.display="none";
        document.querySelectorAll("tbody tr")[i].style.display="none";
       }
    }
}