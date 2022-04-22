const requestURL = 'http://localhost:8080/biathletes'
res = fetch(requestURL)

res.then(function(response) {
    return response.json();
}).then(function (data) {
    const table = document.getElementById('BiathletesTable');

    for(let i = 0; i < Object.keys(data).length; i++) {
        let row = `
        <tr>
        <td>${data[i].id}</td>
        <td>${data[i].name + " " +data[i].secondName}</td>
        <td>${data[i].nationality}</td>
        <td>${data[i].gender}</td>
        </tr>
        `
        table.innerHTML += row;
    }
});
