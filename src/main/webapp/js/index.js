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
 document.getElementsByName("miniute")[0].innerHTML = genSelectOptions(0,60,1);
}

async function readText(event) {
    //const file = event.target.files.item(0)
    //const text = await file.text();
    let form = document.querySelector('form')
    let data = new FormData(form);
    for(let pair of data.entries()){
        console.log(pair);
    }
    let toSend = {}
    toSend.classname = data.get("classname");
    toSend.date = data.get("date");
    toSend.hour = data.get("hour");
    toSend.minitue = data.get("miniute");
    toSend.upload = await data.get("upload").text();
    console.log(toSend);
    await bodyreq(toSend);
}

function params(){
    let myParams = {'name': 'raja', 'dept': 'IT'};
    let url = new URLSearchParams(myParams).toString();
    url = "/dummy?"+url;
    fetch(url,{
        mode: "cors",
        method: "post"
    });
}

async function bodyreq(data){
    let myParams = {'id': '30', 'name': 'raja'};
    fetch("/dummy",{
        mode: "cors",
        method: "post",
        body:JSON.stringify(data)
    })
    .then(res=>res.text())
    .then(data=>{
        let s_data = data.split("\n")
        let out = "";
        for(a_data of s_data){
            out+=a_data+"<br>";
        }
        document.getElementById("report").innerHTML = out;
    });
}