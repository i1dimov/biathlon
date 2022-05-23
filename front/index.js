//Passing id value for competition and biathlete pages
function passValue(id, type, score){
    if (type === "competition"){
        localStorage.setItem("competitionId",id-1);
    }
    if (type === "biathlete"){
        localStorage.setItem("biathleteId",id-1)
        localStorage.setItem("biathleteScore",score)
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