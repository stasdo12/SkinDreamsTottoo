
$(document).ready(function() {
    $('.carousel').carousel({
        interval: 3000 // интервал в миллисекундах
    });
});



function validateForm() {
    var authorName = document.getElementById("authorName").value;
    var comment = document.getElementById("text").value;
    var rating = document.getElementById("rating").value;
    var masterName = document.getElementById("masterName").value;

    if (authorName === "" || comment === "" || rating === "" || masterName === "") {
        alert("Please fill in all fields");
        return false;
    }
    var errorElement = document.getElementById('error');
    if (errorElement) {
        errorElement.scrollIntoView();
    }

    return true;
}


