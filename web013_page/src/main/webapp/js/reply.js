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
<<<<<<< HEAD
			var lis = $("#rPage li");
			console.log(lis);
			var rDto = resp.bDto.replyDto;
			var page = resp.page;
=======
			var rDto = resp.bDto.replyDto;
>>>>>>> f1d3b30fa6895d4f7054704293f04df4079befac
			for(let i=0; i<rDto.length; i++){
				ths[i].childNodes[0].data=rDto[i].RWriter;				
				ths[i].childNodes[2].data=rDto[i].RRegdate;
				if(rDto[i].RDelflag != "Y"){
					tds[i].childNodes[0].data=rDto[i].RContent;
				}
			}
<<<<<<< HEAD
			if(page.startPage>1){
				
			}
			/*var rDto = resp.bDto.replyDto;
			var loginInfo = $("#writer").val();
			$("#replys").children().remove();
			$("#replys").append("<table id='madeTable'>");
			for(let i=0; i<rDto.length; i++){
				$("#replys").append("<tr><th>"+rDto[i].RWriter+"<br>"+rDto[i].RRegdate+"</th>");
				if(rDto[i].RDelflag == "Y"){
					$("#replys").append("<td style='color:red; font-size:0.8em;'>관리자에 의해 삭제되었습니다.</td>");
				} else {
					$("#replys").append("<td>"+rDto[i].RContent+"</td></tr>");
				}
			}
			if(loginInfo!=""){
				$("#replys").append("<tr><th colspan='2'><b>"+loginInfo+"</b>"
								+"<textarea rows='5' cols='95' id='replyTxt'></textarea>"
								+"<button id='replyWriteForm' style='float:right;'>등록</button></th></tr>");
			}
			$("#replys").append("</table>");	*/		
	/*		<div style="text-align: center">
		      		<fmt:parseNumber var="end" value="${page.totalPage/page.countPage}" integerOnly="true"/>
					<ul class="pagination">
						<c:if test="${page.startPage > 1}">
		      				<li><a onclick="replayPage(1)">◁</a></li>
		      				<li><a onclick="replayPage(${page.endPage-page.countPage})">◀</a></li>
		      			</c:if>
						<c:forEach begin="${page.startPage}" end="${page.endPage}" var="p">
							<c:choose>
								<c:when test="${p eq page.page}">
									<li class="active"><a onclick="replayPage(${p})">${p}</a></li>
								</c:when>
								<c:otherwise>
									<li><a onclick="replayPage(${p})">${p}</a></li>
								</c:otherwise>
							</c:choose>	  
						</c:forEach>
		   				<c:if test="${page.endPage < page.totalPage}">
		    				<li><a onclick="replayPage(${page.startPage + page.countPage})">▶</a></li>
		   					<li><a onclick="replayPage(${end*page.countPage+1})">▷</a></li>
		   				</c:if>
					</ul>
				</div>")*/
			$("#madeTable").addClass("table table-hover");
=======
			
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
>>>>>>> f1d3b30fa6895d4f7054704293f04df4079befac
		},
		error:function(request, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			alert("잘못된 요청");
		}
	});
}