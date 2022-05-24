if(!sessionStorage.getItem("user_id")){
    location.assign("index.html")
}

const requestCompetitions = requestUrl_from_cfg + 'allSubscribeCompetitions?userId=' + get_user_id()
const requestBiathletes = requestUrl_from_cfg + 'allSubscribeCompetitionsWithBiathletes?userId=' + get_user_id()

getData(requestCompetitions)
getData(requestBiathletes)

function fillCompetitions(data) {
    let competitions = data;
    if(competitions){
        const table = document.getElementById('CalendarTable');
        for (let i = 0; i < 10; i++) {
            let date = new Date(competitions[i].date);
            let row = `
            <tr>
            <td><a class="table_linker" onclick=passValue(${(+competitions[i].id)-1},'competition') href="../pages/competition.html">${competitions[i].name}</a></td>
            <td><a class="table_linker" onclick=passValue(${(+competitions[i].id)-1},'competition') href="../pages/competition.html">${competitions[i].location}</a></td>
            <td><a class="table_linker" onclick=passValue(${(+competitions[i].id)-1},'competition') href="../pages/competition.html">${date.getDate() + "." +  (+date.getMonth() + 1)  + "." + date.getFullYear()}</a></td>
            </tr>
            `
            table.innerHTML += row;

        }
    }
}

function getData(url){
    let res = fetch(url)
    res.then(function(response) {
        return response.json();
    }).then( function (data){
        fillCompetitions(data)
    });
}

function change_password(){
    const input = document.getElementById('new_password').value;
    const url = requestUrl_from_cfg + 'changePassword?userId='+ get_user_id() +'&newPassword=' + input.hashCode()
    fetch(url, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
    }).then((response) =>{
    })
}
