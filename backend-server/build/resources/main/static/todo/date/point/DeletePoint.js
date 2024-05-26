async function deletePoint(todoPointId){
    try{

        const requestData = {
            todoPointId : todoPointId
        };

        const params = new URLSearchParams(requestData);

        const response  = await fetch(`http://localhost:8080/todoRequest/deleteTodoPoint?${params.toString()}`,{
            method : 'DELETE',
            headers : {
                'Content-Type' : 'application/json'
            }
        });

        const data = await response.json();

        if (response.ok){
            const todoPointComponent = document.getElementById(`point-${todoPointId}`);
            todoPointComponent.remove();
            console.log(data);
        }else {
            console.log(data);
        }









    }catch (error){
        console.log('Unidentified error ' + error);
    }



}