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

            document.getElementById(`${addPointRowId}`).insertAdjacentHTML(
                'beforebegin',
                pointComponent(
                    responseData.toDayNumber,
                    date,
                    checkBoxId,
                    contentId,
                    rowId,
                    false,
                    responseData.todoContent,
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