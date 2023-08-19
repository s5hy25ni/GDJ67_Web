/*
 * 달력의 일 숫자에 마우스를 enter/leaver시 글 개수를 알려주는 이벤트
 */
 
 var broken; // 이벤트를 종료시키기 위해서 사용
 
 $(document).ready(function(){
	console.log("calendar.js onload 이벤트 실행")
	$(".countView")
		.on("mouseenter", function(){
			var v = $(this);
			broken = setTimeout(function(){
				// yyyymmdd 만들어주세요!
				var year = $(".y").text();
				var month = $(".m").text();
				var day = v.text().trim();
				var yyyymmdd = year+month+isTwo(day);
				ajaxCnt(v, yyyymmdd)
			}, 500);
		})
		.on("mouseleave", function(){
			console.log("mouseleave : " ,$(this).text())
			clearTimeout(broken);
			$(".cPreview").remove();
		});
	/*
		$("#multiDelForm").submit(function(){
			if($("#multiDelForm input:checked").length == 0){
				alert("한 개 이상 체크해주세요");
				return false;
			}
		});
	 */
	$("#multiDelForm input[type=submit]").on("click", function(e){
		if($("input[type=checkbox]:checked").length==0){
				alert("한 개 이상 선택")
				e.preventDefault();
			}	
		
	})
});

function ajaxCnt(pos, yyyymmdd){
	console.log("DOM의 위치 : ",pos);
	console.log("선택된 연월일 : ",yyyymmdd)
	
	$.ajax({
		url: "./CalListAjax.do",
		type: "post",
		async: true,
		data: {"yyyymmdd":yyyymmdd},
		dataType: "json",
		success: function(resp){
			console.log(typeof resp, resp);
			pos.after("<div class='cPreview'>"+resp.calCount+"</div>")
		},
		beforeSend: function() {
			console.log("동작전");
			$(".wrap_loading").css("display", "block");
		},
		complete: function() {
			console.log("동작완료");
			$(".wrap_loading").css("display", "none");
		},
		error: function(){
			alert("통신 실패!!!!!!!!!!!!!!!");
		}
	});
}

var isTwo = function(n){
	return n.length<2?"0"+n:n;
}

function allCheck(bool){
	var chks = document.getElementsByName("chk");
	console.log(chks.length);
	for(let i=0; i<chks.length; i++){
		chks[i].checked = bool;
	};
}