function pointModalDropdownData(todoPointId,keyForGlobalObject,fromDayNumber,dropdownButtonId,dropdownListId,deadlineNumber,date){
    console.log(dropdownButtonId);


    const momentDate = moment(date);
    const daysCountInMonth = momentDate.daysInMonth();
    const monthName = momentDate.format('MMMM');
    const dayOfMonth = momentDate.date();
    const dayFromGlobalObject = pointDeadlineGlobalObject[keyForGlobalObject];
    const dropdownButton = document.getElementById(dropdownButtonId);

    const remainingDays = [];

    if (dayOfMonth != dayFromGlobalObject){
        dropdownButton.innerText = `${dayFromGlobalObject}` +' '+`${monthName}`;
        remainingDays.push(`${dayOfMonth}`+' '+ `${monthName}`);
    }

    for (let i = dayOfMonth + 1; i <= daysCountInMonth; i++) {
        remainingDays.push(`${i}`+' '+ `${monthName}`);
    }


     const deadlineDropdownList = document.getElementById(dropdownListId);
    remainingDays.forEach(day => {
        const li = document.createElement('li');
        const a = document.createElement('a');
        a.setAttribute('class', 'dropdown-item');
        a.textContent = day;
        a.addEventListener('click',function (){
            innerMonth(dropdownButtonId,day)
        });
        li.appendChild(a);
        deadlineDropdownList.appendChild(li);
    });

}


function innerMonth(dropdownButtonId,formattedDay){
     document.getElementById(dropdownButtonId).innerText = formattedDay;
}