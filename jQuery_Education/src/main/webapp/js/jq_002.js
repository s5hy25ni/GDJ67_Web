$(document).ready(function(){
   $("fieldset:eq(0)").css({"border":"1px solid red","width":"300px"});
   $("#view").css({"border":"1px solid red","width":"400px","height":"150px"});
});

// a1 tag로 선택하기
function a1(){
   //jQuery에서는 tag로 탐색을 하면 NodeList로 처리해준다
   //index번호를 eq(index), 만약에 검색된 NodeList의 객체에 이벤트를 적용하면 모든 Node에 적용
   console.log($("span").length);
   $("span").css("color","green");
   // inenrHTML,textContent = html(), text()
//   $("#view").html("<b>글작성</b>");
   $("#view").text("<b>글작성</b>");
   console.log($("#view").text())
}

//a2() ID로 선택하기
function a2(){
   //$는 jQuery로 표기 했었음,약자였음
   jQuery("#t1").css("color","skyblue");
   jQuery("#view").text('jQuery("#t1").css("color","skyblue");');
}

//a3() Class로 선택하기
function a3(){
   $(".t2").css("backgroundColor","yellow");
   jQuery("#view").text('$(".t2").css("backgroundColor","yellow");');
}

//a4() parent child로 선택하기
//div span{} : 상위 div를 가지고 그 하위에 있는 모든 자식 span을 선택
//div, span {}: div와 span을 모두 다 선택
//div>span {} : 상위 div를 가지고 바로 아래 자식 span을 선택
//div[name=*'btn'] : div 중에서 name의 속성을 가지고 있고, 값 btn을 포함하는 div를 선택
//input[type='checkbox':checked]

function a4(){
   $("li span").css("color","red");
   $("li,span").css("color","orange");
   $("li>span").css("color","black");
}

//a5() parent &gt; child로 선택하기
function a5(){
   $("li>span").css("backgroundColor","lime");
}

//a6() :nth-child(n/odd/even)로 선택하기
//tbody> tr:nth-child(odd){}
function a6(){
//   $("li:nth-child(odd)").css("backgroundColor","black");
//   $("li:nth-child(even)").css("backgroundColor","black");
   $("li:nth-child(7n)").css("backgroundColor","black");
}

function a7(){
   $("li:first-child").css("border","2px dotted red");
}
function a8(){
   $("li:last-child").css("border","2px dotted red");
}