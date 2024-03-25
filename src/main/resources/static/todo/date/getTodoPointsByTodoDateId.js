async function getTodoPointsByTodoDateId(todoDateID) {

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

       console.log(data);


    } catch (error) {
        errorText = 'Unidentified error';
        console.log(errorText)
    }

}