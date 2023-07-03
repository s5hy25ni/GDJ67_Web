function tableInput(){
    /*
        <form>을 사용하는 이유는 값을 전달하기 위한 영역
            => action, method
        required를 통해서 기본적인 submint 처리시 유효값 해줌(공백, 값 없음 등)
        유효값을 처리해주는 로직 필요
        화면에서는 input 4개 작성, DOM탐색 4번 ex) input[type="text"]

        <form> tag를 탐색하는 방법은 3가지
            1) var doc = document.forms[0]
            2) var doc = document.frm;
            3) var doc = document.getElementByXXXXX 사용

        <form> 내에서만 동작되는 form 요소 : submit, reset => 반드시 <form> 태그 안에 존재

        <input type="submit">을 클릭하면 <form> 속성의 action의 주소로 값(HTML) 전달 => request

        submit 버튼이 아닌 js를 통해서도 <form>의 submit 동작 가능 
            doc.submit();
    */

    var doc = document.frm;

    var vals = [doc.id.value, doc.pw.value, doc.address.value, doc.phone.value];
    console.log(vals);

    // 유효값 검사
    for(let i=0; i<vals.length; i++){
        if(vals[i] == ''){
            alert("모든 값을 입력해주세용");
            return;
        }
    }
    console.log("유효값 이후 로직 시작")

    var tbody = document.getElementById("addRow");
    var trlength = tbody.children.length;

    (trlength<10)?tbody.appendChild(createRow(vals)):alert("10개까지만 추가 가능해용");
}   

function createRow(vals){
    var tr = document.createElement("tr");
    for(let i in vals){
        var td = document.createElement("td");
        td.textContent = vals[i];
        tr.appendChild(td);
    }

    var delBtn = document.createElement("td");
    delBtn.innerHTML = "<input type='button' value='삭제' onclick='delRow(this)'>";
    tr.appendChild(delBtn);

    return tr;
}

function delRow(ele){
    console.log(ele);
    var delTr = ele.parentNode.parentNode;
    var tbody = document.getElementById("addRow");
    tbody.removeChild(delTr);
}

function deleteTable(){
    var tbody = document.getElementById("addRow");
    tbody.innerHTML ="";
}