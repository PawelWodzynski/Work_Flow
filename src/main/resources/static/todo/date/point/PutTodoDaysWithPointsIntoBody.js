function putTodoDaysWithPointsIntoBody(year,monthNumber, todoDateId){

    const daysHolder = document.getElementById('daysHolder');
    daysHolder.innerHTML = '';

    const daysCountInMonth = moment([year, monthNumber - 1]).daysInMonth();
    if (monthNumber < 10){
        monthNumber = '0'+`${monthNumber}`;
    }
    let date = year + '-' + monthNumber;

    const daysCountInPage = 4;
    let pageCount = Math.ceil(daysCountInMonth /  daysCountInPage);


    let dayIteration = 0;
    let generatedDaysCount = 0;
    for (let i = 0; i < pageCount; i++){
        generatedDaysCount = generatedDaysCount + 4;
        const row = document.createElement('div');
        row.classList.add('row');


            let pointsToIntroduceObject = {};
            let pointsToIntroduceIteration = 0;
            for (let i = 0; i < daysCountInPage; i++) {
                dayIteration++;


                let dayNumber = dayIteration;
                if (dayNumber < 10){
                    dayNumber = '0' + `${dayNumber}`;
                }


                if (dayIteration === daysCountInMonth + 1){
                    break;
                }else {
                    let formattedDate = `${date}` + '-' + `${dayNumber}`;
                    const defineDate = moment([year, monthNumber - 1, dayIteration]);
                    const dayName = defineDate.format('dddd');
                    const col = document.createElement('div');
                    col.classList.add('col-3');

                    const htmlRowId = 'addPointRow-' + formattedDate;
                    col.innerHTML =  dayComponent(formattedDate,dayName,dayNumber,todoDateId);
                    row.appendChild(col);

                    if (todoPointsExisted) {
                        var result = globalPointsList.filter(function (object) {
                            return Object.keys(object).some(function (key) {
                                return object[key].todoPoint.fromDayNumber === dayIteration;
                            });
                        });
                        if (result.length !== 0) {
                            result.forEach(function (object) {
                                Object.keys(object).forEach(function (key) {
                                    if (object[key].todoPoint.fromDayNumber === dayIteration) {
                                        pointsToIntroduceIteration++;
                                        const objectKey = 'Point-' + pointsToIntroduceIteration;
                                        const pointContent = object[key].todoPoint.content;
                                        const pointCompleted = object[key].todoPoint.completed;
                                        const pointId = object[key].todoPoint.id;
                                        const toDayNumber = object[key].todoPoint.toDayNumber;
                                        pointsToIntroduceObject[objectKey] = {
                                            deadLine : toDayNumber,
                                            date : formattedDate,
                                            rowId: htmlRowId,
                                            completed: pointCompleted,
                                            content: pointContent,
                                            todoPointId: pointId
                                        };
                                    }
                                });
                            });
                        }
                    }

                }
            }

            daysHolder.appendChild(row);

            let pointsIteration = 0;
            for (let key in pointsToIntroduceObject){
                pointsIteration++;

                const rowId = pointsToIntroduceObject[`Point-${pointsIteration}`].rowId;
                const content = pointsToIntroduceObject[`Point-${pointsIteration}`].content;
                const completed = pointsToIntroduceObject[`Point-${pointsIteration}`].completed;
                const pointId = pointsToIntroduceObject[`Point-${pointsIteration}`].todoPointId;
                const pointDate = pointsToIntroduceObject[`Point-${pointsIteration}`].date;
                const deadLine = pointsToIntroduceObject[`Point-${pointsIteration}`].deadLine;

                let contentId = 'content-' + `${rowId}` + '-' + `${pointsIteration}`;
                let checkBoxId = 'checkBox' + `${rowId}` + '-' + `${pointsIteration}`;
                document.getElementById(`${rowId}`).insertAdjacentHTML(
                    'beforebegin',
                    pointComponent(
                        deadLine,
                        pointDate,
                        checkBoxId,
                        contentId,
                        rowId,
                        completed,
                        content,
                        pointId
                    ));

                if (completed === true){
                    document.getElementById(`${contentId}`).classList.add('striketrought-text');
                    document.getElementById(`${checkBoxId}`).checked = true;
                }


            }
    }
}











