document.addEventListener("gettingIdCompleted", async function() {

    // Get the index of the current target element

    try {
        var employeeId = userId;
        const requestData = {
            employeeId : employeeId
        };

        const params = new URLSearchParams(requestData);

        const response = await fetch(`http://localhost:8080/todoRequest/findAllTodoDatesByEmployeeId?${params.toString()}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        const data = await response.json();

        globalDatesList = [];

        for (let key in data) {
            if (data.hasOwnProperty(key)) {
                globalDatesList.push(data[key]);
            }
        }
        const event = new Event('gettingDatesCompleted');
        document.dispatchEvent(event);


    } catch (error) {
        errorText = 'Unidentified error';
        console.log(errorText)
    }

});