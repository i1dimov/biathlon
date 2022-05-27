function login(data){
    sessionStorage.setItem("user_id",JSON.parse(data).id)
    sessionStorage.setItem("user_name",JSON.parse(data).name)
    sessionStorage.setItem("user_token",(JSON.parse(data).name + JSON.parse(data).login).hashCode())
}

function logout(){
    sessionStorage.removeItem("user_id")
    sessionStorage.removeItem("user_name")
    sessionStorage.removeItem("user_token")
    location.assign('../pages/index.html')
}

function is_logged(){
    return sessionStorage.getItem("user_token");
}

function get_user_id(){
    return sessionStorage.getItem("user_id")
}

//If logged in
if(is_logged()){
    //editing header
    document.getElementById("login_link").href = "../pages/profile.html";
    document.getElementById("login_text").innerHTML = "Профиль";

    //editing login in profile
    if(document.getElementById("profile_login")){
        document.getElementById("profile_login").innerHTML = "Ваше имя: " + sessionStorage.getItem("user_name");
    }
    //Not logged
} else {
    //editing header
    document.getElementById("login_link").href = "../pages/login.html";
    document.getElementById("login_text").innerHTML = "Войти / Зарегистрироваться";

    //removing follow button on competition and biathlete pages
    if(document.getElementById("follow")){
        document.getElementById("follow").remove();
    }
}
