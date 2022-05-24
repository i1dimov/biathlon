const requestURL = requestUrl_from_cfg + 'register'

const form = document.getElementById('register_form');

form.addEventListener('submit',function(event){
    event.preventDefault()
    const login = document.getElementById('login').value;
    const user_name = document.getElementById('user_name').value;
    const password = document.getElementById('password').value

    const user = {
        'login': login,
        'name' : user_name,
        'password' : password.hashCode(),
    }
    postForm(user)
})

function postForm(user){
    fetch(requestURL, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(user)
    }).then((response) =>{
    })
    location.assign('../pages/login.html')
}