function numCheck01(){
    /**
     * javascript 타입
     * HTML에 화면에 출력 되어있는 TextNode를 가져오면 모두 string => content, value
     * 
     * DOM 탐색
     * document.탐색
     * document.getElement[s] : s가 붙으면 NodeList 형태로 가지고 옴 아닌 경우 Node
     * ** DOM 탐색의 결과는 위치 => pass by reference
     * 
     * 탐색된 위치 값을 처리 하는 방식
     * Empty Element(닫힘 tab가 없음) : 속성(attribute)로 값을 가지고 있음 ex) <input value="">
     * Markup tag(well-form) 한 tag : innerHTML - 선택된 HTML의 하위의 모든 html을 string으로 가져옴
     *                                 textContent - textNode을 만들 때 선별적으로 가져옴
     * 
     * form 요소 : <input>, <textarea>, <fieldset> -> 서버에 데이털르 전송할 수 있는 영역(HTML 전송)
     * form 요소 : textarea : <textarea>콘텐츠</textarea> 콘텐츠를 브라우저가 번역하지 않고 보이는 그대로 전송
     *                          마크업 사이에 공백 XX
     *                          값을 입력하거나 가져올 때 : markup 방식이 아닌 value를 통해서 사용
     * <form> -> type=submit, form에 javascript 이벤트(onumbmit())를 통해 보낼 수 있음
     *          action의 속성으로 server로 전송, method 처리되는 protocol을 정의 -> server에서 요청을 받음
     * <form> 내에서만 동작되는 submit, reset
     * 
     */
    var num = document.getElementsByName("num")[0].value;
    var realNum = document.getElementById("realNum").value;
    var phone = document.getElementById("phone").value;

    var regExNum = /[0-9]/g;
    var numChk = num.search(regExNum); // 정규화를 판단하여 맞다면 0 다르면 -1
    if(numChk == -1){
        alert("숫자가 아님");
    } else {
        alert("숫자임");
    }

    // 전화번호 판단
    var regExPhone = /^\d{2,3}-\d{3,4}-\d{4}$/

    // 한 개의 Node를 검색할 때 name이 없다면 결과는 : null;
    var tmp1 = document.getElementById("tmp");
    console.log(tmp1);
    var tmp2 = document.getElementsByName("tmp")[0];
    console.log(tmp2); // undefined

    // ** 탐색이 되면 null 체크할 필요가 없다.


    // if(!isNaN(num)){
    //     alert(`첫 번째 입력값(${num})은 숫자입니다.`);
    // } else {
    //     alert(`첫 번째 입력값(${num})은 숫자가 아닙니다.`);
    // }

    // if(!isNaN(realNum)){
    //     alert(`두 번째 입력값(${realNum})은 숫자입니다.`);
    // } else {
    //     alert(`두 번째 입력값(${realNum})은 숫자가 아닙니다.`);
    // }

    // if(!isNaN(phone)){
    //     alert(`세 번째 입력값(${phone})은 숫자입니다.`);
    // } else {
    //     alert(`세 번째 입력값(${phone})은 숫자가 아닙니다.`);
    // }
}

function searchStr02(){
    var word = document.getElementById("val").value;
    var text = document.getElementsByTagName("pre")[0].textContent

    if(text.indexOf(word) != -1){
        alert(`검색어(${word}) 존재함`);
    } else {
        alert(`검색어(${word}) 존재하지 않음`);
    }
}

window.onload=function(){
    var site = document.getElementsByName("site");

    for(let i=0; i<site.length; i++){
        site[i].onclick=function(){
            console.log(site[i].checked, i);
            console.log(this.checked);
            // window.open(site[i].value);
            openURL(this.value);
        }
    }

    var subject = document.getElementsByName("subject");
    for(let i=0; i<subject.length; i++){
        subject[i].addEventListener("click", function(){
            if(checkedCnt()==subject.length){
                document.getElementById("all").checked=true;
            } else {
                document.getElementById("all").checked=false;
            }
        });
    }


};

function openURL(url){
    console.log(url)
    var urlName= url.substring(url.indexOf(".")+1, url.lastIndexOf("."));
    console.log("이동하는 사이트 ", urlName)
    open(url, urlName, "width=450px, height=800px");
}

function allchk04(bool){
    var subject = document.getElementsByName("subject");
    for(let s of subject){
        s.checked=bool;
    }
}

$(function(){
    $("#allj").click(function(){
        if($("#allj").prop("checked")){
            $("input[type=checkbox]").eq(0).prop("checked", true);
        } else {
            $("input[type=checkbox]").prop("checked", false);
        }
    });
});

