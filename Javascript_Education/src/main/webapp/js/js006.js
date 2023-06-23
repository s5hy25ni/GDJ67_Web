/**
 * progation은 이벤트의 흐름을 끊어 내는 것
 * HTML이벤트와 javascript 이벤트를 멈추는 방법
 * 
 * 1) return을 fasle -> 이벤트가 막힘 : on ~~ = "return 함수명"
 * 2) event.stoppropagation(); 겹쳐있는 javascript의 다음 이벤트를 중지
 * 3) event.preventDefault(); javascript 다음에 동작되는 html 이벤트를 중지
 * 4) return; javascript의 함수를 중지시키고 빠져나감
 */

var num = 1;
function prev_gallary(event){
    // event.stopPropagation(); // 같은 공간에 있는 다른 javascript 이벤트를 막음
    // event.preventDefault(); // 
    // return;
    num--;
    if(num<1){
        num=5
    }
    document.getElementById("gallary").src="./img/img0"+num+".png";
    return false;
}

function next_gallary(){
    num++;
    if(num>5){
        num=1
    }
    document.getElementById("gallary").src="./img/img0"+num+".png";
    return false;
}