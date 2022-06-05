let comp_id = localStorage.getItem("competitionId");
const requestURL = requestUrl_from_cfg + 'competitions'
res = fetch(requestURL)

res.then(function(response) {
    return response.json();
}).then(function (data) {

    let competitionResults = data[Number(comp_id) - 1].competitionResults;

    let name = data[Number(comp_id) - 1].name;
    const name_html = document.getElementById('name');
    name_html.innerHTML += name;

    let date = new Date(data[Number(comp_id) - 1].date);
    const date_html = document.getElementById('date');
    date_html.innerHTML += date.getDate() + "." + (+date.getMonth() + 1) + "." + date.getFullYear();

    let location = data[Number(comp_id) - 1].location;
    const location_html = document.getElementById('location');
    location_html.innerHTML += location;

    let about = data[Number(comp_id) - 1].about;
    const about_html = document.getElementById('about');
    about_html.innerHTML += about;

    let index = 1;
    const table =  document.getElementById('ResultsTable')
        let table_element = competitionResults.sort((a,b) => b.score - a.score).map(competitionRes =>
            `
                <tr>
                <td><a class="table_linker" onclick=passValue(${competitionRes.id.biathleteId},'biathlete',${competitionRes.score}) href="../pages/biathlete.html">${index++}<a/></td>
                <td><a class="table_linker" onclick=passValue(${competitionRes.id.biathleteId},'biathlete',${competitionRes.score}) href="../pages/biathlete.html">${competitionRes.biathleteName}<a/></td>
                <td><a class="table_linker" onclick=passValue(${competitionRes.id.biathleteId},'biathlete',${competitionRes.score}) href="../pages/biathlete.html">${competitionRes.score}</a></td>
                </tr>
            `).join('\n')
        table.innerHTML += table_element;
});

function follow(){
    let url = requestUrl_from_cfg + 'subscribeToCompetition?' + 'userId=' + get_user_id() + '&' + 'competitionId=' + comp_id
    event.preventDefault()
    fetch(url, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
    }).then((response) =>{
        updateSubscribe()
    })
}

function unfollow(){
    let url = requestUrl_from_cfg + 'unsubscribeFromCompetition?' + 'userId=' + get_user_id() + '&' + 'competitionId=' + comp_id
    event.preventDefault()
    fetch(url, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
    }).then((response) =>{
        updateSubscribe()
    })
}

async function isSubscribed(){
    let url = requestUrl_from_cfg + 'allSubscribeCompetitions?userId=' + get_user_id()
    let res = await fetch(url)
    return res.json().then( function (data){
        return data.map(({id}) => id).includes(Number(comp_id))
    })
}

updateSubscribe()
function updateSubscribe(){
    isSubscribed().then(value => {
        const follow = document.getElementById('follow')
        const unfollow = document.getElementById('unfollow')
        if (value){
            follow.style.display = 'none'
            unfollow.style.display = 'block'
        } else {
            unfollow.style.display = 'none'
            follow.style.display = 'block'
        }
    })
}



