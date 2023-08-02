$(function(){
	$("#emp_search").click(function(){
			var empid = $("#empId").val();
		if(!isNaN(empid) && empid.length == 3){
			$.ajax({
				url:"EMPLOYEES_202307181239.xml",
				type:"get",
				async:true,
				dataType:"xml",
				success:function(data){
					console.log(data);
					var empRowList = $(data).find("DATA_RECORD");
					$("body").append(makeTable(empRowList));
				},
				error:function(){
					alert("잘못된 요청 처리");
				}
			});
		} else {
			alert("잘못된 검색어입니다");
		}
	});
	
});

function makeTable(dataTable){
	console.log(dataTable.eq(0).children().length);
	// $변수 : jQuery
	// var 변수 : javascript
	
//	var table = document.createElement("table");
	$table = $("<table>");
	for(let i=0; i<1; i++){
		$tr = $("<tr>");
		for(let j=0; j<dataTable.eq(0).children().length; j++){
			$td = $("<td>").append(dataTable.eq(0).children().eq(j).prop("tagName"));
			$tr.append($td);
		}
		$table.append($tr);
	}
	for(let i=0; i<dataTable.length; i++){
		$tr = $("<tr>");
		for(let j=0; j<dataTable.eq(0).children().length; j++){
			$td = $("<td>").append(dataTable.eq(i).children().eq(j).text());
			$tr.append($td);
		}
		$table.append($tr);
	}
	return $table;
}