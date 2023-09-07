/**
 * 
 */
 
$(function(){
	parseJSON();
})

function parseJSON(){
	console.log("parseJSON 작동");
	
	$.getJSON("./json/BikeLoc.json", function(data){
		console.log(data);
		$.ajax({
			url : "./bikeCtrl.do",
			type : "post",
			data : {"obj" : JSON.stringify(data), "command" : "second_db"},
			// dataType : "json", // 서버의 요청 URL의 결과가 JSON 형태라면 형변환 없이 사용할 수 있다.
			/*dataType = "text | json"*/
			success : function(msg){
				// text{"isc", "true"} --> var m = JSON.parse(msg) -> m.isc -> true
				// json -> msg.isc -> true
				console.log(msg);
				if(msg>0){
							$.each(data, function(key, value) {
							$("table").attr("border", "1")
							if (key == "DESCRIPTION") {
								$("thead").append("<tr>" +
									"<td>" + value.NEW_ADDR + "</td>" +
									"<td>" + value.CONTENT_ID + "</td>" +
									"<td>" + value.ADDR_GU + "</td>" +
									"<td>" + value.LONGITUDE + "</td>" +
									"<td>" + value.CRADLE_COUNT + "</td>" +
									"<td>" + value.LATITUDE + "</td>" +
									"<td>" + value.CONTENT_NM + "</td>" +
									"</tr>");
							} else if (key == "DATA") {
								var dList = value;
								for (let i = 0; i < dList.length; i++) {
									var one_data = dList[i];
									$("tbody").append("<tr>" +
										"<td>" + one_data.NEW_ADDR + "</td>" +
										"<td>" + one_data.CONTENT_ID + "</td>" +
										"<td>" + one_data.ADDR_GU + "</td>" +
										"<td>" + one_data.LONGITUDE + "</td>" +
										"<td>" + one_data.CRADLE_COUNT + "</td>" +
										"<td>" + one_data.LATITUDE + "</td>" +
										"<td>" + one_data.CONTENT_NM + "</td>" +
										"<input type='hidden' name='bike' value='"+one_data.NEW_ADDR+"/"
																					+one_data.CONTENT_ID+"/"
																					+one_data.ADDR_GU+"/"
																					+one_data.LONGITUDE+"/"
																					+one_data.CRADLE_COUNT+"/"
																					+one_data.LATITUDE+"/"
																					+one_data.CONTENT_NM+"'>"+
										"</tr>");
								}
							}
						});	
				}
			},
			error : function(err){
				console.log("잘못된 접근입니다.");
			}
		});
	});
}