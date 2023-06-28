/**
 * tag는 element의 구성으로 되어 있다.
 * 이 element의 구성은 innerHTML을 통해서 값으로 읽어올 수 있다.
 * 만약 상위 tag를 선택하여 하위 태그의 node를 검색한다면,
 * 줄바꿈, element, 주석 등 기타 외의 것들이 포함되어 모두 node로 인식
 * 만약 한 줄로 되어 있는 HTML 이라면, 하나의 node로 인식
 * 
 */

function searchParent(){
    var child = document.getElementsByTagName("p")[1];
    console.log(child.innerHTML);

    //parentNode, childNodes

    var div = child.parentNode;
    console.log(div.innerHTML.trim());

    div.style.backgroundColor="lime";
}

function searchChilds(){
    var div = document.getElementsByTagName("div")[0];
    // console.log(div.length);

    var divChild = div.childNodes; // html이 가지고 있는 모든 구성요소(공백, tag)
    // console.log(divChild.length);

    for(let i=0; i<divChild.length; i++){
        console.log(divChild[i].tagName);
    }

    var divChild2 = div.children; // element만(tag)
    console.log(divChild2);
}

window.onload = function(){
    var ps = document.getElementsByTagName("p");
    for(let i=0; i<ps.length; i++){
        ps[i].onclick=function(){
            var parent = this.parentNode;
            parent.innerHTML="";
        }
    }
}

function examDom(){
    var childP = document.getElementsByTagName("p")[3];
    childP.parentNode.style.backgroundColor="pink";

    var parentDiv = document.getElementsByTagName("div")[3];
    parentDiv.children[1].style.fontSize="30px";
}