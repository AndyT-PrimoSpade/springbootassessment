const createHTMLList = (index, title, description, targetDate) =>
    `
<tr>
    <th scope="row">${index}</th>
    <td> ${title}</td>
    <td>${description}</td>
    <td>${targetDate}</td>
</tr>
`;


class ListsController {
    constructor() {
        this._items = [];
    }

    addItem(title, description, targetDate) {
        let listController = this;
        const formData = new FormData();
        formData.append('title', title);
        formData.append('description', description);
        formData.append('targetDate', targetDate);

        fetch('http://localhost:8080/list/add', {
//        fetch('https://springbootassessment.herokuapp.com/list/add', {
            method: 'POST',
            body: formData
        })
            .then(function (response) {
                console.log(response.status);
                if (response.ok) {
                    alert("Successfully Added to List")
                }
            })
            .catch((error) => {
                console.error('Error:', error);
                alert("Error adding to List")
            });
    }

    renderTodoList() {
        let todoHTMLList = [];

        for (let i = 0; i < this._items.length; i++) {
            const item = this._items[i];
            const todoHTML = createHTMLList(i, item.title, item.description, item.targetDate);
            todoHTMLList.push(todoHTML);
        }

        const pHTML = todoHTMLList.join('\n');
        document.querySelector('#row').innerHTML = pHTML;
    }

    displayList() {
        let listController = this;
        listController._items = [];

        fetch('http://localhost:8080/list/all')
//        fetch('https://springbootassessment.herokuapp.com/list/all')
            .then((resp) => resp.json())
            .then(function (data) {
                console.log("2. receive data")
                console.log(data);
                data.forEach(function (item, index) {
                    const itemObj = {
                        id: item.id,
                        title: item.title,
                        description: item.description,
                        targetDate: item.targetDate,
                    };
                    listController._items.push(itemObj);
                });
                listController.renderTodoList();

            })
            .catch(function (error) {
                console.log(error);
            });
    }
}