var nome      = document.getElementById("name")     
var descricao = document.getElementById("descricao")
var Status    = document.getElementById("status")   
var endDate   = document.getElementById("endDate")  
var category  = document.getElementById("category") 
var priority  = document.getElementById("priority") 

function clearForm(){
	nome     .value = ''
	Status   .value = ''
	descricao.value = ''
	endDate  .value = ''
	category .value = ''
	priority .value = ''
}

document.getElementById("buttonAdd").addEventListener("click", function(){
	
    document.getElementById(Status.value).innerHTML += (
        '<ul>' +
        '<li>' +   nome.value    +'</li>' +
        '<li>' + descricao.value +'</li>' +
        '<li>' +  endDate.value	 +'</li>' +
        '<li>' + category.value  +'</li>' +
        '<li>' + priority.value  +'</li>' +
        '</ul>');

   clearForm();
})

document.getElementById("buttonRemove").addEventListener("click", function(){
    if(nome.value != null && descricao.value != null && Status.value != null){

        var ulContent = document.getElementById(Status.value).getElementsByTagName("ul");

        for(i = 0; i < ulContent.length; i++){
            var liContent = ulContent[i].getElementsByTagName("li");

            if(liContent[0].innerHTML == nome.value && liContent[1].innerHTML == descricao.value){
                ulContent[i].remove();
                break;
            }
        }   
    }
		clearForm();
})

document.getElementById("buttonEdit").addEventListener("click", function(){
    document.getElementById("formEdit").style.display="block";
})

function clearEditForm(){
    var propertys = [
        nome.value, 
        descricao.value, 
        Status.value, 
        endDate.value, 
        category.value, 
        priority.value]

    var formEdit = document.getElementById("formEdit");
		var statusEdit = document.getElementById("statusEdit").value;

    if(nome.value != null && descricao.value != null && Status.value != null){
        var ulContent = document.getElementById(Status.value).getElementsByTagName("ul");
        for(i = 0; i < ulContent.length; i++){

            var liContent = ulContent[i].getElementsByTagName("li");

            if(liContent[0].innerHTML == nome.value && liContent[1].innerHTML == descricao.value){
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

    document.getElementById("nameEdit")     .value = ''
    document.getElementById("descricaoEdit").value = ''
    document.getElementById("statusEdit")   .value = ''
    document.getElementById("endDateEdit")  .value = ''
    document.getElementById("categoryEdit") .value = ''
    document.getElementById("priorityEdit") .value = ''

    document.getElementById("formEdit").style.display = "none";
}