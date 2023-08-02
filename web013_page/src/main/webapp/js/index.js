/*$(function(){
	$.ajax({
		url:"./userCount.do",
		type:"get",
		async:true,
		dataType:"number",
		success:function(data){
			var lists = $(data).find("DATA_RECORD");
			$("table").append(makeTable(lists));
		},
		error:function(){}
	});
	
});*/

function makeTable(dataTable){
	$tbody = $("tbody");
	
	for(let i=0; i<dataTable.length;i++){
		$tr = $("<tr>");
		$td1=$("<td>").append(i+1);
		$td2=$("<td>").append(dataTable.eq(i).children().eq(2).text());
		$td3=$("<td>").append(dataTable.eq(i).children().eq(1).text());
		$td4=$("<td>").append(dataTable.eq(i).children().eq(7).text());
		$tr.append($td1);
		$tr.append($td2);
		$tr.append($td3);
		$tr.append($td4);
		$tbody.append($tr);
	}
	return $tbody;
}