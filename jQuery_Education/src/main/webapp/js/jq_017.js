// jQuery 방식
//$(function(){
//	$("#btn").click(function(){
//		$("img").toggleClass("onOffSize");
//	});
//	
//	$("img").click(function(){
//		if($(this).hasClass("addSize")){
//			$(this).removeClass("addSize").attr("title","이미지 축소");
//		} else {
//			$(this).addClass("addSize").attr("title","이미지 확대");
//		}
//	});
//});






// javascript 방식
onload = function(){
	var btn = document.getElementById("btn");
	var imgs = document.getElementsByTagName("img")
	btn.addEventListener("click",function(){
		for(let i=0; i<imgs.length; i++){
			if(imgs[i].className == ""){
				imgs[i].className = "onOffSize";
			} else {
				imgs[i].className = "";
			}
		}
	});
	
	for(let i=0; i<imgs.length; i++){
		imgs[i].addEventListener("click", function(){
			if(this.classList.contains("addSize")){
				this.classList.remove("addSize");
				this.setAttribute("title","이미지 축소");
			} else {
				this.classList.add("addSize");
				this.setAttribute("title","이미지 확대");
			}
		});
	}
};
