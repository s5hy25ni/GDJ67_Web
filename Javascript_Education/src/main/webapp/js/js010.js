/**
 * 
 */

function stringTest01(){
    // concatenation
    // X.concat(y); 를 통해서 x와 y를 하나의 문자열로 만들 수 있다.
    // + 연산
    var str01 = "string";
    var str02 = 'test';

    // + 연산자를 사용
    var str03 = str01+ (1+0.1) +str02;
    var str04 = str01.concat(str02);

    // join을 통한 문자열을 통합
    var joinString = ['99', 66, 10].join('/');
    console.log(joinString);
}

function stringTest02(){
    // 연산자 우선순위
    var d = 1;
    var f = 1.1;
    var bool = true;

    var result = "";

    result = result + d + f + bool;
    console.log(result);
}

function stringTest03(){
    // == 동등 연산자
    // === 명확한 비교(완벽한 비교)

    var strVal = prompt("숫자를 넣어주세요");
    var span = document.getElementById("cmd");
    // 정규화표현식 작성방법 test, match
    // 정규화표현식.test("비교값");
    // 비교값.match("정규화표현식");
    if(!strVal.match(/[2-9]/)){
        alert("2~9까지 숫자만 입력해주세요.");
    } else if(strVal==1){
        span.textContent = strVal+"님 환영합니다";
    } else{
        span.textContent = "숫자를 다시 입력해주세요."
    }

    // 완벽한 비교
    var objStr1 = new String("월요일");
    var objStr2 = "월요일";
    if(objStr1===objStr2){
        console.log("같다");
    } else {
        console.log("다르다");
    }
}

function stringTest04(){
    // indexOf();
    var strword = "흥부 놀부 까치 도깨비 흥부";
    var find = prompt("검색어를 입력해주세요.");

    console.log(strword.indexOf(find));
    console.log(strword.indexOf(find, 7));
    console.log(strword.lastIndexOf(find, 7));
}

function stringTest05(){
    var strVal = "문자열 추출, indexOf      : lastIndexOf       ";
    var comma = strVal.indexOf(",");
    console.log(strVal.substring(0, comma));

    // split
    var val = "oop:ooo:foo";
    var valSplit = val.split(":");
    console.log(valSplit.length);
    console.log(valSplit);

    var valSplit_o = val.split("o");
    console.log(valSplit_o.length);
    console.log(valSplit_o);

    var charAt = strVal.charAt(4);
    console.log(charAt, typeof charAt);

}

function stringTest06(){
    var val = prompt("쉼표로 구분하여 입력","");
    var splitVal = val.split(",");
    for(let i of splitVal){
        console.log(i);
    }
}