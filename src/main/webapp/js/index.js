function genSelectOptions(from, to, step) {
  let result = new Array();
  let i = 0;
  while (i <= to) {
    result.push("<option value='" + i + "'>" + i + "</option>");
    i += step;
  }
  return result;
}
function setup() {
  document.getElementsByName("hour")[0].innerHTML = genSelectOptions(0, 12, 1);
  document.getElementsByName("miniute")[0].innerHTML = genSelectOptions(0,60,1);
}
/* 
async function readText(event) {
  //const file = event.target.files.item(0)
  //const text = await file.text();
  let form = document.querySelector("form");
  let data = new FormData(form);
  for (let pair of data.entries()) {
    console.log(pair);
  }
  let toSend = {};
  toSend.classname = data.get("classname");
  toSend.date = data.get("date");
  toSend.hour = data.get("hour");
  toSend.minitue = data.get("miniute");
  toSend.upload = await data.get("upload").text();
  console.log(toSend);
  await bodyreq(toSend);
} */

function params() {
  let myParams = { name: "raja", dept: "IT" };
  let url = new URLSearchParams(myParams).toString();
  url = "/dummy?" + url;
  fetch(url, {
    mode: "cors",
    method: "post",
  });
}

async function bodyreq(data) {
  let myParams = { id: "30", name: "raja" };
  fetch("/dummy", {
    mode: "cors",
    method: "post",
    body: JSON.stringify(data),
  })
    .then((res) => res.json())
    .then((data) => {
      jsondata = JSON.parse(JSON.stringify(data));
      displayTable(jsondata.sessions);
      console.log(jsondata.sessions);
    });
}

function displayTable(tablejson) {
  tableData = new Array();
  tablejson.forEach(function (rowobj) {
    row = new Array();
    for (key in rowobj) {
      row.push(rowobj[key]);
    }
    console.log(rowobj);
    tableData.push(row);
  });
  var table = document.createElement("table");
  table.className = "styled-table";
  headings = [
    "CLASS",
    "DATE",
    "START TIME",
    "MEET ID",
    "ID",
    "ROLL NO",
    "NAME",
    "GMEET NAME",
    "JOINED",
    "EXITED",
    "DURATION",
    "STATUS",
    "COMMENTS",
  ];

  var tableHeading = document.createElement("tr");
  headings.forEach(function (heading) {
    var cell = document.createElement("th");
    cell.appendChild(document.createTextNode(heading));
    tableHeading.appendChild(cell);
  });

  table.appendChild(tableHeading);

  var tableBody = document.createElement("tbody");
  tableData.forEach(function (rowData) {
    var row = document.createElement("tr");

    rowData.forEach(function (cellData) {
      var cell = document.createElement("td");
      cell.appendChild(document.createTextNode(cellData));

      if (cellData == "P") {
        row.className = "present";
      } else if (cellData == "AB") {
        row.className = "absent";
      } else if (cellData == "Left Early") {
        row.className = "comment";
      }
      row.appendChild(cell);
    });

    tableBody.appendChild(row);
  });

  table.appendChild(tableBody);
  document.body.appendChild(table);
}

async function process(){
  let form = document.querySelector("form");
  let data = new FormData(form);
  for (let pair of data.entries()) {
    console.log(pair);
  }
  let toSend = {};
  toSend.classname = data.get("classname");
  toSend.date = data.get("date");
  toSend.hour = data.get("hour");
  toSend.minitue = data.get("miniute");
  toSend.map = await data.get("map").text();
  toSend.meet = await data.get("meet").text();
  console.log(toSend);
  await bodyreq(toSend);
}
