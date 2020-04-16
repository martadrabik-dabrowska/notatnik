function changeTrBg(row) {
        row.style.backgroundColor = "lightgray";
    }
function defaultTrBg(row){
    row.style.backgroundColor = "white";
}

function startSearch() {
    var searchWord = document.getElementById('searchString').value;
    if (searchWord.length < 3){
        document.getElementById("errorSearch").innerHTML="";
        return false;
    }
    else{
        document.getElementById("errorSearch").innerHTML="Empty";
        var searchLink = window.location.href = '/admin/users/search/' + searchWord;
        window.location.href = searchLink;

    }

}
