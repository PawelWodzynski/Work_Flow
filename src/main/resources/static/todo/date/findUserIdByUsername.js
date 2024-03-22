document.addEventListener('DOMContentLoaded', async function() {
    try {
        const usernameElement = document.getElementById("principalUsername");

            const username = usernameElement.textContent.trim();

            const requestData = {
                username: username
            };

            const params = new URLSearchParams(requestData);

            const response = await fetch(`http://localhost:8080/employeeRequest/getEmployeeIdByUsername?${params.toString()}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            });

            const data = await response.json();
            userId = data;
            console.log('User ID: ', data);

            const event = new Event('gettingIdCompleted');
             document.dispatchEvent(event);

    } catch (error) {
        const errorText = 'Unidentified error';
        console.error(errorText, error);
    }
});
