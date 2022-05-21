function search(){
    let td,textValue,filter;
    let input = document.getElementById('name_input')
    let table = document.getElementById('table')
    let tr = table.getElementsByTagName('tr');
    filter = input.value.toUpperCase();

    for(let i = 0; i<tr.length; i++){
        td = tr[i].getElementsByTagName('td')[1]
        if (td){
            textValue = td.textContent || td.innerText;
            if (textValue.toUpperCase().indexOf(filter) > -1){
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}