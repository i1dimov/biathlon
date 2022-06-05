const requestURL = requestUrl_from_cfg + 'competitions'

res = fetch(requestURL)

res.then(function(response) {
    return response.json();
}).then(function (data) {
    let length = 9;
    if (window.location.pathname === "/biathlon/front/pages/competitions.html") length = Object.keys(data).length
    const table = document.getElementById('CompetitionsTable');
    let competitions = []
    let date;
    for(let i = 0; i < length; i++) {
        date = new Date(data[i].date);
        competitions.push(
            {
                "id": data[i].id,
                "name": data[i].name,
                "location": data[i].location,
                "date": date.getTime()
            })
    }
    competitions.sort((a,b) => b.date - a.date).map(competition =>
        table.innerHTML +=
            `
        <tr>
        <td><a class="table_linker" onclick=passValue(${competition.id},'competition') href="../pages/competition.html">${competition.name}</a></td>
        <td><a class="table_linker" onclick=passValue(${competition.id},'competition') href="../pages/competition.html">${competition.location}</a></td>
        <td><a class="table_linker" onclick=passValue(${competition.id},'competition') href="../pages/competition.html">
        ${new Date(competition.date).getDate() + "." + (+new Date(competition.date).getMonth() + 1) + "." + new Date(competition.date).getFullYear()}</a></td>
        </tr>
        `
    )
});