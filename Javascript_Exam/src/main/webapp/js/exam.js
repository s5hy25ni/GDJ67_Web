/**
 * 
 */

onload = function() {
    this.document.getElementById("isNumBtn").onclick = isNum;
    this.document.getElementById("isInTextBtn").onclick = isInText;
}

function isNum(){
    var number = document.getElementById("number").value;

    if(isNaN(number)){
        alert("숫자가 아닙니다.");
    } else {
        alert("숫자입니다.");
    }

}

function isInText(){
    var word = document.getElementById("searchWord").value;
    var text = document.getElementById("text").textContent

    if(text.indexOf(word) != -1){
        alert(`검색어(${word}) 존재함`);
    } else {
        alert(`검색어(${word}) 존재하지 않음`);
    }
}