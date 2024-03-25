// Asynchronous function to save a todo date
async function saveTodoDate(event){

    // Get the selected year from the dropdown button
    var yearButton = document.getElementById('dropdownYear');
    let yearValue = yearButton.textContent;

    // Get the selected month from the dropdown button
    var monthButton = document.getElementById('dropdownMonth');
    var monthValue = monthButton.textContent;
    // Calculate the month number using Moment.js library and add 1 to it
    var monthNumber = moment(monthValue, "MMMM").month() + 1;

    // Disable the save button
    saveDateButton.disabled = true;

    try {
        // Get data from the form and construct a JSON object
        const formData = {
            employeeId: userId,
            year: yearValue,
            monthNumber: monthNumber
        };

        // Invoke the asynchronous fetch function to send data to the endpoint using the POST method
        const response = await fetch('http://localhost:8080/todoRequest/addTodoDate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });
        const data = await response.json();

        // Handle response based on its status
        if (!response.ok && response.status === 400) {
            console.log(data);
        } else if (response.ok) {
            console.log(data);

            // Get the dropdownMonth element
            const monthDropDownButton = document.getElementById('dropdownMonth');
            // Get the currently selected month
            const currentSelectedMonth = monthDropDownButton.textContent;
            // Set the default value to "Month"
            monthDropDownButton.innerText = 'Month';
            // Get the dropdown menu of the dropdownMonth element
            const monthDropdownMenu = document.getElementById('monthDropdownMenu');

            // Find the element with the selected month name

            // Get all <li> elements inside the <ul>
            const listItems = monthDropdownMenu.querySelectorAll('li');

            // Iterate through all <li> elements
            listItems.forEach(item => {
                // Get the <a> element inside the current <li>
                const anchorElement = item.querySelector('a');
                // Check if <a> element exists and its text content is equal to "July"
                if (anchorElement && anchorElement.textContent.trim() === currentSelectedMonth) {
                    anchorElement.classList.add('disabled');
                }
            });

            // Create calendar
            let yearFromResponse = data.year;
            let monthNumberFromResponse = data.monthNumber;

            // Create container with dynamic ID
            const container = document.createElement('div');
            container.style.marginTop = '20px';
            container.style.marginBottom = '20px';
            container.id = `${yearFromResponse}-${monthNumberFromResponse}`;

            // Fill the container with new HTML content
            // Create table body
            const tbody = document.createElement('tbody');
            tbody.id = `dateBody-${yearFromResponse}-${monthNumberFromResponse}`;
            getDays(yearFromResponse, monthNumberFromResponse);

            // Create table rows
            for (let i = 0; i < monthDays.length / 7; i++) {
                const row = document.createElement('tr');
                // Populate data into each row
                for (let j = 0; j < 7; j++) {
                    const cell = document.createElement('td');
                    // Set appropriate style for the cell based on whether it belongs to the current month
                    if (monthDays[i * 7 + j].currentMonth === false) {
                        cell.classList.add('day-gray-text');
                    } else {
                        cell.classList.add('day-number-bold-text');
                    }
                    // Place the day of the month in the cell
                    cell.textContent = monthDays[i * 7 + j].day;
                    row.appendChild(cell);
                }
                tbody.appendChild(row);
            }

            // Get todoDateIdFromResponse from the data
            let todoDateIdFromResponse = data.todoDateId;

            // Creating HTML content
            const htmlContent = `
<div id="callendarRow-${yearFromResponse}-${monthNumberFromResponse}" class="row" type="button" onclick="getTodoPointsByTodoDateId(${todoDateIdFromResponse})">
    <div class="col-12">
      <div id="dateCollapse-${yearFromResponse}-${monthNumberFromResponse}" class="collapse">
        <div class="card">
            <div class="card-header bg-warning">
                <div class="row">
                    <div class="col-4"></div>
                    <div class="col-4 text-black text-center">
                        <h5 class="day-name-bold-text">${getMonthName(monthNumberFromResponse)}</h5>
                    </div>
                    <div class="col-4 d-flex justify-content-end">
                                  <button class="btn-close" onclick="DeleteDate(
                                      ${data.todoDateId},
                                       'dateCollapse-' +
                                        ${yearFromResponse} + '-' +
                                         ${monthNumberFromResponse},
                                          ${yearFromResponse} + '-' +
                                           ${monthNumberFromResponse},
                                           ${yearFromResponse},
                                           ${monthNumberFromResponse}); 
                                            event.stopPropagation();"></button>

                    </div>
                </div>
                  <div class="row">
                    <div class="col-12 text-black text-center ">
                       <h7>${yearFromResponse}</h7>
                    </div>
                  </div>
            </div>
            <div class="card-body text-center">
            <div id="content">
               <table class="table table-sm mx-auto">
                    <thead>
                        <tr class="text-black">
                            <th>Sun</th>
                            <th>Mon</th>
                            <th>Tue</th>
                            <th>Wed</th>
                            <th>Thu</th>
                            <th>Fri</th>
                            <th>Sat</th>
                        </tr>
                    </thead>
                </table>
            </div>
            </div>
        </div>
      </div>
    </div>
</div>
`;

            // Insert the generated HTML content into the container
            container.innerHTML = htmlContent;
            container.querySelector('table').appendChild(tbody);

            // Find all containers corresponding to the given year
            const yearContainers = Array.from(document.querySelectorAll(`[id^="${yearFromResponse}-"]`));

            // Sort the containers by their IDs
            yearContainers.sort((a, b) => {
                const numA = parseInt(a.id.split('-')[1]);
                const numB = parseInt(b.id.split('-')[1]);
                return numA - numB;
            });

            // Find the appropriate place to insert the new container
            let index = yearContainers.length;
            for (let i = 0; i < yearContainers.length; i++) {
                const num = parseInt(yearContainers[i].id.split('-')[1]);
                if (num >= monthNumberFromResponse) {
                    index = i;
                    break;
                }
            }

            // Insert the new container at the appropriate position
            const datesOffcanvasList = document.getElementById('datesOffcanvasList');
            if (index === 0) {
                datesOffcanvasList.insertBefore(container, yearContainers[0]);
            } else {
                datesOffcanvasList.insertBefore(container, yearContainers[index - 1]);
            }

            // After adding the container, expand the collapse
            $('#dateCollapse-' + yearFromResponse + '-' + monthNumberFromResponse).collapse('show');

        }
    } catch (error) {
        // In case of an error, log an appropriate message
        console.log('Unidentified Error' + error);
    }







}