const requestURL = 'http://localhost:8080/login'

const form = document.getElementById('login_form');

form.addEventListener('submit',function(event){
    event.preventDefault()
    const login = document.getElementById('login').value;
    const password = document.getElementById('password').value
    const user = {
        'login': login,
        'password' : password,
    }
    postForm(user)
    console.log(user)
})

function postForm(user){
    fetch(requestURL, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(user)
    }).then(() =>{
    })
}
