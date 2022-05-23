const URL = 'http://localhost:8080/competitions'
res = fetch(URL)
res.then(function(response) {
    return response.json();
}).then(function (data) {
    const table = document.getElementById('CompetitionsTable');
    sessionStorage.setItem('competitions', JSON.stringify(data))
    for(let i = 0; i < Object.keys(data).length; i++) {
        let date = new Date(data[i].date);
        let row = `
        <tr>
        <td><a class="table_linker" onclick=passValue(${data[i].id},'competition') href="../pages/competition.html">${data[i].id}</a></td>
        <td><a class="table_linker" onclick=passValue(${data[i].id},'competition') href="../pages/competition.html">${data[i].name}</a></td>
        <td><a class="table_linker" onclick=passValue(${data[i].id},'competition') href="../pages/competition.html">${data[i].location}</a></td>
        <td><a class="table_linker" onclick=passValue(${data[i].id},'competition') href="../pages/competition.html">${date.getDate() + "." + (+date.getMonth() + 1) + "." + date.getFullYear()}</a></td>
        </tr>
        `
        table.innerHTML += row;
    }
});
