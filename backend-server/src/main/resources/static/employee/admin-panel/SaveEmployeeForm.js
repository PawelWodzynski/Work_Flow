// async function handling employee save
async function employeeSaveForm(event) {
    event.preventDefault(); // Stop the form's default behavior

    var sendEmployeeButton = document.getElementById("sendEmployee");

    sendEmployeeButton.onclick = function() {
        document.getElementById('validationTextPlaceholder').innerText = 'Processing';
        document.getElementById('validationTextPlaceholder').style.display = "block";
    };

    // Disable the button
    sendEmployeeButton.disabled = true;



    try {
        // Get data from the form and construct JSON object
        const formData = {
            firstName: document.querySelector('#employeeForm input[name="firstName"]').value,
            lastName: document.querySelector('#employeeForm input[name="lastName"]').value,
            email: document.querySelector('#employeeForm input[name="email"]').value,
            role: document.querySelector('#employeeForm input[name="role"]:checked').value
        };

        // Invoke the asynchronous fetch function to send data to the endpoint using the POST method
        const response = await fetch('http://localhost:8080/employeeRequest/saveEmployee', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
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


            // Set validationText in the placeholder and display the div
            document.getElementById('validationTextPlaceholder').innerText = validationText;
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

            // Clear the form inputs
            document.getElementById('employeeForm').reset();

            // Show the modal
            myModal.show();

            // Listen for the modal hidden event
            myModal._element.addEventListener('hidden.bs.modal', function () {
                // Reload current page after modal is closed
                location.reload();
            });

        }
    } catch (error) {
        // In case of an error, set an appropriate message
        document.getElementById('validationTextPlaceholder').innerText = 'Unidentified error';
    } finally {
        // Enable the button regardless of the operation's result
        document.getElementById('sendEmployee').disabled = false;
    }
}