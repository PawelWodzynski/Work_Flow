// EditEmployeeForm.js

// async function handling employee save
async function editEmployeeSaveForm(event) {
    // Stop the form's default behavior
    event.preventDefault();

    // Get the index of the current target element
    const iterIndex = event.currentTarget.getAttribute('data-index');
    // Find the button element by its id
    var sendEmployeeButton = document.getElementById("sendEditedEmployee"+ iterIndex);

    // Create a new modal instance using Bootstrap
    var myModal = new bootstrap.Modal(document.getElementById('DialogModal'));
    // Set modal title and style
    document.querySelector('#DialogModal .modal-title').innerText = 'Processing';
    document.querySelector('#DialogModal .modal-title').style.color = 'red';
    document.querySelector('#DialogModal .modal-title').style.textAlign = 'center';
    // Find modal body element
    var modalBody = document.getElementById('modalBody');
    // Set modal body text
    modalBody.innerText = 'Employee data is being validated';
    // Show the modal
    myModal.show();

    // Disable the sendEmployeeButton
    sendEmployeeButton.disabled = true;

    try {
        // Get data from the form with id 'editEmployeeForm' using the FormData object
        const formData = new FormData(document.getElementById( `editEmployeeForm-` + iterIndex));

        // Invoke the asynchronous fetch function to send data to the 'http://localhost:8080/employeeRequest/updateEmployee' endpoint using the POST method
        const response = await fetch('http://localhost:8080/employeeRequest/updateEmployee', {
            method: 'POST',
            body: formData
        });
        // Get data from the response in JSON format
        const data = await response.json();

        // Check if the response is not ok and the status is 400 (Bad Request)
        if (!response.ok && response.status === 400) {
            // If the response is Bad Request, set the text in the respective div
            let validationText = '';

            // Check if firstName is present in the response data
            if (data.firstName !== undefined) {
                validationText += `First Name: ${data.firstName} `;
            }

            // Check if lastName is present in the response data
            if (data.lastName !== undefined) {
                // Add a new line if both firstName and lastName are present
                if (Object.keys(data).length > 1) {
                    validationText += '\n';
                }
                // Add lastName information to validationText
                validationText += `Last Name: ${data.lastName}`;
            }

            // Check if email is present in the response data
            if(data.email !== undefined){
                // Add a new line if both firstName and lastName are present
                if (Object.keys(data).length > 1) {
                    validationText += '\n';
                }
                // Add lastName information to validationText
                validationText += `Email : ${data.email}`
            }

            if (data.roles !== undefined){
                // Add a new line if both firstName and lastName are present
                if (Object.keys(data).length > 1) {
                    validationText += '\n';
                }
                validationText += `Role : ${data.role}`
            }

            // Set validationText in the modal body
            modalBody.innerText = validationText;

        } else if (response.ok) {
            // If the response is ok

            let validationText = '';

            // Update email and role in the UI
            const email = document.getElementById('emailCell' + iterIndex).innerText = data.email;
            const role = document.getElementById('roleCell' + iterIndex).innerText = data.role;

            // Checking whether the employee's name or surname has been edited
            if(data.employeeEdited === true){
                const username = document.getElementById('usernameCell' + iterIndex).innerText = data.username;
                const firstName = document.getElementById('firstNameCell' + iterIndex).innerText = data.firstName;
                const lastName = document.getElementById('lastNameCell' + iterIndex).innerText = data.lastName;
                validationText = data.messageEditedEmployee;
            }else{
                validationText = data.messageNoEditedEmployee;
            }

            // Set validationText in the modal body
            modalBody.innerText = validationText;

        }
    } catch (error) {
        // In case of an error, set an appropriate message
        validationText = 'Unidentified error';
        modalBody.innerText = validationText;
    }
}
