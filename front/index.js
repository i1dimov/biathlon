function passValue(id,type){
    if (type === "competition"){
        localStorage.setItem("competitionId",id);
    }
    if (type === "biathlete"){
        localStorage.setItem("biathleteId",id)
        console.log(id)
    }

}