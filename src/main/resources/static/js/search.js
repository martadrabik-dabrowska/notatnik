
    function changeTrBg(row) {
        row.style.backgroundColor = "lightgray";
    }
function defaultTrBg(row){
    row.style.backgroundColor = "white";
}

function startSearch() {
    var searchWord = document.getElementById('searchString').value;
    if (searchWord.length < 3){
        document.getElementById("errorSearch").innerHTML="Enter a minimum of three characters";
        return false;
    }
    else{
        document.getElementById("errorSearch").innerHTML="";
        var searchLink = "users/search/" + searchWord;
        window.location.href = searchLink;
    }

}
