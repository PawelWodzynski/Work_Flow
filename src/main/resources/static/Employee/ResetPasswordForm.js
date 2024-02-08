// EditEmployeeForm.js

// async function handling employee save
async function resetPasswordForm(event) {
    // Stop the form's default behavior
    event.preventDefault();

    // Get the index of the current target element
    const iterIndex = event.currentTarget.getAttribute('data-reset-index');
    // Find the button element by its id
    var resetPasswordButton = document.getElementById("resetPasswordButton"+ iterIndex);
    // Create a new modal instance using Bootstrap
    var myModal = new bootstrap.Modal(document.getElementById('DialogModal'));
    // Set modal title and style
    document.querySelector('#DialogModal .modal-title').innerText = 'Success';
    // Find modal body element
    var modalBody = document.getElementById('modalBody');
    // Disable the sendEmployeeButton
    resetPasswordButton.disabled = true;

    try {
        // Get data from the form with id 'editEmployeeForm' using the FormData object
        const formData = new FormData(document.getElementById( `resetEmployeeForm` + iterIndex));
        // Invoke the asynchronous fetch function to send data to the 'http://localhost:8080/employeeRequest/saveEmployee' endpoint using the POST method
        const response = await fetch('http://localhost:8080/employeeRequest/resetPassword', {
            method: 'POST',
            body: formData
        });
        // Get data from the response in JSON format
        const data = await response.json();
        // set message from endpoint response to modal
        modalBody.innerText = data.message;
        // Show the modal
        myModal.show();
    } catch (error) {
        // In case of an error, set an appropriate message
        errorText = 'Unidentified error';
        modalBody.innerText = errorText;
    }
}
