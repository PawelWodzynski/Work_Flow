function pointComponent(fromDayNumber,keyForContentObject,deadLine,date,checkBoxId, contentId, completed, todoPointId){

    const contentFromObject = pointContentGlobalObject[keyForContentObject];
    const decodedContent = decodeURIComponent(contentFromObject);




    return `
                <div id="point-${todoPointId}" class="row mb-2">
                    <div class="col-12">
                        <div type="button" id="pointButton-${todoPointId}" class="w-100 text-white border-bottom" 
                        onclick="showPointModal('${fromDayNumber}','${date}','${keyForContentObject}','pointButtonContent-${todoPointId}','${todoPointId}','${date}','${deadLine}')">
                            <div class="row">
                                <div class="col-1">
                                    <input class="form-check-input" type="checkbox" id="${checkBoxId}" name="option1" value="something" 
                                    onclick="checkboxOnclick('${checkBoxId}','${contentId}','${todoPointId}'); event.stopPropagation();">
                                </div>
                                <div class="col-11">
                                    <div class="left-aligned-text">
                                        <span id="pointButtonContent-${todoPointId}">${decodedContent}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        `;




}

