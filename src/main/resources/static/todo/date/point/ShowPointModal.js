function showPointModal(todoPointId,todoPointDate,toDayNumber,content){

    const modalContainer = document.getElementById('modal');
    modalContainer.innerHTML = '';
    modalContainer.innerHTML = pointModalComponent(todoPointDate,toDayNumber,content);

    const modal = document.getElementById(`todoPointModal-${todoPointDate}`);
    $(modal).modal('show');



}