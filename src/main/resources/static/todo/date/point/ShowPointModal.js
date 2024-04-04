function showPointModal(keyForContentObject,todoButtonContentId,todoPointId,todoPointDate,toDayNumber){

    const modalContainer = document.getElementById('modal');
    modalContainer.innerHTML = '';
    modalContainer.innerHTML = pointModalComponent(keyForContentObject,todoButtonContentId,todoPointId,todoPointDate,toDayNumber);

    const modal = document.getElementById(`todoPointModal-${todoPointDate}`);
    $(modal).modal('show');


}