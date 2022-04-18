const requestURL = 'http://localhost:8080/biathlete?id=2'
fetch(requestURL)
    .then(res => res.json())
    .then(data => console.log(data))
