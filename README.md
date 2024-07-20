
# Inventory Management System (IMS)

The Inventory Management System (IMS) is a Java-based application that helps businesses manage their inventory, including products, stock levels, and orders. This system allows for efficient tracking and management of inventory, ensuring smooth operations and preventing stockouts or overstocking.

## Table of Contents

- [Features](#Features)

- [Installation](#Installation) 

- [Database Setup](#DatabaseSetup)

- [Configuration](#Configuration)

- [Usage](#Usage)

- [Project Structure](#ProjectStructure)

- [Contributing](#Contributing)

- [License](LICENSE.md)
## Features

- Product Management: Add, update, delete, and view products.
- Stock Management: Track product stock levels, add new stock, update existing stock, and delete stock entries.
- Order Management: Create, update, delete, and view orders.
- Report Generation: Generate reports on stock levels and orders.



# Installation

### Prerequisites

- Java 8+
- MySQL
- Maven

### Steps

1. Clone the repository 

```bash
git clone https://github.com/AmruthLP12/com.InventoryManagementSystem-.git
cd inventory-management-system
```
2. Build the project using Maven:

```bash
mvn clean install
```

3. Run the application:

```bash
mvn exec:java -Dexec.mainClass="com.inventory.ui.Main"
```

- ## Database Setup

1. Create the database schema:

```sql
CREATE SCHEMA IF NOT EXISTS inventory_db;
USE inventory_db;
```
2. Create the tables:

```sql
-- Table: Products
CREATE TABLE IF NOT EXISTS Products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description TEXT
);

-- Table: Stocks
CREATE TABLE IF NOT EXISTS Stocks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES Products(id)
);

-- Table: Orders
CREATE TABLE IF NOT EXISTS Orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    order_date DATE NOT NULL,
    FOREIGN KEY (product_id) REFERENCES Products(id)
);

```

3. Populate the tables with initial data (optional):

```sql
INSERT INTO Products (name, price, description) VALUES ('Product 1', 10.00, 'Description for Product 1');
INSERT INTO Products (name, price, description) VALUES ('Product 2', 20.00, 'Description for Product 2');

INSERT INTO Stocks (product_id, quantity) VALUES (1, 100);
INSERT INTO Stocks (product_id, quantity) VALUES (2, 200);

INSERT INTO Orders (product_id, quantity, order_date) VALUES (1, 10, '2023-07-01');
INSERT INTO Orders (product_id, quantity, order_date) VALUES (2, 20, '2023-07-02');

```



## Configuration

Configure the database connection in` src/main/resources/config.properties`:

```properties
db.url=jdbc:mysql://localhost:3306/inventory_db
db.username=root
db.password=your_password

```
## Usage

1. Run the application:

```bash
mvn exec:java -Dexec.mainClass="com.inventory.ui.Main"

```

2. Navigate through the menu:

- Product Management: Manage product information.
- Stock Management: Manage stock levels.
- Order Management: Manage orders.
- Report Management: Generate reports.

3. Project Structure

```bash
inventory-management-system/
│
├── src/
│     ├── main/
│     ├── java/
│     │   └── com/
│     │       └── inventory/
│     │           ├── config/
│     │           │   └── DatabaseConfig.java
│     │           ├── dao/
│     │           │   ├── OrderDAO.java
│     │           │   ├── ProductDAO.java
│     │           │   ├── ReportDAO.java
│     │           │   └── StockDAO.java
│     │           ├── model/
│     │           │   ├── Order.java
│     │           │   ├── Product.java
│     │           │   ├── Report.java
│     │           │   └── Stock.java
│     │           ├── service/
│     │           │   ├── OrderService.java
│     │           │   ├── ProductService.java
│     │           │   ├── ReportService.java
│     │           │   └── StockService.java
│     │           └── ui/
│     │               ├── Main.java
│     │               ├── OrderUI.java
│     │               ├── ProductUI.java
│     │               ├── ReportUI.java
│     │               └── StockUI.java
│     └── resources/
│         └── schema.sql
│   
│
│
├── .gitignore
├── pom.xml
└── README.md

```



## Contributing

Contributions are always welcome!

See [CONTRIBUTING.md](CONTRIBUTING.md) for ways to get started.





## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

