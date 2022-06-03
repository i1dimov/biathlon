const requestURL = requestUrl_from_cfg + 'biathletes'
res = fetch(requestURL)

res.then(function(response) {
    return response.json();
}).then(function (data) {
    const table = document.getElementById('BiathletesTable');
    let biathletes = sort_data(data);

    for(let i = 0; i < Object.keys(biathletes).length; i++) {
        let nation = biathletes[i].nationality.toLowerCase();
        let row = `
        <tr>
        <td><a class="table_linker" onclick=passValue(${biathletes[i].id},"biathlete",${biathletes[i].score}) href="../pages/biathlete.html">${biathletes[i].score}</a></td>
        <td><a class="table_linker" onclick=passValue(${biathletes[i].id},"biathlete",${biathletes[i].score}) href="../pages/biathlete.html">${biathletes[i].name}<a/></td>
        <td><a class="table_linker" onclick=passValue(${biathletes[i].id},"biathlete",${biathletes[i].score}) href="../pages/biathlete.html">${nation.toLowerCase().charAt(0).toUpperCase() + nation.slice(1)}</a></td>
        <td><a class="table_linker" onclick=passValue(${biathletes[i].id},"biathlete",${biathletes[i].score}) href="../pages/biathlete.html">${biathletes[i].gender.toLowerCase()}</a></td>
        </tr>
        `
        table.innerHTML += row;
    }
});

function sort_data(data){
    let biathletes = [];
    let biathlete;
    for (let i = 0; i < Object.keys(data).length; i++) {
        let biathlete_score = 0;
        if (data[i].competitionResults[0]) {
            biathlete_score = data[i].competitionResults[0].score;
        }
        biathletes.push(biathlete = {
            "id": data[i].id,
            "name": data[i].name + " " + data[i].secondName,
            "score": biathlete_score,
            "nationality": data[i].nationality,
            "gender": data[i].gender,

        })
    }
    return biathletes.sort((a,b) => b.score - a.score)
}
