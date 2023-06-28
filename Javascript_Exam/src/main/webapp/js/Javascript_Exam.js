function numCheck01(){
    var num = document.getElementsByName("num")[0].value;
    var realNum = document.getElementById("realNum").value;
    var phone = document.getElementById("phone").value;

    if(!isNaN(num)){
        alert(`첫 번째 입력값(${num})은 숫자입니다.`);
    } else {
        alert(`첫 번째 입력값(${num})은 숫자가 아닙니다.`);
    }

    if(!isNaN(realNum)){
        alert(`두 번째 입력값(${realNum})은 숫자입니다.`);
    } else {
        alert(`두 번째 입력값(${realNum})은 숫자가 아닙니다.`);
    }

    if(!isNaN(phone)){
        alert(`세 번째 입력값(${phone})은 숫자입니다.`);
    } else {
        alert(`세 번째 입력값(${phone})은 숫자가 아닙니다.`);
    }
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
            window.open(site[i].value);
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
}

function allchk04(bool){
    var subject = document.getElementsByName("subject");
    for(let i=0; i<subject.length; i++){
        subject[i].checked=bool;
    }
}

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
    var selsite = document.getElementById("selsite");
    var selsiteIdx = selsite.selectedIndex;
    var choice = selsite.options[selsiteIdx].value;
    location.href=choice;
}

function sortNum(){
    var numStr = document.getElementById("numVal").textContent;
    var numArr = numStr.split(',');
    for(let i=0; i<numArr.length; i++){
        numArr[i]=parseInt(numArr[i]);
    }
    

    document.getElementById("numSort").textContent = numArr.sort(compare).toString();
}

function compare(a, b){
    return a-b;
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

    var table = document.createElement('table');
    table.setAttribute('style', 'width:200px');

    var tr = document.createElement('tr');


    for(let i=0; i<formInfo.length-1; i++){
        if(formInfo[i].hasAttribute("type")){
            var td = document.createElement('td');
            var txt = document.createTextNode(formInfo[i].value);
            td.setAttribute('style', 'background-color:yellow');
            td.appendChild(txt);
            tr.appendChild(td);
        }
    }

    table.appendChild(tr);
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