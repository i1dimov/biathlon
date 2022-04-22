const requestURL = 'http://localhost:8080/biathletes'
res = fetch(requestURL)

//let biat_id = url.searchParams.get("id"); для получение параметров из url
let biat_id = 1;

res.then(function(response) {
    return response.json();
}).then(function (data) {
    let name = data[biat_id].name + " " + data[biat_id].secondName;
    let nationality = data[biat_id].nationality;
    bday = new Date(data[biat_id].birthDate)
    let gender = data[biat_id].gender;

    const id_html = document.getElementById("id");
    id_html.innerText += biat_id;
    const name_html = document.getElementById('name');
    name_html.innerHTML += name;
    const nationality_html = document.getElementById('nationality');
    nationality_html.innerText += nationality;
    const bday_html = document.getElementById('bday');
    bday_html.innerText = (bday.getDate() + "." + bday.getMonth()+1 + "." + bday.getFullYear());
    const gender_html = document.getElementById('gender');
    gender_html.innerText += gender;
});
