$(function(){
	$("a").eq(0).on("click", function(){
		$(location).attr("href","./download.do?seq="+$("input[type=hidden]").eq(0).val());
	});
	
	$("li a").on("click", function(){
		changePage($(this).attr("id"));
	});
});

function changePage(page){
	var seq = $("input[type=hidden]").eq(0).val()
	$(location).attr("href","./detail.do?seq="+seq+"&page="+page);
}