/**
 * 
 */

function showFood(){
    var food = document.getElementsByName("food")[0];

    // 선택된 옵션의 idx를 가지고 온다.
    var foodIdx = food.selectedIndex;
    // console.log(foodIdx);

    // 선택된 idx를 통해서 <select>의 하위 option을 가지고 온다.
    var choiceFood = food.options[foodIdx];
    console.log(choiceFood.value);
    console.log(choiceFood.textContent);
    
}

function showFoodMulti(){
    var food = document.getElementsByName("food")[1];

    var foodChoice="";

    for(let i=0; i<food.length; i++){
        if(food.options[i].selected){
            foodChoice += food.options[i].textContent+"\n";
        }
    }

    // \n으로 되어 있는 값을 innerHTML로 출력
    var printFood = document.getElementById("printFood");
    printFood.innerHTML = foodChoice;

    // \n으로 되어 있는 값을 textarea영역에 출력
    var areaFood = document.getElementById("areaFood");
    areaFood.value = foodChoice;

    // \n으로 되어 있는 값을 replace와 regEx를 통해 <br>로 출력
    var divFood = document.getElementById("divFood");
    var newFoodChoice = foodChoice.replace(/(?:\r\n|\n\r|\r|\n)/g, "<br>");
    divFood.innerHTML = newFoodChoice;
}