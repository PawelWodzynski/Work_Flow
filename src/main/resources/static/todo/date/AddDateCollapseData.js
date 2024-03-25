// Listening for the 'puttingDatesCompleted' event, which is triggered after completing
// operations related to setting dates
document.addEventListener("puttingDatesCompleted", function () {

    // Getting a reference to the save calendar button
    var saveCallendarButton = document.getElementById('saveCallendarButton');

    // Disabling the save calendar button
    saveCallendarButton.disabled = true;

    // Setting the reference of the save button as a global variable
    saveDateButton = saveCallendarButton;

    // Getting the current month and year using the Moment.js library
    var currentMonth = moment().month();
    var currentYear = moment().year();

    // Displaying the current year in the dropdown element
    document.getElementById('dropdownYear').textContent = currentYear;

    // Getting the list of months for the current year
    getListOfMonths(currentYear);

    // Getting a reference to the year dropdown menu
    var yearDropdownMenu = document.getElementById('yearDropdownMenu');

    // Loop to create two yearly options in the dropdown menu
    for (let i = 0; i <=1; i++){
        if (i === 0){
            // Creating an option for the current year
            const li = document.createElement('li');
            const a = document.createElement('a');
            a.className = 'dropdown-item';
            a.textContent = currentYear;
            // Handling click event for the current year
            a.onclick = function() {
                document.getElementById('dropdownYear').textContent = currentYear;
                getListOfMonths(currentYear);
            };
            li.appendChild(a);
            yearDropdownMenu.appendChild(li);
        } else if (i === 1){
            // Creating an option for the next year
            const li = document.createElement('li');
            const a = document.createElement('a');
            a.className = 'dropdown-item';
            a.textContent = currentYear + 1;
            // Handling click event for the next year
            a.onclick = function() {
                document.getElementById('dropdownYear').textContent = currentYear + 1;
                getListOfMonths(currentYear + 1);
            };
            li.appendChild(a);
            yearDropdownMenu.appendChild(li);
            if (currentYear + currentMonth !== currentYear + 11){
                a.classList.add('disabled');
            }
        }
    }
});

// Function to get the list of months for a given year
function getListOfMonths(year) {
    // Get the dropdown menu for months
    var monthDropdownMenu = document.getElementById('monthDropdownMenu');

    // Clear the existing content of the dropdown menu
    monthDropdownMenu.innerHTML = '';

    // Iterate through each month
    for (let i = 0; i <= 11; i++) {
        // Get the name of the month using Moment.js
        let monthName = moment().month(i).format('MMMM');
        // Increment month number by 1 to match JavaScript's indexing
        let monthNumber = i + 1;

        // Create <li> element
        const li = document.createElement('li');
        // Create <a> element
        const a = document.createElement('a');
        // Set class for the <a> element
        a.className = 'dropdown-item';
        // Set text content for the <a> element
        a.textContent = monthName;
        // Set ID for the <a> element
        a.id = 'monthDropdownItem-' + year + '-' + monthNumber;
        // Attach onclick event handler to the <a> element
        a.onclick = function () {
            // Set the selected month in the dropdown
            document.getElementById('dropdownMonth').textContent = monthName;
            // Enable the save button
            saveDateButton.disabled = false;
        };
        // Append the <a> element to the <li> element
        li.appendChild(a);
        // Append the <li> element to the dropdown menu
        monthDropdownMenu.appendChild(li);

        // Initialize variables for date iteration and checking if the date is found
        let dateIteration = 0;
        let found = false;

        // Iterate through globalDatesList to check if the date exists for the current month and year
        globalDatesList.forEach(dateData => {
            dateIteration++;
            if (dateData['Date-' + dateIteration].year === year) {
                if (dateData && 'Date-' + dateIteration in dateData) {
                    if (dateData['Date-' + dateIteration].monthNumber === i + 1) {
                        found = true;
                    }
                }
            }
        });

        // If the date is found, add 'disabled' class to the <a> element
        if (found) {
            a.classList.add('disabled');
        }
    }
}

