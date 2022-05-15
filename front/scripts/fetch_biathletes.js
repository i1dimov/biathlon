const requestURL = 'http://localhost:8080/biathletes'
res = fetch(requestURL)
res.then(function(response) {
    return response.json();
}).then(function (data) {
    const table = document.getElementById('BiathletesTable');

    for(let i = 0; i < Object.keys(data).length; i++) {
        let row = `
        <tr>
        <td><a class="table_linker" onclick=passValue(${i},"biathlete) href="../pages/biathlete.html">${data[i].id}</a></td>
        <td><a class="table_linker" onclick=passValue(${i},"biathlete") href="../pages/biathlete.html">${data[i].name + " " +data[i].secondName}<a/></td>
        <td><a class="table_linker" onclick=passValue(${i},"biathlete") href="../pages/biathlete.html">${data[i].nationality}</a></td>
        <td><a class="table_linker" onclick=passValue(${i},"biathlete") href="../pages/biathlete.html">${data[i].gender}</a></td>
        </tr>
        `
        table.innerHTML += row;
    }
});
