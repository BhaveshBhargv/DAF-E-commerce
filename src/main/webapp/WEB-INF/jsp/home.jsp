<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Items</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/home.css">
    <link rel="Stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" />
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
</head>
<body>
    <div id="modal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <h2>Order</h2>
                <span class="close">&times;</span>
            </div>
            <div class="modal-body">
                <form id="form" method="post">
                    <label for="order_quantity">Quantity:</label>
                    <input type="text" id="order_quantity" name="order_quantity"><br><br>
                    <label for="contact_number">Contact Number:</label>
                    <input type="text" id="contact_number" name="contact_number"><br><br>
                    <label for="address">Address:</label>
                    <input type="text" id="address" name="address"><br><br>
                    <input type="submit">
                </form>
            </div>
        </div>
    </div>
    <div id="addItemModal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <h2>Order</h2>
                <span class="close">&times;</span>
            </div>
            <div class="modal-body">
                <form id="addItemForm" method="post">
                    <label for="name">Item:</label>
                    <input type="text" id="name" name="name"><br><br>
                    <label for="category">Category:</label>
                    <input type="text" id="category" name="category"><br><br>
                    <label for="price">Price:</label>
                    <input type="text" id="price" name="price"><br><br>
                    <label for="quantity">Quantity:</label>
                    <input type="text" id="quantity" name="quantity"><br><br>
                    <input type="submit">
                </form>
            </div>
        </div>
    </div>
    <div id="deleteItemModal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <h2>Order</h2>
                <span class="close">&times;</span>
            </div>
            <div class="modal-body">
                <form id="deleteItemForm" method="post">
                    <label for="id">Item ID:</label>
                    <input type="text" id="id" name="id"><br><br>
                    <input type="submit">
                </form>
            </div>
        </div>
    </div>
    <div id="updateItemModal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <h2>Order</h2>
                <span class="close">&times;</span>
            </div>
            <div class="modal-body">
                <form id="updateItemForm" method="post">
                    <label for="update_id">Item Id:</label>
                    <input type="text" id="update_id" name="name"><br><br>
                    <label for="update_price">Price:</label>
                    <input type="text" id="update_price" name="price"><br><br>
                    <label for="update_quantity">Quantity:</label>
                    <input type="text" id="update_quantity" name="quantity"><br><br>
                    <input type="submit">
                </form>
            </div>
        </div>
    </div>
    <div id="updateOrderModal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <h2>Order</h2>
                <span class="close">&times;</span>
            </div>
            <div class="modal-body">
                <form id="updateOrderForm" method="post">
                    <label for="update_status">Quantity:</label>
                    <select id="update_status">
                        <option>Order Received</option>
                        <option>Order shipped</option>
                        <option>Order delivered</option>
                    </select><br><br>
                    <input type="submit">
                </form>
            </div>
        </div>
    </div>
    <h1>Daily Cart</h1>
    <div class="container">
        <div class="row">
            <div class="col info-1">
                <div>Total Categories</div>
                <div>${totalCategory}</div>
            </div>
            <div class="col info-2">
                <div>Total Items</div>
                <div>${totalItems}</div>
            </div>
            <div class="col info-3">
                <div>Top Selling Category</div>
                <div>${bestCategory}</div>
            </div>
            <div class="col info-4">
                <div>Top selling Item</div>
                <div>${bestItem}</div>
            </div>
        </div>
    </div>
    <div class="container">
        <h2>Items</h2>
        <table id="itemTable" class="table table-striped display">
            <thead class="thead-dark">
                <tr>
                    <th>Item Id</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Price/Item</th>
                    <th>Available Quantity</th>
                    <th>Place Order</th>
                </tr>
            </thead>
            <tbody id="itemTableBody"></tbody>
        </table>
        <div id="pageNavPosition" class="pager-nav"></div>
    </div>

    <div class="container">
        <button class="btn" onclick="addItemModal()">Add Item</button>
        <button class="btn" onclick="deleteItemModal()">Delete Item</button>
        <button class="btn" onclick="updateItemModal()">Update Item</button>
    </div>
    <div class="container">
        <h2>Orders</h2>
        <table id="orderTable" class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Order ID</th>
                    <th>Item Name</th>
                    <th>Contact Number</th>
                    <th>Address</th>
                    <th>Quantity</th>
                    <th>Total Amount</th>
                    <th>Status</th>
                    <th>Update Status</th>
                </tr>
            </thead>
            <tbody id="orderTableBody"></tbody>
        </table>
    </div>
    <script language="JavaScript" type="text/javascript" src="../../script/home.js"></script>
    <script>
        const items = ${items};
        const orders = ${orders};
        const itemsList = ${itemList};
        const orderList = ${orderList};
        loadItemTable(items);
        loadOrderTable(orders);

    </script>
</body>
</html>