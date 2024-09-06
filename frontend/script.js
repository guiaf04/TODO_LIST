document.getElementById("buttonAdd").addEventListener("click", function(){
    var nome      = document.getElementById("name")     .value
    var descricao = document.getElementById("descricao").value
    var status    = document.getElementById("status")   .value
    var endDate   = document.getElementById("endDate")  .value
    var category  = document.getElementById("category") .value
    var priority  = document.getElementById("priority") .value
 
    if(status == "TODO" || status == "todo"){
        document.getElementById("todo").innerHTML += (
            '<ul>' +
            '<li>' +   nome      +'</li>' +
            '<li>' + descricao   +'</li>' +
            '<li>' +  endDate    +'</li>' +
            '<li>' + category    +'</li>' +
            '<li>' + priority    +'</li>' +
            '</ul>');
    }else if(status == "DOING" || status == "doing"){
        document.getElementById("doing").innerHTML += (
            '<ul>' +
            '<li>' +   nome      +'</li>' +
            '<li>' + descricao   +'</li>' +
            '<li>' +  endDate    +'</li>' +
            '<li>' + category    +'</li>' +
            '<li>' + priority    +'</li>' +
            '</ul>');
    }else if(status == "DONE" || status == "done"){
        document.getElementById("done").innerHTML += (
            '<ul>' +
            '<li>' +   nome      +'</li>' +
            '<li>' + descricao   +'</li>' +
            '<li>' +  endDate    +'</li>' +
            '<li>' + category    +'</li>' +
            '<li>' + priority    +'</li>' +
            '</ul>');
    }

    // document.getElementById("name")     .value = ''
    // document.getElementById("descricao").value = ''
    // document.getElementById("status")   .value = ''
    // document.getElementById("endDate")  .value = ''
    // document.getElementById("category") .value = ''
    // document.getElementById("priority") .value = ''
})

document.getElementById("buttonRemove").addEventListener("click", function(){
    var nome      = document.getElementById("name")     .value;
    var descricao = document.getElementById("descricao").value;
    var status    = document.getElementById("status")   .value;

    
    if(nome != null && descricao != null && status != null){
        var ulContent = document.getElementById(status).getElementsByTagName("ul");
        for(i = 0; i < ulContent.length; i++){

            var liContent = ulContent[i].getElementsByTagName("li");

            if(liContent[0].innerHTML == nome && liContent[1].innerHTML == descricao){
                ulContent[i].remove();
                break;
            }
        }
        
    }
})

document.getElementById("buttonEdit").addEventListener("click", function(){
    document.getElementById("formEdit").style.display="block";
})

function clearEditForm(){
    var nome      = document.getElementById("name")     .value;
    var descricao = document.getElementById("descricao").value;
    var status    = document.getElementById("status")   .value;
    var statusEdit= document.getElementById("statusEdit").value;
    var endDate   = document.getElementById("endDate")  .value;
    var category  = document.getElementById("category") .value;
    var priority  = document.getElementById("priority") .value;

    var propertys = [
        nome, 
        descricao, 
        status, 
        endDate, 
        category, 
        priority]

    var formEdit = document.getElementById("formEdit");

    if(nome != null && descricao != null && status != null){
        var ulContent = document.getElementById(status).getElementsByTagName("ul");
        for(i = 0; i < ulContent.length; i++){

            var liContent = ulContent[i].getElementsByTagName("li");

            if(liContent[0].innerHTML == nome && liContent[1].innerHTML == descricao){
                for(j = 0; j< formEdit.length - 1; j++){
                    if(!formEdit[j].value.match(/^[\s]*$/)){
                        propertys[j] = formEdit[j].value;
                    }
                    console.log(propertys[j])
                }
                ulContent[i].remove();
                document.getElementById(statusEdit).innerHTML += (
                    '<ul>' +
                    '<li>' +    propertys[0]    +'</li>' +
                    '<li>' +    propertys[1]    +'</li>' +
                    '<li>' +    propertys[3]    +'</li>' +
                    '<li>' +    propertys[4]    +'</li>' +
                    '<li>' +    propertys[5]    +'</li>' +
                    '</ul>');
                break;
            }
        }
        
    }
    document.getElementById("formEdit").style.display = "none";
}