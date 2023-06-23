/**
 * 
 */

// 사용자에게 정보를 제공/확인, 내용 디버깅
function alertTest(){
    alert("동작구 동작구");
};

// 확인/취소 버튼, 선택에 따라 true(1)/false(0) 으로 변환하여 반환
function confirmTest(){
    var bool = confirm("배경색을 변경할까요?");
    console.log(typeof bool, bool);

    var color = document.getElementById("choiceColor").value;
    console.log(typeof color, color);
    // if(bool) // 객체 판단
    if(bool == true){ // 객체의 값 판단
        document.body.style.backgroundColor = color;
    } else {
        document.body.style.backgroundColor = "white";
    }
};

function promptTest(){
    var msg = prompt("감기인가요? \n 1번: 맞다, 2번 : 아니다, 3번 : 예정이다", "상태를 선택해주세요");
    console.log(typeof msg, msg); // 취소 -> null
    switch(msg){
        case "1": alert("병원ㄱ"); break;
        case "2": alert("따라ㄱ"); break;
        default: alert("내일ㄱ");

    }

};

function swalTest(){
    swal("특별한 alert");
}