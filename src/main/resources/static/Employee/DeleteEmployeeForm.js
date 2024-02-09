async function deleteEmployee(event) {
    // Stop the form's default behavior
    event.preventDefault();

    // Get the index of the current target element
    const iterIndex = event.currentTarget.getAttribute('data-delete-index');

    try {
        // Get data from the form with id 'deleteEmployeeForm' using the FormData object
        const formData = new FormData(document.getElementById(`deleteEmployeeForm` + iterIndex));
        // Invoke the asynchronous fetch function to send data to the 'http://localhost:8080/employeeRequest/deleteEmployee' endpoint using the POST method
        const response = await fetch('http://localhost:8080/employeeRequest/deleteEmployee', {
            method: 'POST',
            body: formData
        });
        // Get data from the response in JSON format
        const data = await response.json();
        console.log(data.message)

        // refresh current page
        deleteEmployeeForm();



    } catch (error) {
        // In case of an error, set an appropriate message
        errorText = 'Unidentified error';
        console.log(errorText)
    }
}
function deleteEmployeeForm(action) {
    location.reload();
}
