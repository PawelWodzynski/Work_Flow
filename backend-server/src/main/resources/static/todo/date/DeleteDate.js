async function DeleteDate(todoDateId, collapseId, containerId, year, month){



    try {
        // Get data from the form and construct JSON object
        const requestData = {
            todoDateId : todoDateId
        };

        const params = new URLSearchParams(requestData);


        // Invoke the asynchronous fetch function to send data to the endpoint using the POST method
        const response = await fetch(`http://localhost:8080/todoRequest/deleteTodoDate?${params.toString()}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
        });
        const data = await response.json();

        if (!response.ok && response.status === 400) {
            console.log(data);
        } else if (response.ok) {
            console.log(data);
        }

        $(document.getElementById(collapseId)).collapse('hide');

        console.log(containerId);

        setTimeout(() => {
            document.getElementById(containerId).remove();
        }, 400);



        document.getElementById('dropdownYear').innerText = moment().year();
        document.getElementById('monthDropdownItem-'+ year + '-' + month).classList.remove('disabled');

    } catch (error) {
        // In case of an error, set an appropriate message
        console.log('Unidentified Error' + error);
    }




}