const requestURL = 'http://localhost:8080/competitions'
res = fetch(requestURL)

res.then(function(response) {
    return response.json();
}).then(function (data) {
    const table = document.getElementById('CompetitionsTable');
    for(let i = 0; i < Object.keys(data).length; i++) {
        let row = `
        <tr>
        <td>${data[i].id}</td>
        <td>${data[i].name}</td>
        <td>${data[i].location}</td>
        </tr>
        `
        table.innerHTML += row;
    }
});
