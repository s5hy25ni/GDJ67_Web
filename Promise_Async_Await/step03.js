const event = new Promise((resolve, reject)=>{
    var name = "coffee";
    if(name == "coffee"){
        resolve(name);
    } else {
        reject("커피가 아닙니다")
    }
});

// Promise 객체는 위에 코드에서 처럼 성공 resolve / 실패는 reject를 callback 하여 객체를 호출
/*
    호출 resolve와 reject의 실행
    resolve는 then
    reject는 catch를 실행
    모두 실행 finally
*/

event
    .then((name)=>{
        console.log(name);
    })
    .catch((err)=>{
        console.log(err)
    })
    .finally(()=>{
        console.log("Promise 잘 작동됨")
    });