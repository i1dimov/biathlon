if(!is_logged()){
    document.getElementById("subscribe_table").remove()
} else {
    const requestURL = 'http://localhost:8080//allSubscribeCompetitionsWithBiathletes'
    const requestURL2 = 'http://localhost:8080//allSubscribeCompetitions'

    getCompetitions(requestURL)
    getCompetitions(requestURL2)

    function getCompetitions(url){
        let competitions = getData(url)
    }

    function getData(url){
        let newData = {};
        let res = fetch(url)
        res.then(function(response) {
            return response.json();
        }).then( function (data){
            newData = data;
        });
        return newData
    }
}
