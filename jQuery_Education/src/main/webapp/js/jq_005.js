$(function(){
	//1.input 태그 중 text인 엘리먼트를 선택하여 배경색 추가하기
	$("input:text").css("backgroundColor","gray");
	//2.input 태그 중 type이 password인 엘리먼트를 선택하여 배경색 추가하기
	$("input:password").css("backgroundColor","skyblue");
	//3.select 태그의 name 속성이 email인 엘리먼트의 change 이벤트가 발생했다면 선택한 목록의 value를 alert 하세요
	$("select[name=email]").change(function(){
//		alert($("option:selected").val());
		alert($(this).add("option:selected").val())
	});
	//4.checkbox를 체크하면 체크된 목록들을 alert으로 출력하기
	// (체크된 목록이 모두 alert 함수에 출력되어야 함)
//	$("input[type=checkbox]").click(function(){
//		$("input[type=checkbox]:checked").each(function(index, item){
//				alert(item.value);
//		});
//	});
	$("input:checkbox").click(function(){
		var str = "";
//		$("input:checked").each(function(i){
//			str += $("input:checked").eq(i).val();
//		});
//		
		$("input:checked").each(function(i){
			str += $(this).val()+" ";
		});
		alert(str);
	});
});

