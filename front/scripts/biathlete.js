let biat_id = localStorage.getItem('biathleteId');
const requestURL = 'http://localhost:8080/biathletes'
res = fetch(requestURL)

res.then(function(response) {
    return response.json();
}).then(function (data) {
    let name = data[biat_id].name + " " + data[biat_id].secondName;
    let nationality = data[biat_id].nationality;

    //FLAG
    const flag = document.getElementById("flag");
    flag.src += "" + nationality + ".png"

    bday = new Date(data[biat_id].birthDate)
    let gender = data[biat_id].gender;

    const id_html = document.getElementById("id");
    id_html.innerText += localStorage.getItem('biathleteScore');
    const name_html = document.getElementById('name');
    name_html.innerHTML = name;
    const nationality_html = document.getElementById('nationality');
    nationality_html.innerText += nationality;
    const bday_html = document.getElementById('bday');
    bday_html.innerText += (bday.getDate() + "." + bday.getMonth()+1 + "." + bday.getFullYear());
    const gender_html = document.getElementById('gender');
    gender_html.innerText += gender;
    String(biat_id = Number(biat_id) + 1)
});

function follow(){
    let url ='http://localhost:8080/subscribeToBiathlete' + '?userId=' + get_user_id() + '&biathleteId=' + biat_id
    event.preventDefault()
    fetch(url, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
    }).then((response) =>{
        updateSubscribe()
    })
}

function unfollow(){
    let url ='http://localhost:8080/unsubscribeFromBiathlete' + '?userId=' + get_user_id() + '&biathleteId=' + biat_id
    event.preventDefault()
    fetch(url, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
    }).then((response) =>{
        updateSubscribe()
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

async function isSubscribed(){
    if(get_user_id()){
        let url = 'http://localhost:8080/allSubscribeCompetitionsWithBiathletes?userId=' + get_user_id()
        let res = await fetch(url)
        return res.json().then( function (data){
            return data.find(({competitionResults}) => competitionResults.find(({id}) => id.biathleteId === biat_id))
        })
    }
}