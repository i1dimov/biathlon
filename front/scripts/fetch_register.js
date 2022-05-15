const requestURL = 'http://localhost:8080/register'

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

String.prototype.hashCode = function(){
    var hash = 0;
    if (this.length === 0) return hash;
    for (i = 0; i < this.length; i++) {
        char = this.charCodeAt(i);
        hash = ((hash<<5)-hash)+char;
        hash = hash & hash; // Convert to 32bit integer
    }
    return hash;
}