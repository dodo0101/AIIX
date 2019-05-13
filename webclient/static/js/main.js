//Simple Alert
//window.onload = function() {
//alert("Check alert");
//}

//
//function oneTestButtonClick() {
//    alert("Test alert");
//    console.log("Test console alert")
//}

function oneTestButtonClick() {
    var httpRequest = new XMLHttpRequest();

    //always window object
    //always xmlhttprequest object - to use non synchronic java calls - can send call on serv;

    httpRequest.onreadystatechange = function(e) {
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) { //if call is ok
                //console.log(httpRequest.responseText);
                //alert(httpRequest.responseText);
                var responseJson  = JSON.parse(httpRequest.responseText);
                document.getElementById("server_response_section").innerHTML = responseJson.location; // httpRequest.responseText  - как только мы что то получили - поставь ответ в эту секцию
            }
    }

    //httpRequest.open("GET", '/api/testget', true); //
    //httpRequest.send();

    //request
    httpRequest.open("POST", '/api/testpost', true);
    //making new Json object - and sending it to server
    var requestJson = {
        text : document.getElementById("text_input").value,
        location : location.host,
        protocol : location.protocol
    }
    httpRequest.send(JSON.stringify(requestJson));


}