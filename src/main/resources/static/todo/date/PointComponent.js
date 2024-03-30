function pointComponent(checkBoxId, contentId, rowId, completed, content, todoPointId){






    return `
                <div class="row">
                    <div class="col-12">
                        <button class="btn w-100 text-white border-bottom">
                            <div class="row">
                                <div class="col-1">
                                    <input class="form-check-input" type="checkbox" id="${checkBoxId}" name="option1" value="something" 
                                    onclick="checkboxOnclick('${checkBoxId}','${contentId}','${todoPointId}')">
                                </div>
                                <div class="col-11">
                                    <div class="left-aligned-text">
                                        <span id="${contentId}">${content}</span>
                                    </div>
                                </div>
                            </div>
                        </button>
                    </div>
                </div>
        `;




}

