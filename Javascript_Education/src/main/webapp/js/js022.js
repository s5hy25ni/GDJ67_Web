/**
 * 
 */

function createImg(){
    var rdoBtn = document.getElementsByName("rdoBtn");
    var rdoValue = "";

    for(let i=0; i<rdoBtn.length; i++){
        if(rdoBtn[i].checked){
            rdoValue = "./img/"+rdoBtn[i].value;
        }
    }

    console.log(rdoValue);
    
    // 1) img tag 생성 : img tag를 생성하여 src속성을 작성한다.
    var img = document.createElement('img');
    img.setAttribute("src", rdoValue);

    // 2) 생성된 img tag를 붙여넣을 위치
    var div = document.getElementById("imgView");
    // div.appendChild(img);

    // div에 자식노드가 있다면 삭제하거나 replace하여 새로운 이미지를 붙여넣음
    // 부모노드에서 자식 Element만을 선택하는 child가 아닌 children을 사용 -> element 갯수만큼 가져옴
    // firstChild는 전체 자식 노드 중 첫 번째를 찾아옴
    // 삭제 혹은 교체를 하기 위해서는 정확한 Element를 찾아줘야함

    // ex01) childNodes,irstChild : node 방법을 사용해서 증명
    // console.log(div.childNodes.length);
    // if(div.childNodes.length!=0){
    //     var divImg = div.firstChild; // div가 가지고 있는 첫 번째 노드(element XXX)
    //     console.log(divImg);
    //     div.removeChild(divImg);
    // }

    // ex02) children, firstElementChild : element 방법
    // console.log(div.children.length);
    // if(div.children.length!=0){
    //     var divImg = div.firstElementChild; // div가 가지고 있는 첫 번째 노드(element XXX)
    //     console.log(divImg);
    //     div.removeChild(divImg);
    // }

    var oldImg = document.querySelector("#imgView>img");
    div.replaceChild(img, oldImg);
}