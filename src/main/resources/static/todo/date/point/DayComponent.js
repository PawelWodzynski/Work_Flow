function dayComponent(date, dayName, dayNumber,todoDateId){
    return `
          
        <div class="card todo-size bg-dark text-white">
            <div class="card-header">
                <div class="row">
                    <div class="col-12 day-name-bold-text text-center">
                        ${dayName}
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 text-center">
                        ${date}
                    </div>
                </div>
            </div>
            <div id="todoDayBody-${date}" class="card-body">
                <div id="addPointRow-${date}" class="row">
                    <div class="col-12">
                        <input id="inputId-${date}" type="text" class="form-control input-no-bg text-white" placeholder="add new point" style=" background-color: transparent;" 
                        onkeydown="if(event.key ==='Enter') 
                            addPoint('inputId-${date}','todoDayBody-${date}','todoDayBody-${date}',${dayNumber},'${todoDateId}','addPointRow-${date}','${date}')">
                    </div>
                </div>

            </div>
        </div>
        `;
}


