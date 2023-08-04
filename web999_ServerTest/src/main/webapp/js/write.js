$(function(){
	var fileForm = /(.*?)\.(?!exe)[^\.]*$/i;
	$("#file").on("change", function(){
		if(!$(this).val().match(fileForm)){
			alert(".exe 파일은 업로드 할 수 없습니다.");
			$(this).val('');
			return;
		}
	});
	
	$("input[type=button]").eq(0).on("click", function(){
		if($("#id").val() == ""){
			alert("작성자를 입력해주세요.");
			$("#id").focus();
		} else if($("#title").val() == ""){
			alert("제목을 입력해주세요.");
			$("#title").focus();
		} else if($("#content").val() == ""){
			alert("내용을 입력해주세요.");
			$("#content").focus();
		}else {
			$("#writeForm").submit();
		}
	});
});