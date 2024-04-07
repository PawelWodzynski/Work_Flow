async function editTodoPoint(todoPointDate,dropdownButtonId,keyForContentObject,todoButtonContentId,todoPointId, toDayNumber, textareaId){
    console.log(keyForContentObject);
    try{

        const textarea = document.getElementById(textareaId);
        const textareaContent = textarea.value;
        const encodeTextAreaContent = encodeURIComponent(textareaContent);

        const dropdownButton = document.getElementById(dropdownButtonId);
        const dropdownButtonValue = dropdownButton.innerText;
        let formattedButtonValue = dropdownButtonValue.replace(/\D/g, '');
        const buttonValueContainsNumber = /\d/.test(formattedButtonValue);
        const definedDate = moment(todoPointDate,"YYYY-MM-DD");
        const dayNumber = definedDate.date();

        if (!buttonValueContainsNumber){
            formattedButtonValue = dayNumber;
        }

        const formData= {
          todoPointId : todoPointId,
          content : encodeTextAreaContent,
          toDayNumber : formattedButtonValue
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

            pointDeadlineGlobalObject[keyForContentObject] = formattedButtonValue;

            const todoPointComponentContent = document.getElementById(todoButtonContentId);
            todoPointComponentContent.innerText = trimmedContent;



            console.log(responseData);
        }else{
            console.log(responseData);
        }



    }catch (error){
        console.log('Unidentified error ' + error)
    }
}