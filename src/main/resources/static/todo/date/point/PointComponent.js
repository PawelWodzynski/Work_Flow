function pointComponent(deadLine,date,checkBoxId, contentId, rowId, completed, content, todoPointId){






    return `
                <div class="row mb-2">
                    <div class="col-12">
                        <div type="button" id="pointButton-${todoPointId}" class="w-100 text-white border-bottom" onclick="showPointModal('${todoPointId}','${date}','${deadLine}','${content}')">
                            <div class="row">
                                <div class="col-1">
                                    <input class="form-check-input" type="checkbox" id="${checkBoxId}" name="option1" value="something" 
                                    onclick="checkboxOnclick('${checkBoxId}','${contentId}','${todoPointId}'); event.stopPropagation();">
                                </div>
                                <div class="col-11">
                                    <div class="left-aligned-text">
                                        <span id="${contentId}">${content}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        `;




}

