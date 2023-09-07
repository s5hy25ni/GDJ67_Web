/**
 * Bike 01
 */

$(function() {
	getJson();
});

function getJson() {
	console.log("작동");
	//text 객체 혹은 파일의 경우 text의 형태가 "{"a":"가"}" => javascript에서 JSON.parse("{"a":"가"}")

	//JSON 파일을 읽는 함수 $.getJSON(파일의 위치, function(data)) data => 
	$.getJSON("../json/BikeLoc.json", function(data) {
		//      console.log(data.DATA);
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
	});
}