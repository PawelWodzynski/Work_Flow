function pointModalComponent(todoPointId,todoPointDate,deadLine,content){



    return `
           <div class="modal" id="todoPointModal-${todoPointDate}">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">

                <!-- Modal body -->
                <div class="modal-body border rounded-3 border-warning text-white bg-dark">
                    <div class="row mb-3">
                        <div class="col-4 text-left">
                            <h6 class="modal-title">${todoPointDate}</h6>
                        </div>
                        <div class="col-4 d-flex justify-content-center">
                            <div class="dropdown">
                                <button type="button" class="btn btn-warning dropdown-toggle text-center" data-bs-toggle="dropdown">
                                    Task Deadline
                                </button>
                                <ul id="pointModalDropdown-${todoPointDate}" class="dropdown-menu">
                                    
                                </ul>
                            </div>
                        </div>

                        <div class="col-4 d-flex justify-content-end">
                            <div class="btn-group">
                                <button id="deletePointButton-${todoPointDate}" type="button" class="btn btn-danger" data-bs-dismiss="modal" onclick="deletePoint('${todoPointId}')">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3-fill" viewBox="0 0 16 16">
                                        <path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5m-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5M4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06m6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528M8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5"/>
                                    </svg>
                                </button>
                                <button id="closePointModalButton-${todoPointDate}" class="btn btn-danger" data-bs-dismiss="modal" onclick="alert('Kliknięto przycisk!')">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
                                        <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8z"/>
                                    </svg>
                                </button>
                            </div>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <div class="col-12">
                            <div class="form-group">
                                <textarea class="form-control bg-secondary text-white" style="width: 100%;" id="myTextarea" rows="15" placeholder="Point Content">
                                ${content}
                                </textarea>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12 d-flex justify-content-center">
                            <button type="button" class="btn btn-success" onclick=""> Save Changes</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
        `;



}