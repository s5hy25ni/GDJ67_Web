/**
 * 
 */

function numTest(val){
    console.log("전달 값 : " + val, typeof val);
    var cal = val+10;
    console.log(cal, typeof cal);

    var cal = Number(val) + 20;
    console.log(cal, typeof cal);

    var calObject = new Number(val);
    console.log(calObject, typeof calObject);
    console.log(calObject+1);
}

function intTest(val){
    // parseInt 실수도 무조건 정수로 가져옴
    var vals = parseInt(val)+5;
    console.log(vals, typeof vals);
}

function floatTest(val){
    var vals = parseFloat(val)+5;
    console.log(vals, typeof vals);
}

function evalTest(){
    var val = document.getElementsByName("eValue")[0]; // nodeList
    if(confirm("입력하신 코드가 맞습니까?"+val.value)){
        document.getElementsByTagName("span")[0].innerHTML 
            = "<b>"+eval(val.value)+"</b>";
    } else {
        val.value="다시 작성하세요.";
    }
}

window.onload=function(){
    // alert("온로드");

    // 입력이벤트
    var btn = document.getElementsByClassName("btn");
    // 출력
    var view = document.getElementById("view");

    for(let i = 0; i<btn.length; i++){
        btn[i].onclick = function(){
            if(view.textContent.charAt(0)=='계'){
                view.innerHTML = "";
                view.style.backgroundColor = "white";
            }
            if(this.textContent == 'CE') {
                view.innerHTML = "";
            } else if(this.textContent == 'C'){
                view.innerHTML = view.textContent.substring(0, view.textContent.length-1);
            } else if(this.textContent == '+/-'){
                if(view.textContent.charAt(0)=='-'){
                    view.innerHTML = view.textContent.substring(1);
                } else {
                    view.innerHTML = '-'+view.textContent;
                }
            } else if(!this.textContent.match(/[0-9]/)){
                if(view.textContent.charAt(view.textContent.length-1).match(/[0-9]/)){
                    view.innerHTML += this.textContent;
                }
            } else {
                view.innerHTML += this.textContent;
            }
        };
    }
}

function calView(){
    var view = document.getElementById("view");
    var cal = eval(view.textContent);

    document.getElementById("view").innerHTML = 
        "계산 결과 : <b>"+cal+"</b>";
        view.style.backgroundColor = "palevioletred";
}