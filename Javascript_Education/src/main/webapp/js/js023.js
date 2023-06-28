/**
 * 속성을 확인 : hasAttribute("속성명")
 * 
 */

window.onload=function(){
    //a태그 검색
    var anchs = document.querySelectorAll("a");
    var count = 1;
    var img = document.querySelector("img");

    console.log(anchs,count,img)

    // html에서 생성을 했다면 true, 없으면 false
    // 초기에 작성된 속성 여부 판단
    console.log("alt 속성이 있는지? ", img.hasAttribute('alt'));
    console.log("title 속성이 있는지? ", img.hasAttribute('title'));

    anchs[0].onclick=function(e){
        console.log("왼쪽");
        var imgAlt = img.getAttribute("alt"); // img 태그의 속성 중 al
        console.log(imgAlt);
        if(imgAlt == "img01"){
            alert("첫번째 이미지 입니다.");
        } else {
            img.setAttribute("alt", "img0"+(--count));
            img.setAttribute("src", "./img/img0"+(count)+".png");
        }
        e.preventDefault();
    }


    anchs[1].onclick=function(e){
        console.log("오른쪽")
        var imgAlt = img.getAttribute("alt"); // img 태그의 속성 중 al
        console.log(imgAlt);
        if(imgAlt == "img05"){
            alert("마지막 이미지 입니다.");
        } else {
            img.setAttribute("alt", "img0"+(++count));
            img.setAttribute("src", "./img/img0"+(count)+".png");
        }
        e.preventDefault();
    }
}