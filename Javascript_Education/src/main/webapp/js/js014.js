onload = function(){
    this.document.getElementsByTagName("button")[0].onclick = testDate01;
    this.document.getElementsByTagName("button")[1].onclick = testDate02;
    this.document.getElementsByTagName("button")[2].onclick = testDate03;
    this.document.getElementsByTagName("button")[3].onclick = testDate04;
    this.document.getElementsByTagName("button")[4].onclick = testDate05;
}

function testDate01(event){
    console.log("testDate01" , "오늘 날짜 구하기");
    var today = document.getElementById("today");
    var date = new Date();
    // java에서 java.util.Date의 문자 출력 형태 SimpleDateFormat
    // DataBase에서는 TO_CHAR(date컬럼, '패턴')

    // today.innerHTML = date; // Tue Jun 27 2023 11:26:18 GMT+0900 (한국 표준시)
    // today.innerHTML = date.toDateString(); // Tue Jun 27 2023 
    today.innerHTML = date.toLocaleDateString(); // 2023. 6. 27.
    // today.innerHTML = date.toLocaleString(); // 2023. 6. 27. 오전 11:27:17
    // today.innerHTML = date.toLocaleTimeString(); // 오전 11:27:38

}
function testDate02(){
    // 날짜는 month가 array -> 입력시 -1, 출력시 +1
    console.log("testDate02");

    // 입력시 pattern
    // var date = new Date('2023-06-27'); // 통합으로 넣을 때에는 그대로
    // console.log(date);
    var dayOfWeek = ['일', '월', '화', '수', '목', '금', '토'];

    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth()+1+"";
    var date1 = date.getDate()+"";
    var day = dayOfWeek[date.getDay()];

    var monthWord = month.length==2?month:"0"+month;
    var date1Word = date1.length=2?date1:"0"+date1;

    console.log(year, monthWord, date1Word, day);

    document.getElementById("dates").value = `${year}-${monthWord}-${date1Word}`;
}
function testDate03(){
    console.log("testDate03");

    var date1 = new Date('2023-06-27');
    var date2 = new Date('2023',6-1,'27');

    console.log(date1, date2);
}
function testDate04(){
    console.log("testDate04");
    var dates = document.getElementById('dates').value;
    console.log(typeof dates, dates);

    var inputDate = document.getElementById("inputDate").value;
    console.log(typeof inputDate, inputDate);

    var date = new Date(dates);
    date.setDate(date.getDate()+parseInt(inputDate));

    document.getElementById('result').value = date.toLocaleDateString();
}
function testDate05(){
    console.log("testDate05");

    var dates1 = document.getElementById('dates1').value;
    var inputDate1 = document.getElementById("inputDate1").value;

    var startDate = new Date(dates1);
    var endDate = new Date(inputDate1);

    // 날짜(Date)를 통해한 계산의 결과는 밀리세컨드
    var resultDate = (endDate.getTime() - startDate.getTime())/(1000*60*60*24);
    document.getElementById("result1").value = resultDate;
}