/**
 * await, async로 변경
 */

// const {default:axios} = require("axios");
const axios = require("axios");

const fetchData = async() => {
    try{
        const data = await
        axios.get("https://www.google.com"); // 실행 상황에 따라 기다리겠다(await)
        console.log(data);    
    } catch(err) {
        console.log(err)
    } finally {
        console.log("await async 작동")
    }
    
}

fetchData()