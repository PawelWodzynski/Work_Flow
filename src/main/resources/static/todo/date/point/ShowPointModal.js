function showPointModal(fromDayNumber,date,keyForContentObject,todoButtonContentId,todoPointId,todoPointDate,toDayNumber){

    const modalContainer = document.getElementById('modal');
    modalContainer.innerHTML = '';
    modalContainer.innerHTML = pointModalComponent(keyForContentObject,todoButtonContentId,todoPointId,todoPointDate,toDayNumber);


    const modal = document.getElementById(`todoPointModal-${todoPointDate}`);
    const dropdownButtonId = 'pointDropdownButton-' + todoPointId;
    const dropdownListId = 'pointModalDropdown-' + todoPointId;
    pointModalDropdownData(todoPointId,keyForContentObject,fromDayNumber,dropdownButtonId,dropdownListId,toDayNumber,date);
    $(modal).modal('show');

}