// This event listener triggers when dates are successfully fetched
document.addEventListener("gettingDatesCompleted", function (){
    var dateIteration = 0;
    // Loop through the global dates list to process each date
    for (let i = 0; i < globalDatesList.length; i++){
        const dateData = globalDatesList[i];
        dateIteration++;

        // Extract necessary date information
        var year = dateData['Date-' + dateIteration].year;
        var monthNumber = dateData['Date-' + dateIteration].monthNumber;
        var todoDateId=  dateData['Date-' + dateIteration].id;

        // Call function to retrieve days for the specified month and year
        getDays(year,monthNumber);

        // Calculate the name of the first day of the month
        const firstDayOfMonth = moment([year, monthNumber - 1]).startOf('month');
        const firstDayName = firstDayOfMonth.format('dddd');

        // Create a container to hold the calendar display
        const container = document.createElement('div');
        container.style.marginTop = '20px';
        container.style.marginBottom = '20px';
        container.id = year + '-' + monthNumber;

        // Creating table rows begins here
        const tbody = document.createElement('tbody');
        tbody.id = 'dateBody-' + year + '-' + monthNumber;

        // Loop through to create rows for each week
        for (let i = 0; i < monthDays.length / 7; i++){
            const row = document.createElement('tr');

            // Insert data into each row
            for (let j = 0; j < 7; j++) {
                const cell = document.createElement('td');
                // Set appropriate styling for the cell based on whether it belongs to the current month
                if (monthDays[i * 7 + j].currentMonth === false){
                    cell.classList.add('day-gray-text');
                }else {
                    cell.classList.add('day-number-bold-text');
                }

                // Place the day of the month in the cell
                cell.textContent = monthDays[i * 7 + j].day;
                row.appendChild(cell);
            }

            tbody.appendChild(row);
        }

        // Creating HTML content for displaying calendar
        const htmlContent = `
          
            <div id="callendarRow-${year}-${monthNumber}" class="row" type="button" onclick="getTodoPointsByTodoDateId(${todoDateId})">
                <div class="col-12">
                  <div id="dateCollapse-${year}-${monthNumber}" class="collapse show">
                    <div class="card">
                        <div class="card-header bg-warning">
                            <div class="row">
                                <div class="col-4"></div>
                                <div class="col-4 text-black text-center">
                                    <h5 class="day-name-bold-text">${getMonthName(monthNumber)}</h5>
                                </div>
                                <div class="col-4 d-flex justify-content-end">
                                   <button class="btn-close" onclick="DeleteDate(
                                       ${todoDateId},
                                         'dateCollapse-' +
                                           ${year} + '-' +
                                            ${monthNumber}, ${year} + 
                                             '-' + ${monthNumber},
                                             ${year},
                                             ${monthNumber}); 
                                              event.stopPropagation();"></button>

                                </div>
                            </div>
                              <div class="row">
                                <div class="col-12 text-black text-center ">
                                   <h7>${year}</h7>
                                </div>
                              </div>
                        </div>
                        <div class="card-body text-center">
                        <div id="content"">
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
        // Append the container to the offcanvas list
        container.querySelector('table').appendChild(tbody);
        const datesOffcanvasList = document.getElementById('datesOffcanvasList');
        datesOffcanvasList.appendChild(container);
    }

    const event = new Event('puttingDatesCompleted');
    document.dispatchEvent(event);

});

// Function to retrieve the name of the month based on its number
function getMonthName(monthNumber) {
    return moment().month(monthNumber - 1).format('MMMM');
}

// Function to calculate days for the specified month and year
function getDays(year, month){
    // Create a moment object for the first day of the specified month
    const firstDayOfMonth = moment([year, month - 1]).startOf('month');

    // Calculate the day of the week for the first day of the month
    const firstDayOfWeek = firstDayOfMonth.day();

    // Set the date to the previous month's last week's day to complete the week
    const startDate = firstDayOfMonth.clone().subtract(firstDayOfWeek, 'days');

    // Set the date to the last day of the specified month
    const endDate = firstDayOfMonth.clone().endOf('month');

    // Create an array to hold the days of the month along with days from the previous and next months
    const daysArray = [];

    // Add days from the previous month
    for (let i = 0; i < firstDayOfWeek; i++) {
        daysArray.push({
            day: startDate.date(),
            month: startDate.month() + 1,
            year: startDate.year(),
            currentMonth: false
        });
        startDate.add(1, 'day');
    }

    // Add days from the current month
    while (startDate.isSameOrBefore(endDate)) {
        daysArray.push({
            day: startDate.date(),
            month: startDate.month() + 1,
            year: startDate.year(),
            currentMonth: true
        });
        startDate.add(1, 'day');
    }

    // Add days from the next month if necessary to complete the week
    while (startDate.day() !== 0) {
        daysArray.push({
            day: startDate.date(),
            month: startDate.month() + 1,
            year: startDate.year(),
            currentMonth: false
        });
        startDate.add(1, 'day');
    }

    monthDays = daysArray;
}
