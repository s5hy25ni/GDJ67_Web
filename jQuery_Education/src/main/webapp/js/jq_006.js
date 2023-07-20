//유효성 검사하기 : 에러메시지 표시하기 class=error

$(function(){
   $(".error").hide();
   
   //submit은 onclick과 같은 이벤트, jQuery에서의 이벤트는 on을 빼고 작성함
   //submit 버튼을 통해서 <form onsubmit="return fn()">의 결과에 따라서 Propagation을 처리해야함
   //button으로 처리해서 javascript에서 Dom탐색을 한 후 (document.forms[0], document.name) 한 후 submit() 함수를 통해서 실행
   
   $("#signal").submit(function(){
      if($(".infoBox").val()==""){
         $(".error").show();
         return false;
      }
   });
   
   
   
   
   $("#confirm").click(function(){
      $("#result").empty(); //inner
      if($("input[name=chk]:checked").length==0){
         alert("반드시 한 개 이상 선택해주세요");
      }else{
         $("input[name=chk]:checked").each(function(i){
            //위치를 가져옴
            var chkPosition = $("input[name=chk]:checked").eq(i)
            
            //글자값
            var bookName = chkPosition.next().text();
            
            //tag의 값
            var price = chkPosition.val();
            
            $("#result").append(bookName+"가격"+price);
         })
         
      }
   })


   // chk의 선택갯수와 chk의 전체 갯수를 판단하여 all의 상태 변경
   $("input[name=chk]").click(function(){
      if($("input[name=chk]").length==$("input[name=chk]:checked").length){
         $("input[name=all]").attr("checked",true);
      }else{
         $("input[name=all]").attr("checked",false);
      }
   });

});

//체크박스의 체크여부를 확인하여 화면에 체크된 값 표현하기
   function allCheck(bool){
      //입력 받은 bool은 선택된 checkbox의 값으로 대입
      //속성 : javascript에서는 예약어를 통해서 사용하게 됨
      // ex) document.getElementsByName("chk")[0].checked=true;
      //   jQuery는 함수형식이다, attr()/ prop(0)
      //      ex) attr("href") : 값 가져오기
      //         attr("href","http://www.naver.com") : 값 입력하기
      console.log(bool)
      $("input[name=chk]").each(function(i){
//         $(this).prop("checked",bool);
			console.log(i);
         $(this).prop("checked",bool);
      });
   }