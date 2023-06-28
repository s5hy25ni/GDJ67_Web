//TODO js018_02 전체선택 버튼 js
function allSelect(bool){
    // console.log(bool);
    var all = document.getElementsByName("allCheck")[0].checked;
    // console.log(all);

    var chks = document.getElementsByName("chk");
    for(let i=0; i<chks.length; i++){
        chks[i].checked = bool;
    }

}

//TODO js016_04 selColor : 선택된 색상의 div 박스의 해당 컬러를 켜줌
function selColor(){
    var chks = document.getElementsByName("chk");
    console.log(chks.length);
    console.log(chkCheck(chks));
    if(chkCheck(chks)>0){
        for(let i in chks){
            if(chks[i].checked){
                document.getElementById(chks[i].value).style.backgroundColor=chks[i].value;
            } else {
                document.getElementById(chks[i].value).style.backgroundColor="white";
            }
        }
    } else {
        alert("최소 한 개 이상 선택");
    }

}

//TODO js016_05 chk의 선택여부 판단
function chkCheck(chks){
    let cnt = 0;

    for(let i of chks){
        if(i.checked){
            cnt++
        }
    }

    return cnt;
}

//TODO js016_06 chk의 갯수에 따라 allCheck를 변경
window.onload = function(){
    var chks = document.getElementsByName("chk");
    var allCheck = document.getElementsByName("allCheck")[0];

    for(let i=0; i<chks.length; i++){
        chks[i].onclick = function(){
            if(chkCheck(chks)==chks.length){
                allCheck.checked = true;
            } else {
                allCheck.checked = false;
            }
        }
    }
}