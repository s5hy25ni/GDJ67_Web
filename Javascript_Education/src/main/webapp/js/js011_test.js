/**
 * 
 */

function makeAnt(initValue){
    var current = initValue.charAt(0);
    var cnt = 1;
    var result = "";

    for(let i=1; i<initValue.length; i++){
        if(current == initValue.charAt(i)){
            cnt++;
        } else {
            result += current + cnt;
            current = initValue.charAt(i);
            cnt = 1;
        }
    }

    result += current + cnt;
    return result;
}

function antStage(stage){
    var initValue = '11';
    for(let i=0; i<stage; i++){
        initValue = makeAnt(initValue);
    }

    return initValue;
}

function antPrint(val){
    var printArea = document.getElementById("printArea");
    
    for(let i=0; i<val; i++){
        printArea.innerHTML += antStage(i)+'<br>';
    }
}