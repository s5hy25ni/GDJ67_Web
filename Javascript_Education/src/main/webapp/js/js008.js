/**
 * 1. 객체의 작성방법 : 명시적/익명적
 *      명시적 방법 : this 사용
 * 2. 객체를 생성할 때는 Pascal 방법으로 명명
 */

/**
 * 명시적 작성 방법
 *  - this(외부노출)는 new로 객체를 생성하면 생성된 객체명을 통하여 속성 접근이 가능(수정/삭제 가능)
 *  - var로 생성된 변수는 외부에서 절대 접근이 불가능(은닉화)
 *  - 만약에 외부에서 값을 가져가거나 혹은 입력하는 기능을 만들고 싶다면 익명함수로 정의(getter, setter)
 */
function Class008(){
    this.name = "eclipse";
    var name02 = "javascript";
    this.getName02 = function(){
                        return name02;
                    };
}

/**
 * 익명적 방식
 */
var Class008_2 = {
    name: "korea",
    print: function(){
                // 반드시 클래스명을 붙여야 한다.
                alert(Class008_2.name+"!")
                return Class008_2.name;
            }
}

function objectTest(){
    // 명시적 방법의 사용
    var class008 = new Class008(); // 생성자는 constructor로 생성하고 부를 때는 new를 하면 호출됨
    // this로 생성되어 외부에서 접근 가능
    class008.name = "배추도사";
    // alert("Class008의 속성값 name : "+class008.name);
    // var로 생성되어 외부에서 접근 불가
    // class008.name02 = "배추도사"; 
    // this로 생성된 function
    // alert("Class008의 속성값 getName02 : "+class008.getName02); // 변수를 호출 -> 값은 함수
    // alert("Class008의 속성값 getName02 : "+class008.getName02()); // 함수를 호출 -> return값 반환


    // 익명적 방법의 사용 : 클래스를 통해 접근
    Class008_2.name = "무도사";
    alert("Class008_2의 속성값 name : "+Class008_2.name);
    alert(Class008_2.name+ ":" +Class008_2.print);

    // console.log(Class008);

    // prototype : 객체를 만들면 기본으로 생성

    var class008_proto = new Class008();
    class008_proto.printName();
}

Class008.prototype.printName = function(){
    // alert(this.name + ":" + this.getName02); // function을 보는 것
    // alert(this.name + ":" + this.getName02()); // 값을 보는 것
    alert(name02); // var로 생성, 외부에서 호출 불가
}