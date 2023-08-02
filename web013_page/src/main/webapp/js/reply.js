/**
 * 
 */

$(function(){
	$("#replyWriteForm").click(function(){
		replyWrite();
	})
	$("#replyShow").click(function(){
		$("#replys").toggle();
	})
});

function replyWrite(){
	$.ajax({
		url:"./replyWrite.do",
		type:"post",
		async:true,
		dataType:"json",
		data:{"reply":$("#replyTxt").val(),
			"seq":$("#seq").val(),
			"writer":$("#writer").val()},
		success:function(resp){
			$("tfoot").append("<tr>"+
									"<th>"+
										resp.writer+"<br>"+
										resp.regdate+
									"</th>"+
									"<td>"+
										resp.content+
									"</td>"+
								"</tr>");
			$("replyTxt").text("");
		},
		error:function(){
			alert("잘못된 요청");
		}
	})
}

function replayPage(page){
	$.ajax({
		url:"./fileDetail.do",
		type:"get",
		async:true,
		data:{"seq":$("#seq").val(),
			"page":page},
		dataType:"json",
		success:function(resp){
			var ths = $("#replys th");
			var tds = $("#replys td");
			var rDto = resp.bDto.replyDto;
			for(let i=0; i<rDto.length; i++){
				ths[i].childNodes[0].data=rDto[i].RWriter;				
				ths[i].childNodes[2].data=rDto[i].RRegdate;
				if(rDto[i].RDelflag != "Y"){
					tds[i].childNodes[0].data=rDto[i].RContent;
				}
			}
			
			var page = resp.page;
			var allowBox = $("#allowBox");
			allowBox.children().remove();
			var html = "";
			html+="<ul class='pagination'>";
			if(page.startPage>1){
				html+="<li><a id='leftWhite'>◁</a></li><li><a id='leftBlack'>◀</a></li>";
			}
			for(let i=page.startPage; i<=page.endPage; i++){
				if(i==page.page){
					html+="<li class='active'><a>";
					html+=i;
					html+="</a></li>";
				} else {
					html+="<li><a id='goToPage'>";
					html+=i;
					html+="</a></li>";
				}
			}
			if(page.endPage<page.totalPage){
				html+="<li><a id='rightBlack'>▶</a></li>";
				html+="<li><a id='rightWhite'>▷</a></li>";
			}			
			html+="</ul>";
			allowBox.append(html);
			/*$("#leftWhite").on("click",replayPage(1));
			$("#leftBlack").click(replayPage(Math.floor(Number(page.totalPage)/Number(page.countPage))));
			var goTo = $(".goToPage");
			for(let i=0; i<goTo.length; i++){
				console.log(goTo.text());
				goTo[i].on("click", replayPage())
			}
			$("#rigthBlack").click(replayPage(Number(page.startPage)+Number(page.countPage)));*/
			$("#rigthWhite").click(replayPage(Math.floor(Number(page.totalPage)/Number(page.countPage)))*Number(page.countPage)+1);
		},
		error:function(request, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			alert("잘못된 요청");
		}
	});
}