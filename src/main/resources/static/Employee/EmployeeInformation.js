// EmployeeInformation.js
// async function handling employee save
async function employeeSaveForm(event) {
    event.preventDefault(); // Stop the form's default behavior

    try {
        // Get data from the form with id 'employeeForm' using the FormData object
        const formData = new FormData(document.getElementById('employeeForm'));
        // Invoke the asynchronous fetch function to send data to the 'http://localhost:8080/employeeRequest/saveEmployee' endpoint using the POST method
        const response = await fetch('http://localhost:8080/employeeRequest/saveEmployee', {
            method: 'POST',
            body: formData
        });
        // Get data from the response in JSON format
        const data = await response.json();

        // Check if the response is not ok and the status is 400 (Bad Request)
        if (!response.ok && response.status === 400) {
            // If the response is Bad Request, set the text in the respective div
            document.getElementById('validationTextPlaceholder').innerText = data.firstName !== undefined ? `Validation: ${data.firstName}` : '';
            document.getElementById('validationTextPlaceholder').style.display = "block";
        } else if (response.ok) {
            // If the response is ok, hide the div and clear it
            document.getElementById('validationTextPlaceholder').style.display = "none";
            document.getElementById('validationTextPlaceholder').innerText = '';

            // Find the modal by its id
            var myModal = new bootstrap.Modal(document.getElementById('DialogModal'));

            // Find the element with id 'DialogModal' and set the text of the element with class 'modal-title' to 'Success!'
            document.querySelector('#DialogModal .modal-title').innerText = 'Success!';

            // Set the text in modal-body
            document.getElementById('modalBody').innerText = 'Generated Username: ' + data.generatedUsername +
                '\nGenerated Password' + data.generatedPassword +
                '\n\n\nThe user\'s login details have been sent to his e-mail address';

            // Show the modal
            myModal.show();
        }
    } catch (error) {
        // In case of an error, set an appropriate message
        document.getElementById('validationTextPlaceholder').innerText = 'Unidentified error';
    }
}