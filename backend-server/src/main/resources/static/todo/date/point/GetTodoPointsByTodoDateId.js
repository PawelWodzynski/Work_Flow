async function getTodoPointsByTodoDateId(todoDateID,year,monthNumber) {

    try {

        const requestData = {
            todoDateId : todoDateID
        };

        const params = new URLSearchParams(requestData);

        const response = await fetch(`http://localhost:8080/todoRequest/findAllTodoPointsByTodoDateId?${params.toString()}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        const data = await response.json();

        if (data.hasOwnProperty('existed') && data.existed === false){
            todoPointsExisted = false;
        }else {
            todoPointsExisted = true;
            globalPointsList = [];
            for (let key in data) {
                if (data.hasOwnProperty(key)) {
                    globalPointsList.push(data[key])
                }
            }
        }

        putTodoDaysWithPointsIntoBody(year,monthNumber, todoDateID);


    } catch (error) {
        errorText = 'Unidentified error';
        console.log(errorText + error);
    }

}