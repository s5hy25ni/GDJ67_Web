/**
 * 
 */

function numberTest(){
    // 작성방법
    var num1 = new Number(7); // 객체 생성 방법
    var num2 = 10; // 리터럴 선언 방법
                    // 리터럴은 . 했을 때 기능이 나오지 않음
    console.log(num1.toString()); // 문자
    console.log(num2);

    // 비교 ==, ===(명확한 비교)
    document.write(num1==7); // == 값만 같으면 type을 알아서 변경
    document.write(num2==10+"<br>");
    document.write(num1===7); // === 정확한 비교 type까지 같아야 true
    document.write(num2===10+"<br>");

    console.log(num1.valueOf(), num2);

    document.write(num1.valueOf==7); // false
    document.write(num1.valueOf=='7'); // false
    document.write(num2===10);

    console.log(typeof num1.valueOf()); // number
    console.log(typeof num1.toString()); // string\

    // NaN (Not a Number) : 숫자가 아닌 문자형 숫자인지 판별
    document.write(1=='1'); // javascript는 자동으로 형변환
    document.write("속성NaN : " + parseInt("a"+"<br>"));

    // infinity 속성
    // 무한의 값을 표현
    document.write("속성 infinity : " + (Number.MAX_VALUE+0.000001e+308));

    // Number 객체의 함수
    // 1) toFixed() : 실수형의 소수점 자리를 지정하면 반올림하여 문자열로 반환
    var double = 3.0156785;
    var d = double.toFixed(4);
    console.log(d);
    console.log(typeof d);

    // 2) toString() : 보이는 그대로 문자열로 변경
    console.log(num2.toString());
    console.log(typeof num2.toString());
    console.log(num2.toString(8)); // 아규먼트가 있다면 진수변환
}

function isNumber(){
    // isNaN을 통해서 판별
    var prop= prompt("숫자만 입력해주세요.");
    if(isNaN(prop)){
        alert("숫자가 아님");
    } else{
        alert("숫자");
    }
}

function isRegEx(){
    // 숫자만 판별하고 싶다...
    var regEx = /^[0-9]*$/;
    var num = document.getElementById("num").value;
    if(!regEx.test(num)){
        alert("숫자만 입력해주세요.");
    } else {
        alert("숫자 확인");
    }
}

function isPhone(){
    var regEx = /^\d{2,3}-\d{3,4}-\d{4}$/gim;
    var phone = document.getElementById("phone").value;
    if(!regEx.test(phone)){
        alert("형식에 맞는 언어를 입력해주세요.");
    }
}

/**
 * 정규화 표현식 javascript
 * ^ 무조건
 * $ 종료
 * [ - ] 범위
 * *반복
 * \d 숫자만 \D 숫자 아닌 것만
 * {} 반복 횟수
 * g : 발생되는 모든 패턴을 전역 검사
 * i : 대소문자 구분 안함
 * m : 여러 라인을 검색
 */