function checkedCnt(){
    var cnt = 0;
    var subject = document.getElementsByName("subject");
    for(let i=0; i<subject.length; i++){
        if(subject[i].checked){
            cnt++;
        }
    }
    return cnt;
}

function randomNum05(){
    document.getElementById("rdmNum").value = Math.floor(Math.random()*(20-1)+1);
}

function selPage06(){
    // selected : 자식(option) 중에서 선택된 자식의 형태
    // options : 자식의 tag의 집합
    //              document.getElementsByTagName("btn")
    //              DOM(select).option[]
    // selectedIndex : 선택된 자식 option의 element index값
    var selsite = document.getElementById("selsite");
    location.href=selsite.options[selsite.selectedIndex].value;
}

function sortNum(){
    var numStr = document.getElementById("numVal").textContent;
    var numArr = numStr.trim().split(',');
    // var removeSpace = numStr.replace(/\s/g, '');

    // javascript은 값을 가지고 정렬
    // 모든 값은 문자로 처리 => 객체의 타입이 문자||숫자에 관계 없이
    // Lexicographic, Letters 순서로 되어 있음
    // callBack 함수를 만들어서 내부에서 각 값들의 차이를 반환하도록 하는 function을 만들어야 함

    // desc는 없음 -> 문자열 sort를 사용하여 정렬 후 reverse()를 사용

    // for(let i=0; i<numArr.length; i++){
    //     numArr[i]=parseInt(numArr[i]);
    // }
    

    // document.getElementById("numSort").textContent = numArr.sort(compare).toString();
    document.getElementById("numSort").textContent = numArr.sort((a,b)=>a-b).toString();
    // document.getElementById("numSort").textContent = numArr.sort((a,b)=>b-a).toString(); // reverse
}

function compare(a, b){
    return a-b;
}

var reverseStr = function(arr){
    var arrNew = new Array();
    for(let i=0; i<arr.length; i++){
        arrNew.push(arr[arr.lenght-1-i]);
    }
    return arrNew;
}

function life(){
    var birth = document.getElementsByName("birthday")[0];
    var now = document.getElementById("nowDate");
    var sysDate = new Date();
    
    var sysYear = sysDate.getFullYear();
    var sysMonth = sysDate.getMonth()+1;
    var sysMonthStr = (""+sysMonth).length==2?(""+sysMonth):("0"+sysMonth);
    var sysDate = sysDate.getDate();
    var sysDateStr = (""+sysDate).length==2?(""+sysDate):("0"+sysDate);

    now.value=sysYear+"-"+sysMonthStr+"-"+sysDateStr;

    var birthTime = new Date(birth.value).getTime();
    var nowTime = new Date(now.value).getTime();
    document.getElementById("dateVal").textContent = (nowTime-birthTime)/(1000*60*60*24);
}

function domTest(){
    var formInfo = document.getElementById("formInfo").children;

    //OGNL : id가 아니라 name일 때 가능
    var form = document.info;
    var formValues = [form.id.value, form.pw.value, form.addr.value, form.phone.value];
    console.log(formValues);

    var table = document.createElement('table');
    table.setAttribute('style', 'width:200px');

    var thead = document.createElement('thead');
    var tbody = document.createElement('tbody');

    var theadTr = document.createElement('tr');
    var tbodyTr = document.createElement('tr');

    for(let i=0; i<formInfo.length-1; i++){
        if(formInfo[i].hasAttribute("type")){
            var theadTd = document.createElement('td');
            var tbodyTd = document.createElement('td');
            var theadTxt = document.createTextNode(formInfo[i].name);
            var tbodyTxt = document.createTextNode(formInfo[i].value);
            theadTd.setAttribute('style', 'background-color:yellow');
            tbodyTd.setAttribute('style', 'background-color:yellow');
            theadTd.appendChild(theadTxt)
            tbodyTd.appendChild(tbodyTxt);
            theadTr.appendChild(theadTd);
            tbodyTr.appendChild(tbodyTd);
        }
    }

    thead.appendChild(theadTr);
    tbody.appendChild(tbodyTr);

    table.appendChild(thead);
    table.appendChild(tbody);

    document.getElementById("domTable").appendChild(table);


    
}

function guguDanView(){
    var dan = document.getElementById("guguVal");
    var inner = "";
    if(isNaN(dan.value)){
        alert("숫자만 입력하세요.");
    } else {
        for(let i=2; i<10; i++){
            inner += dan.value+"×"+i+" = "+(dan.value*i)+"<br>";
        }
    }
    document.getElementById("guguPrint").innerHTML = inner;
}