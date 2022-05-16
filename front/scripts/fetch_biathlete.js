const requestURL = 'http://localhost:8080/biathletes'
res = fetch(requestURL)
let biat_id = localStorage.getItem('biathleteId');

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
    id_html.innerText += Number(biat_id) + 1;
    const name_html = document.getElementById('name');
    name_html.innerHTML = name;
    const nationality_html = document.getElementById('nationality');
    nationality_html.innerText += nationality;
    const bday_html = document.getElementById('bday');
    bday_html.innerText += (bday.getDate() + "." + bday.getMonth()+1 + "." + bday.getFullYear());
    const gender_html = document.getElementById('gender');
    gender_html.innerText += gender;
});

function follow(){
    let url ='http://localhost:8080/subscribeToBiathlete' + '?userId=' + get_user_id() + '&biathleteId=' + biat_id
    console.log(url)
    event.preventDefault()
    const subscription = {
        "userId" : get_user_id(),
        "biathleteId": biat_id }
    fetch(url, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
    }).then((response) =>{
    })
}

