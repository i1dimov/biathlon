//Passing id value for competition and biathlete pages
function passValue(id,type){
    if (type === "competition"){
        localStorage.setItem("competitionId",id);
    }
    if (type === "biathlete"){
        localStorage.setItem("biathleteId",id)
        console.log(id)
    }
}

//hashCode for password
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