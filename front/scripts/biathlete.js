//Получение ID выбранного биатлониста
let biat_id = localStorage.getItem('biathleteId');
const requestURL = requestUrl_from_cfg + 'biathletes'

//Запрос в бэк
res = fetch(requestURL)

res.then(function(response) {
    return response.json();
}).then(function (data) {
    let name = data[biat_id].name + " " + data[biat_id].secondName;
    let nationality = data[biat_id].nationality;

    //Флаг
    const flag = document.getElementById("flag");
    flag.src += "" + nationality + ".png";

    //Дата рождения
    bday = new Date(data[biat_id].birthDate)
    const bday_html = document.getElementById('bday');
    bday_html.innerText += (bday.getDate() + "." + String(Number (bday.getMonth())+1) + "." + bday.getFullYear());

    //Пол
    let gender = data[biat_id].gender;
    const gender_html = document.getElementById('gender');
    gender_html.innerText += gender.toLowerCase();

    //Очки в прошлом сезоне
    document.getElementById("score").innerText += data[biat_id].scoreInLastSeason;
    const id_html = document.getElementById("id");

    //Очки в сумме
    id_html.innerText += localStorage.getItem('biathleteScore');
    const name_html = document.getElementById('name');
    name_html.innerHTML = name;

    //Национальность
    const nationality_html = document.getElementById('nationality');
    let nation = nationality.toLowerCase();
    nationality_html.innerText += nation.toLowerCase().charAt(0).toUpperCase() + nation.slice(1);

    String(biat_id = Number(biat_id) + 1)
});

function follow(){
    let url = requestUrl_from_cfg + 'subscribeToBiathlete' + '?userId=' + get_user_id() + '&biathleteId=' + biat_id
    event.preventDefault()
    fetch(url, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
    }).then((response) =>{
        updateSubscribe()
    })
}

function unfollow(){
    let url = requestUrl_from_cfg + 'unsubscribeFromBiathlete' + '?userId=' + get_user_id() + '&biathleteId=' + biat_id
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