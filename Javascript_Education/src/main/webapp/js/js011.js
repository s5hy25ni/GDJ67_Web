/**
 * 
 */


//다음값을 반환

function makeAnt(ss){

    var nextRow = "";
    var nums = 1;
    var StartNum = 0;
    for(var i=0; i<ss.length; i++){
        if(ss.charAt(i) == ss.charAt(i+1)){
            nums ++;
        }else{
            nextRow += StartNum;
            nextRow += nums;
            var StartNum = ss.charAt(i)
            nums = 1;
        }
    }
    console.log(nextRow);
    return nextRow;
}

//makeAnt에 '11'을 입력하고 stage가 있다면 다음 값을 만들어줌
function antStage(st){
    let initVal = '11';
    for(let i = 0; i<st; i++){
        console.log(initVal);
        initVal=makeAnt(initVal);
    }
    return initVal;

}


//initVal의 값을 유효값처리하고 antStage()에 값을 입력하여 실행
function antPrint(){
    var inputVal = document.getElementById("initVal");

    if(isNaN(inputVal.value)){
        alert("숫자만 입력해주세요");
        inputVal.value="";
        inputVal.focus();
    }else if(inputVal.value >=10 && inputVal.value <2){
        alert("범위에 맞는 층수를 입력해주세요");
        inputVal.value="";
        inputVal.focus();
    }else{
        //1) innerHTML :결과를 HTML로 만들어 해당 위치의 값으로 넣어줌
            // var resultAnt = "";
            // for(let i=0; i<inputVal.value; i++){
            //     resultAnt += "<span>+antStage+</span><br>";
            // }
            // document.getElementById("printArea").innerHTML = resultAnt;
    
        //2) createElement 방식 append
            var div = document.createElement("div");
            for(let i=0; i<inputVal.value; i++){
                var childDiv = document.createElement("div");
                childDiv.innerHTML = antStage(i);

                div.appendChild(childDiv)
            }
            var print = document.getElementById("printArea");
            print.innerHTML = "";
            print.style.backgroundColor="skyblue";
            print.appendChild(div);
        }
}