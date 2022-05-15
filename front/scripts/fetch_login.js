const requestURL = 'http://localhost:8080/login'

const form = document.getElementById('login_form');

form.addEventListener('submit',function(event){
    event.preventDefault()
    const login = document.getElementById('login').value;
    const password = document.getElementById('password').value
    const user = {
        'login': login,
        'password' : password.hashCode(),
    }
    postForm(user)
})

function postForm(user){
    fetch(requestURL, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(user)
    }).then(function(response){
        response.text()
            .then(function (data){
            sessionStorage.setItem("user_id",JSON.parse(data).id)
        })
    })
}