const listsControl = new ListsController();

newItemForm.addEventListener('submit', (event) => {

    event.preventDefault();
    const newItemTitleInput = document.querySelector('#titleInput');
    const newItemDescription = document.querySelector('#descriptionInput');
    const newItemTargetDate = document.querySelector('#targetDateInput');


    const title = newItemTitleInput.value;
    const description = newItemDescription.value;
    const targetDate = newItemTargetDate.value;


    newItemTitleInput.value = '';
    newItemDescription.value = '';
    newItemTargetDate.value = '';

    listsControl.addItem(title, description, targetDate);

});

