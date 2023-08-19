$(function(){
	$("#emp_search").click(function(){
//		var empId = $("#empId").val();\
		var empid = $("input[name=empId]").val();
		console.log(empid);
		
		if(!isNaN(empid) && empid.length == 3){
			$.ajax({
				url:"EMPLOYEES_202307181239.xml",
				method:"post",
				async:true,
//				data:"emp=111" or {"emp":"111"},
				dataType: "xml",
				success:function(data){
//					console.log(data, typeof data);
//					alert($(data).find("DATA_RECORD").eq(0).children().eq(1).text());
					var empInfo = $(data).find("EMPLOYEE_ID:contains("+empid+")").parent();
					console.log(empInfo);
					
					if($(empInfo).is("DATA_RECORD")){
						$("table input").each(function(i){
							$(this).val($(empInfo).children().eq(i).text());
						});
					} else {
						alert("해당 사원은 존재하지 않습니다");
					}
				},
				error:function(request, status, error){
					alert("code:"+request.status + "\n message:"+request.responseText+"\n error:"+error);
				}
			});
		} else {
			alert("부적합한 사원번호입니다");
		}
	});
});