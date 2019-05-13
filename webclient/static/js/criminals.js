window.onload = function() {
    var httpRequest = new XMLHttpRequest();

    httpRequest.onreadystatechange = function(e) {
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) { //if call is ok
                console.log(httpRequest.responseText);
            }
    }

    httpRequest.open("GET", 'localhost:6702/api/criminals', true);
    //making new Json object - and sending it to server
    httpRequest.send();


}