function login(data){
    sessionStorage.setItem("user_id",JSON.parse(data).id)
    sessionStorage.setItem("user_login",JSON.parse(data).login)
}

function logout(){
    sessionStorage.removeItem("user_id")
    sessionStorage.removeItem("user_login")
    location.assign('index.html')
}

function is_logged(){
    console.log(sessionStorage.getItem("user_id"))
    return sessionStorage.getItem("user_id");
}

function get_user_id(){
    return sessionStorage.getItem("user_id")
}

//If logged in
if(is_logged()){
    //editing header
    document.getElementById("login_link").href = "profile.html";
    document.getElementById("login_text").innerHTML = "Profile";

    //editing login in profile
    if(document.getElementById("profile_login")){
        document.getElementById("profile_login").innerHTML = "Login: " + sessionStorage.getItem("user_login");
    }
    //Not logged
} else {
    //editing header
    document.getElementById("login_link").href = "login.html";
    document.getElementById("login_text").innerHTML = "Login or register";

    //removing follow button on competition and biathlete pages
    if(document.getElementById("follow")){
        document.getElementById("follow").remove();
    }
}