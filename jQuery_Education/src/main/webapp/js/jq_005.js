$(function(){
	// 1. input 태그 중 text인 엘리먼트를 선택하여 배경색 추가
	// prop 노란줄 가는 애 attr 노란 줄 안가는 애
	$("input:text").css("backgroundColor", "violet");
	
	// 2. input 태그 중 타입이 password인 앨리먼트를 선택하여 배경색 추가
	$("input:password").css("backgroundColor", "blue");
	
	// 3. select 태그의 name속성이 email인 엘리먼트의 change 이벤트가 발생했다면 선택한 목록의 value를 alert
	$("select[name=email]").change(function(){
		/*alert($("select option:selected").val());*/
		alert($(this).add("option:selected").val())
	})
	
	// 4. checkbox를 체크하면 체크된 목록들을 alert으로 출력
	// (체크된 목록이 모두 alert 함수에 출력되어야 함) 
	$("input:checkbox").click(function(){
		var str="";
		$("input:checked").each(function(i){
			str += $("input:checked").eq(i).val();
		});
		
		/*$("input:checked").each(function(i){
			str += $(this).val();
		});*/
		
		alert(str);
	})
})