//Item Table Loader
function loadItemTable(items) {
    const table = document.getElementById("itemTableBody");
    items.forEach( item => {
        let row = table.insertRow();
        let item_id = row.insertCell(0)
        let name = row.insertCell(1);
        let category = row.insertCell(2);
        let price = row.insertCell(3);
        let quantity = row.insertCell(4);
        let order = row.insertCell(5);
        let button = document.createElement('button');
        button.className = "addOrder btn";
        button.innerHTML = "Order";
        item_id.innerHTML = item.id;
        name.innerHTML = item.name;
        category.innerHTML = item.category;
        price.innerHTML = item.price;
        quantity.innerHTML = item.quantity;
        order.appendChild(button);
    });
}

//Order Table Loader

function loadOrderTable(orders) {
    const table = document.getElementById("orderTableBody");
    orders.forEach( order => {
        let row = table.insertRow();
        let order_id = row.insertCell(0);
        let item_name = row.insertCell(1);
        let contact_number = row.insertCell(2);
        let address = row.insertCell(3);
        let order_quantity = row.insertCell(4);
        let total_amount = row.insertCell(5);
        let status = row.insertCell(6);
        let update_status = row.insertCell(7);
        let button = document.createElement('button');
        button.className = "updateOrder btn";
        button.innerHTML = "update";
        order_id.innerText = order.id;
        item_name.innerHTML = order.item_name;
        contact_number.innerHTML = order.contact_number;
        address.innerHTML = order.address;
        order_quantity.innerHTML = order.order_quantity;
        total_amount.innerHTML = order.total_amount;
        status.innerHTML = order.status;
        update_status.appendChild(button);
    });
}


//Transaction


document.addEventListener('DOMContentLoaded', () => {
    let orderBtn = document.querySelectorAll(".addOrder")
    let modal = document.getElementById("modal")
    orderBtn.forEach(function (btn) {
        btn.addEventListener('click', () => {
            modal.style.display = "block";
            let form = document.getElementById("form");
            let temp = btn.parentElement.parentElement;
            let temp2 = temp.children[0].innerHTML;
            form.addEventListener('submit', function (e) {
                e.preventDefault()
                let order_quantity = document.getElementById("order_quantity").value
                let contact_number = document.getElementById("contact_number").value
                let address = document.getElementById("address").value

                fetch("http://localhost:8080/transaction", {
                    method:'POST',
                    body:JSON.stringify({
                        item_id: temp2,
                        phone_number: contact_number,
                        address: address,
                        quantity: order_quantity,
                    }),
                    headers: {
                        "Content-type": "application/json; charset=UTF-8"
                    }
                })
                    .then(function (response){
                        return response.json()
                    })
                    .then(function (data) {
                        alert(data.message)
                        console.log(data)
                    })

            })
        });
    });
    let span = document.getElementsByClassName("close")[0]
    span.onclick = function() {
        modal.style.display = "none";
    }
});

function addItemModal() {
    let modal = document.getElementById("addItemModal");
    modal.style.display = "block";
    let span = document.getElementsByClassName("close")[1]
    span.onclick = function() {
        modal.style.display = "none";
    }
}

//Add item

let addItemForm = document.getElementById("addItemForm");
addItemForm.addEventListener('submit', function (e) {
    e.preventDefault()
    let name = document.getElementById("name").value
    let category = document.getElementById("category").value
    let price = document.getElementById("price").value
    let quantity = document.getElementById("quantity").value

    fetch("http://localhost:8080/home/item/add", {
        method:'POST',
        body:JSON.stringify({
            name: name,
            category: category,
            price: price,
            quantity: quantity
        }),
        headers: {
            "Content-type": "application/json;charset=UTF-8"
        }
    })
        .then(function (response){
            return response.json()
        })
        .then(function (data) {
            console.log(data)
        })
    setTimeout(function(){window.location.reload();},1000);
});


//Delete Item

function deleteItemModal() {
    let modal = document.getElementById("deleteItemModal");
    modal.style.display = "block";
    let span = document.getElementsByClassName("close")[2]
    span.onclick = function() {
        modal.style.display = "none";
    }
}

let deleteItemForm = document.getElementById("deleteItemForm");
deleteItemForm.addEventListener('submit', function (e) {
    e.preventDefault()
    let id = document.getElementById("id").value

    fetch("http://localhost:8080/home/item/delete", {
        method:'POST',
        body:JSON.stringify({
            id: id
        }),
        headers: {
            "Content-type": "application/json;charset=UTF-8"
        }
    })
        .then(function (response){
            return response.json()
        })
        .then(function (data) {
            console.log(data)
        })
    setTimeout(function(){window.location.reload();},1000);
});


//Update Item


function updateItemModal() {
    let modal = document.getElementById("updateItemModal");
    modal.style.display = "block";
    let span = document.getElementsByClassName("close")[3]
    span.onclick = function() {
        modal.style.display = "none";
    }
}

let updateItemForm = document.getElementById("updateItemForm");
updateItemForm.addEventListener('submit', function (e) {
    e.preventDefault()
    let id = document.getElementById("update_id").value
    let price = document.getElementById("update_price").value
    let quantity = document.getElementById("update_quantity").value

    fetch("http://localhost:8080/home/item/update", {
        method:'POST',
        body:JSON.stringify({
            id: id,
            price: price,
            quantity: quantity
        }),
        headers: {
            "Content-type": "application/json;charset=UTF-8"
        }
    })
        .then(function (response){
            return response.json()
        })
        .then(function (data) {
            console.log(data)
        })
    //setTimeout(function(){window.location.reload();},1000);
});


//Update Order


document.addEventListener('DOMContentLoaded', () => {
    let orderBtn = document.querySelectorAll(".updateOrder")
    let modal = document.getElementById("updateOrderModal")
    orderBtn.forEach(function (btn) {
        btn.addEventListener('click', () => {
            modal.style.display = "block";
            let updateOrderForm = document.getElementById("updateOrderForm");
            updateOrderForm.addEventListener('submit', function (e) {
                e.preventDefault()
                let temp = btn.parentElement.parentElement;
                let order_id = temp.children[0].innerHTML;
                let update_status = document.getElementById("update_status").value

                fetch("http://localhost:8080/home/orders/updateStatus", {
                    method:'POST',
                    body:JSON.stringify({
                        id: order_id,
                        status: update_status
                    }),
                    headers: {
                        "Content-type": "application/json; charset=UTF-8"
                    }
                })
                    .then(function (response){
                        return response.json()
                    })
                    .then(function (data) {
                        console.log(data)
                    })
                setTimeout(function(){window.location.reload();},1000);
            })
        });
    });
    let span = document.getElementsByClassName("close")[4]
    span.onclick = function() {
        modal.style.display = "none";
    }
});

/*-----------Pagination---------Filtering---------------Sorting----------*/

$(document).ready(function() {
    $('#itemTable').DataTable( {
        initComplete: function () {
            this.api().columns().every( function () {
                let column = this;
                let select = $('<select><option value=""></option></select>')
                    .appendTo( $(column.footer()).empty() )
                    .on( 'change', function () {
                        let val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );
                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );
                column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' )
                } );
            } );
        }
    } );
} );