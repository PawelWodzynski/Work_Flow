// Function to unlock and enable save changes/reset password button after modal is closed
function ModalUnlockButtons() {
    // Create a new modal instance using Bootstrap
    var myModal = new bootstrap.Modal(document.getElementById('DialogModal'));

    // Listen for the modal hidden event
    myModal._element.addEventListener('hidden.bs.modal', function () {
        // Enable the save changes button after modal is closed
        var sendEmployeeButton = document.querySelectorAll('[id^="sendEditedEmployee"]');
        sendEmployeeButton.forEach(function(button) {
            button.disabled = false;
        });

        // Enable the reset password button after modal is closed
        var resetEmployeePasswordButton = document.querySelectorAll('[id^="resetPasswordButton"]');
        resetEmployeePasswordButton.forEach(function(resetButton) {
            resetButton.disabled = false;
        });

    });
}

// Call the function to unlock and enable the save changes button
ModalUnlockButtons();
