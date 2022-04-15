const requestURL = 'http://localhost:8080/biathlon/front/'
fetch(requestURL)
    .then(res => res.json())
    .then(data => console.log(data))
