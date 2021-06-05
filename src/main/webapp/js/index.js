function genSelectOptions(from,to,step){
    let result = new Array();
    let i = 0;
    while(i<=to){
        result.push("<option value='"+i+"'>"+i+"</option>");
        i+=step;
    }
    return result;
}
function setup(){
 document.getElementsByName("hour")[0].innerHTML = genSelectOptions(0,12,1);
 document.getElementsByName("minute")[0].innerHTML = genSelectOptions(0,60,1);
}


var data = "We have data";
function show(){
    let data = "We don't have data";
    console.log(data);
}
console.log(data);

show();

