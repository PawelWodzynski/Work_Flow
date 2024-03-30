async function checkboxOnclick(checkBoxId, pointContentId, todoPointId){

    const checkBox = document.getElementById(checkBoxId);
    const content = document.getElementById(pointContentId);
    let isChecked = document.getElementById(checkBoxId).checked;

    try{

    const formData = {
        todoPointId : todoPointId,
        completed : isChecked
    }

    const response = await fetch('http://localhost:8080/todoRequest/changeCompletedStatusOfTodoPoint', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body : JSON.stringify(formData)

    });

    const responseData = await response.json();

    if (response.ok){

        if (responseData.completed === true){
            content.classList.add('striketrought-text');
        }else {
            content.classList.remove('striketrought-text');
        }


    }else {
        console.log(responseData);
    }

    }catch (error){
        console.log('Unidentified error' + error)
    }

}