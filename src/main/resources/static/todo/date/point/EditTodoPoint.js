async function editTodoPoint(keyForContentObject,todoButtonContentId,todoPointId, toDayNumber, textareaId){
    console.log(keyForContentObject);
    try{

        const textarea = document.getElementById(textareaId);
        const textareaContent = textarea.value;

        const encodeTextAreaContent = encodeURIComponent(textareaContent);

        const formData= {
          todoPointId : todoPointId,
          content : encodeTextAreaContent,
          toDayNumber : toDayNumber
        };

        const response = await fetch('http://localhost:8080/todoRequest/updateTodoPoint',{
            method : 'PUT',
            headers :{
            'Content-Type' : 'application/json'
            },
            body : JSON.stringify(formData)
        });

        const responseData = await response.json();
        if (response.ok){
            const responseContent = responseData.content;
            const responseToDayNumber  = responseData.toDayNumber;

            const decodedContent =  decodeURIComponent(responseContent);
            const trimmedContent = decodedContent.replace(/[\n\r]/g, ' ');
            pointContentGlobalObject[keyForContentObject] = responseContent;

            const todoPointComponentContent = document.getElementById(todoButtonContentId);
            todoPointComponentContent.innerText = trimmedContent;
            globalAreaContent = decodedContent;



            console.log(responseData);
        }else{
            console.log(responseData);
        }



    }catch (error){
        console.log('Unidentified error ' + error)
    }
}