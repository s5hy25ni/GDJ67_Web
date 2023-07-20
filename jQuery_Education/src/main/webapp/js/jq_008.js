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
				error:function(){}
			});
		} else {
			alert("잘못된 검색어 입니다.");
		}
		
	});
	
});

function makeTable(dataTable){
	// $변수 : jQuery
	// var : javascript
	
	// var table = document.createElement("table");
	$table = $("<table>");
	for(let i=0; i<1; i++){
		$tr = $("<tr>");
		for(let j=0; j<dataTable.eq(0).children().length;j++){
			$td=$("<td>").append(dataTable.eq(0).children().eq(j).prop("tagName"));
			$tr.append($td);
		}
		$table.append($tr);
	}
	
	for(let i=0; i<dataTable.length;i++){
		$tr = $("<tr>");
		for(let j=0; j<dataTable.eq(0).children().length; j++){
			$td=$("<td>").append(dataTable.eq(i).children().eq(j).text());
			$tr.append($td);
		}
		$table.append($tr);
	}
	return $table;
}