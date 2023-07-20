$(function(){
	$("#weaView").click(function(){
		console.log("jQuery Ajax를 실행해봅니다:)");
		var code = $("#address option:selected").val();
		console.log("선택된 zone : ",code);
		
		$.ajax({
			url : "./weatherOpen.do",
			type : "post",
			data : {"zone" : code},
			dataType : "text", //json일 경우 JSON.parse()를 안하면 된다.
			success : function(data){
//TODO 1)-1				console.log("ajax결과 : ",data);
//TODO 2)-1, 3)-1, 4)-1			var obj = JSON.parse(data);
			/*console.log(obj, typeof obj);*/
			
			var obj = JSON.parse(data);
			console.log(obj, typeof obj); // html
			
			$("#x").val(obj.x)
			$("#y").val(obj.y)
			$("#pubDate").val(obj.pubDate)
			$("#wfKor").val(obj.wfKor)
			$("#temp").val(obj.temp)
			$("#reh").val(obj.reh)
			$("#pop").val(obj.pop)
			
			var weather_icon = obj.wfKor;
			switch(weather_icon){
				case "맑음": $("#weatherImg").attr("src", "./images/Clear.png"); break;
				case "구름 조금": $("#weatherImg").attr("src", "./images/PartlyCloudy.png"); break;
				case "구름 많음": $("#weatherImg").attr("src", "./images/MostlyCloudy.png"); break;
				case "흐림": $("#weatherImg").attr("src", "./images/Cloudy.png"); break;
				case "비": $("#weatherImg").attr("src", "./images/Rain.png"); break;
				case "눈/비": $("#weatherImg").attr("src", "./images/SnowRain.png"); break;
				case "눈": $("#weatherImg").attr("src", "./images/Snow.png"); break;
			}
			
			},
			error : function(){
				alert("잘못된 요청 값 입니다.");
			}
		})
	});
	
	// CORS가 처리되지 않기 때문에 Ajax를 통한 직접 호출이 불가능함
	$("#cors").click(function(){
		console.log("JQuery Ajax를 통해서 공공데이터의 xml을 요청해본다.");
		$.ajax({
			url : "http://www.kma.go.kr/wid/queryDFSRSS.jsp",
			type : "post",
			data : {"zone" : "1156055000"},
			dataType : "text",
			success : function(data){
				var obj = JSON.parse(data);
				console.log(obj);
			},
			error : function(err){
				alert("잘못된 요청");
			}
		})
	});
	
	$("#xmlview").click(function(){
		location.href="./weatherXML.do"
	})
	
	$("#jsoupEx").click(function(){
		location.href="./jsoup.do"
	})
	
	$("#webtoon").click(function(){
		location.href="./webtoon.do"
	})
});