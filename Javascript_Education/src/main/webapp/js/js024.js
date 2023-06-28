function childAppend(){
    //body에 존재하는 element를 탐색
    var fieldSet = document.getElementById("addElement");

    //생성하는 element
    var p = document.createElement("p");

    //fieldSet의 자식 tag 중 마지막에 붙여 넣음
    var txt = document.createTextNode("appedChild는 맨 뒤에 붙어요");
    // p.appendChild(txt); // <p>appedChild는 맨 뒤에 붙어요</p>
    p.textContent = "appedChild는 맨 뒤에 붙어요";
    // fieldSet.append(p); // 문자열HTML로 전달하면 문자열로 출력, 객체로 하면 appendChild
    // fieldSet.append("<p>안녕하세요</p>");
    // fieldSet.appendChild("<p>안녕하세요</p>"); // 문자열 HTML로 전달되지 않는다.
    fieldSet.appendChild(p); // element 객체만 입력 가능;
}