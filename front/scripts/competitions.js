const requestURL = 'http://localhost:8080/searchCompetitions'
const form = document.getElementById('competition_form');

form.addEventListener('submit',function(event){
    event.preventDefault()
    const name = document.getElementById('name').value;
    const season = document.getElementById('season').value;
    const type = document.getElementById('type').value

    const search = {
        'competitionName': name,
        'season' : season,
        'type' : type,
    }
    getForm(search)
})

function getForm(search){

}