async function addPoint(inputId,inputRowId,pointsBodyId,dayNumber,todoDateId,addPointRowId,date){

    try{

        const inputField = document.getElementById(`${inputId}`);
        const inputRow = document.getElementById(`${inputRowId}`);
        const inputEnteredValue = inputField.value;
        const childElementsCountInDayBody = document.getElementById(`${pointsBodyId}`).childElementCount;


        const formData = {
            content : inputEnteredValue,
            pointOrder : childElementsCountInDayBody,
            fromDayNumber : dayNumber,
            toDayNumber : dayNumber,
            todoDateId : todoDateId
        };

        const response = await fetch('http://localhost:8080/todoRequest/addTodoPoint' ,{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body : JSON.stringify(formData)
        });

        const responseData = await response.json();

        if (response.ok){
            const checkBoxId = 'checkBox' + `${inputRowId}` + '-' + `${childElementsCountInDayBody}`;
            const contentId = 'content-' + `${inputRowId}` + '-' + `${childElementsCountInDayBody}`;
            const rowId = `InputId-${date}`;
            const todoPointId = responseData.todoPointId;
            const contentFromResponse = responseData.todoContent;
            const keyForContentGlobalObject =  'pointContent-' + todoPointId;
            const fromDayNumber   = responseData.fromDayNumber;
            const deadlineNumber = responseData.toDayNumber;

            pointContentGlobalObject[keyForContentGlobalObject] = contentFromResponse;
            pointDeadlineGlobalObject[keyForContentGlobalObject] = deadlineNumber;

            document.getElementById(`${addPointRowId}`).insertAdjacentHTML(
                'beforebegin',
                pointComponent(
                    fromDayNumber,
                    keyForContentGlobalObject,
                    responseData.toDayNumber,
                    date,
                    checkBoxId,
                    contentId,
                    false,
                    responseData.todoPointId
                ));

            inputField.value = '';

        }else{
            console.log(responseData);
        }












    }catch (error){
        console.log('Unidentified error ' + error)
    }





}